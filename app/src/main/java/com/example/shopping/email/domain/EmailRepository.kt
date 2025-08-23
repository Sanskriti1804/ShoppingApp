package com.example.shopping.email.domain

import com.example.shopping.email.data.EmailRequest
import com.example.shopping.email.data.Personalization
import com.example.shopping.email.data.SendGridContent
import com.example.shopping.email.data.SendGridEmail
import retrofit2.Response

class EmailRepository(
    private val api: EmailAPI
) {
    suspend fun postEmail(
        from: String,
        to: String,
        subject: String,
        body: String
    ): Result<Unit> {
        return try {
            val request = EmailRequest(
                personalizations = listOf(
                    Personalization(
                        to = listOf(SendGridEmail(email = to))
                    )
                ),
                from = SendGridEmail(email = from),
                content = listOf(SendGridContent(value = body)),
                subject = subject
            )

            val response: Response<Unit> = api.postEmail(request)

            if (response.isSuccessful) {
                Result.success(Unit)
            } else {
                Result.failure(
                    Exception("SendGrid error: ${response.code()} - ${response.message()}")
                )
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
