package com.example.cars_shift_2025.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.cars_shift_2025.R

@Composable
fun ErrorScreen(message : String , onRetry : () -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center ,
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Ошибка: $message")
        Button(onClick = onRetry) {
            Text(stringResource(R.string.button_retry))
        }
    }
}