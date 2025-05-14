package com.example.shopping.home.model

import com.example.shopping.home.model.ProductApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//JSON data -> kotlin object
object RetrofitInstance {
    val api : ProductApi by lazy {  //load lazily
        Retrofit.Builder()      //building a retrofit instance
            .baseUrl("https://dummyjson.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductApi::class.java) //creates productapi interface from retrofit instance
    }
}