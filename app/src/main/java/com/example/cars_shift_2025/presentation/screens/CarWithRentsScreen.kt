package com.example.cars_shift_2025.presentation.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.cars_shift_2025.presentation.Dimens.PADDING_LARGE
import com.example.cars_shift_2025.presentation.components.CarWithRentsContent
import com.example.cars_shift_2025.presentation.components.CarWithRentsTopBar
import com.example.cars_shift_2025.presentation.models.CarWithRentsUi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarWithRentsScreen(
    car : CarWithRentsUi ,
    navController : NavController ,
    onSaveClick : () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxWidth() ,
        topBar = {
            CarWithRentsTopBar(
                onBackClick = { navController.popBackStack() }
            )
        } ,
        content = { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize() ,
                contentPadding = PaddingValues(horizontal = PADDING_LARGE)
            ) {
                item {
                    CarWithRentsContent(
                        car = car ,
                        modifier = Modifier.fillMaxWidth() ,
                        onBackClick = { navController.popBackStack() } ,
                        onSaveClick = onSaveClick
                    )
                }
            }
        }
    )
}