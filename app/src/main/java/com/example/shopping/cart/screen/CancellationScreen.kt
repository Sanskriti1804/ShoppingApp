package com.example.shopping.cart.screen

import androidx.compose.foundation.layout.Column
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
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.shopping.R
import com.example.shopping.components.CustomButton
import com.example.shopping.components.CustomTitle
import com.example.shopping.components.CustomTopBar
import com.example.shopping.ui.theme.app_dBlack
import com.example.shopping.ui.theme.app_lGray


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CancellationScreen(){
    var scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.t2))
    val lottieProg by animateLottieCompositionAsState(
        composition = composition,
        isPlaying = true,
        speed = 0.6f,
        iterations = LottieConstants.IterateForever
    )

    Scaffold(
        topBar = {
            CustomTopBar(
                title = "Shoppie",
                fontWeight = FontWeight.ExtraBold,
                titleOverflow = TextOverflow.Ellipsis,
                navigationIcon = Icons.Default.ArrowBack,
                navigationIconColor = Color.Black,
                onNavigationClick = {},
                actionIcon = Icons.Default.Favorite,
                containerColor = app_dBlack, // Assuming this color is defined elsewhere
                titleColor = Color.Black,
                actionIconColor = Color.Black,
                scrollBehavior = scrollBehavior
            )
        }
    ){paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomTitle(
                header = "ORDER FAILED",
                headerColor = app_lGray,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 32.sp
            )

            composition?.let {
                CancellationState(
                    composition = it,
                    progress = { lottieProg}
                )
            }

            CustomTitle(
                header = "Couldn't place your order",
                headerColor = app_dBlack,
                fontWeight = FontWeight.SemiBold,
                fontSize = 22.sp
            )

            CustomTitle(
                header = "Please try again!!",
                headerColor = app_dBlack,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp
            )

            CustomButton(
                textButton = true,
                onClick = {},
                containerColor = app_dBlack,
                contentColor = app_lGray,
                elevation = ButtonDefaults.buttonElevation(4.dp),
                buttonText = "BACK TO ORDER",
                buttonDescription = "order desc"
            )
        }
    }
}


@Composable
fun CancellationState(
    composition : LottieComposition,
    progress: () -> Float
){
    LottieAnimation(
        composition = composition,
        progress = progress
    )
}


@Preview(showBackground = true)
@Composable
fun CancellationScreenPreview()
{
    CancellationScreen()
}