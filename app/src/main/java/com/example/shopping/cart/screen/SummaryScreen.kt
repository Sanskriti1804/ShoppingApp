package com.example.shopping.cart.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.example.shopping.components.CustomButton
import com.example.shopping.components.CustomCard
import com.example.shopping.ui.theme.app_lBlack

@Composable
fun CheckoutSummary(summary : Summary){

    CustomCard(
        onClick = {}
    ){
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "Summary"
            )
            Divider(thickness = 1.dp, color = Color.LightGray)
            Spacer(modifier = Modifier.height(3.dp))
            Text("Subtotal  :   ${summary.Subtotal}")
            Text("Shipping  :   ${summary.Shipping}")
            Text("Tax :   ${summary.Tax}")

            Spacer(modifier = Modifier.height(5.dp))
            Text("Total  : ${summary.Total}", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(5.dp))
        CustomButton(
            textButton = true,
            onClick = {},
            containerColor = app_lBlack,
            contentColor = app_lBlack,
            elevation = ButtonDefaults.buttonElevation(4.dp),
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