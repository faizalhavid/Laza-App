package com.faizal.project.laza.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.faizal.project.laza.R
import com.faizal.project.laza.ui.component.AppSafeAreaView


@Composable
fun WelcomeScreen(navController: NavController) {
    val genderSelection = remember { mutableIntStateOf(R.drawable.welcome_hero_man) }
    AppSafeAreaView(
        statusBarColor = Color.Transparent,
        isLoading = false,
        contentAlignment = Arrangement.Bottom,
        backgroundImage = painterResource(id = genderSelection.value)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                Card(
                    modifier = Modifier
                        .align(Alignment.BottomCenter).fillMaxWidth().height(200.dp)
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Welcome to Pep**k",
                        color = Color.Black,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}