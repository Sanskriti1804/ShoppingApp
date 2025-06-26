package com.example.shopping.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
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
import com.example.shopping.ui.theme.app_lBlack
import com.example.shopping.ui.theme.app_white


@Composable
fun CustomButton(
    textButton : Boolean,
    onClick : () -> Unit,
    shape : Shape = RoundedCornerShape(4.dp),
    containerColor: Color = app_lBlack,
    contentColor : Color = app_white,
    elevation: ButtonElevation,
    buttonText: String? = null,
    buttonIcon : ImageVector? = null,
    buttonDescription: String,
    modifier: Modifier = Modifier.padding(2.dp)
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
    shape: Shape = RoundedCornerShape(2.dp),
    elevation: ButtonElevation = ButtonDefaults.buttonElevation(2.dp),
    containerColor: Color = app_lBlack,
    contentColor: Color = app_white,
    borderColor : Color = app_white,
    borderThickness : Dp = 1.dp,
    upIcon : Painter = painterResource(R.drawable.ic_remove),
    downIcon : ImageVector = Icons.Default.Add,
    contentDesciption : String = "Quantity icon",
    quantity : String

    ){
    Button(
        onClick = onClick,
        modifier = Modifier.padding(3.dp).border(width = borderThickness, color = borderColor),
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
            Icon(
                painter = upIcon,
                contentDescription = contentDesciption
            )
            Text(
                text = quantity
            )
            Icon(
                imageVector = downIcon,
                contentDescription = contentDesciption
            )
        }
    }
}

@Composable
fun SizeButton(
    onClick: () -> Unit,
    shape: Shape = RoundedCornerShape(2.dp),
    elevation: ButtonElevation = ButtonDefaults.buttonElevation(2.dp),
    containerColor: Color = Color.White,
    contentColor: Color = Color.Black,
    borderColor : Color = Color.Black,
    borderThickness : Dp = 1.dp,
    upIcon : ImageVector = Icons.Default.KeyboardArrowUp,
    downIcon : ImageVector = Icons.Default.KeyboardArrowDown,
    contentDesciption : String = "Quantity icon",
    quantity : String

){
    Button(
        onClick = onClick,
        modifier = Modifier.padding(3.dp).border(width = borderThickness, color = borderColor),
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
                Icon(
                    imageVector = upIcon,
                    contentDescription = contentDesciption
                )

                Icon(
                    imageVector = downIcon,
                    contentDescription = contentDesciption
                )

            }
        }
    }
}