package com.example.shopping.order.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.isTraceInProgress
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.shopping.R
import com.example.shopping.cart.data.CartProduct
import com.example.shopping.cart.screen.CartProdCard
import com.example.shopping.cart.viewmodel.CartViewModel
import com.example.shopping.components.CustomBody
import com.example.shopping.components.CustomButton
import com.example.shopping.components.CustomCard
import com.example.shopping.components.CustomDivider
import com.example.shopping.components.CustomLabel
import com.example.shopping.components.CustomTitle
import com.example.shopping.components.EmptyState
import com.example.shopping.ui.theme.Dimensions
import com.example.shopping.ui.theme.app_highlight
import org.koin.androidx.compose.koinViewModel
import java.util.Date
import java.util.TimeZone

@Composable
fun OrderStatusScreen(){

    val viewModel : CartViewModel = koinViewModel()
    val order = viewModel.cartList

    Column(
      modifier = Modifier
          .fillMaxWidth()
          .padding(Dimensions.appPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.emptycart))
        val lottieProg by animateLottieCompositionAsState(
            composition = composition,
            isPlaying = true,
            speed = 0.6f,
            iterations = LottieConstants.IterateForever
        )
        composition?.let{
            EmptyState(
                composition = it,
                progress = {lottieProg}
            )
        }

        CustomTitle(
            header = "Order Status"
        )
        CustomBody(
            header = "Your packcage is on the way"
        )

        order.forEach {
            CartProdCard(
                cartProduct = it,
                onClick = {}
            )
        }

        OrderSummary()

        Spacer(modifier = Modifier.height(Dimensions.medSpacer))
        CustomButton(
            textButton = true,
            onClick = {},
            buttonText = "TRACK ORDER",
            buttonDescription = "track order button"
        )

        CustomLabel(
            header = "Your Order is confirmed and is in transit",
            headerColor = app_highlight
        )


    }
}

@Composable
fun OrderSummary(){
    CustomCard(
        onClick = {}
    ) {
        Column (
            modifier = Modifier
                .padding(Dimensions.componentPadding)
                .fillMaxWidth()
        ){
            CustomTitle(
                header = "Order Summary"
            )
            CustomDivider()
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(Dimensions.componentPadding),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CustomLabel(
                    header = "Order ID",
                    fontWeight = FontWeight.Bold
                )
                CustomLabel(
                    header = "152425475274"
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(Dimensions.componentPadding),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CustomLabel(
                    header = "Customer name",
                    fontWeight = FontWeight.Bold
                )
                Row {
                    CustomLabel(
                        header = "Gunni Munni"
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(Dimensions.componentPadding),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CustomLabel(
                    header = "Shipping Address",
                    fontWeight = FontWeight.Bold
                )
                CustomLabel(
                    header = "45 Fazalpur lilliput"
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(Dimensions.componentPadding),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CustomLabel(
                    header = "Tracking ID",
                    fontWeight = FontWeight.Bold
                )
                CustomLabel(
                    header = "15757235475237"
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(Dimensions.componentPadding),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CustomLabel(
                    header = "Estimated Delivery Date",
                    fontWeight = FontWeight.Bold
                )
                Row {
                    CustomLabel(
                        header = Date().toString()
                    )
                    CustomLabel(
                        header = "5: 40"
                    )
                }
            }


        }
    }
}

@Preview(showBackground = true)
@Composable
fun OrderSummaryPreview(){
    OrderSummary()
}