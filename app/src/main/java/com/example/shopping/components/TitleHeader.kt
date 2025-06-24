package com.example.shopping.components

import android.R
import android.util.Size
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopping.ui.theme.Typography

@Composable
fun CustomTitle(
    header : String,
    headerColor : Color = Color.Black,
    fontWeight: FontWeight = FontWeight.SemiBold,
    fontSize : TextUnit = 24.sp,
    style: TextStyle = MaterialTheme.typography.bodyLarge
){
    Text(
        text = header,
        color = headerColor,
        style = style.copy(
            fontWeight = fontWeight,
            fontSize = fontSize
        )
    )
}

@Composable
fun CustomDivider(
    modifier: Modifier = Modifier.padding(12.dp),
    thickness : Dp = 2.dp,
    divColor : Color = Color.DarkGray
){
    Divider(
        modifier = modifier,
        thickness = thickness,
        color = divColor
    )
}

