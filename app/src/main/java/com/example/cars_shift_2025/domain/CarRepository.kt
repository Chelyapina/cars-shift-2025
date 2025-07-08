package com.example.cars_shift_2025.domain

import com.example.cars_shift_2025.domain.models.Car
import com.example.cars_shift_2025.domain.models.CarWithRents

interface CarRepository {
    suspend fun getCarsList() : Result<List<Car>>
    suspend fun getCarById(id : String) : Result<CarWithRents>
}