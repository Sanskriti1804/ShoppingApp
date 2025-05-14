package com.example.shopping.components


import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun CustomBadge(
    showBadge : Boolean,
    badgeContent : (@Composable () -> Unit)? = null,
    badgeColor : Color,
    contentColor : Color,
    component : (@Composable () -> Unit)? = null
){
    BadgedBox(
        badge = {
            if (showBadge) {
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
        }
    ) {
        if (component != null) {
            component()
        }
    }
}
