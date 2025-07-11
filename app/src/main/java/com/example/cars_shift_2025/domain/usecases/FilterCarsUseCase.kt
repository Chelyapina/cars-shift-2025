package com.example.cars_shift_2025.domain.usecases

import com.example.cars_shift_2025.domain.models.Car
import com.example.cars_shift_2025.domain.models.FilterParams
import javax.inject.Inject

class FilterCarsUseCase @Inject constructor() {
    operator fun invoke(cars: List<Car>, params: FilterParams): List<Car> {
        return if (params.isEmpty()) cars else cars.filter { car ->
            params.run {
                listOf(
                    brand == null || car.brand == brand,
                    bodyType == null || car.bodyType == bodyType,
                    steering == null || car.steering == steering,
                    transmission == null || car.transmission == transmission,
                    maxPrice == null || car.price <= maxPrice,
                    color == null || car.color == color
                ).all { it }
            }
        }
    }
}