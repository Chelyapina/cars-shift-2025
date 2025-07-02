package com.example.cars_shift_2025.domain

import com.example.cars_shift_2025.domain.models.CarWithRents
import com.example.cars_shift_2025.domain.models.Car

interface CarRepository {
    suspend fun getCarsList(): List<Car>
    suspend fun getCarById(id: String): CarWithRents
}