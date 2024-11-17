package com.faizal.project.laza.ui.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.faizal.project.laza.data.model.Product
import com.faizal.project.laza.ui.component.AppBottomBar
import com.faizal.project.laza.ui.component.AppButton
import com.faizal.project.laza.ui.component.AppNavBar
import com.faizal.project.laza.ui.component.AppSafeAreaView
import com.faizal.project.laza.ui.component.ButtonVariant
import com.faizal.project.laza.ui.viewmodel.ProductViewModel

@Composable
fun ProductCard(product: Product, modifier: Modifier) {
    Card(
        modifier = modifier
    ) {
        Text(
            text = product.title ?: "Null Name"
        )
        Text(
            text = product.description ?: ""
        )
        Text(
            text = product.price.toString()
        )
        Text(
            text = product.category ?: ""
        )
    }
}

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
        if (products.isNotEmpty()) {

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.wrapContentHeight()
            ) {
                items(products.size) { index ->
                    ProductCard(product = products[index], modifier = Modifier.fillMaxWidth())
                }
            }


        } else {
            Text("No products found")
        }
    }
}