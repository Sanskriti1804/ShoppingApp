package com.example.shopping.di

import com.example.shopping.backend.BackendApi
import org.koin.dsl.module
import com.example.shopping.email.domain.EmailAPI
import com.example.shopping.email.domain.EmailRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val backendModule = module {
    single<BackendApi> {
        get<Retrofit>(named("backendRetrofit")).create(BackendApi::class.java)
    }
}