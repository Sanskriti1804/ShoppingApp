package com.example.shopping.Profile.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.shopping.R
import com.example.shopping.components.CustomBody
import com.example.shopping.components.CustomCard
import com.example.shopping.components.CustomIcon
import com.example.shopping.components.CustomLabel
import com.example.shopping.components.CustomNavigationBar
import com.example.shopping.components.CustomProfilePic
import com.example.shopping.components.CustomTitle
import com.example.shopping.components.CustomTopBar
import com.example.shopping.ui.theme.Dimensions
import com.example.shopping.ui.theme.app_background

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    navController: NavHostController
){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    val profileImage = painterResource(id = R.drawable.profile)

    Scaffold(
        containerColor = app_background,
        topBar = {
            CustomTopBar(
                titleOverflow = TextOverflow.Ellipsis,
                scrollBehavior = scrollBehavior
            )
        },
        bottomBar = {
            CustomNavigationBar(navController = navController)
        }
    ) {paddingValues ->
        LazyColumn (
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth()
        ){
            item {
                ProfileSection(
                    profileImage = profileImage,
                    username = "GUNNI",
                    name = "heloiiw PETU"
                )
            }
            item {
                OrderCard(
                    onClick = {}
                )
            }
            item {
                CustomCard(
                    onClick = {}
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalAlignment = Alignment.Start
                    ) {
                        CustomBody(
                            header = "My Profile"
                        )
                        CustomBody(
                            header = " Refer and Earn"
                        )
                    }
                }
            }

            item {
                CustomCard(
                    onClick = {}
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalAlignment = Alignment.Start
                    ) {
                        CustomLabel(
                            header = "Help Center"
                        )
                        CustomLabel(
                            header = "Customer Service"
                        )
                        CustomLabel(
                            header = "Return Policy"
                        )
                        CustomLabel(
                            header = "Shipping Delivery"
                        )
                    }
                }
            }

            item {
                CustomCard(
                    onClick = {}
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(Dimensions.componentPadding),
                        horizontalAlignment = Alignment.Start
                    ) {
                        CustomLabel(
                            header = "About Service"
                        )
                        CustomLabel(
                            header = "About Us"
                        )
                    }
                }

            }
        }
    }
}


@Composable
fun ProfileSection(
    profileImage : Painter,
    username : String,
    name : String
){
    Row(
        modifier = Modifier.padding(Dimensions.componentPadding),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
//        CustomProfilePic()
        Column (
            modifier = Modifier.padding(Dimensions.componentPadding)
        ){
            CustomTitle(
                header = username
            )

            CustomLabel(
                header = name
            )
        }
    }
}

@Composable
fun OrderCard(
    onClick : () -> Unit,
    innerPadding : Dp = Dimensions.cardElementsPadding,
    cardTitle : String = "My Orders",
    viewmore : String = "View More",
    unpaid : Painter = painterResource(R.drawable.ic_order_unpaid),
    tracking : Painter = painterResource(R.drawable.ic_app_processing),
    delivered: Painter = painterResource(R.drawable.ic_order_delivered),
    returns : Painter = painterResource(R.drawable.ic_order_return),
    unpaidLabel : String = "Unpaid",
    trackingLabel : String = "Processing",
    deliveredLabel: String = "Delivered",
    returnsLabel : String = "Returns",
){
    CustomCard(
        onClick = onClick,
    ) {
        Column (
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
        ){
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                CustomBody(
                    header = cardTitle
                )

                CustomLabel(
                    header =  viewmore
                )
            }
            Spacer(modifier = Modifier.height(Dimensions.smallSpacer))

            Row(
                modifier = Modifier
                    .padding(Dimensions.componentPadding),
                horizontalArrangement = Arrangement.Absolute.SpaceAround
            )
            {
                Column {
                    CustomIcon(painter = unpaid)
                    CustomLabel(
                        header = unpaidLabel
                    )
                }

                Column {
                    CustomIcon(painter = tracking)
                    CustomLabel(
                        header = trackingLabel
                    )
                }

                Column {
                    CustomIcon(painter = delivered)
                    CustomLabel(
                        header = deliveredLabel
                    )
                }

                Column {
                    CustomIcon(painter = returns)
                    CustomLabel(
                        header = returnsLabel
                    )
                }

            }
        }

    }
}


//@Preview(showBackground = true)
//@Composable
//fun ProfileScreenPreview(){
//    ProfileScreen()
//}