package com.example.shopping.di


import com.example.shopping.startup.model.AuthRepoImpl
import com.example.shopping.startup.model.AuthRepository
import com.example.shopping.startup.viewmodel.AuthViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

//koin module - how to create and  provide dependencies
val authModule = module {
    single { FirebaseAuth.getInstance() }

    single { FirebaseFirestore.getInstance() }

    single<AuthRepository> {
        //when koin sees req for AuthRepo - provode an instance of AuthRepoimp
        AuthRepoImpl(
            firebaseAuth = get(),
            firestore = get()
        )      //get() - injects the instance we defined above
    }


}