package com.example.shopping.home.data

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import com.example.shopping.ui.theme.app_lComponent

data class CategoryData(
    val icon : Painter,
    val label : String = "Category Icon",
    val bgColor : Color = app_lComponent
)
