package com.example.shopping.product

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.PagerState


@Composable
fun ProductCarousel(
    state : PagerState,
    images : List<Int>,
    imageDescription : String = "product image",
    padding : Dp = 2.dp,
    shape : Shape = RoundedCornerShape(3.dp),
    imageSize : Dp = 250.dp,
    contentScale : ContentScale = ContentScale.Crop,
    inActiveColor : Color = Color.DarkGray,
    activeColor : Color = Color.White,
    indicatorShape : Shape = CircleShape,
    indicatorAlignment : Alignment = Alignment.Center,
    indicatorPadding : Dp = 4.dp
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ){
        HorizontalPager(
            state = state,
            count = images.size,
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .clip(shape)
        ) {page ->          //for each page show this ui
            AsyncImage(
                model = images[page],       //url of the current page for image
                contentDescription = imageDescription,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(imageSize),
                contentScale = contentScale
            )
        }
        HorizontalPagerIndicator(
            pagerState = state,
            modifier = Modifier
                .align (indicatorAlignment)
                .padding(indicatorPadding),
            inactiveColor = inActiveColor,
            activeColor = activeColor,
            indicatorShape = indicatorShape,
        )
    }
}