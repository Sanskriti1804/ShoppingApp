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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import com.example.shopping.R
import com.example.shopping.ui.theme.Strings
import com.example.shopping.ui.theme.app_dBlack
import com.example.shopping.ui.theme.app_lBlack

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(
    title: String = stringResource(Strings.appName),
    fontWeight : FontWeight = FontWeight.Bold,
    titleOverflow: TextOverflow,
    //navIcon
    navigationIcon: Painter = painterResource(R.drawable.ic_app_back),
    navigationIconColor: Color = app_lBlack,
    onNavigationClick: (() -> Unit)? = null,
    onActionClick: (() -> Unit) = {},
    actionIcon: Painter = painterResource(R.drawable.ic_app_search),
    containerColor: Color = Color.White,
    titleColor: Color = app_dBlack,
    actionIconColor: Color = app_lBlack,
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
        IconButton(onClick = {
            onNavigationClick?.invoke()     //safely calls only if it is null
        }) {
            CustomIcon(painter = navigationIcon)
        }
    },
    actions = {
        IconButton(onClick = {onActionClick()}) {
            CustomIcon(painter = actionIcon)
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