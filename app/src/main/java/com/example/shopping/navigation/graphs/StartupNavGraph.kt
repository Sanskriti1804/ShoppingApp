package com.example.shopping.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.shopping.navigation.Screen
import com.example.shopping.startup.EmailVerificationScreen
import com.example.shopping.startup.ForgotPasswordScreen
import com.example.shopping.startup.LoginScreen
import com.example.shopping.startup.NewPasswordScreen
import com.example.shopping.startup.SignupScreen
import com.example.shopping.startup.SplashScreen


fun NavGraphBuilder.StartupNavGraph(navController: NavHostController){
        composable(Screen.SplashScreen.route){
            SplashScreen(navController)
        }
        composable(Screen.SignupScreen.route){
            SignupScreen(navController)
        }
        composable(Screen.LoginScreen.route){
            LoginScreen(navController)
        }
        composable(Screen.ForgotPasswordScreen.route){
            ForgotPasswordScreen(navController)
        }
        composable(Screen.EmailVerificationScreen.route){
            EmailVerificationScreen(navController)
        }
        composable(Screen.NewPasswordScreen.route){
            NewPasswordScreen(navController)
        }
}