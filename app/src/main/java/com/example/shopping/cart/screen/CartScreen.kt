package com.example.shopping.cart.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.shopping.cart.data.CartProduct
import com.example.shopping.cart.viewmodel.CartViewModel
import com.example.shopping.components.CustomDivider
import com.example.shopping.components.CustomTitle
import com.example.shopping.components.CustomTopBar
import com.example.shopping.components.QuantityButton
import com.example.shopping.components.SizeButton
import com.example.shopping.ui.theme.T_CardColor
import com.example.shopping.ui.theme.T_DTextColor
import com.example.shopping.ui.theme.T_LTextColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    val viewModel : CartViewModel = viewModel()
    val cartProduct : List<CartProduct> = viewModel.cartList ?: emptyList()

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
        LazyColumn (
            modifier = Modifier.padding(paddingValues)
        ){
            item {
                CustomTitle(
                    header = "Cart"
                )
                CustomDivider()
            }
            items(cartProduct) { product ->
                CartProdCard(
                    cartProduct = product,
                    onClick = {},

                )
            }

        }

    }
}

@Composable
fun CartProdCard(
    cartProduct: CartProduct,
    onClick : () -> Unit,
    contentDescription : String = "Cart Product",
    modifier : Modifier = Modifier.padding(10.dp),
    shape : Shape  = RoundedCornerShape(4.dp),
    containerColor: Color = T_CardColor,
    contentColor: Color = Color.Black,
    elevation: CardElevation = CardDefaults.cardElevation(2.dp),
    titleColor: Color = T_DTextColor,
    titleSize : TextUnit = 24.sp,
    textColor: Color = Color.Black,
    textSize : TextUnit = 14.sp,

    ){
    Card(
        onClick = onClick,
        modifier = modifier,
        shape = shape,
        colors = CardDefaults.cardColors(
            containerColor = containerColor,
            contentColor = contentColor,
        ),
        elevation = elevation
    ) {
        Row (
             modifier = Modifier.padding(12.dp)
        ){
            Image(
                painter = rememberAsyncImagePainter(cartProduct.thumbnail),
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(3.dp))
            Column {
                Text(
                    text = cartProduct.title,
                    color = titleColor,
                    fontWeight = FontWeight.Bold,
                    fontSize = titleSize
                )
                Spacer(modifier = Modifier.height(2.dp))
                Row {
                    Text(
                        text = cartProduct.price.toString(),
                        color = textColor,
                        fontWeight = FontWeight.Bold,
                        fontSize = textSize
                    )
                    Text(
                        text = cartProduct.discountPercentage.toString(),
                        color = textColor,
                        fontWeight = FontWeight.Thin,
                        fontSize = textSize
                    )
                }
                Row {
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