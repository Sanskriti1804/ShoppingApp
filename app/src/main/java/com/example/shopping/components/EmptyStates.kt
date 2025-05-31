package com.example.shopping.components

import androidx.compose.runtime.Composable
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.compose.LottieAnimation

@Composable
fun EmptyState(
    composition: LottieComposition,
    progress : () -> Float
) {
        LottieAnimation(
        composition = composition,
        progress = progress
    )
}

