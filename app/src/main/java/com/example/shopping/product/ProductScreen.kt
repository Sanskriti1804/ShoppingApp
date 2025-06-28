package com.example.shopping.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shopping.R
import com.example.shopping.components.CustomButton
import com.example.shopping.components.CustomIcon
import com.example.shopping.components.CustomInputChip
import com.example.shopping.components.CustomReviewImage
import com.example.shopping.components.CustomTitle
import com.example.shopping.home.data.Product
import com.example.shopping.home.viewmodel.ProductViewModel
import com.example.shopping.navigation.Screen
import com.example.shopping.ui.theme.app_lBlack
import com.example.shopping.ui.theme.app_lGray
import com.google.accompanist.pager.rememberPagerState
import java.util.Date

@Composable
fun ProductDescriptionScreen(){
    val viewModel : ProductViewModel = viewModel()
    val product  = viewModel.product
    LazyColumn (
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
    ){
        item {
            ProductDesc(
                product = product
            )
        }
        item {
            ReviewCard(
                count = "35",
                text = "Reviews",
                image = painterResource(R.drawable.ic_discount13)
            )
        }
        item {
            DeliveryInfo()
        }
        item {
            ProductDetail()
        }
    }
}

@Composable
fun ProductDesc(
    product: Product?,
    padding : Dp = 5.dp
){
    val  pagerState = rememberPagerState()
    val productImage = listOf(
        R.drawable.ic_discount1,
        R.drawable.ic_discount2,
        R.drawable.ic_discount3,
        R.drawable.ic_discount4,
        R.drawable.ic_discount5
    )

    Column(
        modifier = Modifier
            .padding(padding)
            .fillMaxWidth()
    ) {
        ProductCarousel(
            state = pagerState,
            images = productImage
        )
        Spacer(modifier = Modifier.height(10.dp))
        CustomTitle(
            header = product?.title ?: "Summer Side Pleated Textured Midi Dress",
            fontWeight = FontWeight.Thin,
            fontSize = 12.sp
        )
        CustomTitle(
            header = product?.price.toString() ?: "$45.67",
            fontWeight = FontWeight.SemiBold,
            fontSize = 15.sp
        )
        CustomTitle(
            header = "Inclusive of all taxes",
            headerColor = Color.LightGray,
            fontWeight = FontWeight.ExtraLight,
            fontSize = 6.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            CustomTitle(
                header = "SIZE",
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp
            )
            Row {
                CustomTitle(
                    header = "Size Guide and Model Info",
                    fontWeight = FontWeight.Normal,
                    fontSize = 10.sp
                )
                CustomIcon(
                    painter = painterResource(R.drawable.ic_app_arrow)
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CustomInputChip(
                selected = false,
                onClick = {},
                label = "Size Chip",
                icon = Icons.Default.Favorite
            )
            CustomInputChip(
                selected = false,
                onClick = {},
                label = "Size Chip",
                icon = Icons.Default.Favorite
            )
            CustomInputChip(
                selected = false,
                onClick = {},
                label = "Size Chip",
                icon = Icons.Default.Favorite
            )
            CustomInputChip(
                selected = false,
                onClick = {},
                label = "Size Chip",
                icon = Icons.Default.Favorite
            )
        }
    }
}

@Composable
fun ReviewCard(
    count : String,
    text : String,
    image : Painter,
    contentDescription : String = "Review Image",
    contentScale : ContentScale = ContentScale.Crop,
    boxModifier : Modifier = Modifier.padding(4.dp).fillMaxWidth(),
    boxInnerPadding : Dp = 3.dp,
    borderWidth : Dp = 2.dp,
    borderColor : Color = Color.DarkGray,
    borderShape : Shape = RoundedCornerShape(4.dp),
    star : ImageVector = Icons.Default.Star,
    starDesc : String = "StarReview",
    review : String = "amazing producttt 🩷🩷🩷"


){
    Column (
        modifier = Modifier.fillMaxWidth()
    ){
        Row {
            CustomTitle(
                header = text
            )
            CustomTitle(
                header = count
            )
        }
        LazyRow {
            item {
                CustomReviewImage()
            }
        }
        LazyRow {
            item {
                Box(
                    modifier = boxModifier
                        .border(
                            width = borderWidth,
                            color = borderColor,
                            shape = borderShape
                        )
                        .padding(boxInnerPadding)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row {
                                CustomIcon(
                                    painter = painterResource(R.drawable.ic_app_star_fill)
                                )
                                CustomIcon(
                                    painter = painterResource(R.drawable.ic_app_star_fill)
                                )
                                CustomIcon(
                                    painter = painterResource(R.drawable.ic_app_star_fill)
                                )
                                CustomIcon(
                                    painter = painterResource(R.drawable.ic_app_star)
                                )
                            }
                            CustomIcon(
                                painter = painterResource(R.drawable.ic_app_star_fill)
                            )
                            CustomTitle(
                                header = Date().toString(),
                                fontWeight = FontWeight.Thin,
                                fontSize = 8.sp,
                                headerColor = app_lGray
                            )
                        }
                        CustomTitle(
                            header = review,
                            fontWeight = FontWeight.Thin,
                            fontSize = 10.sp,
                            headerColor = app_lBlack
                        )
                    }
                }

            }
        }
        CustomButton(
            textButton = true,
            buttonDescription = "reviews button",
            onClick = {},
            buttonText = "See all Reviews"
        )

    }
}

@Composable
fun DeliveryInfo(
    modifier : Modifier = Modifier.padding(10.dp).fillMaxWidth(),
    deliveryInfo : String = "DELIVERY INFO",
    qnaIcon : Painter = painterResource(R.drawable.ic_app_info),
    searchModifier : Modifier = Modifier.fillMaxWidth().padding(12.dp),
    pincodeQuery : String = " Enter pincode to check"
){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Row {
            CustomTitle(
                header =  deliveryInfo,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp
            )
            CustomIcon(
                painter = painterResource(R.drawable.ic_app_info),
                iconColor = app_lGray
            )
        }

//        CustomSearch(
//            modifier = searchModifier,
//            query = pincodeQuery,
//            onQueryChange = {},
//            active = true,
//            onActiveChange = {},
//            leadingIcon = qnaIcon,
//            trailingIcon = qnaIcon,
//            containerColor =
//        )

        Row {
            CustomIcon(
                painter = painterResource(R.drawable.ic_app_info),
                iconColor = app_lGray

            )
            CustomTitle(
                header = "Fast Delivery available on all products",
                fontWeight = FontWeight.Normal,
                fontSize = 8.sp
            )
        }
        Row {
            CustomIcon(
                painter = painterResource(R.drawable.ic_app_info),
                iconColor = app_lGray
            )
            CustomTitle(
                header = "Standard Delivery",
                fontWeight = FontWeight.Normal,
                fontSize = 8.sp
            )
            CustomTitle(
                header = "Free shipping on this product. Please enter pincode to check delivery time," ,
                fontWeight = FontWeight.Thin,
                fontSize = 8.sp
            )
        }

        Row {
            CustomIcon(
                painter = painterResource(R.drawable.ic_order_return),
                iconColor = app_lGray
            )
            CustomTitle(
                header = "7 days easy return with pickup besides special offer products",
                fontWeight = FontWeight.Thin,
                fontSize = 8.sp
            )
        }

        Row {
            CustomIcon(
                painter = painterResource(R.drawable.ic_app_info),
                iconColor = app_lGray
            )
            CustomTitle(
                header = "Cash on delivery available in most areas",
                fontWeight = FontWeight.Thin,
                fontSize = 8.sp
            )
        }
    }
}

@Composable
fun ProductDetail(
    modifier : Modifier = Modifier.padding(12.dp).fillMaxWidth(),
    productDetail : String = "Product Detail",
    divModifier : Modifier = Modifier.padding(1.dp),
    divColor : Color = Color.LightGray,
    divThickness : Dp = 1.dp,
    productIcon : Painter = painterResource(R.drawable.ic_cat_tshirt),
    productDesc : String = "Product Detail",
    detailOne : String = "ABOUT THE PRODUCT",
    detailTwo : String = "SERVICE AND POLICY",
    collapseIcon : ImageVector = Icons.Default.ArrowDropDown,
    collapseIconDesc : String = "collapse icon"
){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        CustomTitle(
            header = productDetail,
            fontWeight = FontWeight.Bold
        )
        Divider(
            modifier = divModifier,
            color = divColor,
            thickness = divThickness
        )
        Row (
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            CustomIcon(
                painter = painterResource(R.drawable.ic_cat_tshirt)
            )
            CustomTitle(
                header = detailOne,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp
            )
            CustomIcon(
                painter = painterResource(R.drawable.ic_app_info),
                iconColor = app_lGray
            )
        }
        Row (
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            CustomIcon(
                painter = painterResource(R.drawable.ic_cat_tshirt)
            )
            CustomTitle(
                header = detailTwo,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp
            )
            CustomIcon(
                painter = painterResource(R.drawable.ic_app_info),
                iconColor = app_lGray
            )

        }

    }
}

@Preview(showBackground = true)
@Composable
fun Screen.ProductDescriptionScreenPreview(){
    ProductDescriptionScreen()
}
