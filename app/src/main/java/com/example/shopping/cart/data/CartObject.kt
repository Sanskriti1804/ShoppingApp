package com.example.shopping.cart.data

data class CartObject(
    val id: Int,
    val products: List<CartProduct>,
    val total: Double,
    val discountedTotal: Double,
    val userId: Int,
    val totalProducts: Int,
    val totalQuantity: Int
)