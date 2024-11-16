package com.faizal.project.laza.ui.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.faizal.project.laza.AppTypography

enum class ButtonType {
    SOLID,
    OUTLINE,
    TEXT,
    ICON
}

@Composable
fun AppButton(
    onPress: () -> Unit,
    type: ButtonType = ButtonType.SOLID,
    label: String? = null,
    icon: @Composable (() -> Unit)? = null,
    disabled: Boolean = false,
    modifier: Modifier = Modifier,
    prefixIcon: @Composable (() -> Unit)? = null,
    suffixIcon: @Composable (() -> Unit)? = null,
) {
    when (type) {
        ButtonType.SOLID -> SolidButton(
            onPress = onPress,
            label = label,
            icon = icon,
            disabled = disabled,
            modifier = modifier,
            prefixIcon = prefixIcon,
            suffixIcon = suffixIcon
        )
        ButtonType.OUTLINE -> OutlineButton(
            onPress = onPress,
            label = label,
            icon = icon,
            disabled = disabled,
            modifier = modifier,
            prefixIcon = prefixIcon,
            suffixIcon = suffixIcon
        )
        ButtonType.TEXT -> TextButton(
            onPress = onPress,
            label = label,
            icon = icon,
            disabled = disabled,
            modifier = modifier,
            prefixIcon = prefixIcon,
            suffixIcon = suffixIcon
        )
        ButtonType.ICON -> IconButton(
            onPress = onPress,
            icon = icon!!,
            disabled = disabled,
            modifier = modifier,
            prefixIcon = prefixIcon,
            suffixIcon = suffixIcon
        )
    }
}

@Composable
fun SolidButton(
    onPress: () -> Unit,
    label: String? = null,
    icon: @Composable (() -> Unit)? = null,
    disabled: Boolean = false,
    modifier: Modifier = Modifier,
    prefixIcon: @Composable (() -> Unit)? = null,
    suffixIcon: @Composable (() -> Unit)? = null,
) {
    val buttonColors = ButtonDefaults.buttonColors()
    val buttonModifier = modifier.fillMaxWidth().then(buttonModifier(type = ButtonType.SOLID))
    val content: @Composable RowScope.() -> Unit = {
        prefixIcon?.invoke()
        if (label != null) {
            Text(
                text = label,
                style = AppTypography.bodyLarge,
                modifier = Modifier.padding(8.dp)
            )
        } else {
            icon?.invoke()
        }
        suffixIcon?.invoke()
    }
    ElevatedButton(
        onClick = onPress,
        enabled = !disabled,
        colors = buttonColors,
        shape = RoundedCornerShape(12.dp),
        modifier = buttonModifier,
        content = content
    )
}

@Composable
fun OutlineButton(
    onPress: () -> Unit,
    label: String? = null,
    icon: @Composable (() -> Unit)? = null,
    disabled: Boolean = false,
    modifier: Modifier = Modifier,
    prefixIcon: @Composable (() -> Unit)? = null,
    suffixIcon: @Composable (() -> Unit)? = null,
) {
    val buttonColors = ButtonDefaults.buttonColors()
    val buttonModifier = modifier.fillMaxWidth().then(buttonModifier(type = ButtonType.OUTLINE))
    val content: @Composable RowScope.() -> Unit = {
        prefixIcon?.invoke()
        if (label != null) {
            Text(
                text = label,
                style = AppTypography.bodyLarge,
                modifier = Modifier.padding(8.dp)
            )
        } else {
            icon?.invoke()
        }
        suffixIcon?.invoke()
    }
    ElevatedButton(
        onClick = onPress,
        enabled = !disabled,
        colors = buttonColors,
        shape = RoundedCornerShape(12.dp),
        modifier = buttonModifier,
        content = content
    )
}

@Composable
fun TextButton(
    onPress: () -> Unit,
    label: String? = null,
    icon: @Composable (() -> Unit)? = null,
    disabled: Boolean = false,
    modifier: Modifier = Modifier,
    prefixIcon: @Composable (() -> Unit)? = null,
    suffixIcon: @Composable (() -> Unit)? = null,
) {
    val buttonColors = ButtonDefaults.textButtonColors(contentColor = Color.White)
    val buttonModifier = modifier.fillMaxWidth().then(buttonModifier(type = ButtonType.TEXT))
    val content: @Composable RowScope.() -> Unit = {
        prefixIcon?.invoke()
        if (label != null) {
            Text(
                text = label,
                style = AppTypography.headlineSmall,
                fontSize = 18.sp,
                modifier = Modifier.padding(8.dp)
            )
        } else {
            icon?.invoke()
        }
        suffixIcon?.invoke()
    }
    androidx.compose.material3.TextButton(
        onClick = onPress,
        enabled = !disabled,
        colors = buttonColors,
        modifier = buttonModifier,
        content = content
    )
}

@Composable
fun IconButton(
    onPress: () -> Unit,
    icon: @Composable (() -> Unit),
    disabled: Boolean = false,
    modifier: Modifier = Modifier,
    prefixIcon: @Composable (() -> Unit)? = null,
    suffixIcon: @Composable (() -> Unit)? = null,
) {
    val buttonColors = ButtonDefaults.buttonColors()
    val buttonModifier = modifier.fillMaxWidth().then(buttonModifier(type = ButtonType.ICON))
    val content: @Composable RowScope.() -> Unit = {
        prefixIcon?.invoke()
        icon()
        suffixIcon?.invoke()
    }
    ElevatedButton(
        onClick = onPress,
        enabled = !disabled,
        colors = buttonColors,
        shape = RoundedCornerShape(12.dp),
        modifier = buttonModifier,
        content = content
    )
}
@Composable
fun buttonModifier(type: ButtonType): Modifier {
    var modifier = Modifier.padding(8.dp, 12.dp)
    modifier = when (type) {
        ButtonType.SOLID -> {
            modifier
        }
        ButtonType.OUTLINE -> {
            modifier.then(Modifier.border(1.dp, ButtonDefaults.buttonColors().containerColor))
        }
        ButtonType.TEXT -> {
            modifier.then(Modifier.padding(0.dp))
        }
        ButtonType.ICON -> TODO()
    }
    return modifier
}