package com.example.shopping.backend.data

data class LoginResponse(
    val token: String,
    val expiresIn: Long,
    val email: String
)
