package com.example.shopping.Profile.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopping.R
import com.example.shopping.components.CustomCard
import com.example.shopping.components.CustomTitle
import com.example.shopping.components.ProfileSection

@Composable
fun ProfileScreen(){

    val profileImage = painterResource(id = R.drawable.profile)

    val delivered = painterResource(id = R.drawable.profile)
    val returns = painterResource(id = R.drawable.profile)
    val tracking = painterResource(id = R.drawable.profile)
    val unpaid = painterResource(id = R.drawable.profile)

    ProfileSection(
        profileImage = profileImage,
        username = "JKKiddding",
        name = "heloiiw"
    )

    OrderCard(
        onClick = {},
        cardTitle = "My Orders",
        viewmore = "View More",
        unpaid = unpaid,
        tracking = tracking,
        returns = returns,
        delivered = delivered,
        unpaidLabel = "Unpaid",
        trackingLabel = "Tracking",
        deliveredLabel = "Delivered",
        returnsLabel = "Returns"
    )

    CustomCard(
        onClick = {}
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "My Profile",
                fontSize = 12.sp,
                fontWeight = FontWeight.Thin
            )
            Divider(thickness = 1.dp)
            Text(
                text = "Refer and earn",
                fontSize = 12.sp,
                fontWeight = FontWeight.Thin
            )
            Divider(thickness = 1.dp)
        }
    }

    CustomCard(
        onClick = {}
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "My Profile",
                fontSize = 12.sp,
                fontWeight = FontWeight.Thin
            )
            Divider(thickness = 1.dp)
            Text(
                text = "Refer and earn",
                fontSize = 12.sp,
                fontWeight = FontWeight.Thin
            )
        }
    }

    CustomCard(
        onClick = {}
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Help Center",
                fontSize = 12.sp,
                fontWeight = FontWeight.Thin
            )
            Divider(thickness = 1.dp)
            Text(
                text = "Customer Service",
                fontSize = 12.sp,
                fontWeight = FontWeight.Thin
            )
            Divider(thickness = 1.dp)
            Text(
                text = "Return Policy",
                fontSize = 12.sp,
                fontWeight = FontWeight.Thin
            )
            Divider(thickness = 1.dp)
            Text(
                text = "Shipping Delivery",
                fontSize = 12.sp,
                fontWeight = FontWeight.Thin
            )
        }
    }
    CustomCard(
        onClick = {}
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "About Shoppie",
                fontSize = 12.sp,
                fontWeight = FontWeight.Thin
            )
            Divider(thickness = 1.dp)
            Text(
                text = "About us",
                fontSize = 12.sp,
                fontWeight = FontWeight.Thin
            )
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
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        ProfileSection(
            profilePhoto = profileImage,
            profileDesc = "profile image"
        )

        Column {
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
    cardTitle : String,
    orderFont : TextUnit = 16.sp,
    viewmoreFont : TextUnit = 14.sp,
    viewmore : String,
    unpaid : Painter,
    tracking : Painter,
    delivered: Painter,
    returns : Painter,
    unpaidLabel : String,
    trackingLabel : String,
    deliveredLabel: String,
    returnsLabel : String,
    labelWeight : FontWeight = FontWeight.Thin,
    labelSize : TextUnit = 12.sp

){
    CustomCard(
        onClick = onClick,
    ) {
        Column (
            modifier = Modifier.padding(10.dp)
        ){
            Row (
                modifier = Modifier.padding(12.dp),
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
                horizontalArrangement = Arrangement.SpaceEvenly
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