package com.example.shopping.backend

import com.example.shopping.backend.data.LoginRequest
import com.example.shopping.backend.data.LoginResponse
import com.example.shopping.backend.data.OrderResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface BackendApi{
    @POST("login")
    suspend fun login(@Body request : LoginRequest) : Response<LoginResponse>

    @GET("protected")
    suspend fun getProtectedData() : Response<String>

    @GET("orders/{id}")
    suspend fun getOrderById(@Path("id") id : Long) : Response<OrderResponse>
}