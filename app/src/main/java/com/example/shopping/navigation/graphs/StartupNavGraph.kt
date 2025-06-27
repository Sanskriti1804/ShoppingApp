package com.example.shopping.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.shopping.navigation.Screen
import com.example.shopping.startup.screen.EmailVerificationScreen
import com.example.shopping.startup.screen.ForgotPasswordScreen
import com.example.shopping.startup.screen.LoginScreen
import com.example.shopping.startup.screen.NewPasswordScreen
import com.example.shopping.startup.screen.SignupScreen
import com.example.shopping.startup.screen.SplashScreen
import com.example.shopping.startup.viewmodel.AuthViewModel
import org.koin.androidx.compose.koinViewModel



fun NavGraphBuilder.StartupNavGraph(navController: NavHostController){
        composable(Screen.SplashScreen.route){
            SplashScreen(navController)
        }
        composable(Screen.SignupScreen.route){
            val authViewModel : AuthViewModel = koinViewModel()
            SignupScreen(navController, authViewModel)
        }
        composable(Screen.LoginScreen.route){
            val authViewModel : AuthViewModel = koinViewModel()
            LoginScreen(navController, authViewModel)
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