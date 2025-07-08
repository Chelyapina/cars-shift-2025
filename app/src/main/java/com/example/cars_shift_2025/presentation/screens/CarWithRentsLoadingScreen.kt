package com.example.cars_shift_2025.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.example.cars_shift_2025.presentation.viewmodels.CarWithRentsState
import com.example.cars_shift_2025.presentation.viewmodels.CarWithRentsViewModel

@Composable
fun CarWithRentsLoadingScreen(
    viewModel : CarWithRentsViewModel ,
    navController : NavController
) {
    val state by viewModel.stateFlow.collectAsState()

    when (val currentState = state) {
        is CarWithRentsState.Loading -> LoadingScreen()
        is CarWithRentsState.Success -> CarWithRentsScreen(
            car = currentState.carDetail ,
            navController = navController ,
            onSaveClick = { }
        )

        is CarWithRentsState.Error -> ErrorScreen(
            message = currentState.message ,
            onRetry = currentState.retryAction
        )
    }
}
