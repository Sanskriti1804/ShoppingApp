package com.example.shopping.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopping.R



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSlider(){

    var sliderPosn by remember{ mutableStateOf(0f) }

    Column (
        modifier = Modifier.padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Slider(
            value = sliderPosn,
            onValueChange = { sliderPosn = it },
            steps = 5,
            onValueChangeFinished = {},     //called when the user lifts their finger after dragging
            thumb = {
                Icon(
                    imageVector = Icons.Outlined.FavoriteBorder,
                    contentDescription = null,
                    modifier = Modifier.size(ButtonDefaults.IconSize),
                    tint = Color.Red
                )
            })
    }
}

@Composable
fun CustomRangeSlider(){

    var sliderPosn by remember{ mutableStateOf(0f..100f) }

    Column (
        modifier = Modifier.padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = sliderPosn.toString())
        RangeSlider(
            value = sliderPosn,
            onValueChange = { sliderPosn = it },
            valueRange = 0f..100f,
            steps = 5,
            onValueChangeFinished = {}
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FaceSlider(){

    var sliderPosition by remember { mutableStateOf(0f) }

    Slider(
        value = sliderPosition,
        onValueChange = { sliderPosition = it },
        onValueChangeFinished = {},
        colors = SliderDefaults.colors(
            activeTrackColor = Color.Black,
            inactiveTrackColor = Color.LightGray,
            activeTickColor = Color.Red,
            inactiveTickColor = Color.Yellow
        ),
        thumb = {
            Image(
                painter = painterResource(R.drawable.t_ic),
                contentDescription = null,
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
        },

        )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmojiSlider(){
    var sliderPosition by remember{ mutableStateOf(0f) }

    val emoji = when{
        sliderPosition <= 20f -> "😔"
        sliderPosition <= 40f -> "😰"
        sliderPosition <= 60f -> "😠"
        sliderPosition <= 80f -> "🥺"
        else -> "😘"
    }

    Column(
        modifier = Modifier.padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it},
            valueRange = 0f..100f,
            onValueChangeFinished = {},
            thumb = {
                Text(text = emoji, fontSize = 25.sp)
            }
        )
    }
}