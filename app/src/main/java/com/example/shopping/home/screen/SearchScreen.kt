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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopping.components.CustomAssistChip
import com.example.shopping.components.CustomSearch
import com.example.shopping.components.CustomTitle
import com.example.shopping.components.CustomTopBar
import com.example.shopping.navigation.Screen
import com.example.shopping.ui.theme.app_white_bg

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(){

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    var query by mutableStateOf("")
    var active by mutableStateOf(false)
    val searchHistory = listOf("First Search", "Second Search", "Third Search")

    Scaffold(
        containerColor = app_white_bg,
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
                .background(app_white_bg)
                .padding(12.dp),
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
            header = "Recent Searches",
            fontWeight = FontWeight.Normal,
            fontSize = 22.sp
        )
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
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
        Spacer(modifier = Modifier.height(12.dp))

        CustomTitle(
            header = "TRENDING",
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp
        )
        Column(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                CustomTitle(
                    header = "1",
                    fontSize = 18.sp
                )
                CustomTitle(
                    header = "Lobabu dolls",
                    fontSize = 18.sp
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                CustomTitle(
                    header = "2",
                    fontSize = 18.sp
                )
                CustomTitle(
                    header = "Pop on nails",
                    fontSize = 18.sp
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                CustomTitle(
                    header = "3",
                    fontSize = 18.sp
                )
                CustomTitle(
                    header = "playstation 5 ",
                    fontSize = 18.sp
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                CustomTitle(
                    header = "4",
                    fontSize = 18.sp
                )
                CustomTitle(
                    header = "A Line Dress",
                    fontSize = 18.sp
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