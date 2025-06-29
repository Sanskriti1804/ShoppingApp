package com.example.shopping.components


import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.shopping.ui.theme.app_orange
import com.example.shopping.ui.theme.app_white_bg

@Composable
fun CustomBadge(
    showBadge : Boolean = true,
    badgeContent : (@Composable () -> Unit)? = null,
    badgeColor : Color = app_orange,
    contentColor : Color = app_white_bg
){
    if (!showBadge) return
                if (badgeContent != null) {
                    Badge(
                        containerColor = badgeColor,
                        contentColor = contentColor
                    ) {
                        badgeContent()
                    }
                } else {
                    Badge(containerColor = badgeColor)
                }
}