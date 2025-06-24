package com.example.shopping.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Badge
import androidx.compose.material.Text
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.shopping.navigation.BottomNavScreens
import com.example.shopping.navigation.bottomNavItems
import com.example.shopping.ui.theme.T_CardColor
import com.example.shopping.ui.theme.T_DTextColor

@Composable
fun CustomNavigationBar(
    modifier : Modifier = Modifier.padding(4.dp).fillMaxWidth(),
    bottomBarColor : Color = T_CardColor,
    contentColor : Color = T_DTextColor,
    selected : Boolean = false,

){
    NavigationBar(
        modifier = modifier,
        containerColor = bottomBarColor,
        contentColor = contentColor
    ){
        bottomNavItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selected,
                onClick = {},
                icon = {
                    BadgedBox(
                        badge = {
                            if (item.badgeCount != null){
                                Badge(){
                                    Text(text = item.badgeCount.toString())
                                }
                            }
                            else if (item.hasNews){
                                Badge()
                            }
                        }
                    ) {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.label
                        )
                    }
                }
            )
        }
    }
}