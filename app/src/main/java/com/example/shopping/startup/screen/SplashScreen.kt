package com.example.shopping.startup.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.shopping.R
import com.example.shopping.components.AppLogo
import com.example.shopping.components.CustomTitle
import com.example.shopping.navigation.Screen
import com.example.shopping.ui.theme.Strings
import kotlinx.coroutines.delay

@SuppressLint("SuspiciousIndentation")
@Composable
fun SplashScreen(navController: NavHostController)
{
    val appLogo = painterResource(id = R.drawable.iconapp)

        LaunchedEffect(Unit) {
            delay(3000)
            navController.navigate(Screen.SignupScreen.route)
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                AppLogo(
                    logoImage = appLogo
                )

                Spacer(modifier = Modifier.height(15.dp))

                CustomTitle(
                    header = stringResource(Strings.appName),
                    fontSize = 56.sp,
                    fontWeight = FontWeight.ExtraBold,
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview(){
    val dummyNavController = rememberNavController()
    SplashScreen(navController = dummyNavController)
}