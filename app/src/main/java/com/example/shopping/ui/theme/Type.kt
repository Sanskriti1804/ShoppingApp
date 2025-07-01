package com.example.shopping.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.shopping.R


val appFont = FontFamily(
    Font(R.font.app_font)
)

val appRegular = FontFamily(
    Font(R.font.app_font_regular)
)

val appLight = FontFamily(
    Font(R.font.app_font_light)
)
// APP TYPOGRAPHY
val Typography = Typography(

    bodyLarge = TextStyle(
        fontFamily = appRegular ,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),

    titleLarge = TextStyle(
        fontFamily = appFont,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 28.sp,
        letterSpacing = 2.sp
    ),
    labelSmall = TextStyle(
        fontFamily = appLight,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )

)

