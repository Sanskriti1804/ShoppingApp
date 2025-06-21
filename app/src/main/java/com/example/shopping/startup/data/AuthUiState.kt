package com.example.shopping.startup.data

data class AuthUiState(
    val name : String = "",
    val email : String = "",
    val  password : String = "",
    val  isLoading: Boolean = false,
    val error : String? = null,
    val  user : User? = null
)