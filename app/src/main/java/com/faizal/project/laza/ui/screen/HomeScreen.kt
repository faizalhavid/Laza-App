package com.faizal.project.laza.ui.screen

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.faizal.project.laza.ui.component.AppBottomBar
import com.faizal.project.laza.ui.component.AppButton
import com.faizal.project.laza.ui.component.AppNavBar
import com.faizal.project.laza.ui.component.AppSafeAreaView
import com.faizal.project.laza.ui.component.ButtonVariant
import com.faizal.project.laza.ui.component.Card.ProductCard
import com.faizal.project.laza.ui.viewmodel.ProductViewModel


@Composable
fun HomeScreen(navController: NavController, productViewModel: ProductViewModel) {
    val products by productViewModel.products.observeAsState(emptyList())
    val isLoading by productViewModel.isLoading.observeAsState(false)

    LaunchedEffect(Unit) {
        productViewModel.fetchProducts()
    }

    AppSafeAreaView(
        isLoading = isLoading,
        bottomBar = {
            AppBottomBar(
                navController = navController,
            )
        },
        appBar = {
            AppNavBar(
                leading = {
                    AppButton(
                        type = ButtonVariant.ICON,
                        icon = {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = "Back"
                            )
                        },
                        onPress = {
                            // Handle back button click
                        },
                    )
                },
                actions = listOf(
                    {
                        AppButton(
                            type = ButtonVariant.ICON,
                            icon = {
                                Icon(
                                    imageVector = Icons.Filled.ShoppingCart,
                                    contentDescription = "Cart"
                                )
                            },
                            onPress = {
                                // Handle action 1 click
                            },
                        )
                    },
                )
            )
        }
    ) {
            Text(
                text = "Hello",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 24.sp,
                style = MaterialTheme.typography.labelMedium
            )
            Text(
                text = "Welcome to Laza",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 24.sp,
                style = MaterialTheme.typography.labelMedium
            )
            Text(
                text = "Choose Brand",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 24.sp,
                style = MaterialTheme.typography.labelMedium
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Badge(
                    content = { Text("All") },
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(8.dp)
                )
                Badge(
                    content = { Text("Nike") },
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(8.dp)
                )
                Badge(
                    content = { Text("Adidas") },
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(8.dp)
                )
                Badge(
                    content = { Text("Puma") },
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(8.dp)
                )
                Badge(
                    content = { Text("Reebok") },
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(8.dp)
                )
            }

            if (products.isNotEmpty()) {
                LazyVerticalGrid(
                    modifier = Modifier
                        .fillMaxSize()
                        .fillMaxHeight(),
                    columns = GridCells.Fixed(2),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {

                    items(products.size) { index ->
                        ProductCard(
                            product = products[index], modifier = Modifier.fillMaxWidth(),
                            onClick = {
                                navController.navigate("product/${products[index].id}")
                            }
                        )
                    }
                }
            } else {
                Text("No products found")
            }
        }
}