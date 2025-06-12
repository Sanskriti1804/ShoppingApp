package com.example.shopping.cart.data

data class Summary(
    val quantity : Int,
    val Subtotal : Double,
    val Shipping : Double,
    val Tax : Double,
    val Total : Double,
    val recipient : String,
    val address : String,
    val payment : String
)

