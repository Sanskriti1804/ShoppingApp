package com.example.shopping.home.data

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter

data class DiscountData(
    val title : String,
    val desc : String,
    val textColor : Color,
    val descColor : Color,
    val image : List<Int>,
    val ctaText : String = "Buy now",
)