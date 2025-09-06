package com.example.shopping.di

import com.example.shopping.order.model.ShiprocketApi
import com.example.shopping.order.model.ShiprocketRepository
import org.koin.dsl.module
import org.koin.core.qualifier.named
import retrofit2.Retrofit

val backendModule = module {
    single<ShiprocketApi> {
        get<Retrofit>(named("backendRetrofit")).create(ShiprocketApi::class.java)
    }

    single {
        ShiprocketRepository(get(), get())
    }
}