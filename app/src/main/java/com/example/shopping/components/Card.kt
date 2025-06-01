package com.example.shopping.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.example.shopping.ui.theme.T_CardColor
import com.example.shopping.ui.theme.T_DTextColor


@Composable
fun CustomCard(
    onClick: () -> Unit,
    shape: Shape = RoundedCornerShape(6.dp),
    elevation: CardElevation = CardDefaults.cardElevation(4.dp),
    containerColor: Color = T_CardColor,
    contentColor: Color = Color.Black,
    content : @Composable () -> Unit
){
    Card (
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