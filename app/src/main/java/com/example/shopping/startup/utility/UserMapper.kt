package com.example.shopping.startup.utility

import com.example.shopping.startup.data.User
import com.google.firebase.auth.FirebaseUser
import java.util.Date

fun FirebaseUser.toUser() : User{
    return User(
        id = uid,
        name = displayName,
        email = email,
        phoneNumber = phoneNumber,
        profileUrl = photoUrl?.toString(),
        createdAt = Date()
    )
}