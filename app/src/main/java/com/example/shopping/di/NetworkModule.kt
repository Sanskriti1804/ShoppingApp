package com.example.shopping.di

import com.google.firebase.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single {
        val logging = HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG){
                HttpLoggingInterceptor.Level.BODY
            }
            else{
                HttpLoggingInterceptor.Level.NONE
            }
        }

        OkHttpClient.Builder()
            .addInterceptor(logging)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    factory { (baseUrl : String) ->
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()


    }
}