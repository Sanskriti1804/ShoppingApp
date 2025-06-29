package com.example.shopping.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.shopping.R
import com.example.shopping.ui.theme.app_white

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSearch(
    padding : Dp = 5.dp,
    query : String,
    onQueryChange : (String) -> Unit,
    active : Boolean,
    onActiveChange : (Boolean) -> Unit,
    searchIcon : Painter = painterResource(R.drawable.ic_app_search),
    containerColor : Color = app_white,
    placeholder: @Composable () -> Unit,
    onClick: @Composable () -> Unit,
    searchHistory : List<String>,
    historyIcon : Painter = painterResource(R.drawable.ic_history)

){
    SearchBar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(padding),
        query = query,
        onQueryChange = { onQueryChange},
        onSearch = {newQuery->
            println("performing search : $newQuery")
        },
        active = active,
        onActiveChange = {onActiveChange},
        placeholder = { placeholder },
//        leadingIcon = {
//            Icon(imageVector = leadingIcon, contentDescription = null)
//        },
        trailingIcon = {
            Row {
                IconButton(onClick = {}) {
                    CustomIcon(
                        painter = searchIcon
                    )
                }
                if (active) {
                    IconButton(
                        onClick = { onClick }
                    ) {
                        CustomIcon(
                            painter = searchIcon
                        )
                    }
                } else null
            }
        },
        colors = SearchBarDefaults.colors(
            containerColor = containerColor
        )
    ) {
        searchHistory.takeLast(3).forEach {
            item ->
            ListItem(
//                modifier = Modifier.clickable(query = item),
                headlineContent = { Text(text = item) },
                leadingContent = {
                    Icon(
                        painter = historyIcon,
                        contentDescription = "history icon"
                    )
                }
            )
        }
    }
}