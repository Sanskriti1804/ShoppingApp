package com.example.shopping.startup.model

import com.example.shopping.startup.data.User
import com.example.shopping.startup.utility.toUser
import kotlinx.coroutines.flow.Flow
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await

class AuthRepoImpl(
    private val firebaseAuth : FirebaseAuth,
    private val firestore : FirebaseFirestore,
//    private val googleSignInClient : GoogleSignInClient
) : AuthRepository
{
    override suspend fun loginWithEmail(
        email: String,
        password: String
    ): Flow<Result<User>> = flow {      //flow - coroutine - flow builder - emits one value(success/ error)
        try {
            val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()       //await - convertd tasks into suspendable for using try/catch
            val firebaseUser = result.user?.toUser() ?: throw Exception("User is null")
            emit(Result.success(firebaseUser))
        }
        catch (e : Exception){
            emit(Result.failure(e))
        }
    }

    override suspend fun registerWithEmail(
        name: String,
        email: String,
        password: String
    ): Flow<Result<User>> = flow {
        try {
            val result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            val firebaseUser = result.user?.toUser() ?: throw Exception("User is null")

            firestore.collection("users")
                .document(firebaseUser.id)      //document it inside the users collection
                .set(firebaseUser)
                .await()
            emit(Result.success(firebaseUser))
        }
        catch (e : Exception){
            emit(Result.failure(e))
        }
    }

    override suspend fun signInWithGoogle(idToken: String): Flow<Result<User>> = flow {
        try {
            val credential = GoogleAuthProvider.getCredential(idToken, null)
            val result = firebaseAuth.signInWithCredential(credential).await()
            val firebaseUser = result.user?.toUser() ?: throw Exception("User is null")
            emit(Result.success(firebaseUser))
        }
        catch (e : Exception){
            emit(Result.failure(e))
        }
    }

    override suspend fun getCurrentUser(): User? {
        return firebaseAuth.currentUser?.toUser()
    }

    override suspend fun logout(): Flow<Result<Boolean>> = flow {
        try {
          firebaseAuth.signOut()
//            googleSignInClient.signOut().await()
            emit(Result.success(true))
        }
        catch (e : Exception){
            emit(Result.failure(e))
        }

    }

}
