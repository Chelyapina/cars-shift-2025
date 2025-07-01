package com.example.cars_shift_2025.domain.usecases

import com.example.cars_shift_2025.domain.CarRepository
import com.example.cars_shift_2025.domain.models.CarListItem

class GetCarsListUseCase(private val repository : CarRepository) {
    operator fun invoke(): List<CarListItem> = repository.getCarsList()
}