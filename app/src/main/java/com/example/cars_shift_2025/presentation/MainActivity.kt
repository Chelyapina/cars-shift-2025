package com.example.cars_shift_2025.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.cars_shift_2025.di.DaggerViewModelFactory
import com.example.cars_shift_2025.presentation.navigation.AppNavGraph
import com.example.cars_shift_2025.presentation.theme.Carsshift2025Theme
import com.example.cars_shift_2025.presentation.viewmodels.MainScreenViewModel
import javax.inject.Inject

class MainActivity : ComponentActivity() {
    @Inject
    lateinit var viewModelFactory : DaggerViewModelFactory

    override fun onCreate(savedInstanceState : Bundle?) {
        (application as CarShiftApp).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Carsshift2025Theme {
                val navController = rememberNavController()
                val viewModel : MainScreenViewModel = viewModel(factory = viewModelFactory)

                AppNavGraph(
                    navHostController = navController ,
                    viewModel = viewModel ,
                    viewModelFactory = viewModelFactory
                )
            }
        }
    }
}