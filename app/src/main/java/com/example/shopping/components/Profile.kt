package com.example.shopping.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.shopping.ui.theme.app_lBlack


@Composable
fun ProfileSection(
    profilePhoto : Painter,
    profileDesc : String,
    contentScale: ContentScale = ContentScale.Crop,
    borderWidth : Dp = 1.dp,
    borderColor : Color = app_lBlack,
    shape : Shape = CircleShape
){
    Row (
        modifier = Modifier.padding(12.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        Image(
            painter = profilePhoto,
            contentDescription = profileDesc,
            contentScale = contentScale,
            modifier = Modifier
                .border(width = borderWidth, color = borderColor)
                .clip(shape = shape)
        )
    }
}