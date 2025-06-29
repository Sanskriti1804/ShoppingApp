package com.example.shopping.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ChipColors
import androidx.compose.material3.ChipElevation
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.Shapes
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.shopping.R
import com.example.shopping.ui.theme.app_dBlack
import com.example.shopping.ui.theme.app_lBlack
import com.example.shopping.ui.theme.app_lGray
import com.example.shopping.ui.theme.app_white
import com.example.shopping.ui.theme.app_white_bg

@Composable
fun CustomAssistChip(
    onClick : () -> Unit,
    label : String,
    icon : Painter = painterResource(R.drawable.ic_app_fav),
    shape : Shape = RoundedCornerShape(2.dp),
    containerColor: Color = app_white,
    labelColor : Color = app_dBlack,
    iconColor : Color = app_lGray,
    chipElevation: Dp = 2.dp,
    borderWidth : Dp = 1.dp,
    borderColor : Color = app_dBlack
){
    AssistChip(
        onClick = onClick,
        label = { Text(label) },
        leadingIcon = {
            CustomIcon(
                painter = icon
            )
        },
        shape = shape,
        colors = AssistChipDefaults.assistChipColors(
            containerColor = containerColor,
            labelColor = labelColor,
            leadingIconContentColor = iconColor
        ),
        elevation = AssistChipDefaults.assistChipElevation(
            chipElevation
        ),
        border =  BorderStroke(
            width = borderWidth,
            color = borderColor
        )
    )
}

@Composable
fun CustomFilteringChip(
    selected : Boolean,
    onClick: () -> Unit,
    label: String,
){
    FilterChip(
        selected = selected,
        onClick = onClick,
        label = { Text(label) },
        leadingIcon = {
            if(selected) Icon(Icons.Default.Clear, contentDescription = null)
        }

    )
}

@Composable
fun CustomInputChip(
    selected: Boolean,
    onClick: () -> Unit,
    label: String,
    icon: ImageVector,
){
    InputChip(
        selected = selected,
        onClick = onClick,
        label = { Text(label) },
        avatar = {icon}
    )
}

@Composable
fun CustomSuggestionChip(
    onClick: () -> Unit,
    label: String,
    shape: Shape = RoundedCornerShape(4.dp),
    containerColor : Color = app_lBlack,
    labelColor : Color = app_white_bg,
    disabledContainerColor : Color = app_white_bg,
    disabledLabelColor : Color = app_lBlack
){
    SuggestionChip(
        onClick = onClick,
        label = { Text(label) },
        shape = shape,
        colors = SuggestionChipDefaults.suggestionChipColors(
            containerColor = containerColor,
            labelColor = labelColor,
            disabledContainerColor =  disabledContainerColor,
            disabledLabelColor = disabledLabelColor
        )
    )
}