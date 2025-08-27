package com.example.shopping.di

import com.example.shopping.email.domain.EmailAPI
import com.example.shopping.email.domain.EmailRepository
import com.example.shopping.email.viewmodel.EmailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val EmailModule = module{
    single<EmailAPI> {
        get<Retrofit>(named("emailRetrofit")).create(EmailAPI::class.java)
    }
    single { EmailRepository(get()) }
}