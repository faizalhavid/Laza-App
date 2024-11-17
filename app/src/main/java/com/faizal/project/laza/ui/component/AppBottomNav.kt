package com.faizal.project.laza.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

data class BottomNavItem(
    val name: String,
    val route: String,
    val icon: ImageVector
)

@Composable
fun AppBottomBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    BottomAppBar(
        contentPadding = PaddingValues(16.dp),
        content = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                BottomNavigationItem(
                    icon = { Icon(imageVector = Icons.Outlined.Home, contentDescription = "Home") },
                    label = { Text(text = "Home") },
                    selected = currentRoute == "home",
                    onClick = {
                        if (currentRoute != "home") {
                            navController.navigate("home") {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                )
                BottomNavigationItem(
                    icon = { Icon(imageVector = Icons.Outlined.Home, contentDescription = "Home") },
                    label = { Text(text = "Home") },
                    selected = currentRoute == "home",
                    onClick = {
                        if (currentRoute != "home") {
                            navController.navigate("home") {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                )
                BottomNavigationItem(
                    icon = { Icon(imageVector = Icons.Outlined.Home, contentDescription = "Home") },
                    label = { Text(text = "Home") },
                    selected = currentRoute == "home",
                    onClick = {
                        if (currentRoute != "home") {
                            navController.navigate("home") {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                )
            }
        }
    )
}

@Composable
fun BottomNavigationItem(
    icon: @Composable () -> Unit,
    label: @Composable () -> Unit,
    selected: Boolean,
    onClick: () -> Unit
) {
    Column {
        IconButton(
            onClick = onClick
        ) {
            icon()
        }
    }
}