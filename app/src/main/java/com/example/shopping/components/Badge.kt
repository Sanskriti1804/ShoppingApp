package com.example.shopping.components


import android.annotation.SuppressLint
import androidx.compose.material3.Badge
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.shopping.ui.theme.app_highlight
import com.example.shopping.ui.theme.app_background

@SuppressLint("SuspiciousIndentation")
@Composable
fun CustomBadge(
    showBadge : Boolean = true,
    badgeContent : (@Composable () -> Unit)? = null,
    badgeColor : Color = app_highlight,
    contentColor : Color = app_background
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