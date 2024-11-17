package com.faizal.project.laza

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.faizal.project.laza.navigation.AppNavController
import com.faizal.project.laza.ui.theme.LazaTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LazaTheme {
                AppNavController().SetupNavController()
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    LazaTheme {
//
//    }
//}