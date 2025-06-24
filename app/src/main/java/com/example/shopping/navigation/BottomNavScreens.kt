package com.example.shopping.navigation

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
    val icon: ImageVector,
    val label: String,
    val hasNews : Boolean = false,
    val badgeCount : Int? = null,
    val selected : Boolean = false
)

val bottomNavItems = listOf(
    BottomNavScreens(
        route = Screen.HomeScreen.route,
        icon = Icons.Default.Home,
        label = "Home"
    ),
    BottomNavScreens(
        route = Screen.MenuScreen.route,
        icon = Icons.Default.Menu,
        label = "Menu",
        hasNews = true

    ),
    BottomNavScreens(
        route = Screen.CartScreen.route,
        icon = Icons.Default.ShoppingCart,
        label = "Cart",
        badgeCount = 23
    ),
    BottomNavScreens(
        route = Screen.ProfileScreen.route,
        icon = Icons.Default.Person,
        label = "Me"
    )
)
