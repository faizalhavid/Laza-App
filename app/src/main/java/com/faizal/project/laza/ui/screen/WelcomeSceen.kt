package com.faizal.project.laza.ui.screen

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.faizal.project.laza.AppTypography
import com.faizal.project.laza.R
import com.faizal.project.laza.ui.component.AppButton
import com.faizal.project.laza.ui.component.AppSafeAreaView
import com.faizal.project.laza.ui.component.ButtonVariant

@Composable
fun WelcomeScreen(navController: NavController) {
    val genderSelection = remember { mutableIntStateOf(R.drawable.welcome_hero_man) }
        AppSafeAreaView(
            statusBarColor = Color.Transparent,
            isLoading = false,
            contentAlignment = Arrangement.Bottom,
            backgroundComposable = {
                Crossfade(
                    targetState = genderSelection.intValue, label = "", animationSpec = tween(
                        durationMillis = 500,
                        delayMillis = 2,
                        easing = EaseOut
                    )
                ) { currentImage ->
                    Image(
                        painter = painterResource(id = currentImage),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                            .zIndex(-2f),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    Card(

                        shape = RoundedCornerShape(
                            topStart = 20.dp,
                            topEnd = 20.dp,
                            bottomStart = 20.dp,
                            bottomEnd = 20.dp
                        ),
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .fillMaxWidth().height(320.dp)
                            .padding(12.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(20.dp, 25.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Look Good, Feel Good",
                                fontSize = 28.sp,
                                textAlign = TextAlign.Center,
                                style = AppTypography.displaySmall,
                            )
                            Text(
                                text = "Create your individual & unique style and look amazing everyday.",
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center,
                                style = AppTypography.labelMedium,
                            )
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                            ) {
                                AppButton(
                                    onPress = {
                                        genderSelection.intValue = R.drawable.welcome_hero_man
                                    },
                                    label = "Man",
                                    modifier = Modifier.weight(1f)
                                )
                                AppButton(
                                    onPress = {
                                        genderSelection.intValue = R.drawable.welcome_hero_woman
                                    },
                                    label = "Woman",
                                    modifier = Modifier.weight(1f)
                                )
                            }
                            AppButton(
                                type = ButtonVariant.TEXT,
                                onPress = {
                                    navController.navigate("home")
                                },
                                label = "Skip",
                            )
                        }
                    }
                }
            }
        }

}