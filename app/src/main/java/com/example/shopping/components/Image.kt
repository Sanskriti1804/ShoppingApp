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
import coil.size.Dimension
import com.example.shopping.R
import com.example.shopping.ui.theme.Dimensions
import com.example.shopping.ui.theme.Shapes

@Composable
fun CustomProfilePic(
    profile : Painter = painterResource(R.drawable.profile),
    userProfileDesc : String = "User Profile Photo",
    contentScale : ContentScale = ContentScale.Crop
){
    Image(
        painter = profile,
        contentDescription = userProfileDesc,
        modifier = Modifier
            .padding(Dimensions.componentPadding)
            .clip(Shapes.ProfilePhoto)
            .size(Dimensions.profileSize),
        contentScale = contentScale,

    )
}

@Composable
fun CustomReviewImage(
    painter : Painter = painterResource(R.drawable.profile),
    reviewDesc : String = "Review Image Description",
    contentScale: ContentScale = ContentScale.Crop
){
    Image(
        painter = painter,
        contentDescription = reviewDesc,
        modifier = Modifier
            .padding(Dimensions.reviewImageSize)
            .size(Dimensions.reviewImageSize),
        contentScale = contentScale
    )
}

@Composable
fun CustomDiscountImage(
    painter : Painter ,
    reviewDesc : String = "Discount Image Description",
    contentScale: ContentScale = ContentScale.Crop
){
    Image(
        painter = painter,
        contentDescription = reviewDesc,
        modifier = Modifier
            .padding(Dimensions.imagePadding),
        contentScale = contentScale
    )
}

