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
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.shopping.R
import com.example.shopping.components.CustomCard
import com.example.shopping.components.CustomNavigationBar
import com.example.shopping.components.CustomProfilePic
import com.example.shopping.components.CustomTitle
import com.example.shopping.components.CustomTopBar
import com.example.shopping.components.ProfileSection
import com.example.shopping.ui.theme.app_white_bg

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    navController: NavHostController
){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    val profileImage = painterResource(id = R.drawable.profile)

    Scaffold(
        containerColor = app_white_bg,
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
                        CustomTitle(
                            header = "My Profile",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Thin
                        )
                        CustomTitle(
                            header = "Refer and Earn",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Thin
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
                        CustomTitle(
                            header = "Help Center",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Thin
                        )
                        CustomTitle(
                            header = "Customer Service",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Thin
                        )
                        CustomTitle(
                            header = "Return Policy",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Thin
                        )
                        CustomTitle(
                            header = "Shipping Delivery",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Thin
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
                        CustomTitle(
                            header = "About Service",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Thin
                        )
                        CustomTitle(
                            header = "About Us",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Thin
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
        modifier = Modifier.padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CustomProfilePic()
        Column (
            modifier = Modifier.padding(15.dp)
        ){
            CustomTitle(
                header = username,
                fontWeight = FontWeight.Bold
            )

            CustomTitle(
                header = name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Thin
            )
        }
    }
}

@Composable
fun OrderCard(
    onClick : () -> Unit,
    innerPadding : Dp = 8.dp,
    cardTitle : String = "My Orders",
    orderFont : TextUnit = 16.sp,
    viewmoreFont : TextUnit = 14.sp,
    viewmore : String = "View More",
    unpaid : Painter = painterResource(R.drawable.ic_order_unpaid) ,
    tracking : Painter = painterResource(R.drawable.ic_app_processing),
    delivered: Painter = painterResource(R.drawable.ic_order_delivered),
    returns : Painter = painterResource(R.drawable.ic_order_return),
    unpaidLabel : String = "Unpaid",
    trackingLabel : String = "Processing",
    deliveredLabel: String = "Delivered",
    returnsLabel : String = "Returns",
    labelWeight : FontWeight = FontWeight.Thin,
    labelSize : TextUnit = 12.sp
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
                CustomTitle(
                    header = cardTitle,
                    fontSize = orderFont
                )

                CustomTitle(
                    header =  viewmore,
                    fontWeight = FontWeight.Thin,
                    fontSize = viewmoreFont
                )
            }
            Spacer(modifier = Modifier.height(2.dp))
            Row(
                modifier = Modifier
                    .padding(12.dp),
                horizontalArrangement = Arrangement.Absolute.SpaceAround
            )
            {
                Column {
                    orderIcon(order = unpaid)
                    CustomTitle(
                        header = unpaidLabel,
                        fontWeight = labelWeight,
                        fontSize = labelSize
                    )
                }

                Column {
                    orderIcon(order = tracking)
                    CustomTitle(
                        header = trackingLabel,
                        fontWeight = labelWeight,
                        fontSize = labelSize
                    )
                }

                Column {
                    orderIcon(order = delivered)
                    CustomTitle(
                        header = deliveredLabel,
                        fontWeight = labelWeight,
                        fontSize = labelSize
                    )
                }

                Column {
                    orderIcon(order = returns)
                    CustomTitle(
                        header = returnsLabel,
                        fontWeight = labelWeight,
                        fontSize = labelSize
                    )
                }

            }
        }

    }
}

@Composable
fun orderIcon(
    order : Painter,
    orderDesc : String = "order description",
    contentScale: ContentScale = ContentScale.Crop,
    size : Dp = 25.dp

){
    Image(
        painter = order,
        contentDescription = orderDesc,
        contentScale = contentScale,
        modifier = Modifier.size(size)
    )
}

//@Preview(showBackground = true)
//@Composable
//fun ProfileScreenPreview(){
//    ProfileScreen()
//}