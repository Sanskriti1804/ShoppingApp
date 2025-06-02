package com.example.shopping.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun AppLogo(
    logoImage : Painter,
    appSize : Dp = 150.dp,
    appScale : ContentScale = ContentScale.Crop

){
    Image(
        painter = logoImage,
        contentDescription = "App Icon",
        contentScale = appScale,
        modifier = Modifier.size(appSize)
    )

}
