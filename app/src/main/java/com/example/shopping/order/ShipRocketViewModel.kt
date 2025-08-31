package com.example.shopping.order

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopping.order.model.ShipRocketRepository
import com.example.shopping.util.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ShipRocketViewModel(
    private val shipRocketRepository: ShipRocketRepository
)  : ViewModel(){

    private val _uiState = MutableStateFlow<UiState<Unit>>(UiState.Loading)
    val uiState : StateFlow<UiState<Unit>> = _uiState

    fun login(email : String, password : String){
        viewModelScope.launch {
            val result = shipRocketRepository.login(email, password)
            _uiState.value = if (result.isSuccess){
                UiState.Success(Unit)
            }else{
                UiState.Error(result.exceptionOrNull() ?: Exception("Unknown error"))
            }
        }
    }
}