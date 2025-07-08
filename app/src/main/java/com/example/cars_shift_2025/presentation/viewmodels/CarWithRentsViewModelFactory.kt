package com.example.cars_shift_2025.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cars_shift_2025.data.CarApiFactory
import com.example.cars_shift_2025.data.CarRepositoryImpl

class CarWithRentsViewModelFactory (
    private val carId: String
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CarWithRentsViewModel(
            carId = carId,
            repository = CarRepositoryImpl(CarApiFactory.apiService)
        ) as T
    }
}