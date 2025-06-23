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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Star
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopping.R
import com.example.shopping.components.CustomInputChip
import com.example.shopping.components.CustomTitle
import com.example.shopping.home.data.Product
import com.example.shopping.home.viewmodel.ProductViewModel
import com.google.accompanist.pager.rememberPagerState
import java.util.Date

@Composable
fun ProductDescriptionScreen(
    productViewModel: ProductViewModel
){
    val product  = productViewModel.product
    LazyRow (modifier = Modifier.padding(2.dp).fillMaxWidth()){
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
    modifier: Modifier = Modifier.padding(2.dp).fillMaxSize()
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
        modifier = modifier
    ){  }
    ProductCarousel(
        state = pagerState,
        images = productImage
    )
    Spacer(modifier = Modifier.height(10.dp))
    CustomTitle(
        header = product?.title ?: "unavailable"
    )
    CustomTitle(
        header = product?.price.toString(),
        fontWeight = FontWeight.Bold,
        fontSize = 26.sp
    )
    CustomTitle(
        header = "Inclusive of all taxes",
        headerColor = Color.LightGray,
        fontWeight = FontWeight.Thin,
        fontSize = 20.sp
    )
    Spacer(modifier = Modifier.height(5.dp))
    CustomTitle(
        header = "SIZE",
        fontWeight = FontWeight.Bold,
        fontSize = 26.sp
    )
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
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
                header = count
            )
            CustomTitle(
                header = text
            )
        }
        LazyRow {
            item {
                Image(
                    painter = image,
                    contentDescription = contentDescription,
                    contentScale = contentScale
                )
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
                            Icon(
                                imageVector = star,
                                contentDescription = starDesc,
                            )
                            Date()
                        }
                        CustomTitle(
                            header = review
                        )
                        Image(
                            painter = image,
                            contentDescription = contentDescription
                        )
                    }
                }

            }
        }

    }
}

@Composable
fun DeliveryInfo(
    modifier : Modifier = Modifier.padding(2.dp).fillMaxWidth(),
    deliveryInfo : String = "DELIVERY INFO",
    qnaIcon : ImageVector = Icons.Default.Info,
    qnaDesc : String = "delivery info",
    searchModifier : Modifier = Modifier.fillMaxWidth().padding(2.dp),
    pincodeQuery : String = " Enter pincode to check"
){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Row {
            CustomTitle(
                header =  deliveryInfo
            )
            Icon(
                imageVector = qnaIcon,
                contentDescription = qnaDesc,
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
            Icon(
                imageVector = qnaIcon,
                contentDescription = qnaDesc
            )
            CustomTitle(
                header = "Fast Delivery available on all products",
                fontWeight = FontWeight.Bold,
            )
        }
        Row {
            Icon(
                imageVector = qnaIcon,
                contentDescription = qnaDesc
            )
            CustomTitle(
                header = "Standard Delivery",
                fontWeight = FontWeight.Bold,
            )
            CustomTitle(
                header = "Free shipping on this product. Please enter pincode to check delivery time"
            )
        }

        Row {
            Icon(
                imageVector = qnaIcon,
                contentDescription = qnaDesc
            )
            CustomTitle(
                header = "7 days easy return with pickup besides special offer products",
            )
        }

        Row {
            Icon(
                imageVector = qnaIcon,
                contentDescription = qnaDesc
            )
            CustomTitle(
                header = "Cash on delivery available in most areas",
            )
        }
    }
}

@Composable
fun ProductDetail(
    modifier : Modifier = Modifier.padding(2.dp).fillMaxWidth(),
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
            Icon(
                painter = productIcon,
                contentDescription = productDesc
            )
            CustomTitle(
                header = detailOne
            )
            Icon(
                imageVector = collapseIcon,
                contentDescription = collapseIconDesc
            )
        }
        Row (
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Icon(
                painter = productIcon,
                contentDescription = productDesc
            )
            CustomTitle(
                header = detailTwo
            )
            Icon(
                imageVector = collapseIcon,
                contentDescription = collapseIconDesc
            )

        }

    }
}