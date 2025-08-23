package com.example.shopping.email.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopping.email.data.EmailRequest
import com.example.shopping.email.domain.EmailRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EmailViewModel(
    private val emailRepository: EmailRepository
) : ViewModel(){
    private val _status = MutableStateFlow<String?>(null)
    val status : StateFlow<String?> = _status

    init {

    }

    private fun postEmail(emailRequest: EmailRequest){
        viewModelScope.launch {
            try {
                emailRepository.postEmail(emailRequest).onSuccess { response ->
                    println("Status Code : ${response.code()}")
                    println("Body : ${response.body()}")
                    println("Headers : ${response.headers()}")

                    if (response.isSuccessful){
                        _status.value = "Email Sent Successfully"
                    }
                    else{
                        _status.value = "Failed to send email : ${response.code()}"
                    }
                }.onFailure { exception ->
                    _status.value = "Failed to send email : ${exception.message}"
                    exception.printStackTrace()
                }
            }
            catch (e : Exception){
                _status.value = "Failed to send email : ${e.message}"
                e.printStackTrace()
            }
        }
    }
}
