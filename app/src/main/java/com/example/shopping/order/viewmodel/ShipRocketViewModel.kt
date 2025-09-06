package com.example.shopping.order.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopping.order.data.OrderResponse
import com.example.shopping.order.data.ShiprocketLoginResponse
import com.example.shopping.order.model.ShiprocketRepository
import com.example.shopping.util.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ShipRocketViewModel(
    private val shiprocketRepository: ShiprocketRepository
)  : ViewModel(){

    private val _loginState = MutableStateFlow<UiState<ShiprocketLoginResponse>>(UiState.Loading)
    val loginState : StateFlow<UiState<ShiprocketLoginResponse>> = _loginState

    private val _protectedState = MutableStateFlow<UiState<String>>(UiState.Loading)
    val protectedState : StateFlow<UiState<String>> = _protectedState

    private val _orderState = MutableStateFlow<UiState<OrderResponse>>(UiState.Loading)
    val orderState : StateFlow<UiState<OrderResponse>> = _orderState


    fun login(email : String, password : String){
        viewModelScope.launch {
            val result = shiprocketRepository.login(email, password)
            _loginState.value = if (result.isSuccess){
                UiState.Success(result.getOrThrow())
            }else{
                UiState.Error(result.exceptionOrNull() ?: Exception("Unknown error"))
            }
        }
    }

    fun getProtectedData(){
        viewModelScope.launch {
            val result = shiprocketRepository.getProtectedData()

            _protectedState.value = if (result.isSuccess){
                UiState.Success(result.getOrThrow())
            }else{
                UiState.Error(result.exceptionOrNull() ?: Exception("Unknown error"))
            }
        }
    }

    fun getOrderById(orderId : Long){
        viewModelScope.launch {
            val result = shiprocketRepository.getOrderById(orderId)
            _orderState.value = if (result.isSuccess){
                UiState.Success(result.getOrThrow())
            }else{
                UiState.Error(result.exceptionOrNull() ?: Exception("Failed to fetch Order"))
            }
        }
    }
}