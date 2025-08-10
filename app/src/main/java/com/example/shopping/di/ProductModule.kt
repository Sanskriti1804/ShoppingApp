package com.example.shopping.di

import com.example.shopping.ShoppingApp
import com.example.shopping.cart.model.CartApi
import com.example.shopping.home.model.ProductApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val productModule = module {
    single {
        //JSON data -> kotlin object
        Retrofit.Builder()      //building a retrofit instance
            .baseUrl("https://dummyjson.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<ProductApi> { get<Retrofit>().create(ProductApi::class.java) } //creates productapi interface from retrofit instance
    single<CartApi> { get<Retrofit>().create(CartApi::class.java)}
}