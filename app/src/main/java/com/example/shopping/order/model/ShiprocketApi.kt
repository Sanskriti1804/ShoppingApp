package com.example.shopping.order.model

import com.example.shopping.order.data.ShiprocketLoginRequest
import com.example.shopping.order.data.ShiprocketLoginResponse
import com.example.shopping.order.data.OrderResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ShiprocketApi{
    @POST("login")
    suspend fun login(@Body request : ShiprocketLoginRequest) : Response<ShiprocketLoginResponse>

    @GET("protected")
    suspend fun getProtectedData() : Response<String>

    @GET("orders/{id}")
    suspend fun getOrderById(@Path("id") id : Long) : Response<OrderResponse>
}