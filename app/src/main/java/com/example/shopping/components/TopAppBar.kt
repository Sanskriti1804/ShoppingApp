package com.example.shopping.components

import android.R.attr.fontStyle
import android.R.style
import androidx. compose. ui. graphics. Color
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(
    title: String,
    fontWeight : FontWeight,
    titleOverflow: TextOverflow,

    //navIcon
    navigationIcon: ImageVector,
    navigationIconColor: Color,
    onNavigationClick: (() -> Unit)? = null,

    actionIcon: ImageVector,
    containerColor: Color,
    titleColor: Color,
    actionIconColor: Color,

    scrollBehavior: TopAppBarScrollBehavior
){ CenterAlignedTopAppBar(
    title = {
        Text(
            text = title,
            fontWeight = fontWeight,
            overflow = titleOverflow
        )
    },
    navigationIcon = {
        IconButton(onClick = {}) {
            Icon(imageVector = navigationIcon, contentDescription = null)
        }
    },
    actions = {
        IconButton(onClick = {}) {
            Icon(imageVector = navigationIcon, contentDescription = null)
        }
    },
    scrollBehavior = scrollBehavior,
    colors = TopAppBarDefaults.topAppBarColors(
        containerColor = containerColor,
        navigationIconContentColor = navigationIconColor,
        titleContentColor = titleColor,
        actionIconContentColor = actionIconColor
    )
)
}