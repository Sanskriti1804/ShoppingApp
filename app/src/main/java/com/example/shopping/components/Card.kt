package com.example.shopping.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.shopping.ui.theme.Dimensions
import com.example.shopping.ui.theme.Shapes
import com.example.shopping.ui.theme.app__dtext
import com.example.shopping.ui.theme.app_lComponent


@Composable
fun CustomCard(
    onClick: () -> Unit,
    padding : Dp = Dimensions.cardElementsPadding,
    shape: Shape = Shapes.CardShape,
    elevation: CardElevation = CardDefaults.cardElevation(Dimensions.cardElevation),
    containerColor: Color = app_lComponent,
    contentColor: Color = app__dtext,
    content : @Composable () -> Unit
){
    Card (
        modifier = Modifier
            .padding(padding),
        onClick = onClick,
        shape = shape,
        elevation = elevation,
        colors = CardDefaults.cardColors(
            containerColor = containerColor,
            contentColor = contentColor
        )
    ){
        content()
    }
}