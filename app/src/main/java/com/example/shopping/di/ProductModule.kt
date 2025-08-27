package com.example.shopping.di

import com.example.shopping.ShoppingApp
import com.example.shopping.cart.model.CartApi
import com.example.shopping.home.model.ProductApi
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val productModule = module {

    single<ProductApi> {
        get<Retrofit>("productRetrofit").create(ProductApi::class.java)
    }

    single<CartApi> { get<Retrofit>("productRetrofit").create(CartApi::class.java)}
}