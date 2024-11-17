package com.faizal.project.laza.ui.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.faizal.project.laza.ui.component.AppSafeAreaView
import com.faizal.project.laza.ui.component.ShimmerLoading
import com.faizal.project.laza.ui.viewmodel.ProductViewModel

@Composable
fun ProductDetailScreen(
    navController: NavHostController,
    productViewModel: ProductViewModel,
    id: String
) {
    val product = productViewModel.getProductById(id)
    val isLoadingImage = remember { mutableStateOf(true) }
    AppSafeAreaView {
        Box(
            modifier = Modifier
                .height(400.dp)
                .fillMaxWidth()
                .padding(8.dp),

            ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(product.image)
                    .crossfade(true).build(),
                contentDescription = product.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .background(
                        brush = ShimmerLoading(
                            targetValue = 1300f,
                            isLoading = isLoadingImage.value
                        )
                    )
                    .fillMaxSize()
                    .clip(RoundedCornerShape(16.dp)),
                onSuccess = {
                    isLoadingImage.value = false
                },
                onError = {
                    Log.d("ProductCard", "ProductCard: $it")
                },
            )
        }
    }
}