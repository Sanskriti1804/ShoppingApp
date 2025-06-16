package com.example.shopping.startup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.shopping.Profile.Screen.ProfileScreen
import com.example.shopping.R
import com.example.shopping.components.AppLogo
import com.example.shopping.components.CustomButton
import com.example.shopping.components.CustomCard
import com.example.shopping.components.CustomTextField
import com.example.shopping.components.CustomTitle
import com.example.shopping.navigation.Screen

@Composable
fun SignupScreen(navController: NavHostController){
    val appLogo = painterResource(id = R.drawable.iconapp)

    Column (
        modifier = Modifier.padding(12.dp),
        verticalArrangement = Arrangement.Center
    ){
        AppLogo(
            logoImage = appLogo
        )

        Spacer(modifier = Modifier.height(36.dp))

        CustomTitle(
            header = "SIGNUP SCREEN"
        )

        Spacer(modifier = Modifier.height(18.dp))

        CustomCard(
            onClick = {}
        ) {
            Column(
                modifier = Modifier.padding(28.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CustomTitle(
                    header = "Username"
                )
                CustomTextField(
                    value = "Username",
                    onValueChange = {},
                    placeholder = "Enter your Username"
                )
                CustomTitle(
                    header = "Name"
                )
                CustomTextField(
                    value = "Name",
                    onValueChange = {},
                    placeholder = "Enter your name"
                )
                CustomTitle(
                    header = "Password"
                )
                CustomTextField(
                    value = "Password",
                    onValueChange = {},
                    placeholder = "Enter your password"
                )

                Spacer(modifier = Modifier.height(12.dp))

                CustomButton(
                    textButton = true,
                    onClick = {navController.navigate(Screen.LoginScreen.route)},
                    buttonText = "SIGN UP",
                    elevation = ButtonDefaults.buttonElevation(4.dp),
                    buttonDescription = "signup"

                )
            }
            }
        }
}

@Preview(showBackground = true)
@Composable
fun SignupScreenPreview(){
    val dummyNavController = rememberNavController()
    SignupScreen(dummyNavController)
}