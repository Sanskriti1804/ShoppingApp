package com.example.shopping.startup.data

import java.util.Date

data class User (
    val id : String = "",
    val name : String? = null,
    val email : String? = null,
    val phoneNumber : String? = null,
    val profileUrl : String? = null,
    val createdAt : Date = Date()   // current time
)