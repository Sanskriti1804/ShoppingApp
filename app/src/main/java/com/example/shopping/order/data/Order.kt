package com.example.shopping.order.data

data class OrderResponse(
    val data: OrderData
)

data class OrderData(
    val id: Long,
    val customerName: String,
    val customerEmail: String,
    val customerPhone: String,
    val customerAddress: String,
    val customerCity: String,
    val customerState: String,
    val customerPinCode: String,
    val total: Double,
    val status: String,
    val paymentMethod: String,
    val orderDate: String,
    val products: List<Product>
)
data class Product(
    val id: Long,
    val orderId: Long,
    val productId: Long,
    val name: String,
    val sku: String,
    val size: String?,   // nullable
    val price: Double,
    val quantity: Int,
    val status: String
)
