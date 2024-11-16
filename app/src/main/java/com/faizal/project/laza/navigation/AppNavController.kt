package com.faizal.project.laza.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.faizal.project.laza.ui.screen.WelcomeScreen

class AppNavController {
    @Composable
    fun SetupNavController() {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "welcome") {
            composable("welcome") { WelcomeScreen(navController) }
            //        composable("home") {}
            //        composable("wishlist") {}
            //        composable("products") {}
            //        composable("product/{id}") {}
            //        composable("cart") {}
            //        composable("checkout") {}
            //        composable("payment") {}
        }
    }
}