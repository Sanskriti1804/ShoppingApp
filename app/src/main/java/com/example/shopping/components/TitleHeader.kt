package com.example.shopping.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopping.ui.theme.app__dtext

@Composable
fun CustomTitle(
    header : String,
    headerColor : Color = app__dtext,
    fontWeight: FontWeight = FontWeight.Bold,
    fontSize : TextUnit = 24.sp,
    style: TextStyle = MaterialTheme.typography.bodyLarge,
    modifier: Modifier = Modifier.padding(1.dp),
    maxLine: Int = 1
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
fun CustomBody(
    header : String,
    headerColor : Color = app__dtext,
    fontWeight: FontWeight = FontWeight.SemiBold,
    fontSize : TextUnit = 22.sp,
    style: TextStyle = MaterialTheme.typography.bodyLarge,
    modifier: Modifier = Modifier.padding(1.dp),
    maxLine: Int = 1
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
fun CustomLabel(
    header : String,
    headerColor : Color = app__dtext,
    fontWeight: FontWeight = FontWeight.Normal,
    fontSize : TextUnit = 18.sp,
    style: TextStyle = MaterialTheme.typography.labelSmall,
    modifier: Modifier = Modifier.padding(1.dp),
    maxLine: Int = 1
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

