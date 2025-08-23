package com.example.shopping.email.domain

import com.example.shopping.email.data.EmailRequest
import retrofit2.Response

class EmailRepository(
    private val api : EmailAPI
){
    suspend fun postEmail(emailRequest: EmailRequest) : Result<Response<Unit>> {
        return try {
            val response = api.postEmail(emailRequest)
            Result.success(response)
        }catch (e : Exception){
            Result.failure(e)
        }
    }
}