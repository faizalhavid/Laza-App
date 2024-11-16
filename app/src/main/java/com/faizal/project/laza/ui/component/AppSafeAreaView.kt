package com.faizal.project.laza.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.compose.primaryContainerDark
import com.faizal.project.laza.ui.theme.APP_LAYOUT_PADDING

@Composable
fun AppSafeAreaView(
    modifier: Modifier = Modifier,
    statusBarColor: Color = Color.Transparent,
    isLoading: Boolean = false,
    backgroundColor: Color = primaryContainerDark,
    paddingValues: List<Dp> = APP_LAYOUT_PADDING["M"] ?: listOf(8.dp, 12.dp),
    contentAlignment: Arrangement.Vertical = Arrangement.Top,
    backgroundComposable: @Composable() (() -> Unit?)? = null,
    children: @Composable () -> Unit
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .windowInsetsPadding(WindowInsets.statusBars.only(WindowInsetsSides.Top)),
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                if (backgroundComposable != null) {
                    backgroundComposable()
                }
                Column(
                    modifier = Modifier
                        .padding(paddingValues[0], paddingValues[1])
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = contentAlignment
                ) {
                    children()
                }
                if (isLoading) {
                    AppLoading(isLoading = isLoading, modifier = Modifier.fillMaxSize())
                }
            }
        }
    )
}