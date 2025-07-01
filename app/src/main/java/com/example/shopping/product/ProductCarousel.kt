 package com.example.shopping.product

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.shopping.ui.theme.Dimensions
import com.example.shopping.ui.theme.Shapes
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.PagerState


@Composable
fun ProductCarousel(
    state : PagerState,
    images : List<Int>,
    imageDescription : String = "product image",
    padding : Dp = Dimensions.componentPadding,
    shape : Shape = Shapes.CardShape,
    pageInteractionSource : MutableInteractionSource = remember { MutableInteractionSource() },
    imageSize : Dp = Dimensions.productDescSize,
    contentScale : ContentScale = ContentScale.Crop,
    inActiveColor : Color = Color.DarkGray,
    activeColor : Color = Color.White,
    indicatorShape : Shape = CircleShape,
    indicatorAlignment : Alignment = Alignment.Center,
    indicatorPadding : Dp = Dimensions.componentPadding
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Dimensions.componentPadding)
    ){
        HorizontalPager(
            state = state,
            count = images.size,
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .clickable(
                    interactionSource = pageInteractionSource,
                    indication = LocalIndication.current
                ){

                }
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