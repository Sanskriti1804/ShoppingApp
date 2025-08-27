package com.example.shopping.section.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.shopping.R
import com.example.shopping.components.CustomBody
import com.example.shopping.components.CustomDivider
import com.example.shopping.components.CustomIcon
import com.example.shopping.components.CustomNavigationBar
import com.example.shopping.components.CustomSuggestionChip
import com.example.shopping.components.CustomTopBar
import com.example.shopping.home.data.CategoryData
import com.example.shopping.home.screen.CategoryCardRow
import com.example.shopping.home.screen.ProductCard
import com.example.shopping.home.viewmodel.ProductViewModel
import com.example.shopping.navigation.Screen
import com.example.shopping.ui.theme.Dimensions
import com.example.shopping.ui.theme.app_ltext
import com.example.shopping.ui.theme.app_lComponent
import com.example.shopping.ui.theme.app_background
import org.koin.androidx.compose.koinViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(navController: NavHostController) {
    val viewModel : ProductViewModel = koinViewModel()
    val product = viewModel.productList

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) } // Changed from true to false for better default state

    Scaffold(
        containerColor = app_background,
        topBar = {
            CustomTopBar(
                titleOverflow = TextOverflow.Ellipsis,
                navigationIcon = painterResource(R.drawable.ic_app_back),
                onNavigationClick = {},
                actionIcon = painterResource(R.drawable.ic_app_search),
                scrollBehavior = scrollBehavior
            )
        },
        bottomBar = {
            CustomNavigationBar(
                navController = navController
            )
        }
    ) { paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.padding(paddingValues)
        ) {
            item(span = { GridItemSpan(2)}) {
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                }
            }

            item(span = { GridItemSpan(2)}) {
                val section = listOf(
                    "NEW IN TOWN",
                    "FRESH PICKS",
                    "TRENDING NOW",
                    "JUST DROPPED",
                    "BEST SELLERS",
                    "DAILY SELLERS",
                    "ON THE GO",
                    "BACK IN STOCKS",
                    "SEASONAL STAPLES"
                )

                Section(
                    section = section
                )
            }

            item (span = { GridItemSpan(2)}) {
                val categoryList = listOf(
                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_dress),
                        label = "null",
                        bgColor = app_ltext
                    ),
                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_hat),
                        label = "null",
                        bgColor = app_ltext
                    ),
                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_bow_tie),
                        label = "null",
                        bgColor = app_ltext
                    ),
                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_camera),
                        label = "null",
                        bgColor = app_ltext
                    ),

                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_dryer),
                        label = "null",
                        bgColor = app_ltext
                    ),
                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_belt),
                        label = "null",
                        bgColor = app_ltext
                    ),
                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_earrings),
                        label = "null",
                        bgColor = app_ltext
                    )
                )

                Box(modifier = Modifier.padding(8.dp)) {
                    CategoryCardRow(
                        categoryList = categoryList,
                        onClick = {}
                    )
                }
            }

            item (span = { GridItemSpan(2)}) {
                val categoryList = listOf(
                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_glasses),
                        label = "null",
                        bgColor = app_ltext
                    ),
                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_hand_bag),
                        label = "null",
                        bgColor = app_ltext
                    ),
                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_jeans),
                        label = "null",
                        bgColor = app_ltext
                    ),
                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_lipstick),
                        label = "null",
                        bgColor = app_ltext
                    ),
                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_shorts),
                        label = "null",
                        bgColor = app_ltext
                    ),
                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_tshirt),
                        label = "null",
                        bgColor = app_ltext
                    ),
                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_wristwatch),
                        label = "null",
                        bgColor = app_ltext
                    )
                )

                Box(modifier = Modifier.padding(8.dp)) {
                    CategoryCardRow(
                        categoryList = categoryList,
                        onClick = {}
                    )
                }
            }


            item(span = { GridItemSpan(2)}) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CustomBody(
                        header = "NEW ARRIVAL"
                    )
                    Row {
                        CustomBody(
                            header = "See all section"
                        )
                        CustomIcon(
                            painter = painterResource(R.drawable.ic_app_arrow)
                        )

                    }
                    CustomDivider()
            }
        }
            items(
                items = product,
                key = {product -> product.id}
            ) {
                item ->
                ProductCard(
                    product = item,
                    onClick = {
                        navController.navigate(Screen.ProductDescriptionScreen.route)
                    }
                )
            }
        }
    }
}

@Composable
fun Section(
    section: List<String>,
    chipsPadding : Dp = Dimensions.buttonPadding,
){
   LazyRow(modifier = Modifier.padding(chipsPadding)) {
       item {
           CustomSuggestionChip(
               onClick = {},
               label = section.toString()
           )
       }
   }
}