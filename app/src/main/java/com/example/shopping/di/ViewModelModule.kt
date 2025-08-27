package com.example.shopping.di


import com.example.shopping.cart.viewmodel.CartViewModel
import com.example.shopping.email.viewmodel.EmailViewModel
import com.example.shopping.home.viewmodel.ProductViewModel
import com.example.shopping.order.viewmodel.PaymentViewModel
import com.example.shopping.startup.viewmodel.AuthViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { AuthViewModel(get()) }

    viewModel { ProductViewModel(get()) }  // get() fetches ProductApi

    viewModel { EmailViewModel(get()) }
    viewModel { PaymentViewModel(get()) }
    viewModel { CartViewModel(get()) }

}