package com.example.shopping.email.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopping.email.data.EmailRequest
import com.example.shopping.email.domain.EmailRepository
import com.example.shopping.util.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EmailViewModel(
    private val emailRepository: EmailRepository
) : ViewModel(){
    private val _uiState = MutableStateFlow<UiState<Unit>>(UiState.Loading)
    val uiState: StateFlow<UiState<Unit>> = _uiState

    fun postEmail(
        from : String,
        to : String,
        subject : String,
        body : String
    ){
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            val result = emailRepository.postEmail(from, to, body, subject)
            _uiState.value = if (result.isSuccess){
                UiState.Success(Unit)
            }
            else{
                UiState.Error(result.exceptionOrNull() ?: Exception("Unknown error"))
            }
        }
    }
}
