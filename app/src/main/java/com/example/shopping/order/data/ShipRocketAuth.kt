package com.example.shopping.order.data

data class ShipRocketAuthRequest(
    val email : String,
    val password : String
)

data class ShipRocketAuthResponse(
    val token : String
)