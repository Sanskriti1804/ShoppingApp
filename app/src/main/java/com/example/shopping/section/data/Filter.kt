package com.example.shopping.section.data

import androidx.compose.ui.graphics.Color

data class Filter (
    val filterType: FilterType,
    val label : String,
    val options : List<String>?,
    val colorOptions : List<Color>? = null,
    val sliderRange : ClosedFloatingPointRange<Float> = (0f..1000f),
    val selectedData : List<String> = emptyList()
)

val filters = listOf(
    Filter(FilterType.SORT, "Sort", options = listOf("Recommended", "New Arrivals", "Price : Low to High", "Price : High to Low")),
    Filter(FilterType.PRICE, "Price", options = null),
    Filter(FilterType.COLOR, "Color", options = null, colorOptions = listOf(Color.Black, Color.White, Color.Red, Color.DarkGray,
        Color.Yellow,
        Color.Blue,
        Color.Cyan, Color.Magenta)),
    Filter(FilterType.SIZE, "Size", options = listOf("One-Size", "XS", "S" ,"M", "L", "XL", "XXL")),
    Filter(FilterType.DISCOUNT, "Discount", options = listOf("50-70% OFF", "30-50%OFF", "10-30%OFF")),
    Filter(FilterType.SERVICE, "Service", options = listOf("Fast Delivery", "Same-Day Delivery", "Free Shippin", "COD (Cash On Delivery)", "International Shipping")),
    Filter(FilterType.PATTERN, "Pattern", options = listOf("Solid", "Floral", "Printed")),
    Filter(FilterType.STYLE, "Style", options = listOf("Sexy", "Minimalist", "Elegant", "Casual", "Relaxed")),
    )