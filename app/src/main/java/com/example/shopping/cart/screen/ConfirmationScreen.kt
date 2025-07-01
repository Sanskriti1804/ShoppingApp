package com.example.shopping.cart.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
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
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.shopping.R
import com.example.shopping.components.CustomBody
import com.example.shopping.components.CustomButton
import com.example.shopping.components.CustomLabel
import com.example.shopping.components.CustomTitle
import com.example.shopping.components.CustomTopBar
import com.example.shopping.ui.theme.app__dtext
import com.example.shopping.ui.theme.app_lComponent
import java.util.Date


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfirmationScreen(){
    var scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.t1))
    val lottieProg by animateLottieCompositionAsState(
        composition = composition,
        isPlaying = true,
        speed = 0.6f,
        iterations = LottieConstants.IterateForever
    )

    Scaffold(
        topBar = {
            CustomTopBar(
                titleOverflow = TextOverflow.Ellipsis,
                onNavigationClick = {},
                scrollBehavior = scrollBehavior
            )
        }
    ){paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomTitle(
                header = "THANKYOU FOR YOUR ORDER"
            )

            composition?.let {
                SuccessState(
                    composition = it,
                    progress = { lottieProg}
                )
            }

            CustomBody(
                header = "Estimated Delivery"
            )
            CustomLabel(
                header = Date().toString()
            )
            CustomLabel(
                header = "We've emailed a confirmation and we'll notify you when your order has been shipped"
            )

            CustomButton(
                textButton = true,
                onClick = {},
                buttonText = "VIEW PLACED ORDER",
                buttonDescription = "order desc"
            )
        }
    }
}

@Composable
fun SuccessState(
    composition : LottieComposition,
    progress : () -> Float
){
    LottieAnimation(
        composition = composition,
        progress = progress
    )
}


@Preview(showBackground = true)
@Composable
fun ConfirmationScreenPreview()
{
    ConfirmationScreen()
}