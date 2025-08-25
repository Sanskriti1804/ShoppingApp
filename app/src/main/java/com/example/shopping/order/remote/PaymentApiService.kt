package com.example.shopping.order.remote

import com.example.shopping.order.data.PaymentConfigResponse
import retrofit2.Response
import retrofit2.http.GET

interface PaymentApiService{
    // Doc: "add an endpoint on your server that creates a PaymentIntent - returns the client secret, ephemeral key, customer id, and publishable key"
    @GET("payment_intents")
    suspend fun getPaymentIntent(): Response<PaymentConfigResponse>
}