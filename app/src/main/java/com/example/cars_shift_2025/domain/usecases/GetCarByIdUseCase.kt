package com.example.cars_shift_2025.domain.usecases

import com.example.cars_shift_2025.domain.CarRepository
import com.example.cars_shift_2025.domain.models.CarWithRents
import javax.inject.Inject

class GetCarByIdUseCase @Inject constructor(
    private val repository : CarRepository
) : suspend (String) -> Result<CarWithRents> by repository::getCarById