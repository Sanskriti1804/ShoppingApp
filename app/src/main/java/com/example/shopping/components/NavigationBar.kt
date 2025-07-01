package com.example.shopping.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Badge
import androidx.compose.material.Text
import androidx.compose.material3.BadgedBox
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
import androidx.navigation.NavHostController
import com.example.shopping.navigation.bottomNavItems
import com.example.shopping.ui.theme.Dimensions
import com.example.shopping.ui.theme.Shapes
import com.example.shopping.ui.theme.app__dtext
import com.example.shopping.ui.theme.app_highlight
import com.example.shopping.ui.theme.app_llComponent
import com.example.shopping.ui.theme.app_background


@Composable
fun CustomNavigationBar(
    navBarPadding : Dp = Dimensions.barPadding,
    bottomBarColor : Color = app__dtext,
    contentColor : Color = app_llComponent,
    selected : Boolean = false,
    navBarShape : Shape = Shapes.BarShape,
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
                                Badge(
                                    backgroundColor = app_highlight,
                                    contentColor = app_background
                                ){
                                    Text(text = item.badgeCount.toString())
                                }
                            }
                            else if (item.hasNews){
                                Badge(
                                    backgroundColor = app_highlight,
                                )
                            }
                        }
                    ) {
                        CustomIcon(
                            painter = painterResource(item.iconResId),
                            iconColor = app_llComponent
                        )
                    }
                }
            )
        }
    }
}