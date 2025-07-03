package com.example.shopping.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.shopping.R
import com.example.shopping.ui.theme.Dimensions
import com.example.shopping.ui.theme.Shapes

@Composable
fun CustomProfilePic(
    profile : Painter = painterResource(R.drawable.profile),
    userProfileDesc : String = "User Profile Photo",
//    profilePadding : Dp = Dimensions.imagePadding,
    profilePadding : Dp = 2.dp,
    profileShape : Shape = Shapes.ProfilePhoto,
//    profileSize : Dp = Dimensions.profileSize
    profileSize : Dp = 250.dp
    ,
    contentScale : ContentScale = ContentScale.Crop
){
    Image(
        painter = profile,
        contentDescription = userProfileDesc,
        modifier = Modifier
            .padding(profilePadding)
            .clip(profileShape)
            .size(profileSize),
        contentScale = contentScale,

    )
}

@Composable
fun CustomReviewImage(
    painter : Painter = painterResource(R.drawable.profile),
    reviewDesc : String = "Review Image Description",
    contentScale: ContentScale = ContentScale.Crop,
//    size: Dp = Dimensions.reviewImageSize,
    size: Dp = 100.dp,
//    reviewPadding : Dp = Dimensions.imagePadding
    reviewPadding : Dp = 1.dp
){
    Image(
        painter = painter,
        contentDescription = reviewDesc,
        modifier = Modifier
            .padding(reviewPadding)
            .size(size),
        contentScale = contentScale
    )
}

@Composable
fun CustomDiscountImage(
    painter : Painter ,
    reviewDesc : String = "Discount Image Description",
    contentScale: ContentScale = ContentScale.Crop,
//    reviewPadding : Dp = Dimensions.imagePadding
    reviewPadding : Dp = 1.dp
){
    Image(
        painter = painter,
        contentDescription = reviewDesc,
        modifier = Modifier
            .padding(reviewPadding),
        contentScale = contentScale
    )
}

