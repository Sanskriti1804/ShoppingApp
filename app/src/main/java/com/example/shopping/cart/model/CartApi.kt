package com.example.shopping.cart.model

import com.example.shopping.cart.data.CartResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CartApi {
    @GET("carts")
    suspend fun getCartProducts(
        @Query("limit") limit : Int,
        @Query("skip") skip : Int
    ) : CartResponse
}