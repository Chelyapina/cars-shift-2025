package com.example.cars_shift_2025.domain.usecases

import com.example.cars_shift_2025.domain.CarRepository
import com.example.cars_shift_2025.domain.models.CarWithRents

class GetCarByIdUseCase(private val repository : CarRepository) {
    operator fun invoke(id : String) : CarWithRents = repository.getCarById(id)
}