package com.example.shopping

import android.app.Application
import com.example.shopping.di.authModule
import com.example.shopping.di.productModule
import com.example.shopping.di.viewModelModule
import com.example.shopping.util.LocalProps
import com.stripe.android.PaymentConfiguration
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ShoppingApp : Application(){

    //only initialized when required
    lateinit var stripePublishableKey: String
    lateinit var stripeSecretKey: String

    override fun onCreate() {
        super.onCreate()

//        val stripePublishableKey = getStripePublishableKey()

        val props = LocalProps.load(this)
        stripePublishableKey = props.getProperty("STRIPE_PUBLISHABLE_KEY", "")
        stripeSecretKey = props.getProperty("STRIPE_SECRET_KEY", "")

        // Example: Initialize Stripe with the publishable key
        PaymentConfiguration.init(
            applicationContext,
            stripePublishableKey
        )

        startKoin {
            androidContext(this@ShoppingApp)
            modules(
                authModule,
                productModule,
                viewModelModule
            )
        }
    }
}