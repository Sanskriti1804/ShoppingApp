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
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.shopping.R
import com.example.shopping.cart.data.CartProduct
import com.example.shopping.cart.viewmodel.CartViewModel
import com.example.shopping.components.CustomBody
import com.example.shopping.components.CustomDivider
import com.example.shopping.components.CustomNavigationBar
import com.example.shopping.components.CustomLabel
import com.example.shopping.components.CustomTopBar
import com.example.shopping.components.QuantityButton
import com.example.shopping.components.SizeButton
import com.example.shopping.ui.theme.Dimensions
import com.example.shopping.ui.theme.Shapes
import com.example.shopping.ui.theme.app_lComponent
import com.example.shopping.ui.theme.app_background


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(navController: NavHostController) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    val viewModel : CartViewModel = viewModel()
    val cartProduct = viewModel.cartList

    Scaffold(
        containerColor = app_background,
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
                CustomBody(
                    header = "Cart"
                )
                CustomDivider()
            }
            if (cartProduct.isEmpty()){
                item {
                    CustomLabel(
                        header = "Cart is Empty"
                    )
                }
            }
            else{
                items(cartProduct) { product ->
                    CartProdCard(
                        cartProduct = product,
                        onClick = {}
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
    padding : Dp = Dimensions.componentPadding,
    shape : Shape  = Shapes.CardShape,
    containerColor: Color = app_lComponent,
    imageSize : Dp = Dimensions.cartCardSize,
    contentColor: Color = Color.Black,
    elevation: CardElevation = CardDefaults.cardElevation(Dimensions.cardElevation)
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
            modifier = Modifier.padding(Dimensions.cardElementsPadding)
        ) {
            Image(
                painter = rememberAsyncImagePainter(cartProduct.thumbnail),
                contentDescription = contentDescription,
                modifier = Modifier.size(imageSize),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(Dimensions.smallSpacer))

            Column {
                CustomBody(
                    header = cartProduct.title
                )
                Spacer(modifier = Modifier.height(Dimensions.smallSpacer))
                Row {
                    CustomLabel(
                        header = cartProduct.price.toString()
                    )
                    Spacer(modifier = Modifier.width(Dimensions.medSpacer))
                    CustomLabel(
                        header = cartProduct.discountPercentage.toString()
                    )
                    Row(
                        modifier = Modifier.padding(Dimensions.medSpacer),
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