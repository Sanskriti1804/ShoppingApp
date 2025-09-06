package com.example.shopping.order.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.shopping.order.viewmodel.ShipRocketViewModel
import com.example.shopping.util.UiState
import org.koin.androidx.compose.koinViewModel


@Composable
fun OrderScreen(
    viewModel: ShipRocketViewModel = koinViewModel()
) {
    val loginState by viewModel.loginState.collectAsState()
    val orderState by viewModel.orderState.collectAsState()

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {
            viewModel.login("your-email@example.com", "your-password")
        }) {
            Text("Login to Shiprocket")
        }

        Button(onClick = {
            viewModel.getOrderById(12345L)
        }) {
            Text("Fetch Order")
        }

        when (val state = loginState) {
            is UiState.Loading -> Text("Logging in...")
            is UiState.Success -> Text("Login successful! Token: ${state.data.token}")
            is UiState.Error -> Text("Login failed: ${state.exception.message}")
        }

        when (val state = orderState) {
            is UiState.Loading -> Text("Loading order...")
            is UiState.Success -> Text("Order total: $${state.data.data.total}")
            is UiState.Error -> Text("Order fetch failed: ${state.exception.message}")
        }
    }
}