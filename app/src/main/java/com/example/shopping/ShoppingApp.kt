package com.example.shopping

import android.app.Application
import android.util.Log
import com.example.shopping.di.authModule
import com.example.shopping.di.emailModule
import com.example.shopping.di.networkModule
import com.example.shopping.di.paymentModule
import com.example.shopping.di.productModule
import com.example.shopping.di.viewModelModule
import com.example.shopping.util.LocalProps
import com.stripe.android.PaymentConfiguration
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import java.io.File

class ShoppingApp : Application(){

    //only initialized when required
    lateinit var stripePublishableKey: String
    lateinit var stripeSecretKey: String

    lateinit var shipRocketEmail : String
    lateinit var shipRocketPassword : String

    override fun onCreate() {
        super.onCreate()

//        val stripePublishableKey = getStripePublishableKey()

//        val paymentSheet = remember { PaymentSheet.Builder(::onPaymentSheetResult) }.build()


        val stripeProps = LocalProps.loadFromAssets(this)
        stripePublishableKey = stripeProps.getProperty("STRIPE_PUBLISHABLE_KEY", "")
        stripeSecretKey = stripeProps.getProperty("STRIPE_SECRET_KEY", "")

        android.util.Log.d("CHECKPOINT", "Stripe key loaded: $stripePublishableKey")

        require(stripePublishableKey.startsWith("pk_")) {
            "Stripe publishable key is missing or invalid!"
        }

        // Example: Initialize Stripe with the publishable key
        PaymentConfiguration.init(
            applicationContext,
            stripePublishableKey
        )

        val rootDir = File("/absolute/path/to/project/root")
        val shipRocketProps = LocalProps.loadFromLocalProperties(rootDir)
        shipRocketEmail = shipRocketProps.getProperty("SHIPROCKET_API_EMAIL", "")
        shipRocketPassword = shipRocketProps.getProperty("SHIPROCKET_API_PASSWORD", "")

        Log.d("CHECKPOINT", "==== Starting Koin setup ====")

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@ShoppingApp)
            modules(
                networkModule,
                authModule,
                productModule,
                viewModelModule,
                emailModule,
                paymentModule

            )
        }
        Log.d("CHECKPOINT", "==== Finished Koin setup ====")
    }
}