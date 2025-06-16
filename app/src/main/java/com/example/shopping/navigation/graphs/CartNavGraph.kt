package com.example.shopping.navigation.graphs

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.shopping.cart.data.Summary
import com.example.shopping.cart.screen.CancellationScreen
import com.example.shopping.cart.screen.CartScreen
import com.example.shopping.cart.screen.CheckoutSummary
import com.example.shopping.cart.screen.ConfirmationScreen
import com.example.shopping.cart.screen.EmptyCartScreen
import com.example.shopping.navigation.Screen


@SuppressLint("SuspiciousIndentation")
fun NavGraphBuilder.CartNavGraph(navController: NavHostController){
    val dummySummary =
        Summary(
            quantity = 2,
            Subtotal = 1200.00,
            Shipping = 1200.00,
            Tax = 1200.00,
            Total = 1200.00,
            recipient = "Sanskriti",
            address = "222 Street, India" ,
            payment ="Credit Card"
        )

        composable(Screen.CartScreen.route) {
            CartScreen()
        }
        composable(Screen.CancellationScreen.route) {
            CancellationScreen()
        }
        composable(Screen.CheckoutScreen.route) {
        }
        composable(Screen.ConfirmationScreen.route) {
            ConfirmationScreen()
        }
        composable(Screen.EmptyCartScreen.route) {
            EmptyCartScreen()
        }
        composable(Screen.SummaryScreen.route) {
            CheckoutSummary(
                summary = dummySummary
            )
    }
}