package com.example.cars_shift_2025.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.cars_shift_2025.R
import com.example.cars_shift_2025.di.DaggerViewModelFactory
import com.example.cars_shift_2025.presentation.screens.CarLoadingScreen
import com.example.cars_shift_2025.presentation.screens.CarWithRentsLoadingScreen
import com.example.cars_shift_2025.presentation.screens.ErrorScreen
import com.example.cars_shift_2025.presentation.screens.FilterScreen
import com.example.cars_shift_2025.presentation.screens.LoadingScreen
import com.example.cars_shift_2025.presentation.viewmodels.CarListState.Success
import com.example.cars_shift_2025.presentation.viewmodels.CarWithRentsViewModel
import com.example.cars_shift_2025.presentation.viewmodels.FilterViewModel
import com.example.cars_shift_2025.presentation.viewmodels.MainScreenViewModel

@Composable
fun AppNavGraph(
    navHostController : NavHostController ,
    viewModel : MainScreenViewModel ,
    viewModelFactory : DaggerViewModelFactory
) {
    NavHost(
        navController = navHostController ,
        startDestination = Screen.Loading.route
    ) {
        composable(Screen.Main.route) {
            CarLoadingScreen(viewModel , navHostController)
        }
        composable(Screen.Loading.route) {
            LoadingScreen()
            LaunchedEffect(Unit) {
                viewModel.retryLoad()

                viewModel.stateFlow.collect { state ->
                    when (state) {
                        is Success -> navHostController.navigate(Screen.Main.route) {
                            popUpTo(Screen.Loading.route) { inclusive = true }
                        }

                        is Error -> navHostController.navigate(Screen.Error.route) {
                            popUpTo(Screen.Loading.route) { inclusive = true }
                        }

                        else -> Unit
                    }
                }
            }
        }
        composable(Screen.Error.route) { backStackEntry ->
            val errorMessage = backStackEntry.arguments?.getString("message")
                ?: stringResource(R.string.error_message)
            ErrorScreen(
                message = errorMessage ,
                onRetry = { viewModel.retryLoad() }
            )
        }
        composable(
            route = Screen.CarWithRents.route ,
            arguments = listOf(navArgument("carId") { type = NavType.StringType })
        ) { backStackEntry ->
            val carId = backStackEntry.arguments?.getString("carId") ?: ""
            val carWithRentsViewModel : CarWithRentsViewModel = viewModel(
                factory = object : ViewModelProvider.Factory {
                    @Suppress("UNCHECKED_CAST")
                    override fun <T : ViewModel> create(modelClass : Class<T>) : T {
                        return viewModelFactory.create(carId) as T
                    }
                }
            )

            CarWithRentsLoadingScreen(
                viewModel = carWithRentsViewModel ,
                navController = navHostController
            )
        }
        composable("filter") { backStackEntry ->
            val filterViewModel : FilterViewModel = viewModel(
                factory = object : ViewModelProvider.Factory {
                    @Suppress("UNCHECKED_CAST")
                    override fun <T : ViewModel> create(modelClass : Class<T>) : T {
                        return viewModelFactory.create(modelClass) as T
                    }
                }
            )

            LaunchedEffect(Unit) {
                filterViewModel.initWithCars(viewModel.originalCars)
            }

            FilterScreen(
                viewModel = filterViewModel ,
                navController = navHostController ,
                onApplyFilters = { filterParams ->
                    val filtered = viewModel.applyFilters(filterParams)
                    viewModel.updateFilteredCars(filtered)
                }
            )
        }

    }
}