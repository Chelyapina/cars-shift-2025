package com.example.cars_shift_2025.presentation.viewmodels

import com.example.cars_shift_2025.presentation.models.CarWithRentsUi

sealed class CarWithRentsState {
    object Loading : CarWithRentsState()
    data class Success(val carDetail : CarWithRentsUi) : CarWithRentsState()
    data class Error(val message : String) : CarWithRentsState()
}