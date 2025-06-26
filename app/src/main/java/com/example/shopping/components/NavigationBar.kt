package com.example.shopping.components

import android.R.attr.contentDescription
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Badge
import androidx.compose.material.Text
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.shopping.navigation.BottomNavScreens
import com.example.shopping.navigation.bottomNavItems
import com.example.shopping.ui.theme.app_dBlack
import com.example.shopping.ui.theme.app_lBlack
import com.example.shopping.ui.theme.app_white


@Composable
fun CustomNavigationBar(
    navBarPadding : Dp = 8.dp,
    bottomBarColor : Color = app_dBlack,
    contentColor : Color = app_white,
    selected : Boolean = false,
    navBarShape : Shape = RoundedCornerShape(8.dp),
    navController: NavHostController
    ){
    NavigationBar(
        modifier = Modifier
            .padding(navBarPadding)
            .clip(navBarShape)
            .fillMaxWidth(),
        containerColor = bottomBarColor,
        contentColor = contentColor
    ){
        bottomNavItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selected,
                onClick = {navController.navigate(item.route)},
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
                        CustomIcon(
                            painter = painterResource(item.iconResId),
                        )
                    }
                }
            )
        }
    }
}