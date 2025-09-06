package com.example.shopping.order.model

import okhttp3.Interceptor
import okhttp3.Response

//interceptor automatically adds JWT token
class AuthInterceptor(private val shiprocketTokenManager: ShiprocketTokenManager) : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val requestBuilder = originalRequest.newBuilder()

        // Only add auth header for your backend calls
        if (originalRequest.url.toString().contains("10.0.2.2:8080")) {
            shiprocketTokenManager.getToken()?.let { token ->
                requestBuilder.addHeader("Authorization", "Bearer $token")
            }
        }

        return chain.proceed(requestBuilder.build())
    }
}