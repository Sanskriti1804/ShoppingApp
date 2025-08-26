package com.example.shopping

import android.app.Application
import android.util.Log
import androidx.compose.runtime.remember
import com.example.shopping.di.authModule
import com.example.shopping.di.networkModule
import com.example.shopping.di.productModule
import com.example.shopping.di.viewModelModule
import com.example.shopping.util.LocalProps
import com.stripe.android.PaymentConfiguration
import com.stripe.android.paymentsheet.PaymentSheet
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class ShoppingApp : Application(){

    //only initialized when required
    lateinit var stripePublishableKey: String
    lateinit var stripeSecretKey: String

    override fun onCreate() {
        super.onCreate()

//        val stripePublishableKey = getStripePublishableKey()

//        val paymentSheet = remember { PaymentSheet.Builder(::onPaymentSheetResult) }.build()


        val props = LocalProps.load(this)
        stripePublishableKey = props.getProperty("STRIPE_PUBLISHABLE_KEY", "")
        stripeSecretKey = props.getProperty("STRIPE_SECRET_KEY", "")

        android.util.Log.d("CHECKPOINT", "Stripe key loaded: $stripePublishableKey")

        require(stripePublishableKey.startsWith("pk_")) {
            "Stripe publishable key is missing or invalid!"
        }

        // Example: Initialize Stripe with the publishable key
        PaymentConfiguration.init(
            applicationContext,
            stripePublishableKey
        )

        Log.d("CHECKPOINT", "==== Starting Koin setup ====")

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@ShoppingApp)
            modules(
                networkModule,
                authModule,
                productModule,
                viewModelModule,

            )
        }
        Log.d("CHECKPOINT", "==== Finished Koin setup ====")
    }
}