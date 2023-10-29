package com.shahtott.meals_app.ui.theme

import android.app.Activity
import android.graphics.Color
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat


private val LightColorPalette = lightColors(
    primary = primary,
    primaryVariant = light_primary,
    secondary = secondary,
    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun Meals_appTheme(darkTheme: Boolean = false, content: @Composable () -> Unit) {

    val colors = LightColorPalette

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            WindowCompat.getInsetsController(window, view)?.isAppearanceLightStatusBars = true
        }
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}