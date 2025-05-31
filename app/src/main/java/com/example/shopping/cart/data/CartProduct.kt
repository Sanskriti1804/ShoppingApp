package com.example.shopping.cart.data

import android.health.connect.datatypes.units.Percentage

data class CartProduct (
    val id: Int,
    val title: String,
    val price: Double,
    val quantity: Int,
    val total : Double,
    val discountPercentage : Double,
    val thumbnail : String
)