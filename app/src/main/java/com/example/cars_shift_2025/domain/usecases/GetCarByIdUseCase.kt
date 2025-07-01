package com.example.cars_shift_2025.domain.usecases

import com.example.cars_shift_2025.domain.CarRepository
import com.example.cars_shift_2025.domain.models.CarDetails

class GetCarByIdUseCase(private val repository : CarRepository) {
    operator fun invoke(id : String) : CarDetails = repository.getCarById(id)
}