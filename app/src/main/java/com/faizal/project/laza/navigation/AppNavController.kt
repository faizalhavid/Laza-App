package com.faizal.project.laza.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.faizal.project.laza.ui.screen.HomeScreen
import com.faizal.project.laza.ui.screen.ProductDetailScreen
import com.faizal.project.laza.ui.screen.WelcomeScreen
import com.faizal.project.laza.ui.viewmodel.ProductViewModel

class AppNavController {
    @Composable
    fun SetupNavController() {
        val productViewModel = ProductViewModel()
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "welcome") {
            composable("welcome") { WelcomeScreen(navController) }
            composable("home") { HomeScreen(navController, productViewModel) }
            composable(
                "product/{id}",
                enterTransition = {
                   scaleIn(
                          animationSpec = tween(300)
                   )
                },
                exitTransition = {
                   scaleOut(
                          animationSpec = tween(300)
                   )
                }
            ) { backStackEntry ->
                val id = backStackEntry.arguments?.getString("id")
                if (id != null) {
                    ProductDetailScreen(navController, productViewModel, id)
                }
            }
            //        composable("wishlist") {}
            //        composable("products") {}
            //        composable("product/{id}") {}
            //        composable("cart") {}
            //        composable("checkout") {}
            //        composable("payment") {}
        }
    }
}