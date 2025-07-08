package com.example.cars_shift_2025.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TwoButtonGroup(
    firstButtonText : String ,
    secondButtonText : String ,
    onClickFirst : () -> Unit ,
    onClickSecond : () -> Unit
) {
    Column {
        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth() ,
            onClick = onClickFirst ,
        ) {
            Text(firstButtonText)
        }
        Button(
            modifier = Modifier
                .fillMaxWidth() ,
            onClick = onClickSecond ,
        ) {
            Text(secondButtonText)
        }
    }
}