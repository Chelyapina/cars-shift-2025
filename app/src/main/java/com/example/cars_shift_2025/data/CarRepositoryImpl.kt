package com.example.cars_shift_2025.data

import android.util.Log
import com.example.cars_shift_2025.data.mappers.CarMapper
import com.example.cars_shift_2025.domain.CarRepository
import com.example.cars_shift_2025.domain.models.Car
import com.example.cars_shift_2025.domain.models.CarWithRents
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CarRepositoryImpl(
    private val carApiService: CarApiService,
    private val carMapper: CarMapper
) : CarRepository {

    override suspend fun getCarsList(): List<Car> = withContext(Dispatchers.IO) {
        try {
            val carDtoList = carApiService.getCarsList()
            carMapper.toListCar(carDtoList.data)
        } catch (e: Exception) {
            Log.e("Error fetching car list:", e.toString())
            emptyList()
        }
    }

    override suspend fun getCarById(id: String): CarWithRents = withContext(Dispatchers.IO) {
        try {
            val carDto = carApiService.getCarById(id)
            carMapper.toCarWithRents(carDto.data)
        } catch (e: Exception) {
            Log.e("Error fetching car with id $id:", e.message.toString())
            throw e
        }
    }
}