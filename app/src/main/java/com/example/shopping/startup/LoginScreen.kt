package com.example.shopping.startup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shopping.Profile.Screen.ProfileScreen
import com.example.shopping.R
import com.example.shopping.components.AppLogo
import com.example.shopping.components.CustomButton
import com.example.shopping.components.CustomCard
import com.example.shopping.components.CustomTextField
import com.example.shopping.components.CustomTitle

@Composable
fun LoginScreen(

){
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
            header = "LOGIN SCREEN"
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
                    onClick = {},
                    buttonText = "LOG IN",
                    elevation = ButtonDefaults.buttonElevation(4.dp),
                    buttonDescription = "signup"

                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview(){
    LoginScreen()
}