package com.example.shopping.home.model

import com.example.shopping.cart.model.CartApi
import com.example.shopping.home.model.ProductApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//JSON data -> kotlin object
object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()      //building a retrofit instance
            .baseUrl("https://dummyjson.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api : ProductApi by lazy {  //load lazily
            retrofit.create(ProductApi::class.java) //creates productapi interface from retrofit instance
    }

    val cartApi : CartApi by lazy {
        retrofit.create(CartApi::class.java)
    }
}