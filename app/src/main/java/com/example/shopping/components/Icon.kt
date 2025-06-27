package com.example.shopping.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.shopping.ui.theme.app_dBlack
import com.example.shopping.ui.theme.app_white

@Composable
fun CustomIcon(
    painter : Painter,
    iconDescription : String = "Dunelle Icon",
    iconPadding : Dp = 1.dp,
    iconSize : Dp = 20.dp,
    iconColor : Color = app_dBlack

){
    Icon(
        painter = painter,
        contentDescription = iconDescription,
        modifier = Modifier
            .padding(iconPadding)
            .size(iconSize),
        tint = iconColor
    )
}