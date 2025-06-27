package com.example.shopping.startup.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.shopping.R
import com.example.shopping.components.AppLogo
import com.example.shopping.components.CustomButton
import com.example.shopping.components.CustomCard
import com.example.shopping.components.CustomTextField
import com.example.shopping.components.CustomTitle
import com.example.shopping.navigation.Screen
import com.example.shopping.startup.viewmodel.AuthViewModel
import com.example.shopping.ui.theme.Strings

@Composable
fun LoginScreen(
    navController: NavHostController,
    authViewModel: AuthViewModel
){

    val appLogo = painterResource(id = R.drawable.iconapp)

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }

    Column (
        modifier = Modifier.padding(top = 100.dp, start = 30.dp, end = 30.dp, bottom = 30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        AppLogo(
            logoImage = appLogo
        )

        Spacer(modifier = Modifier.height(36.dp))

        CustomTitle(
            header = stringResource(Strings.login),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 40.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        CustomCard(
            onClick = {}
        ) {
            Column(
                modifier = Modifier.padding(28.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CustomTitle(
                    header = "email"
                )
                CustomTextField(
                    value = email,
                    onValueChange = {email = it},
                    placeholder = "Enter your email"
                )
                CustomTitle(
                    header = "Password"
                )
                CustomTextField(
                    value = password,
                    onValueChange = {password = it},
                    placeholder = "Enter your password",
                    visualTransformation = PasswordVisualTransformation()
                )

                Spacer(modifier = Modifier.height(12.dp))

                CustomButton(
                    textButton = true,
                    onClick = {
                        authViewModel.login(email, password)
                        navController.navigate(Screen.HomeScreen.route)},
                    buttonText = stringResource(Strings.login),
                    elevation = ButtonDefaults.buttonElevation(4.dp),
                    buttonDescription = "login"
                )

                CustomTitle(
                    header = "Forgot Password",
                    fontSize = 10.sp,
                    modifier = Modifier
                        .clickable(
                            onClick = {navController.navigate(Screen.ForgotPasswordScreen.route)}
                        )
                )
            }
        }
    }
}
//
//@Preview(showBackground = true)
//@Composable
//fun LoginScreenPreview(){
//    val dummyNavController = rememberNavController()
//    LoginScreen(dummyNavController)
//}