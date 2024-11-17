package com.faizal.project.laza.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavBar(
    leading: @Composable () -> Unit = { DefaultBackButton() },
    title: @Composable () -> Unit = { },
    actions: List<@Composable () -> Unit> = emptyList()
) {
    TopAppBar(
        title = title,
        navigationIcon = leading,
        actions = { actions.forEach { it() } },
    )
}


@Composable
fun DefaultBackButton() {
    AppButton(
        type = ButtonVariant.ICON,
        icon = { Icon(imageVector =  Icons.Filled.ArrowBack, contentDescription = "Back") },
        onPress = {
            // Handle back button click
        },
    )
}