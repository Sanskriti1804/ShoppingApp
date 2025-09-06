package com.example.shopping.order.model

import okhttp3.Interceptor
import okhttp3.Response

//interceptor automatically adds JWT token
class AuthInterceptor(private val shiprocketTokenManager: ShiprocketTokenManager) : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response{
        val request = chain.request().newBuilder()
        val token = shiprocketTokenManager.getToken()
        if (token != null){
            request.addHeader("Authorization", "Bearer $token")
        }
        return chain.proceed(request.build())
    }
}