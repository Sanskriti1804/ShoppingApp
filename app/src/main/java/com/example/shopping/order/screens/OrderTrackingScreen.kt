package com.example.shopping.order.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.shopping.R
import com.example.shopping.components.CustomButton
import com.example.shopping.components.CustomCard
import com.example.shopping.components.CustomIcon
import com.example.shopping.components.CustomLabel
import com.example.shopping.components.CustomProfilePic
import com.example.shopping.components.CustomTitle
import com.example.shopping.components.CustomTopBar
import com.example.shopping.ui.theme.Dimensions
import com.example.shopping.ui.theme.app_background
import com.example.shopping.ui.theme.app_llComponent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderTrackingScreen(){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    Scaffold(
        containerColor = app_background,
        topBar = {
            CustomTopBar(
                title = "Order Track",
                titleOverflow = TextOverflow.Ellipsis,
                scrollBehavior = scrollBehavior
            )
        }
    ) {paddingValues ->
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
        ){
            OrderDetails()
            DeliveryPartener()
        }
    }
}

@Composable
fun OrderDetails(){
    Column (
        modifier = Modifier
            .padding(Dimensions.appPadding)
            .fillMaxWidth()
    ){
        CustomTitle(
            header = "Details"
        )
        CustomCard(
            onClick = {}
        ) {
            Row(
                modifier = Modifier
                    .padding(Dimensions.componentPadding)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                CustomIcon(
                    painter = painterResource(R.drawable.ic_history)
                )
                Column {
                    CustomLabel(
                        header = "10 -15 mins",
                        fontWeight = FontWeight.Bold
                    )
                    CustomLabel(
                        header = "Delivery Item",
                        headerColor = app_llComponent
                    )
                }
            }

            Row(
                modifier = Modifier
                    .padding(Dimensions.componentPadding)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                CustomIcon(
                    painter = painterResource(R.drawable.ic_history)
                )
                Column {
                    CustomLabel(
                        header = "78 LilyGarden vipinGargen",
                        fontWeight = FontWeight.Bold
                    )
                    CustomLabel(
                        header = "YoourAddress",
                        headerColor = app_llComponent
                    )
                }
            }

        }
    }
}


@Composable
fun DeliveryPartener(){
    CustomCard(
        onClick = {},
        shape = RoundedCornerShape(10.dp)
    ) {
        Row (
            modifier = Modifier.padding(Dimensions.componentPadding)
        ){
            CustomProfilePic(
                profilePadding = Dimensions.barProfileSize
            )

            Column {
                CustomLabel(
                    header = "maxxxist",
                    fontWeight = FontWeight.Bold
                )
                CustomLabel(
                    header = "Your courier",
                    headerColor = app_llComponent
                )
            }

            Row(
                horizontalArrangement = Arrangement.End
            ) {
                CustomIcon(
                    painter = painterResource(R.drawable.ic_app_star)
                )
                CustomIcon(
                    painter = painterResource(R.drawable.ic_app_star_fill)
                )
            }
        }
    }
}