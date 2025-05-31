package com.example.shopping.cart.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopping.cart.data.CartProduct
import com.example.shopping.home.model.RetrofitInstance
import kotlinx.coroutines.launch

class CartViewModel : ViewModel() {
    var cartList by mutableStateOf<List<CartProduct>>(emptyList())
        private  set

    init {
        fetchCartProd()
    }

    private fun fetchCartProd( ){
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.cartApi.getCartProducts(limit = 4, skip = 0)
                cartList = response.cart
            }
            catch (e : Exception){
                e.printStackTrace()
            }
        }
    }

}