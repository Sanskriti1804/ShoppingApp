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
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.shopping.R
import com.example.shopping.components.CustomButton
import com.example.shopping.components.CustomDivider
import com.example.shopping.components.CustomTitle
import com.example.shopping.components.CustomTopBar
import com.example.shopping.components.EmptyState
import com.example.shopping.ui.theme.app_lBlack
import com.example.shopping.ui.theme.app_lGray
import com.example.shopping.ui.theme.app_white


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmptyCartScreen(

) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.emptycart))
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
                navigationIconColor = Color.Black,
                onNavigationClick = {},
                containerColor = app_white, // Assuming this color is defined elsewhere
                titleColor = Color.Black,
                actionIconColor = Color.Black,
                scrollBehavior = scrollBehavior
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            CustomTitle(
                header = "Cart"
            )

            CustomDivider()

            composition?.let {
                EmptyState(
                    composition = it,
                    progress = { lottieProg }
                )
            }

            CustomTitle(
                header = "Empty Cart",
                headerColor = app_lGray,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 36.sp
            )

            CustomTitle(
                header = "Your Cart is Empty",
                headerColor = app_white,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )

            CustomButton(
                textButton = true,
                onClick = {},
                containerColor = app_lBlack,
                contentColor = Color.Black,
                elevation = ButtonDefaults.buttonElevation(2.dp),
                buttonText = "START SHOPPING",
                buttonDescription = "shart shopping button"

            )

        }
    }
}



@Preview(showBackground = true)
@Composable
fun EmptyCartScreenPreview()
{
    EmptyCartScreen()
}