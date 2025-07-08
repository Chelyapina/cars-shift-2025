package com.example.cars_shift_2025.data

import com.example.cars_shift_2025.data.mappers.toCarWithRents
import com.example.cars_shift_2025.data.mappers.toListCar
import com.example.cars_shift_2025.domain.CarRepository
import com.example.cars_shift_2025.domain.models.Car
import com.example.cars_shift_2025.domain.models.CarWithRents
import java.io.IOException

class CarRepositoryImpl(
    private val carApiService : CarApiService ,
) : CarRepository {
    override suspend fun getCarsList(): Result<List<Car>> = try {
        val response = carApiService.getCarsList()

        if (!response.success) {
            Result.failure(Exception("Ошибка сервера"))
        } else {
            val cars = response.toListCar()
            Result.success(cars)
        }
    } catch (_: IOException) {
        Result.failure(Exception("Ошибка сети"))
    } catch (_: Exception) {
        Result.failure(Exception("Неизвестная ошибка"))
    }

    override suspend fun getCarById(id : String) : Result<CarWithRents>  = try {
        val response = carApiService.getCarById(id)

        if (!response.success) {
            Result.failure(Exception("Ошибка сервера"))
        } else {
            val car = response.data.toCarWithRents()
            Result.success(car)
        }
    } catch (_: IOException) {
        Result.failure(Exception("Ошибка сети"))
    } catch (_: Exception) {
        Result.failure(Exception("Неизвестная ошибка"))
    }
}