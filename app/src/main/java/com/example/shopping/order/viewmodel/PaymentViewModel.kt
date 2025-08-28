package com.example.shopping.order.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopping.order.data.PaymentConfigResponse
import com.example.shopping.order.model.PaymentRepository
import com.example.shopping.util.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PaymentViewModel (
    private val paymentRepository: PaymentRepository
) : ViewModel(){
    private val _paymentConfigState = MutableStateFlow<UiState<PaymentConfigResponse>>(UiState.Loading)
    val paymentConfigState : StateFlow<UiState<PaymentConfigResponse>> = _paymentConfigState

    fun fetchPaymentConfig(){
        viewModelScope.launch {
            try {
                val result = paymentRepository.getPaymentConfig()
                _paymentConfigState.value = result

                if(result is UiState.Success){
                    PaymentConfigResponse(
                        publishableKeys = result.data.publishableKeys,
                        customer = result.data.customer,
                        ephemeralKey = result.data.ephemeralKey,
                        paymentIntent = result.data.paymentIntent
                    )

                }
            }
            catch (e : Exception){
                e.printStackTrace()
                _paymentConfigState.value = UiState.Error( e)
            }
        }
    }
}