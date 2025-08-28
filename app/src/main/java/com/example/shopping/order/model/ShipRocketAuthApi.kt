package com.example.shopping.order.model

import com.example.shopping.order.data.ShipRocketAuthRequest
import com.example.shopping.order.data.ShipRocketAuthResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ShipRocketAuthApi{

    @POST("v1/external/auth/login")
    suspend fun login(@Body request : ShipRocketAuthRequest) : Response<ShipRocketAuthResponse>

}