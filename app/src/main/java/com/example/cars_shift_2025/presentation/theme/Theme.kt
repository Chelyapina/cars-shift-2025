package com.example.cars_shift_2025.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = Colors.Brand ,
    primaryContainer = Colors.PressedPrimary ,
    secondary = Colors.HoverPrimary ,
    secondaryContainer = Colors.BrandExtraLight ,
    background = Color.White ,
    surface = Color.White ,
    error = Color(0xFFB00020) ,
    onPrimary = Color.White ,
    onSecondary = Color.White ,
    onBackground = Colors.LightTextPrimary ,
    onSurface = Colors.LightTextPrimary ,
    onError = Color.White
)

private val DarkColorScheme = darkColorScheme(
    primary = Colors.Brand ,
    primaryContainer = Colors.PressedPrimary ,
    secondary = Colors.HoverPrimary ,
    secondaryContainer = Colors.BrandExtraLight ,
    background = Color.Black ,
    surface = Color(0xFF121212) ,
    error = Color(0xFFCF6679) ,
    onPrimary = Color.White ,
    onSecondary = Color.White ,
    onBackground = Colors.DarkTextPrimary ,
    onSurface = Colors.DarkTextPrimary ,
    onError = Color.Black
)

@Composable
fun CarsShift2025Theme(
    darkTheme : Boolean = isSystemInDarkTheme() ,
    content : @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme ,
        typography = Typography ,
        content = content ,
    )
}