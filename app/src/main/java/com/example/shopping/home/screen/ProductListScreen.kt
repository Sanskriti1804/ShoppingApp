package com.example.shopping.home.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
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
import coil.compose.rememberAsyncImagePainter
import com.example.shopping.R
import com.example.shopping.components.CustomSearch
import com.example.shopping.components.CustomTopBar
import com.example.shopping.home.data.CategoryData
import com.example.shopping.home.data.DiscountData
import com.example.shopping.home.data.Product
import com.example.shopping.home.viewmodel.ProductViewModel
import com.example.shopping.ui.theme.T_BgColor
import com.example.shopping.ui.theme.T_CardColor
import com.example.shopping.ui.theme.T_DTextColor
import com.example.shopping.ui.theme.T_LTextColor

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen() {
    val viewModel: ProductViewModel = viewModel()
    val products = viewModel.productList

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) } // Changed from true to false for better default state

    val searchHistory = listOf("First Search", "Second Search", "Third Search")

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
                containerColor = T_LTextColor, // Assuming this color is defined elsewhere
                titleColor = Color.Black,
                actionIconColor = Color.Black,
                scrollBehavior = scrollBehavior
            )
        }
    ) { paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize()

        ) {
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
                    descColor = T_DTextColor,
                    image = discountImage,
                    ctaText = "SHOP NOW"
                )

                DiscountCard(
                    shape = RoundedCornerShape(8.dp),
                    containerColor = T_BgColor, // Assuming this color is defined elsewhere
                    elevation = CardDefaults.cardElevation(4.dp),
                    data = discountData,
                    titleSize = 40.sp,
                    descSize = 20.sp,
                    ctaSize = 20.sp
                )

            }
            item(span = { GridItemSpan(2)}) {
                val categoryList = listOf(
                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_dress),
                        label = "null",
                        bgColor = T_LTextColor
                    ),
                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_hat),
                        label = "null",
                        bgColor = T_LTextColor
                    ),
                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_bow_tie),
                        label = "null",
                        bgColor = T_LTextColor
                    ),
                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_camera),
                        label = "null",
                        bgColor = T_LTextColor
                    ),
                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_tie),
                        label = "null",
                        bgColor = T_LTextColor
                    ),
                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_dryer),
                        label = "null",
                        bgColor = T_LTextColor
                    ),
                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_belt),
                        label = "null",
                        bgColor = T_LTextColor
                    ),
                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_earrings),
                        label = "null",
                        bgColor = T_LTextColor
                    ),
                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_glasses),
                        label = "null",
                        bgColor = T_LTextColor
                    ),
                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_hand_bag),
                        label = "null",
                        bgColor = T_LTextColor
                    ),
                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_jeans),
                        label = "null",
                        bgColor = T_LTextColor
                    ),
                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_lipstick),
                        label = "null",
                        bgColor = T_LTextColor
                    ),
                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_shorts),
                        label = "null",
                        bgColor = T_LTextColor
                    ),
                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_tshirt),
                        label = "null",
                        bgColor = T_LTextColor
                    ),
                    CategoryData(
                        icon = painterResource(id = R.drawable.ic_cat_wristwatch),
                        label = "null",
                        bgColor = T_LTextColor
                    )
                )

                Box(modifier = Modifier.padding(8.dp)) {
                    CategoryCardRow(
                        categoryList = categoryList,
                        size = 45.dp,
                        onClick = {},
                        CardColor = Color.White,
                        borderStroke = 1.dp,
                        borderColor = T_DTextColor // Assuming this color is defined elsewhere
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
                    Text(
                        text = "Featured",
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Row {
                        Text(
                            text = "See all",
                            color = T_DTextColor, // Assuming this color is defined elsewhere
                            fontSize = 15.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = "See all icon",
                            tint = T_DTextColor // Assuming this color is defined elsewhere
                        )
                    }
                }
                Divider(thickness = 2.dp, color = T_LTextColor) // Assuming this color is defined elsewhere
            }
            items(
                items = products,
                key = {products -> products.id}
            ){ product ->
                ProductCard(
                    product = product,
                    containerColor = T_CardColor, // Assuming this color is defined elsewhere
                    shape = RoundedCornerShape(4.dp)
                )
            }
        }
    }
}

@Composable
fun ProductCard(
    product : Product,
    containerColor : Color,
    shape: Shape,
){
    Card(
        modifier = Modifier
//            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = shape,
        colors = CardDefaults.cardColors(
            containerColor = containerColor
        ),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = rememberAsyncImagePainter(product.thumbnail),
                contentDescription = product.title,
                modifier = Modifier.size(80.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(6.dp))
            Row {
                Text(text = product.title, style = MaterialTheme.typography.titleMedium)
                Text(text = "$${product.price}", style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

@Composable
fun DiscountCard(
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
                Text(
                    text = data.title,
                    color = data.textColor,
                    fontSize = titleSize,
                    fontWeight = FontWeight.ExtraBold,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = data.desc,
                    color = data.descColor,
                    fontSize = descSize,
                    fontWeight = FontWeight.Thin,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = data.ctaText,
                    color = data.descColor,
                    fontSize = ctaSize,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
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
    size : Dp,
    onClick : () -> Unit,
    CardColor : Color,
    borderStroke : Dp,
    borderColor: Color
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
                    contentDescription = item.label
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







//@Composable
//fun ProductGrid(
//
//) {
//    LazyVerticalGrid(
//        columns = GridCells.Fixed(2),
//        verticalArrangement = Arrangement.spacedBy(12.dp),
//        horizontalArrangement = Arrangement.spacedBy(12.dp)
//    ) {
//
//        items(products) { product ->
//
//        }
//    }
//}


//        LazyColumn(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(Color.White)
//                .padding(paddingValues)
//                .padding(12.dp)
//        ) {
//            item {
//                Box(
//                    modifier = Modifier.fillMaxSize()
//                ){
//                    CustomSearch(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .wrapContentHeight(),
//                        query = query,
//                        onQueryChange = {query = it},
//                        active = active,
//                        onActiveChange = { active = it},
//                        leadingIcon = Icons.Default.ArrowBack,
//                        trailingIcon = Icons.Default.Close,
//                        micIcon = painterResource(R.drawable.ic_mic),
//                        containerColor = Color.Gray,
//                        placeholder = {Text("Search")},
//                        onClick = {},
//                        historyIcon = painterResource(R.drawable.ic_history),
//                        searchHistory = searchHistory,
//                    )
//                }
//            }
//            item {
//                    }
//            item {
//}
//            items(products) {products->
//                ProductCard(
//                    product = products,
//                    containerColor = T_CardColor,
//                    shape = RoundedCornerShape(4.dp)
//                )
//            }
//        }
//    }
//}
