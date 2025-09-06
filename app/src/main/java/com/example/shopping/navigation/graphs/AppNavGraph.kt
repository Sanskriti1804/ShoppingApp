package com.example.shopping.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shopping.Profile.Screen.ProfileScreen
import com.example.shopping.home.screen.ProductListScreen
import com.example.shopping.navigation.Screen
import com.example.shopping.order.screens.OrderScreen
import com.example.shopping.order.viewmodel.ShipRocketViewModel
import com.example.shopping.startup.viewmodel.AuthViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainApp(){
    val navController = rememberNavController()
    AppNavGraph(navController)
}

@Composable
fun AppNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screen.OrderScreen.route
    ) {
        StartupNavGraph(navController)
        CartNavGraph(navController)
        ProductNavGraph(navController)
        composable(Screen.ProfileScreen.route) {
            ProfileScreen(
                navController = navController
            )
        }
    }
}