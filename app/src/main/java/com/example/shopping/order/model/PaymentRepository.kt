package com.example.shopping.order.model

import com.example.shopping.order.data.PaymentConfigResponse
import com.example.shopping.util.UiState

class PaymentRepository (
    private val paymentApi: PaymentApiService
){
    suspend fun getPaymentConfig() : UiState<PaymentConfigResponse> {
        return try {
//        Make a request to your own server and retrieve payment configurations
            val response = paymentApi.getPaymentIntent()
            if (response.isSuccessful){
                //Direct mapping (response.body()!!) → fast, simple, API perfectly matches model
                UiState.Success(response.body()!!)      //!! - asserting it is not null
            }
            else{
                UiState.Error(Exception("Network request failed"))
            }

        }catch (e : Exception){
            UiState.Error(e)
        }
    }
}