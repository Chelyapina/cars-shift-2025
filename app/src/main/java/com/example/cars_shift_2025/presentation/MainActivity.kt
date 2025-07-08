package com.example.cars_shift_2025.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.cars_shift_2025.presentation.navigation.AppNavGraph
import com.example.cars_shift_2025.presentation.theme.Carsshift2025Theme
import com.example.cars_shift_2025.presentation.viewmodels.MainScreenViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        ResourceProvider.initialize(this)
        enableEdgeToEdge()
        setContent {
            Carsshift2025Theme {
                val navController = rememberNavController()
                val viewModel: MainScreenViewModel = viewModel()

                AppNavGraph(
                    navHostController = navController,
                    viewModel = viewModel,
                )
            }
        }
    }
}