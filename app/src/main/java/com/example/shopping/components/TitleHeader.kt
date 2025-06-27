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
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopping.ui.theme.Typography
import com.example.shopping.ui.theme.app_dBlack

@Composable
fun CustomTitle(
    header : String,
    headerColor : Color = app_dBlack,
    fontWeight: FontWeight = FontWeight.SemiBold,
    fontSize : TextUnit = 22.sp,
    style: TextStyle = MaterialTheme.typography.titleLarge,
    modifier: Modifier = Modifier.padding(1.dp),
    maxLine: Int = 5
){
    Text(
        text = header,
        modifier = modifier,
        color = headerColor,
        style = style.copy(
            fontWeight = fontWeight,
            fontSize = fontSize
        ),
        maxLines = maxLine
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

