package com.example.shopping.home.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.shopping.components.CustomAssistChip
import com.example.shopping.components.CustomBody
import com.example.shopping.components.CustomSearch
import com.example.shopping.components.CustomTitle
import com.example.shopping.components.CustomTopBar
import com.example.shopping.ui.theme.Dimensions
import com.example.shopping.ui.theme.app_background

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(){

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    var query by mutableStateOf("")
    var active by mutableStateOf(false)
    val searchHistory = listOf("First Search", "Second Search", "Third Search")

    Scaffold(
        containerColor = app_background,
        topBar = {
            CustomTopBar(
                titleOverflow = TextOverflow.Ellipsis,
                onNavigationClick = {},
                fontWeight = FontWeight.ExtraBold,
                scrollBehavior = scrollBehavior,
                onActionClick = {}
            )
        }
    ) { Column (
            modifier = Modifier
                .fillMaxWidth()
                .background(app_background)
                .padding(Dimensions.componentPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
        CustomSearch(
            query = query,
            onQueryChange = {query = it},
            active = active,
            onActiveChange = { active = it},
            placeholder = { "Search" },
            onClick = {},
            searchHistory = searchHistory,
        )
        CustomTitle(
            header = "Recent Searches"
        )
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Dimensions.componentPadding)
        ) {
            item {
                CustomAssistChip(
                    onClick = {},
                    label = "pink shirt for men"
                )
            }
            item {
                CustomAssistChip(
                    onClick = {},
                    label = "pink shirt for men"
                )
            }
            item {
                CustomAssistChip(
                    onClick = {},
                    label = "pink shirt for men"
                )
            }
        }
        Spacer(modifier = Modifier.height(Dimensions.medSpacer))

        CustomTitle(
            header = "TRENDING"
        )
        Column(
            modifier = Modifier
                .padding(Dimensions.componentPadding)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                CustomBody(
                    header = "1"
                )
                CustomBody(
                    header = "Lobabu dolls"
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                CustomBody(
                    header = "2"
                )
                CustomBody(
                    header = "Pop on nails"
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                CustomBody(
                    header = "3"
                )
                CustomBody(
                    header = "playstation 5 "
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                CustomBody(
                    header = "4"
                )
                CustomBody(
                    header = "A Line Dress"
                )
            }
        }
    }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview(){
    SearchScreen()
}