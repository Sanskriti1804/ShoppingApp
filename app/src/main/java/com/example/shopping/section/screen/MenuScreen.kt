package com.example.shopping.section.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopping.Profile.Screen.ProfileScreen
import com.example.shopping.R
import com.example.shopping.components.CustomTopBar
import com.example.shopping.home.data.CategoryData
import com.example.shopping.home.screen.CategoryCardRow
import com.example.shopping.ui.theme.app_dBlack
import com.example.shopping.ui.theme.app_lBlack


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen() {

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) } // Changed from true to false for better default state


    Scaffold(
        topBar = {
            CustomTopBar(
                title = "Shoppie",
                fontWeight = FontWeight.ExtraBold,
                titleOverflow = TextOverflow.Ellipsis,
                navigationIcon = Icons.Default.ArrowBack,
                navigationIconColor = Color.Black,
                onNavigationClick = {},
                actionIcon = Icons.Default.Favorite,
                containerColor = app_lBlack, // Assuming this color is defined elsewhere
                titleColor = Color.Black,
                actionIconColor = Color.Black,
                scrollBehavior = scrollBehavior
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            Row (modifier = Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
                ){
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "Cart",
                    tint = app_dBlack
                )
            }

            val section = listOf(
               Text(text = "NEW IN TOWN"),
               Text(text = "FRESH PICKS"),
               Text(text = "TRENDING NOW"),
               Text(text = "JUST DROPPED"),
               Text(text = "BEST SELLERS"),
               Text(text = "DAILY SELLERS"),
               Text(text = "ON THE GO"),
               Text(text = "BACK IN STOCKS"),
               Text(text = "SEASONAL STAPLES")
            )

            LazyRow {
//                Section(
//                    section = section,
//                    secColor = Color.Black,
//                    fontWeight = FontWeight.SemiBold,
//                    onClick = {},
//                    fontSize = 24.sp,
//                    selected = section.get(1),
//                    selectedShape = RoundedCornerShape(2.dp)
//                )
            }


            val categoryList = listOf(
                CategoryData(
                    icon = painterResource(id = R.drawable.ic_cat_dress),
                    label = "null",
                    bgColor = app_lBlack
                ),
                CategoryData(
                    icon = painterResource(id = R.drawable.ic_cat_hat),
                    label = "null",
                    bgColor = app_lBlack
                ),
                CategoryData(
                    icon = painterResource(id = R.drawable.ic_cat_bow_tie),
                    label = "null",
                    bgColor = app_lBlack
                ),
                CategoryData(
                    icon = painterResource(id = R.drawable.ic_cat_camera),
                    label = "null",
                    bgColor = app_lBlack
                ),
                CategoryData(
                    icon = painterResource(id = R.drawable.ic_cat_tie),
                    label = "null",
                    bgColor = app_lBlack
                ),
                CategoryData(
                    icon = painterResource(id = R.drawable.ic_cat_dryer),
                    label = "null",
                    bgColor = app_lBlack
                ),
                CategoryData(
                    icon = painterResource(id = R.drawable.ic_cat_belt),
                    label = "null",
                    bgColor = app_lBlack
                ),
                CategoryData(
                    icon = painterResource(id = R.drawable.ic_cat_earrings),
                    label = "null",
                    bgColor = app_lBlack
                ),
                CategoryData(
                    icon = painterResource(id = R.drawable.ic_cat_glasses),
                    label = "null",
                    bgColor = app_lBlack
                ),
                CategoryData(
                    icon = painterResource(id = R.drawable.ic_cat_hand_bag),
                    label = "null",
                    bgColor = app_lBlack
                ),
                CategoryData(
                    icon = painterResource(id = R.drawable.ic_cat_jeans),
                    label = "null",
                    bgColor = app_lBlack
                ),
                CategoryData(
                    icon = painterResource(id = R.drawable.ic_cat_lipstick),
                    label = "null",
                    bgColor = app_lBlack
                ),
                CategoryData(
                    icon = painterResource(id = R.drawable.ic_cat_shorts),
                    label = "null",
                    bgColor = app_lBlack
                ),
                CategoryData(
                    icon = painterResource(id = R.drawable.ic_cat_tshirt),
                    label = "null",
                    bgColor = app_lBlack
                ),
                CategoryData(
                    icon = painterResource(id = R.drawable.ic_cat_wristwatch),
                    label = "null",
                    bgColor = app_lBlack
                )
            )

            Box(modifier = Modifier.padding(8.dp)) {
                CategoryCardRow(
                    categoryList = categoryList,
                    size = 45.dp,
                    onClick = {},
                    CardColor = Color.White,
                    borderStroke = 1.dp,
                    borderColor = app_dBlack // Assuming this color is defined elsewhere
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "NEW ARRIVAL",
                    color = app_dBlack, // Assuming this color is defined elsewhere
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "See all icon",
                    tint = app_dBlack // Assuming this color is defined elsewhere
                )
            }
            Divider(thickness = 2.dp, color = app_lBlack) // Assuming this color is defined elsewhere
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuScreenPreview(){
    MenuScreen()
}

//@Composable
//fun Section(
//    section: List<Unit>,
//    secColor: Color,
//    fontSize: Size,
//    fontWeight: FontWeight,
//    onClick: () -> Unit,
//    selected: Boolean,
//    selectedShape: Shape
//){
//    Text(
//        text = section,
//        color = secColor,
//        fontWeight = fontWeight,
//        modifier = Modifier
//            .clickable{
//                onClick()
//            }
//            .then(if (selected) Modifier.clip(selectedShape) else Modifier)
//
//    )
//}