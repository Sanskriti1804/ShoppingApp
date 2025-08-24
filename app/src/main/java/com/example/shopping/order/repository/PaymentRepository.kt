package com.example.shopping.order.repository

import com.stripe.android.paymentsheet.PaymentSheet
import com.stripe.android.paymentsheet.PaymentSheetResult

class PaymentRepository (

){
    fun presentPaymentSheet(
        paymentSheet: PaymentSheet,
        customerConfig: PaymentSheet.CustomerConfiguration,
        paymentIntentClientSecret: String
    ) {
        paymentSheet.presentWithPaymentIntent(
            paymentIntentClientSecret,
            PaymentSheet.Configuration.Builder(merchantDisplayName = "My merchant name")
                .customer(customerConfig)
                // Set `allowsDelayedPaymentMethods` to true if your business handles
                // delayed notification payment methods like US bank accounts.
                .allowsDelayedPaymentMethods(true)
                .build()
        )
    }

    fun onPaymentSheetResult(paymentSheetResult: PaymentSheetResult) {
        when (paymentSheetResult) {
            is PaymentSheetResult.Canceled -> {
                print("Canceled")
            }

            is PaymentSheetResult.Failed -> {
                print("Error: ${paymentSheetResult.error}")
            }

            is PaymentSheetResult.Completed -> {
                // Display for example, an order confirmation screen
                print("Completed")
            }
        }
    }
}