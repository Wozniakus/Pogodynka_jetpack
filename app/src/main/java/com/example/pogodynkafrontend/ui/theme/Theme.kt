package com.example.pogodynkafrontend.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = BluePrimary,
    secondary = BlueLight,
    background = BackgroundLight,
    surface = SurfaceLight,
    error = RedError,
    onPrimary = SurfaceLight,
    onSecondary = TextPrimary,
    onBackground = TextPrimary,
    onSurface = TextPrimary,
    onError = SurfaceLight
)

private val DarkColors = darkColorScheme(
    primary = BlueLight,
    secondary = BluePrimary,
    background = Color(0xFF121212),
    surface = Color(0xFF1E1E1E),
    error = RedError
)

@Composable
fun PogodynkaTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        typography = AppTypography,
        content = content
    )
}
