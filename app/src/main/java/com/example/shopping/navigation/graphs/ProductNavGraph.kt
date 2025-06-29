package com.example.shopping.navigation.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.shopping.home.screen.ProductListScreen
import com.example.shopping.home.screen.SearchScreen
import com.example.shopping.navigation.Screen
import com.example.shopping.product.ProductDescriptionScreen
import com.example.shopping.section.screen.FilterScreen
import com.example.shopping.section.screen.MenuScreen

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
}