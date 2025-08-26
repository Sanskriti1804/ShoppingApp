package com.example.shopping.di

import com.example.shopping.order.remote.PaymentApiService
import com.example.shopping.order.repository.PaymentRepository
import com.example.shopping.order.viewmodel.PaymentViewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val PaymentModule = module {
    single<PaymentApiService> {
        get<Retrofit>().create(PaymentApiService::class.java)
    }
    single {
        PaymentRepository(get())
    }
}