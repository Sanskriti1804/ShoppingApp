package com.example.shopping.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun CustomButton(
    textButton : Boolean,
    onClick : () -> Unit,
    shape : Shape = RoundedCornerShape(4.dp),
    containerColor: Color,
    contentColor : Color,
    elevation: ButtonElevation ,
    buttonText: String? = null,
    buttonIcon : ImageVector? = null,
    buttonDescription: String,
){
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(2.dp),
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        elevation = elevation,
    ) {
        if (textButton){
            Text(
                text = buttonText.toString()
            )
        }
        if (buttonIcon != null && buttonDescription != null){
            Image(imageVector = buttonIcon, contentDescription = buttonDescription)
        }
    }
}