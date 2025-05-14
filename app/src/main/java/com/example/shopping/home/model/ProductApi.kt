package com.example.shopping.home.model

import com.example.shopping.home.data.Product
import com.example.shopping.home.data.ProductResponse
import retrofit2.http.GET
import retrofit2.http.Query

//interface - HTTP requests to made to web API
interface ProductApi {
    @GET("products")
    //returns a list of product objects - api returnn a json array or prod - deserialize into a list of product model
//    suspend fun getProducts() : List<Product>
    suspend fun getProducts(
        @Query("limit") limit : Int,
        @Query("skip") skip : Int,
    ) : ProductResponse
}