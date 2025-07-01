package com.example.shopping.cart.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopping.cart.data.Summary
import com.example.shopping.components.CustomBody
import com.example.shopping.components.CustomButton
import com.example.shopping.components.CustomCard
import com.example.shopping.components.CustomDivider
import com.example.shopping.components.CustomLabel
import com.example.shopping.components.CustomTitle
import com.example.shopping.ui.theme.Dimensions
import com.example.shopping.ui.theme.app_ltext

@Composable
fun CheckoutSummary(summary : Summary){

    CustomCard(
        onClick = {}
    ){
        Column(
            modifier = Modifier
                .padding(Dimensions.componentPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            CustomBody(
                header = "Summary"
            )

            CustomDivider()

            Spacer(modifier = Modifier.height(Dimensions.smallSpacer))

            CustomLabel(
                header = "Subtotal  :   ${summary.Subtotal}"
            )
            CustomLabel(
                header = "Shipping  :   ${summary.Shipping}"
            )
            CustomLabel(
                header =  "Tax :   ${summary.Tax}"
            )

            Spacer(modifier = Modifier.height(Dimensions.medSpacer))

            CustomTitle(
                header = "Total  : ${summary.Total}"
            )
        }

        Spacer(modifier = Modifier.height(Dimensions.medSpacer))

        CustomButton(
            textButton = true,
            onClick = {},
            buttonText = "PROCEED TO PAY",
            buttonDescription = "payment button"
        )
    }
}


@Preview(showBackground = true)
@Composable
fun CheckoutScreenPreview()
{
    val dummySummary =
        Summary(
            quantity = 2,
            Subtotal = 1200.00,
            Shipping = 1200.00,
            Tax = 1200.00,
            Total = 1200.00,
            recipient = "Sanskriti",
            address = "222 Street, India" ,
            payment ="Credit Card"
    )
    CheckoutSummary(dummySummary)
}