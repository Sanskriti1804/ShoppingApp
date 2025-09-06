package com.example.shopping.order.data

data class ShiprocketLoginResponse(
    val token: String,
    val expiresIn: Long,
    val email: String
)