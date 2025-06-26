package com.example.shopping.navigation

import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import com.example.shopping.R

data class BottomNavScreens (
    val route: String,
    val iconResId: Int,
    val navIconDesc : String = "Navigation icon",
    val label: String,
    val hasNews : Boolean = false,
    val badgeCount : Int? = null,
    val selected : Boolean = false,
)

val bottomNavItems = listOf(
    BottomNavScreens(
        route = Screen.HomeScreen.route,
        iconResId = R.drawable.ic_app_home,
        label = "Home"
    ),
    BottomNavScreens(
        route = Screen.MenuScreen.route,
        iconResId = R.drawable.ic_app_menu ,
        label = "Menu",
        hasNews = true

    ),
    BottomNavScreens(
        route = Screen.CartScreen.route,
        iconResId = R.drawable.ic_app_cart,
        label = "Cart",
        badgeCount = 23
    ),
    BottomNavScreens(
        route = Screen.ProfileScreen.route,
        iconResId = R.drawable.ic_app_user,
        label = "Me"
    )
)
