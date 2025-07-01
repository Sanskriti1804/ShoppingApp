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
import com.example.shopping.ui.theme.Dimensions
import com.example.shopping.ui.theme.app__dtext

@Composable
fun CustomIcon(
    painter : Painter,
    iconDescription : String = "Dunelle Icon",
    iconPadding : Dp = Dimensions.iconPadding,
    iconSize : Dp = Dimensions.iconSize,
    iconColor : Color = app__dtext

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