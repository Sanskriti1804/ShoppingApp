package com.example.shopping.order.screens

import android.util.Log
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

private const val TAG = "OrderScreen"

@Composable
fun OrderScreen(
    viewModel: ShipRocketViewModel = koinViewModel()
) {
    val loginState by viewModel.loginState.collectAsState()
    val orderState by viewModel.orderState.collectAsState()

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {
            Log.d(TAG, "Login button clicked")
            viewModel.login("your-email@example.com", "your-password")
        }) {
            Text("Login to Shiprocket")
        }

        Button(onClick = {
            Log.d(TAG, "Fetch order button clicked")
            viewModel.getOrderById(12345L)
        }) {
            Text("Fetch Order")
        }

        when (val state = loginState) {
            is UiState.Loading -> {
                Log.d(TAG, "Login state: Loading")
                Text("Logging in...")
            }
            is UiState.Success -> {
                Log.d(TAG, "Login state: Success. Token=${state.data.token}")
                Text("Login successful! Token: ${state.data.token}")
            }
            is UiState.Error -> {
                Log.e(TAG, "Login state: Error", state.exception)
                Text("Login failed: ${state.exception.message}")
            }
        }

        when (val state = orderState) {
            is UiState.Loading -> {
                Log.d(TAG, "Order state: Loading")
                Text("Loading order...")
            }

            is UiState.Success -> {
                Log.d(TAG, "Order state: Success. Order=${state.data}")
                Text("Order total: $${state.data.data.total}")
            }

            is UiState.Error -> {
                Log.e(TAG, "Order state: Error", state.exception)
                Text("Order fetch failed: ${state.exception.message}")
            }
        }
    }
}