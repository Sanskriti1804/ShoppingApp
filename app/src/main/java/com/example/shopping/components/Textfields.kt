package com.example.shopping.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.shopping.ui.theme.Dimensions
import com.example.shopping.ui.theme.Shapes
import com.example.shopping.ui.theme.app_ltext
import com.example.shopping.ui.theme.app_llComponent


@Composable
fun CustomTextField(
    value : String,
    padding : Dp = Dimensions.componentPadding,
    onValueChange : (String) -> Unit,
    shape: Shape = Shapes.TextFieldShape,
    placeholder: String,
    textColor : Color = app_ltext,
    containercolor : Color = app_llComponent,
    visualTransformation : VisualTransformation = VisualTransformation.None
){
    OutlinedTextField(
        modifier = Modifier
            .padding(padding),
        value = value,
        onValueChange =  onValueChange,
        shape = shape,
        placeholder = {
            Text(text = placeholder)
        },
        colors = TextFieldDefaults.colors(
            focusedTextColor = textColor,
            unfocusedTextColor = textColor,
            focusedContainerColor = containercolor,
            unfocusedContainerColor = containercolor,
            focusedIndicatorColor = textColor
        ),
        visualTransformation = visualTransformation

    )
}

@Composable
fun CustomField(
    value : String,
    onValueChange : (String) -> Unit,
    placeholder: String
){
    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(text = placeholder)
        },

    )
}