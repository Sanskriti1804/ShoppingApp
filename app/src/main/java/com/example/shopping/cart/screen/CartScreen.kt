package com.example.shopping.cart.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.shopping.R
import com.example.shopping.cart.data.CartProduct
import com.example.shopping.cart.viewmodel.CartViewModel
import com.example.shopping.components.CustomDivider
import com.example.shopping.components.CustomNavigationBar
import com.example.shopping.components.CustomTitle
import com.example.shopping.components.CustomTopBar
import com.example.shopping.components.QuantityButton
import com.example.shopping.components.SizeButton
import com.example.shopping.ui.theme.app_dBlack
import com.example.shopping.ui.theme.app_lGray
import com.example.shopping.ui.theme.app_white_bg


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(navController: NavHostController) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    val viewModel : CartViewModel = viewModel()
    val cartProduct = viewModel.cartList

    Scaffold(
        containerColor = app_white_bg,
        topBar = {
            CustomTopBar(
                fontWeight = FontWeight.Bold,
                titleOverflow = TextOverflow.Ellipsis,
                onNavigationClick = {},
                actionIcon = painterResource(R.drawable.ic_app_cart),
                scrollBehavior = scrollBehavior
            )
        },
        bottomBar = {
            CustomNavigationBar(navController = navController)
        }
    ) { paddingValues ->
        LazyColumn (
            modifier = Modifier.padding(paddingValues)
        ){
            item {
                CustomTitle(
                    header = "Cart"
                )
                CustomDivider()
            }
            if (cartProduct.isEmpty()){
                item {
                    Text("cart is Empty")
                }
            }
            else{
                items(cartProduct) { product ->
                    CartProdCard(
                        cartProduct = product,
                        onClick = {},

                        )
                }
            }


        }

    }
}

@Composable
fun CartProdCard(
    cartProduct: CartProduct,
    onClick : () -> Unit,
    contentDescription : String = "Cart Product",
   padding : Dp = 8.dp,
    shape : Shape  = RoundedCornerShape(8.dp),
    containerColor: Color = app_lGray,
    imageSize : Dp = 80.dp,
    contentColor: Color = Color.Black,
    elevation: CardElevation = CardDefaults.cardElevation(2.dp),
    titleColor: Color = app_dBlack,
    titleSize : TextUnit = 24.sp,
    textColor: Color = Color.Black,
    textSize : TextUnit = 14.sp,

    ){
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(padding),
        shape = shape,
        colors = CardDefaults.cardColors(
            containerColor = containerColor,
            contentColor = contentColor,
        ),
        elevation = elevation
    ) {
        Row(
            modifier = Modifier.padding(12.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(cartProduct.thumbnail),
                contentDescription = contentDescription,
                modifier = Modifier.size(imageSize),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(3.dp))
            Column {
                CustomTitle(
                    header = cartProduct.title,
                    fontWeight = FontWeight.Normal,
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(2.dp))
                Row {
                    CustomTitle(
                        header = cartProduct.price.toString(),
                        fontWeight = FontWeight.Light,
                        fontSize = 18.sp
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    CustomTitle(
                        header = cartProduct.discountPercentage.toString(),
                        fontWeight = FontWeight.Light,
                        fontSize = 18.sp
                    )
                    Row(
                        modifier = Modifier.padding(5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        SizeButton(
                            onClick = {},
                            quantity = cartProduct.quantity.toString(),
                        )

                        QuantityButton(
                            onClick = {},
                            quantity = cartProduct.quantity.toString(),
                        )
                    }
                }
            }
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun CartScreenPreview()
//{
//    CartScreen()
//}