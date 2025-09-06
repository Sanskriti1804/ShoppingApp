package com.example.shopping.navigation.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.shopping.home.screen.ProductListScreen
import com.example.shopping.home.screen.SearchScreen
import com.example.shopping.navigation.Screen
import com.example.shopping.order.screens.OrderScreen
import com.example.shopping.order.viewmodel.ShipRocketViewModel
import com.example.shopping.product.ProductDescriptionScreen
import com.example.shopping.section.screen.FilterScreen
import com.example.shopping.section.screen.MenuScreen
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.ProductNavGraph(navController: NavHostController){
    composable(Screen.HomeScreen.route){
        ProductListScreen(navController)
    }
    composable(Screen.FilterScreen.route){
        FilterScreen()
    }
    composable(Screen.MenuScreen.route){
        MenuScreen(navController = navController)
    }
    composable(Screen.SearchScreen.route){
        SearchScreen()
    }
    composable(Screen.ProductDescriptionScreen.route) {
        ProductDescriptionScreen()
    }
    composable(Screen.OrderScreen.route) {
        val shipRocketViewModel : ShipRocketViewModel = koinViewModel()
        OrderScreen(
            viewModel = shipRocketViewModel
        )
    }
}