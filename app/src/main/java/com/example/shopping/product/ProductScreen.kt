package com.example.shopping.product

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Favorite
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
import com.example.shopping.R
import com.example.shopping.components.CustomBody
import com.example.shopping.components.CustomButton
import com.example.shopping.components.CustomDivider
import com.example.shopping.components.CustomIcon
import com.example.shopping.components.CustomInputChip
import com.example.shopping.components.CustomLabel
import com.example.shopping.components.CustomReviewImage
import com.example.shopping.components.CustomTitle
import com.example.shopping.home.data.Product
import com.example.shopping.home.viewmodel.ProductViewModel
import com.example.shopping.navigation.Screen
import com.example.shopping.ui.theme.Dimensions
import com.example.shopping.ui.theme.Shapes
import com.example.shopping.ui.theme.app_ltext
import com.example.shopping.ui.theme.app_lComponent
import com.google.accompanist.pager.rememberPagerState
import org.koin.androidx.compose.koinViewModel
import java.util.Date

@Composable
fun ProductDescriptionScreen(){
    val viewModel : ProductViewModel = koinViewModel()
    val product  = viewModel.product
    LazyColumn (
        modifier = Modifier
            .padding(Dimensions.componentPadding)
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
                text = "Reviews"            )
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
    padding : Dp = Dimensions.componentPadding
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
        Spacer(modifier = Modifier.height(Dimensions.medSpacer))
        CustomBody(
            header = product?.title ?: "Summer Side Pleated Textured Midi Dress"
        )
        CustomBody(
            header = product?.price.toString() ?: "$45.67"
        )
        CustomLabel(
            header = "Inclusive of all taxes"
        )
        Spacer(modifier = Modifier.height(Dimensions.medSpacer))
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(Dimensions.componentPadding),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            CustomBody(
                header = "SIZE"
            )
            Row {
                CustomBody(
                    header = "Size Guide and Model Info",
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
    boxModifier : Modifier = Modifier.padding(Dimensions.componentPadding).fillMaxWidth(),
    boxInnerPadding : Dp = Dimensions.componentPadding,
    borderWidth : Dp = Dimensions.cardBorder,
    borderColor : Color = Color.DarkGray,
    borderShape : Shape = Shapes.CardShape,
    review : String = "amazing producttt 🩷🩷🩷"


){
    Column (
        modifier = Modifier.fillMaxWidth()
    ){
        Row {
            CustomBody(
                header = text
            )
            CustomBody(
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
                            CustomLabel(
                                header = Date().toString()
                            )
                        }
                        CustomLabel(
                            header = review
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
    modifier : Modifier = Modifier.padding(Dimensions.componentPadding).fillMaxWidth(),
    deliveryInfo : String = "DELIVERY INFO",
    qnaIcon : Painter = painterResource(R.drawable.ic_app_info),
    searchModifier : Modifier = Modifier.fillMaxWidth().padding(Dimensions.componentPadding),
    pincodeQuery : String = " Enter pincode to check"
){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Row {
            CustomBody(
                header =  deliveryInfo
            )
            CustomIcon(
                painter = qnaIcon,
                iconColor = app_lComponent
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
                painter = `painterResource`(R.drawable.ic_app_info),
                iconColor = app_lComponent

            )
            CustomBody(
                header = "Fast Delivery available on all products"
            )
        }
        Row {
            CustomIcon(
                painter = `painterResource`(R.drawable.ic_app_info),
                iconColor = app_lComponent
            )
            CustomBody(
                header = "Standard Delivery"
            )
            CustomLabel(
                header = "Free shipping on this product. Please enter pincode to check delivery time,"
            )
        }

        Row {
            CustomIcon(
                painter = `painterResource`(R.drawable.ic_order_return),
                iconColor = app_lComponent
            )

            CustomBody(
                header = "7 days easy return with pickup besides special offer products"
            )
        }

        Row {
            CustomIcon(
                painter = painterResource(R.drawable.ic_app_info),
                iconColor = app_lComponent
            )

            CustomBody(
                header = "Cash on delivery available in most areas"
            )
        }
    }
}

@Composable
fun ProductDetail(
    padding : Dp = Dimensions.componentPadding,
    modifier : Modifier = Modifier.padding(12.dp).fillMaxWidth(),
    productDetail : String = "Product Detail",
    productIcon : Painter = painterResource(R.drawable.ic_cat_tshirt),
    productDesc : String = "Product Detail",
    detailOne : String = "ABOUT THE PRODUCT",
    detailTwo : String = "SERVICE AND POLICY",
    collapseIcon : ImageVector = Icons.Default.ArrowDropDown,
    collapseIconDesc : String = "collapse icon"
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(padding),
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        CustomTitle(
            header = productDetail
        )
        CustomDivider()
        Row (
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            CustomIcon(
                painter = painterResource(R.drawable.ic_cat_tshirt)
            )

            CustomBody(
                header = detailOne
            )
            CustomIcon(
                painter = painterResource(R.drawable.ic_app_info),
                iconColor = app_lComponent
            )
        }
        Row (
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            CustomIcon(
                painter = painterResource(R.drawable.ic_cat_tshirt)
            )
            CustomBody(
                header = detailTwo
            )
            CustomIcon(
                painter = painterResource(R.drawable.ic_app_info),
                iconColor = app_lComponent
            )

        }

    }
}

@Preview(showBackground = true)
@Composable
fun Screen.ProductDescriptionScreenPreview(){
    ProductDescriptionScreen()
}
