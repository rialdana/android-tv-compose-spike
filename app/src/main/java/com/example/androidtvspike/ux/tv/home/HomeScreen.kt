@file:OptIn(
    ExperimentalTvMaterialApi::class, ExperimentalComposeUiApi::class,
    ExperimentalMaterial3Api::class
)

package com.example.androidtvspike.ux.tv.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.tv.foundation.lazy.list.TvLazyColumn
import androidx.tv.foundation.lazy.list.TvLazyRow
import androidx.tv.foundation.lazy.list.items
import androidx.tv.material.ExperimentalTvMaterialApi
import androidx.tv.material.carousel.Carousel
import androidx.tv.material.carousel.CarouselDefaults
import androidx.tv.material.carousel.CarouselItem
import androidx.tv.material.carousel.CarouselState
import coil.compose.AsyncImage
import com.example.androidtvspike.ui.theme.AndroidTVSpikeTheme

@Composable
fun HomeScreen() {
    HomeScreenContent(uiState = HomeUiState())
}

@Composable
private fun HomeScreenContent(
    uiState: HomeUiState,
) {
    TvLazyColumn {
        item {

            val carouselState: CarouselState = remember { CarouselState() }
            val slideCount = uiState.banners.count()

            Carousel(
                slideCount = slideCount,
                carouselIndicator = {
                    CarouselDefaults.Indicator(
                        carouselState = carouselState,
                        slideCount = slideCount,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(16.dp),
                    )
                },
                carouselState = carouselState,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
            ) { index ->
                uiState.banners[index].let {
                    CarouselItem(
                        background = {

                            AsyncImage(
                                model = it.imageUrl,
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop,
                            )

                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(Color.Black.copy(0.5f))
                            )
                        },
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxSize(),
                        ) {

                            Text(
                                text = it.name,
                                style = MaterialTheme.typography.titleLarge,
                            )

                            Text(
                                text = it.title,
                                style = MaterialTheme.typography.titleSmall,
                            )
                        }
                    }
                }
            }
        }

//        item {
//            ImmersiveList(background = { _, _ -> }) {
//                uiState.countries.forEachIndexed { index, it ->
//
//                    ElevatedCard(
//                        modifier = Modifier
//                            .padding(horizontal = 8.dp)
//                            .focusableItem(index)
//
//                    ) {
//                        Column(
//                            horizontalAlignment = Alignment.CenterHorizontally,
//                        ) {
//                            AsyncImage(
//                                model = it.imageUrl,
//                                contentDescription = null,
//                                modifier = Modifier.size(200.dp),
//                                contentScale = ContentScale.Crop,
//                            )
//
//                            Text(text = it.name, modifier = Modifier.padding(8.dp))
//                        }
//                    }
//
//                }
//            }
//        }

        item {
            Text(text = "Top players", modifier = Modifier.padding(16.dp))
        }

        item {
            TvLazyRow(
                contentPadding = PaddingValues(8.dp)
            ) {
                items(uiState.players) {
                    val focusManager = LocalFocusManager.current
                    var focusState: FocusState? by remember { mutableStateOf(null) }

                    ElevatedCard(
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .onFocusChanged {
                                focusState = it
                                if (it.isFocused) {
                                    focusManager.moveFocus(FocusDirection.Enter)
                                }
                            }
                            .focusable(),
                        colors = CardDefaults.elevatedCardColors(
                            containerColor = if (focusState?.isFocused == true) Color.DarkGray else Color.Black
                        ),
                        onClick = {
                            Log.i("HomeScreen", "Tapped on ${it.name}")
                        }
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            AsyncImage(
                                model = it.imageUrl,
                                contentDescription = null,
                                modifier = Modifier.size(200.dp),
                                contentScale = ContentScale.Crop,
                            )

                            Text(text = it.name, modifier = Modifier.padding(8.dp))
                        }
                    }
                }
            }
        }

        item {
            Text(text = "Countries", modifier = Modifier.padding(16.dp))
        }

        item {
            TvLazyRow(
                contentPadding = PaddingValues(8.dp)
            ) {
                items(uiState.countries) {
                    val focusManager = LocalFocusManager.current
                    var focusState: FocusState? by remember { mutableStateOf(null) }

                    ElevatedCard(
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .onFocusChanged {
                                focusState = it
                                if (it.isFocused) {
                                    focusManager.moveFocus(FocusDirection.Enter)
                                }
                            }
                            .focusable(),
                        colors = CardDefaults.elevatedCardColors(
                            containerColor = if (focusState?.isFocused == true) Color.DarkGray else Color.Black
                        ),
                        onClick = {
                            Log.i("HomeScreen", "Tapped on ${it.name}")
                        }
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            AsyncImage(
                                model = it.imageUrl,
                                contentDescription = null,
                                modifier = Modifier.size(200.dp),
                                contentScale = ContentScale.Crop,
                            )

                            Text(text = it.name, modifier = Modifier.padding(8.dp))
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenContentPreview() {
    AndroidTVSpikeTheme {
        HomeScreenContent(uiState = HomeUiState())
    }
}
