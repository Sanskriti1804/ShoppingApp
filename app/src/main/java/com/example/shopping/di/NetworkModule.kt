package com.example.shopping.di


import com.example.shopping.BuildConfig
import com.example.shopping.order.model.AuthInterceptor
import com.example.shopping.order.model.ShiprocketTokenManager
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {

    single { ShiprocketTokenManager(get()) }

    single {
        val logging = HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG){
                HttpLoggingInterceptor.Level.BODY
            }
            else{
                HttpLoggingInterceptor.Level.NONE
            }
        }

        val authInterceptor = AuthInterceptor(get())

        OkHttpClient.Builder()
            .addInterceptor(logging)
            .addInterceptor(authInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    single(named("backendRetrofit")){
        Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/")
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single(named("productRetrofit")) {
        Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single(named("emailRetrofit")) {
        Retrofit.Builder()
            .baseUrl("https://api.sendgrid.com")
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
