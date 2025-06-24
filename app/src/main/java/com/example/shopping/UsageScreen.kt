package com.example.shopping


import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.shopping.components.CustomAssistChip
import com.example.shopping.components.CustomBadge
import com.example.shopping.components.CustomFilteringChip
import com.example.shopping.components.CustomInputChip
import com.example.shopping.components.CustomSuggestionChip
import com.example.shopping.components.CustomSwitch
import com.example.shopping.components.CustomTopBar



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UsageScreen() {

    var filterSelected by remember { mutableStateOf(false) }
    var inputSelected by remember { mutableStateOf(false) }
    var showBadge by remember { mutableStateOf(true) }
    var enabled by remember { mutableStateOf(true) }
    var isChecked by remember { mutableStateOf(false) }
    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(true) }
    val interactionSource = remember { MutableInteractionSource() }

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
//
//    val lottieComp by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.t_animation))
//    val lottieProg by animateLottieCompositionAsState(
//        composition = lottieComp,
//        isPlaying = true,
//        speed = 0.6f,
//        iterations = LottieConstants.IterateForever
//    )

    val searchHistory = listOf<String>( "First Search", "Second Search", "Third Search")

    Scaffold(
        topBar = {
            CustomTopBar(
                title = "My app",
                fontWeight = FontWeight.ExtraBold,
                titleOverflow = TextOverflow.Ellipsis,
                navigationIcon = Icons.Default.ArrowBack,
                navigationIconColor = Color.Black,
                onNavigationClick = {},
                actionIcon = Icons.Default.MoreVert,
                actionIconColor = Color.Black,
                scrollBehavior = scrollBehavior,
                titleColor = Color.Black,
                containerColor = Color.Yellow
            )
        },
//        bottomBar = {
//            CustomNavBar(
//                modifier = Modifier.padding(15.dp),
//                containerColor = Color.Yellow,
//                onItemClick = {},
//                items = navBarItems
//            )
//        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
//            item {
//                Box(
//                    modifier = Modifier.fillMaxSize()
//                ){
//                    CustomSearch(
//                        query = query,
//                        onQueryChange = { query = it },
//                        active = active,
//                        onActiveChange = { active = it },
//                        leadingIcon = Icons.Default.ArrowBack,
//                        trailingIcon = Icons.Default.Close,
//                        micIcon = painterResource(R.drawable.ic_mic),
//                        containerColor = Color.Gray,
//                        placeholder = { "Search" },
//                        onClick = {},
//                        historyIcon = painterResource(R.drawable.ic_history),
//                        searchHistory = searchHistory,
//                        modifier = Modifier
//                            .fillMaxWidth()
////                        .heightIn(max = 300.dp)
////                        .wrapContentHeight()
//                    )
//
//                }
//            }
            item {
                Text("Assist Chip")
                CustomAssistChip(
                    onClick = {},
                    label = "Add to wishList",
                    icon = Icons.Default.Favorite,
                    colors = AssistChipDefaults.assistChipColors(
                        containerColor = Color.LightGray,
                        labelColor = Color.Black
                    ),
                    elevation = AssistChipDefaults.assistChipElevation(
                        elevation = 4.dp,
                        pressedElevation = 16.dp
                    ),
                    border = BorderStroke(2.dp, Color.Yellow),
                    interactionSource = interactionSource,
                    shape = RoundedCornerShape(7.dp)
                )
            }

            item {
                Text("Filter Chip")
                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    CustomFilteringChip(
                        selected = filterSelected,
                        onClick = {},
                        label = "Under 5000"
                    )

                    CustomFilteringChip(
                        selected = filterSelected,
                        onClick = {},
                        label = "Local"
                    )
                }
            }

            item {
                Text("InputChip")
                CustomInputChip(
                    selected = inputSelected,
                    onClick = {},
                    label = "Nike",
                    icon = Icons.Default.Add
                )
            }

            item {
                Text("Suggestion Chip")
                CustomSuggestionChip(
                    onClick = {},
                    label = "T shirt for summer"
                )
            }

            item {
                CustomBadge(
                    showBadge = showBadge,
                    badgeContent = {
                        Icon(
                            imageVector = Icons.Outlined.FavoriteBorder,
                            contentDescription = null
                        )
                    },
                    badgeColor = Color.Red,
                    contentColor = Color.White,
                    component = {
                        Image(
                            painter = painterResource(R.drawable.t_ic),
                            contentDescription = null
                        )
                    }
                )
            }

            item {
                CustomSwitch(
                    isChecked = isChecked,
                    enabled = enabled,
                    onCheckedChange = { isChecked = it },
                    checkedIconColor = Color.White,
                    checkedThumbColor = Color.Red,
                    checkedTrackColor = Color.Gray,
                    checkedBorderColor = Color.Yellow,
                    thumbContent = {
                        if (isChecked) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = null,
                                modifier = Modifier.size(ButtonDefaults.IconSize)
                            )
                        } else {
                            Icon(
                                imageVector = Icons.Default.Check,
                                contentDescription = null,
                                modifier = Modifier.size(ButtonDefaults.IconSize)
                            )
                        }
                    }
                )
            }

//            item {
//                lottieComp?.let {
//                    EmptyState(
//                        composition = it,
//                        progress = { lottieProg }
//                    )
//                }
//            }
        }
    }
}
