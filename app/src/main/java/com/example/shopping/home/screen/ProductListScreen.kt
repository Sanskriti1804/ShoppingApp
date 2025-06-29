package com.example.shopping.home.screen

import android.annotation.SuppressLint
import android.util.Size
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowRight
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.shopping.R
import com.example.shopping.components.CustomIcon
import com.example.shopping.components.CustomNavigationBar
import com.example.shopping.components.CustomSearch
import com.example.shopping.components.CustomTitle
import com.example.shopping.components.CustomTopBar
import com.example.shopping.home.data.CategoryData
import com.example.shopping.home.data.DiscountData
import com.example.shopping.home.data.Product
import com.example.shopping.home.viewmodel.ProductViewModel
import com.example.shopping.navigation.Screen
import com.example.shopping.product.ProductCarousel
import com.example.shopping.ui.theme.app_dBlack
import com.example.shopping.ui.theme.app_lBlack
import com.example.shopping.ui.theme.app_lGray
import com.example.shopping.ui.theme.app_white
import com.example.shopping.ui.theme.app_white_bg
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(navController : NavHostController) {
    val viewModel: ProductViewModel = viewModel()
    val products = viewModel.productList

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) } // Changed from true to false for better default state

    val searchHistory = listOf("First Search", "Second Search", "Third Search")

    Scaffold(
        containerColor = app_white_bg,
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
            modifier = Modifier.fillMaxSize().padding(top = 95.dp, bottom = 18.dp, start = 18.dp, end = 18.dp)
//            modifier = Modifier.fillMaxSize().padding(20.dp)

        ) {
//            item {
//                featureRow()
//            }
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
                    textColor = Color.Black,
                    descColor = app_dBlack,
                    image = discountImage,
                    ctaText = "SHOP NOW"
                )

                DiscountCard(
                    shape = RoundedCornerShape(8.dp),
                    containerColor = app_lGray, // Assuming this color is defined elsewhere
                    elevation = CardDefaults.cardElevation(4.dp),
                    data = discountData,
                    titleSize = 40.sp,
                    descSize = 20.sp,
                    ctaSize = 20.sp
                )

                Spacer(modifier = Modifier.height(12.dp))
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
                        onClick = {}
                    )
                }
            }

            item(span = { GridItemSpan(2)}) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CustomTitle(
                        header = "Featured",
                        fontSize = 16.sp
                    )
                    Row {
                        CustomTitle(
                            header = "See all",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Thin
                        )
                        CustomIcon(
                            painter = painterResource(R.drawable.ic_app_arrow),
                            iconColor = app_dBlack
                        )
                    }
                }
            }


            if (products.isEmpty()) {
                item(span = { GridItemSpan(2) }) {
                    Text("No products found", modifier = Modifier.fillMaxWidth().padding(16.dp))
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
fun featureRow(
    padding : Dp = 4.dp
){
    Row(
        modifier = Modifier
            .padding(padding)
            .fillMaxWidth()
    ) {
        Row {
            CustomIcon(
                painter = painterResource(R.drawable.ic_order_return),
                iconSize = 15.dp
            )
            Column {
                CustomTitle(
                    header = "Easy Return",
                    fontSize = 8.sp
                )
                CustomTitle(
                    header = "Free pick up",
                    fontSize = 8.sp,
                    fontWeight = FontWeight.Thin
                )
            }
        }

        Row {
            CustomIcon(
                painter = painterResource(R.drawable.ic_app_star),
                iconSize = 15.dp
            )
            Column {
                CustomTitle(
                    header = "Fast Delivery",
                    fontSize = 8.sp
                )
                CustomTitle(
                    header = "100+ Styles",
                    fontSize = 8.sp,
                    fontWeight = FontWeight.Thin
                )
            }
        }

        Row {
            CustomIcon(
                painter = painterResource(R.drawable.ic_app_processing),
                iconSize = 15.dp
            )
            Column {
                CustomTitle(
                    header = "Free Shipping",
                    fontSize = 8.sp
                )
                CustomTitle(
                    header = "For orders 50+",
                    fontSize = 8.sp,
                    fontWeight = FontWeight.Thin
                )
            }
        }

    }
}

@Composable
fun ProductCard(
    product : Product,
    containerColor : Color = app_white,
    outerPadding : Dp = 8.dp,
    shape: Shape = RoundedCornerShape(4.dp),
    elevation: CardElevation = CardDefaults.cardElevation(4.dp),
    innerPadding: Dp = 16.dp,
    imageSize : Dp = 100.dp,
    contentScale: ContentScale = ContentScale.Crop,
    spacerHeight : Dp = 4.dp,
    onClick: () -> Unit
){
    Card(
        modifier = Modifier
            .padding(outerPadding)
            .heightIn(min = 220.dp, max = 260.dp)
        ,
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
            Spacer(modifier = Modifier.height(spacerHeight))
            Column {
                CustomTitle(
                    header = product.title,
                    fontSize = 16.sp
                )
                CustomTitle(
                    header = "$${product.price}",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Thin
                )
            }
        }
    }
}

@Composable
fun DiscountCard(
    modifier : Modifier = Modifier.padding(2.dp).heightIn(max = 180.dp),
    shape: Shape,
    containerColor: Color,
    elevation: CardElevation,
    data: DiscountData,
    titleSize: TextUnit,
    descSize: TextUnit,
    ctaSize: TextUnit
){
    val selectedImage  = remember { data.image.random() }
    Card(
        modifier = modifier,
        shape = shape,
        colors = CardDefaults.cardColors(
            containerColor = containerColor
        ),
        elevation = elevation
    ){
        Row (modifier = Modifier
            .padding(20.dp)
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
                    fontWeight = FontWeight.Bold,
                    maxLine = 1
                )
                Spacer(modifier = Modifier.height(3.dp))

                CustomTitle(
                    header =   data.desc,
                    maxLine = 1,
                    modifier = Modifier.weight(0.8f)
                )
                Spacer(modifier = Modifier.height(2.dp))
                CustomTitle(
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
                Image(
                    painter = painterResource(selectedImage),
                    contentDescription = "Discount Image",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxSize()
//                    .size()
//                    .aspectRatio(1f)
                )
            }
        }
    }
}

@Composable
fun CategoryCardRow(
    categoryList : List<CategoryData>,
    size : Dp = 45.dp,
    onClick : () -> Unit,
    CardColor : Color = app_white_bg,
    borderStroke : Dp = 1.dp,
    borderColor: Color = app_lGray,
    innerPadding : Dp = 7.dp
){
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(3.dp)
    ) {
        items(categoryList){item ->
            Card(
                modifier = Modifier
                    .size(size)
                    .clickable{onClick()},
                elevation = CardDefaults.cardElevation(4.dp),
                colors = CardDefaults.cardColors(
                    containerColor = CardColor
                ),
                border = BorderStroke(borderStroke, borderColor)
            ) {
                Icon(
                    painter = item.icon,
                    tint = item.bgColor,
                    contentDescription = item.label,
                    modifier = Modifier.padding(innerPadding)
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDiscountCard(){
    val sampleData = DiscountData(
        title = "50% OFF",
        desc = "On all skincare products",
        ctaText = "Shop Now",
        textColor = Color.Black,
        descColor = Color.DarkGray,
        image = listOf(R.drawable.ic_discount13)
    )

    DiscountCard(
        shape = RoundedCornerShape(12.dp),
        containerColor = Color(0xFFFFF3E0),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        data = sampleData,
        titleSize = 18.sp,
        descSize = 14.sp,
        ctaSize = 16.sp
    )
}

