package com.example.shopping.di

import com.example.shopping.email.domain.EmailAPI
import com.example.shopping.email.domain.EmailRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val emailModule = module{
    single<EmailAPI> {
        get<Retrofit>(named("emailRetrofit")).create(EmailAPI::class.java)
    }
    single { EmailRepository(get()) }
}