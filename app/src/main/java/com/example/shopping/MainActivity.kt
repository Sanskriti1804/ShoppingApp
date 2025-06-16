package com.example.shopping

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.shopping.cart.screen.CartScreen
import com.example.shopping.navigation.graphs.MainApp
import com.example.shopping.section.screen.MenuScreen
import com.example.shopping.ui.theme.ShoppingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShoppingTheme {
//                MenuScreen()
//                ScrollableGridScreen()
//                ProductListScreen()
//                FilterScreen()
//                CartScreen()
                MainApp()
                }
            }
        }
    }

