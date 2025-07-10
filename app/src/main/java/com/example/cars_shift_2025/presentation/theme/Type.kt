package com.example.cars_shift_2025.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.cars_shift_2025.R

val Inter = FontFamily(
    Font(R.font.inter_regular , FontWeight.Normal) ,
    Font(R.font.inter_medium , FontWeight.Medium) ,
    Font(R.font.inter_semibold , FontWeight.SemiBold) ,
    Font(R.font.inter_bold , FontWeight.Bold)
)

val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = Inter ,
        fontWeight = FontWeight.Normal ,
        fontSize = 57.sp ,
        lineHeight = 64.sp
    ) ,
    // H2
    headlineLarge = TextStyle(
        fontFamily = Inter ,
        fontWeight = FontWeight.SemiBold ,
        fontSize = 24.sp ,
        lineHeight = 32.sp
    ) ,
    // H3
    headlineMedium = TextStyle(
        fontFamily = Inter ,
        fontWeight = FontWeight.SemiBold ,
        fontSize = 20.sp ,
        lineHeight = 28.sp
    ) ,
    // Body/16
    bodyLarge = TextStyle(
        fontFamily = Inter ,
        fontWeight = FontWeight.Normal ,
        fontSize = 16.sp ,
        lineHeight = 24.sp
    ) ,
    // Body/16-16
    bodyMedium = TextStyle(
        fontFamily = Inter ,
        fontWeight = FontWeight.Normal ,
        fontSize = 16.sp ,
        lineHeight = 16.sp
    ) ,
    // Body/12
    bodySmall = TextStyle(
        fontFamily = Inter ,
        fontWeight = FontWeight.Normal ,
        fontSize = 12.sp ,
        lineHeight = 16.sp
    ) ,
    // Button text
    labelLarge = TextStyle(
        fontFamily = Inter ,
        fontWeight = FontWeight.Medium ,
        fontSize = 14.sp ,
        lineHeight = 20.sp
    )
)