package com.example.cars_shift_2025.presentation.viewmodels

import com.example.cars_shift_2025.presentation.models.CarUi

sealed class CarListState {
    object Loading : CarListState()
    object Empty : CarListState()
    data class Success(val cars : List<CarUi>) : CarListState()
    data class Error(val message : String) : CarListState()
}