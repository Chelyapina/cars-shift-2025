package com.example.cars_shift_2025.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.example.cars_shift_2025.presentation.navigation.Screen
import com.example.cars_shift_2025.presentation.viewmodels.CarListState
import com.example.cars_shift_2025.presentation.viewmodels.MainScreenViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun CarLoadingScreen(
    viewModel : MainScreenViewModel ,
    navController : NavController
) {
    val state by viewModel.stateFlow.collectAsState()

    if (state is CarListState.Success) {
        val cars = (state as CarListState.Success).cars
        CarListScreen(
            cars = cars ,
            onCarClick = { carId ->
                navController.navigate(Screen.CarWithRents.createRoute(carId))
            }
        )
    }
}