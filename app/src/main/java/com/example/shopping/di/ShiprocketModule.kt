package com.example.shopping.di

import com.example.shopping.order.model.ShiprocketApi
import com.example.shopping.order.model.ShiprocketRepository
import com.example.shopping.order.model.ShiprocketTokenManager
import org.koin.dsl.module
import org.koin.core.qualifier.named
import retrofit2.Retrofit

val shiprocketModule = module {
    single<ShiprocketApi> {
        get<Retrofit>(named("backendRetrofit")).create(ShiprocketApi::class.java)
    }

    single { ShiprocketTokenManager(get()) }

    single<ShiprocketRepository> {
        ShiprocketRepository(get(), get())
    }
}