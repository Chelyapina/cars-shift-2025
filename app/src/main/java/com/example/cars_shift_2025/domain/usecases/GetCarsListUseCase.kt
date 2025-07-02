package com.example.cars_shift_2025.domain.usecases

import com.example.cars_shift_2025.domain.CarRepository
import com.example.cars_shift_2025.domain.models.Car

class GetCarsListUseCase(private val repository : CarRepository) {
    suspend operator fun invoke(): List<Car> = repository.getCarsList()
}