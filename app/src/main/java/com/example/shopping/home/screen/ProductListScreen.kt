package com.example.shopping.home.screen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.size.Dimension
import com.example.shopping.R
import com.example.shopping.components.CustomBody
import com.example.shopping.components.CustomDiscountImage
import com.example.shopping.components.CustomIcon
import com.example.shopping.components.CustomLabel
import com.example.shopping.components.CustomNavigationBar
import com.example.shopping.components.CustomTitle
import com.example.shopping.components.CustomTopBar
import com.example.shopping.home.data.CategoryData
import com.example.shopping.home.data.DiscountData
import com.example.shopping.home.data.Product
import com.example.shopping.home.viewmodel.ProductViewModel
import com.example.shopping.navigation.Screen
import com.example.shopping.product.ProductCarousel
import com.example.shopping.ui.theme.Dimensions
import com.example.shopping.ui.theme.Shapes
import com.example.shopping.ui.theme.app__dtext
import com.example.shopping.ui.theme.app_ltext
import com.example.shopping.ui.theme.app_lComponent
import com.example.shopping.ui.theme.app_llComponent
import com.example.shopping.ui.theme.app_background
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel
import org.koin.androidx.compose.viewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(navController : NavHostController) {
    val viewModel: ProductViewModel = koinViewModel()
    val products = viewModel.productList

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) } // Changed from true to false for better default state

    val searchHistory = listOf("First Search", "Second Search", "Third Search")

    Scaffold(
        containerColor = app_background,
        topBar = {
            CustomTopBar(
                titleOverflow = TextOverflow.Ellipsis,
                onNavigationClick = {},
                fontWeight = FontWeight.ExtraBold,
                scrollBehavior = scrollBehavior,
                onActionClick = {navController.navigate(Screen.SearchScreen.route)}
            )
        },
        bottomBar = {
            CustomNavigationBar(navController = navController)
        }
    ) { paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize()
                .padding(paddingValues)
                .padding(Dimensions.appPadding)
        ) {
            item {
                featureRow()
            }
            item(span = { GridItemSpan(2)}) {
                val discountImage = listOf(
                    R.drawable.ic_discount1,
                    R.drawable.ic_discount2,
                    R.drawable.ic_discount3,
                    R.drawable.ic_discount4,
                    R.drawable.ic_discount5,
                    R.drawable.ic_discount6,
                    R.drawable.ic_discount7,
                    R.drawable.ic_discount8,
                    R.drawable.ic_discount9,
                    R.drawable.ic_discount10,
                    R.drawable.ic_discount11,
                    R.drawable.ic_discount12,
                    R.drawable.ic_discount13,
                    R.drawable.ic_discount14
                )

                val discountData = DiscountData(
                    title = "Flat 30% OFF",
                    desc = "on Summer Collection",
                    textColor = app__dtext,
                    descColor = app__dtext,
                    image = discountImage,
                    ctaText = "SHOP NOW"
                )

//                DiscountCard(
//                    data = discountData
//                )

                Spacer(modifier = Modifier.height(Dimensions.medSpacer))
            }

            item (
                span = { GridItemSpan(2)}
            ){
                val pagerState = rememberPagerState()
                val productImage = listOf(
                    R.drawable.ic_discount1,
                    R.drawable.ic_discount2,
                    R.drawable.ic_discount3,
                    R.drawable.ic_discount4,
                    R.drawable.ic_discount5
                )

                val pagerIsDragged by pagerState.interactionSource.collectIsDraggedAsState()
                val pagerInteractionSource = remember { MutableInteractionSource() }        //remember new interaction source - like user gestures
                val pagerIsPressed by pagerInteractionSource.collectIsPressedAsState()

                val autoAdvance = !pagerIsDragged && !pagerIsPressed        //auto afvancing when pager is not dragged or advancing

                    LaunchedEffect(autoAdvance) {
                        if (autoAdvance){
                        while (true){
                            delay(2000)
                            val nextPage = (pagerState.currentPage + 1)  % productImage.size        // % productImage.size- 0 if on last page
                            pagerState.animateScrollToPage(nextPage)
                        }
                    }
                }
                ProductCarousel(
                    state = pagerState,
                    images = productImage
                )
            }

            item(span = { GridItemSpan(2)}) {
                val categoryList = listOf(
                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_dress)
                    ),
                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_hat)
                    ),
                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_bow_tie)
                    ),
                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_camera)
                    ),
                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_tie)
                    ),
                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_dryer)
                    ),
                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_belt)
                    ),
                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_earrings)
                    ),
                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_glasses)
                    ),
                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_hand_bag)
                    ),
                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_jeans)
                    ),
                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_lipstick)
                    ),
                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_shorts)
                    ),
                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_tshirt)
                    ),
                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_wristwatch)
                    )
                )

                Box(modifier = Modifier.padding(Dimensions.componentPadding)) {
                    CategoryCardRow(
                        categoryList = categoryList,
                        onClick = {}
                    )
                }
            }

            item(span = { GridItemSpan(2)}) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(Dimensions.componentPadding),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CustomBody(
                        header = "Featured"
                    )
                    Row {
                        CustomLabel(
                            header = " See all"
                        )
                        CustomIcon(
                            painter = painterResource(R.drawable.ic_app_arrow)
                        )
                    }
                }
            }

            if (products.isEmpty()) {
                item(span = { GridItemSpan(2) }) {
                    Text("No products found", modifier = Modifier.fillMaxWidth().padding(Dimensions.componentPadding))
                }
            } else {

                items(items = products, key = { product -> product.id }) { product ->
                    ProductCard(
                        product = product,
                        onClick = {
                            navController.navigate(Screen.ProductDescriptionScreen.route)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun ProductCard(
    product : Product,
    containerColor : Color = app_llComponent,
//    outerPadding : Dp = Dimensions.productCardSize,
    outerPadding : Dp = 1.dp,
//    shape: Shape = Shapes.CardShape,
    shape: Shape = RoundedCornerShape(2.dp),
//    elevation: CardElevation = CardDefaults.cardElevation(Dimensions.cardElevation),
    elevation: CardElevation = CardDefaults.cardElevation(2.dp),
//    innerPadding: Dp = Dimensions.componentPadding,
    innerPadding: Dp = 2.dp,
//    imageSize : Dp = Dimensions.ProductSize,
    imageSize : Dp = 100.dp,
    contentScale: ContentScale = ContentScale.Crop,
    onClick: () -> Unit
){
    Card(
        modifier = Modifier
            .padding(outerPadding),
//            .heightIn(min = 220.dp, max = 260.dp)
//        ,
        shape = shape,
        colors = CardDefaults.cardColors(
            containerColor = containerColor
        ),
        elevation = elevation,
        onClick = onClick,
    ) {
        Column(modifier = Modifier.padding(innerPadding)) {
            Image(
                painter = rememberAsyncImagePainter(product.thumbnail),

                contentDescription = product.title,
                modifier = Modifier.size(imageSize),
                contentScale = contentScale
            )
            Spacer(modifier = Modifier.height(Dimensions.smallSpacer))
            Column {
                Column {
                    CustomTitle(
                        header = product.title
                    )
                    CustomLabel(
                        header = "$${product.price}"
                    )
                }
            }
        }
    }
}


@Composable
fun featureRow(
    padding : Dp = Dimensions.componentPadding
){
    Row(
        modifier = Modifier
            .padding(padding)
            .fillMaxWidth()
    ) {
        Row {
            CustomIcon(
                painter = painterResource(R.drawable.ic_order_return)
            )
            Column {
                CustomLabel(
                    header = "Easy Return",
                    fontWeight = FontWeight.Bold
                )
                CustomLabel(
                    header = "Free Pick Up",
                    fontWeight = FontWeight.Thin
                )
            }
        }
        Row {
            CustomIcon(
                painter = painterResource(R.drawable.ic_app_star)
            )
            Column {
                CustomLabel(
                    header = "Fast Delivery",
                    fontWeight = FontWeight.Bold
                )
                CustomLabel(
                    header = "100+ Styles",
                    fontWeight = FontWeight.Thin
                )
            }
        }

        Row {
            CustomIcon(
                painter = painterResource(R.drawable.ic_app_processing)
            )
            Column {
                CustomLabel(
                    header = "Free Shipping",
                    fontWeight = FontWeight.Bold
                )
                CustomLabel(
                    header = "For Orders 50+",
                    fontWeight = FontWeight.Thin
                )
            }
        }
    }
}


@Composable
fun DiscountCard(
    padding: Dp = Dimensions.componentPadding,
    height : Dp = Dimensions.productCardSize,
    shape: Shape = Shapes.CardShape,
    containerColor: Color = app_llComponent,
    elevation: CardElevation= CardDefaults.cardElevation(Dimensions.cardElevation),
    data: DiscountData,
){
    val selectedImage  = remember { data.image.random() }
    Card(
        modifier = Modifier
            .padding(padding)
            .heightIn(height),
        shape = shape,
        colors = CardDefaults.cardColors(
            containerColor = containerColor
        ),
        elevation = elevation
    ){
        Row (modifier = Modifier
            .padding(Dimensions.componentPadding)
            .wrapContentHeight()
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Column(
                modifier = Modifier.weight(3f),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                CustomTitle(
                    header = data.title,
                    modifier = Modifier.weight(3f),
                    maxLine = 1
                )
                Spacer(modifier = Modifier.height(Dimensions.smallSpacer))

                CustomTitle(
                    header =   data.desc,
                    maxLine = 1,
                    modifier = Modifier.weight(0.8f)
                )

                Spacer(modifier = Modifier.height(Dimensions.smallSpacer))

                CustomBody(
                    header = data.ctaText,
                    modifier = Modifier.weight(0.8f),
                    maxLine = 1
                )
            }
            Box(
                modifier = Modifier
                    .weight(1.5f)
                    .fillMaxHeight()
            ){
                CustomDiscountImage(
                    painter = painterResource(selectedImage)
                )
            }
        }
    }
}

@Composable
fun CategoryCardRow(
    categoryList : List<CategoryData>,
    size : Dp = Dimensions.CategoryCardSize,
    onClick : () -> Unit,
    CardColor : Color = app_background,
    elevation: CardElevation = CardDefaults.cardElevation(Dimensions.cardElevation),
    borderStroke : Dp = Dimensions.cardBorder,
    borderColor: Color = app_lComponent,
    innerPadding : Dp = Dimensions.componentPadding
){
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(Dimensions.medSpacer)
    ) {
        items(categoryList){item ->
            Card(
                modifier = Modifier
                    .size(size)
                    .clickable{onClick()},
                elevation = elevation,
                colors = CardDefaults.cardColors(
                    containerColor = CardColor
                ),
                border = BorderStroke(borderStroke, borderColor)
            ) {
                CustomIcon(
                    painter = item.icon,
                    iconColor = item.bgColor,
                    iconDescription = item.label
                )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewDiscountCard(){
//    val sampleData = DiscountData(
//        title = "50% OFF",
//        desc = "On all skincare products",
//        ctaText = "Shop Now",
//        textColor = Color.Black,
//        descColor = Color.DarkGray,
//        image = listOf(R.drawable.ic_discount13)
//    )
//
//    DiscountCard(
//        shape = RoundedCornerShape(12.dp),
//        containerColor = Color(0xFFFFF3E0),
//        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
//        data = sampleData,
//        titleSize = 18.sp,
//        descSize = 14.sp,
//        ctaSize = 16.sp
//    )
//}

