package com.example.cars_shift_2025.domain

import com.example.cars_shift_2025.domain.models.CarDetails
import com.example.cars_shift_2025.domain.models.CarListItem

interface CarRepository {
    fun getCarsList(): List<CarListItem>
    fun getCarById(id: String): CarDetails
    fun loadCars()
}