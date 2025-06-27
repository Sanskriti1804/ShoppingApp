package com.example.shopping.components

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.compose.LottieAnimation

@Composable
fun EmptyState(
    composition: LottieComposition,
    progress : () -> Float,
    lottieSize : Dp = 300.dp
) {
        LottieAnimation(
        composition = composition,
        progress = progress,
            modifier = Modifier
                .size(lottieSize)
    )
}

