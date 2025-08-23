package com.example.shopping.di

import com.example.shopping.email.domain.EmailAPI
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val EmailModule = module{
    single {
        Retrofit.Builder()
            .baseUrl("https://api.sendgrid.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single<EmailAPI> { get<Retrofit>().create(EmailAPI::class.java)}
}