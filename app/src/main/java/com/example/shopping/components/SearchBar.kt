package com.example.shopping.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
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
import com.example.shopping.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSearch(
    modifier: Modifier,
    query : String,
    onQueryChange : (String) -> Unit,
    active : Boolean,
    onActiveChange : (Boolean) -> Unit,
    leadingIcon : ImageVector,
    trailingIcon : ImageVector,
    micIcon : Painter = painterResource(R.drawable.ic_mic),
    containerColor : Color = Color.White,
    placeholder: @Composable () -> Unit,
    onClick: @Composable () -> Unit,
    searchHistory : List<String>,
    historyIcon : Painter

){
    SearchBar(
        query = query,
        onQueryChange = { onQueryChange},
        onSearch = {newQuery->
            println("performing search : $newQuery")
        },
        active = active,
        onActiveChange = {onActiveChange},
        placeholder = { placeholder },
        leadingIcon = {
            Icon(imageVector = leadingIcon, contentDescription = null)
        },
        trailingIcon = {
            Row {
                IconButton(onClick = {}) {
                    Icon(
                        painter = micIcon,
                        contentDescription =  "mic icon"
                    )
                }
                if (active) {
                    IconButton(
                        onClick = { onClick }
                    ) {
                        Icon(imageVector = trailingIcon, contentDescription = null)
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