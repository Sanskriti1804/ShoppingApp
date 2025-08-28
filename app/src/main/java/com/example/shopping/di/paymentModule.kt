package com.example.shopping.di

import com.example.shopping.order.model.PaymentApiService
import com.example.shopping.order.model.PaymentRepository
import org.koin.dsl.module
import retrofit2.Retrofit

val paymentModule = module {
    single<PaymentApiService> {
        get<Retrofit>().create(PaymentApiService::class.java)
    }
    single {
        PaymentRepository(get())
    }
}