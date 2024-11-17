package com.faizal.project.laza.ui.component


import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

enum class ComponentColorType {
    PRIMARY,
    SECONDARY,
    TERTIARY,
    SUCCESS,
    DANGER,
    WARNING,
    INFO,
    LIGHT,
    DARK,
    DISABLED
}

@Composable
fun getButtonColorsForType(type: ComponentColorType): ButtonColors {
    return when (type) {
        ComponentColorType.PRIMARY -> ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        )

        ComponentColorType.SECONDARY -> ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.secondary,
            contentColor = MaterialTheme.colorScheme.onSecondary
        )

        ComponentColorType.TERTIARY -> ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.tertiary,
            contentColor = MaterialTheme.colorScheme.onTertiary
        )

        ComponentColorType.SUCCESS -> ButtonDefaults.buttonColors(
            containerColor = Color(0xFF4CAF50),
            contentColor = Color(0xFFFFFFFF)
        )

        ComponentColorType.DANGER -> ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.error,
            contentColor = MaterialTheme.colorScheme.onError
        )

        ComponentColorType.DISABLED -> ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
            contentColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
        )

        ComponentColorType.WARNING -> TODO()
        ComponentColorType.INFO -> TODO()
        ComponentColorType.LIGHT -> TODO()
        ComponentColorType.DARK -> TODO()
    }
}

//@Composable
//fun getTextFieldColorsForType(type: ComponentColorType): TextFieldColors {
//    return when (type) {
//        ComponentColorType.PRIMARY -> TextFieldDefaults.colors(
//            containerColor = MaterialTheme.colorScheme.primary
//        )
//        ComponentColorType.SECONDARY -> TextFieldDefaults.colors(
//            containerColor = MaterialTheme.colorScheme.secondary
//        )
//        ComponentColorType.TERTIARY -> TextFieldDefaults.colors(
//            containerColor = MaterialTheme.colorScheme.tertiary
//        )
//        ComponentColorType.SUCCESS -> TextFieldDefaults.colors(
//            containerColor = MaterialTheme.colorScheme.primaryVariant
//        )
//        ComponentColorType.DANGER -> TextFieldDefaults.colors(
//            containerColor = MaterialTheme.colorScheme.error
//        )
//        ComponentColorType.WARNING -> TextFieldDefaults.colors(
//            containerColor = MaterialTheme.colorScheme.secondaryVariant
//        )
//        ComponentColorType.INFO -> TextFieldDefaults.colors(
//            containerColor = MaterialTheme.colorScheme.primary
//        )
//        ComponentColorType.LIGHT -> TextFieldDefaults.colors(
//            containerColor = MaterialTheme.colorScheme.background
//        )
//        ComponentColorType.DARK -> TextFieldDefaults.colors(
//            containerColor = MaterialTheme.colorScheme.surface
//        )
//        ComponentColorType.DISABLED -> TextFieldDefaults.colors(
//            containerColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f)
//        )
//    }
//}