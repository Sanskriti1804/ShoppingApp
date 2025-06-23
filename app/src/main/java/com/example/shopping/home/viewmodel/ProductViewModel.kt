package com.example.shopping.home.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopping.home.data.Product
import com.example.shopping.home.model.RetrofitInstance
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel(){

    var product by mutableStateOf<Product?>(null)
    //prodList - observable property that will hold a list of products fetched from the api
    //mutableStateOf - ui will be automatically updated when the ui changes
    var productList by mutableStateOf<List<Product>>(emptyList())
        private set     //other classes can read the prodList but cant modify it

    init {      //as soon as the instace of prodvm is created
        fetchProducts()
    }

    //makes network request to fetch prods
    private fun fetchProducts(){
        //nw calls are asynch  - if vm destroyed prop destroyed - no memory leaks
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getProducts(limit = 100, skip = 0)
                productList = response.products
            }
            catch (e : Exception){
                e.printStackTrace()
            }
        }
    }

    private fun fetchProductById(){
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getProducts(limit = 1, skip = 0)
                product = response.products.firstOrNull()
            }
            catch (e : Exception){
                e.printStackTrace()
            }

        }
    }
}