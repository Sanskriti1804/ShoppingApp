package com.example.shopping.section.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.shopping.Profile.Screen.ProfileScreen
import com.example.shopping.components.CustomButton
import com.example.shopping.components.CustomDivider
import com.example.shopping.components.CustomFilteringChip
import com.example.shopping.components.CustomTopBar
import com.example.shopping.section.data.filters
import com.example.shopping.ui.theme.Dimensions

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterScreen(){

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    Scaffold(
        topBar = {
            CustomTopBar(
                title = "Filter",
                titleOverflow = TextOverflow.Ellipsis,
                onNavigationClick = {},
                scrollBehavior = scrollBehavior
            )
        }
    ) {paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                CollapseSection(
                    isCollapsed = true,
                    onToggleCollapse = {},
                    icon =  Icons.Default.KeyboardArrowDown,
                    collapseIcon = "Collapse Icon"

                )
                CustomDivider()
            }

            item {
                Row(
                    modifier = Modifier.padding(Dimensions.componentPadding),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CustomButton(
                        textButton = true,
                        onClick = {},
                        buttonText = "Cancel",
                        buttonDescription = "Cancel button",                    )
                    CustomButton(
                        textButton = true,
                        onClick = {},
                        buttonDescription = "Apply Filter button",
                    )
                }
            }
        }
    }
}

@Composable
fun CollapseSection(
    isCollapsed : Boolean,
    onToggleCollapse : () -> Unit,
    padding : Dp = Dimensions.componentPadding,
    icon : ImageVector,
    collapseIcon : String,
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(padding)
            .clickable{
                onToggleCollapse()
            }
    ){
        filters.forEach { filter ->
            Row (
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = filter.label
                )
                Icon(icon, collapseIcon)
            }
        }
        if (!isCollapsed){
            filterChips()
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun filterChips(){
    var selected by remember { mutableStateOf(false) }
    filters.forEach { filter ->
        if (filter.options != null){
            FlowRow {
                filter.options.forEach { option ->
                    CustomFilteringChip(
                        selected = false,
                        onClick ={},
                        label = Text(text =  option).toString()
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FilterScreenPreview(){
    FilterScreen()
}