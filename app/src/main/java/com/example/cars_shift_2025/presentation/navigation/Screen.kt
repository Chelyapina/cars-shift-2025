package com.example.cars_shift_2025.presentation.navigation

sealed class Screen(
    val route : String
) {
    object Main : Screen(ROUTE_MAIN)
    object Error : Screen(ROUTE_ERROR)
    object Loading : Screen(ROUTE_LOADING)
    object Filter : Screen(ROUTE_FILTER)
    object CarWithRents : Screen("car_with_rents/{carId}") {
        fun createRoute(carId : String) = "car_with_rents/$carId"
    }

    companion object {
        const val ROUTE_MAIN = "main"
        const val ROUTE_ERROR = "error"
        const val ROUTE_LOADING = "loading"
        const val ROUTE_FILTER = "filter"
    }
}