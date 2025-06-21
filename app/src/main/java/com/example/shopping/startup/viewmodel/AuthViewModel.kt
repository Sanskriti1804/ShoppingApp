package com.example.shopping.startup.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopping.startup.data.AuthUiState
import com.example.shopping.startup.data.User
import com.example.shopping.startup.model.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AuthViewModel(
    private val authRepository: AuthRepository
) : ViewModel(){
    private val _result = MutableStateFlow(AuthUiState())
    val result : StateFlow<AuthUiState> = _result


    private fun setLoading(){
        _result.update { it.copy(isLoading = true, error = null) }
    }

    private fun setSuccess(user: User){
        _result.update { it.copy(isLoading = false, user = user) }
    }

    private fun setError(message : String?){
        _result.update { it.copy(isLoading = false, error = message) }
    }

    private fun resetForm(){
        _result.update { it.copy(name = "", email = "", password = "") }
    }

    //it.copy -it - cuurent state of authUiState    - .copy - new update instance of authuistate
    fun register(name : String, email : String, password : String){
//        val (name, email, password) = _result.value

        viewModelScope.launch {
            _result.update { it.copy(isLoading = true, error = null) }

            //.collect - collects the data from the flow
            authRepository.registerWithEmail(name, email, password).collect { res ->
                res.onSuccess {
                    user -> setSuccess(user)
                }
                res.onFailure { e -> setError(e.message) }
            }
        }
    }

    fun login(email : String, password : String){
        viewModelScope.launch {
            _result.update { it.copy(isLoading = true, error = null) }

            authRepository.loginWithEmail(email, password).collect {res ->
                res.onSuccess { user -> setSuccess(user) }
                res.onFailure { e -> setError(e.message) }
            }
        }
    }
}

//fun updateName(name : String){
//    _result.update { it.copy(name = name) }
//}
//
//fun updateEmail(email : String){
//    _result.update { it.copy(email = email) }
//}
//
//fun updatePassword(password : String){
//    _result.update { it.copy(password = password) }
//}
