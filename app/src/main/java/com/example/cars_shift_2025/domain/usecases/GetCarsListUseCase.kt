package com.example.cars_shift_2025.domain.usecases

import com.example.cars_shift_2025.domain.CarRepository
import com.example.cars_shift_2025.domain.models.Car
import javax.inject.Inject

class GetCarsListUseCase @Inject constructor(
    private val repository : CarRepository
) : suspend () -> Result<List<Car>> by repository::getCarsList