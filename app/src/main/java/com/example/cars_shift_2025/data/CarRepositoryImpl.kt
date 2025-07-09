package com.example.cars_shift_2025.data

import com.example.cars_shift_2025.data.mappers.toCarWithRents
import com.example.cars_shift_2025.data.mappers.toListCar
import com.example.cars_shift_2025.domain.CarRepository
import com.example.cars_shift_2025.domain.models.Car
import com.example.cars_shift_2025.domain.models.CarWithRents
import javax.inject.Inject

class CarRepositoryImpl @Inject constructor(
    private val carApiService : CarApiService ,
) : CarRepository {
    override suspend fun getCarsList() : Result<List<Car>> =
        safeCall(
            request = { carApiService.getCarsList() } ,
            isSuccess = { response -> response.success } ,
            onSuccess = { response -> response.toListCar() }
        )

    override suspend fun getCarById(id : String) : Result<CarWithRents> =
        safeCall(
            request = { carApiService.getCarById(id) } ,
            isSuccess = { response -> response.success } ,
            onSuccess = { response -> response.data.toCarWithRents() }
        )
}