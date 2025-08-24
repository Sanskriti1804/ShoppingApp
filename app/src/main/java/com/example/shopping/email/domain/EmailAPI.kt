package com.example.shopping.email.domain

import com.example.shopping.email.data.EmailRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface EmailAPI {
    @Headers("Content-type: application/json")
    @POST("v3/mail/send")
    suspend fun postEmail(
        @Body emailRequest: EmailRequest
    ) : Response<Unit>
}