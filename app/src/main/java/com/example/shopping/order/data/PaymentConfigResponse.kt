package com.example.shopping.order.data

data class PaymentConfigResponse(
    val publishableKeys: String,
    val customer: String,
    val ephemeralKey : String,
    val paymentIntent : String,
)