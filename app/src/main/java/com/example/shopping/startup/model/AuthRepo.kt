package com.example.shopping.startup.model

import com.example.shopping.startup.data.User
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun loginWithEmail(email : String, password : String) : Flow<Result<User>>
    suspend fun registerWithEmail(name : String, email: String, password: String) : Flow<Result<User>>
    suspend fun signInWithGoogle(idToken : String) : Flow<Result<User>>
    suspend fun getCurrentUser() : User?    //one value no need to keep observing or updating once is enough
    suspend fun logout() : Flow<Result<Boolean>>
}
