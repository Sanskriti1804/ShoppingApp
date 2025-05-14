package com.example.shopping.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.AssistChip
import androidx.compose.material3.ChipColors
import androidx.compose.material3.ChipElevation
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.Shapes
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun CustomAssistChip(
    onClick : () -> Unit,
    label : String,
    icon : ImageVector,
    shape : Shape,
    colors: ChipColors,
    elevation : ChipElevation,
    border : BorderStroke,
    interactionSource: MutableInteractionSource,
){
    AssistChip(
        onClick = onClick,
        label = { Text(label) },
        leadingIcon = { Icon(icon, contentDescription = null) },
        shape = shape,
        colors = colors,
        elevation = elevation,
        border = border,
        interactionSource = interactionSource
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
    label: String
){
    SuggestionChip(
        onClick = onClick,
        label = { Text(label) }
    )
}