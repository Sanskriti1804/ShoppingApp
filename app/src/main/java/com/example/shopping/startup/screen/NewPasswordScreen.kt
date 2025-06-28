package com.example.shopping.startup.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.shopping.R
import com.example.shopping.components.CustomButton
import com.example.shopping.components.CustomField
import com.example.shopping.components.CustomTitle
import com.example.shopping.components.CustomTopBar
import com.example.shopping.components.EmptyState
import com.example.shopping.navigation.Screen
import com.example.shopping.ui.theme.app_lGray
import com.example.shopping.ui.theme.app_white_bg


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewPasswordScreen(navController: NavHostController){

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())


    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.forgot_password))
    val lottieProg by animateLottieCompositionAsState(
        composition = composition,
        isPlaying = true,
        speed = 0.6f,
        iterations = LottieConstants.IterateForever

    )

    Scaffold (
        containerColor = app_white_bg,
        topBar = {
            CustomTopBar(
                title = "Create New Password",
                titleOverflow = TextOverflow.Ellipsis,
                scrollBehavior = scrollBehavior
            )}
    ){ paddingValues ->
        Column (
            modifier = Modifier.padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Spacer(modifier = Modifier.height(50.dp))
            composition?.let {
                EmptyState(
                    composition = it,
                    progress = { lottieProg }
                )
            }

            Spacer(modifier = Modifier.height(15.dp))
            CustomTitle(
                header = "Your New Password must be different from previously used Password",
                fontWeight = FontWeight.Normal,
                fontSize = 22.sp
            )
            Spacer(modifier = Modifier.height(10.dp))

            CustomField(
                value = "New Password",
                onValueChange = {},
                placeholder = "New Password"
            )
            Spacer(modifier = Modifier.height(4.dp))
            CustomField(
                value = "Confirm Password",
                onValueChange = {},
                placeholder = "Confirm Password"
            )
            Spacer(modifier = Modifier.height(10.dp))


            CustomButton(
                textButton = true,
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = {navController.navigate(Screen.HomeScreen.route)},
                buttonText = "Save",
                elevation = ButtonDefaults.buttonElevation(4.dp),
                buttonDescription = "Save Password button"
            )


        }
    }
}

@Preview(showBackground = true)
@Composable
fun newpasswordcreenPreview(){
    val dummyNavController = rememberNavController()
    NewPasswordScreen(dummyNavController)
}