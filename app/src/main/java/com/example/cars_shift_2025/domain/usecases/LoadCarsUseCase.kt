package com.example.cars_shift_2025.domain.usecases

import com.example.cars_shift_2025.domain.CarRepository

class LoadCarsUseCase (private val repository : CarRepository) {
    operator fun invoke() = repository.loadCars()
}