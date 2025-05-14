package com.example.shopping.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.shopping.navigation.NavBarItem

@Composable
fun CustomNavBar(
    modifier: Modifier,
    containerColor : Color,
    selectedColor : Color = Color.Red,
    unselectedColor : Color = Color.Black,
    items : List<NavBarItem>,
    onItemClick : (String) -> Unit, //passes the selected route when clicked
){
    //holds the current selected item route - initialized with first item route
    var selectedRoute by remember { mutableStateOf(items.first().route) }
    NavigationBar (
        modifier = Modifier
            .padding(12.dp)
            .clip(RoundedCornerShape(12.dp)),
        tonalElevation = 8.dp,
        containerColor = containerColor
    ){
        items.forEach{ item ->
            //selcted route is item route assigned as selected
            val selected = selectedRoute == item.route
            NavigationBarItem(
                selected = selected,
                onClick = {
                    onItemClick(item.route)
                },
                icon = {
                    Icon(
                        imageVector = if (selected) item.selectedIcon else item.unselectedIcon,
                        contentDescription = item.title,
                        tint = if (selected) selectedColor else unselectedColor
                    )
                },
                label = {
                    Text(text = item.title)
                }

            )
        }
    }
}