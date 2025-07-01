package com.example.shopping.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
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
import com.example.shopping.ui.theme.Dimensions
import com.example.shopping.ui.theme.Shapes
import com.example.shopping.ui.theme.app_ltext
import com.example.shopping.ui.theme.app_llComponent


@Composable
fun CustomButton(
    textButton : Boolean,
    onClick : () -> Unit,
    shape : Shape = Shapes.ButtonShape,
    containerColor: Color = app_ltext,
    contentColor : Color = app_llComponent,
    elevation: ButtonElevation = ButtonDefaults.buttonElevation(Dimensions.buttonElevation),
    buttonText: String? = null,
    buttonIcon : ImageVector? = null,
    buttonDescription: String,
    modifier: Modifier = Modifier.padding(Dimensions.buttonPadding) .fillMaxWidth()
){
    Button(
        onClick = onClick,
        modifier = modifier,
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

@Composable
fun QuantityButton(
    onClick: () -> Unit,
    shape: Shape = Shapes.ButtonShape,
    elevation: ButtonElevation = ButtonDefaults.buttonElevation(Dimensions.buttonElevation),
    containerColor: Color = app_ltext,
    contentColor: Color = app_llComponent,
    borderColor : Color = app_llComponent,
    borderThickness : Dp = Dimensions.buttonBorder,
    upIcon : Painter = painterResource(R.drawable.ic_remove),
    downIcon : ImageVector = Icons.Default.Add,
    quantity : String,
    padding : Dp = Dimensions.buttonPadding
    ){
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(padding)
            .border(width = borderThickness, color = borderColor),
        shape = shape,
        elevation = elevation,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        )
    ) {
        Row(
            modifier = Modifier.wrapContentWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CustomIcon(
                painter = painterResource(R.drawable.ic_app_arrow)
            )
            Text(
                text = quantity
            )
            CustomIcon(
                painter = painterResource(R.drawable.ic_app_arrow),
            )
        }
    }
}

@Composable
fun SizeButton(
    onClick: () -> Unit,
    shape: Shape = Shapes.ButtonShape,
    elevation: ButtonElevation = ButtonDefaults.buttonElevation(Dimensions.buttonElevation),
    containerColor: Color = Color.White,
    contentColor: Color = Color.Black,
    borderColor : Color = Color.Black,
    borderThickness : Dp = Dimensions.buttonBorder,
    upIcon : ImageVector = Icons.Default.KeyboardArrowUp,
    downIcon : ImageVector = Icons.Default.KeyboardArrowDown,
    quantity : String,
    padding : Dp = Dimensions.buttonPadding

){
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(padding)
            .border(width = borderThickness, color = borderColor),
        shape = shape,
        elevation = elevation,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        )
    ) {
        Column(
            modifier = Modifier.wrapContentWidth().wrapContentHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = quantity
            )

            Row {
                CustomIcon(
                    painter = painterResource(R.drawable.ic_app_arrow)
                )

                CustomIcon(
                    painter = painterResource(R.drawable.ic_app_arrow)
                )
            }
        }
    }
}