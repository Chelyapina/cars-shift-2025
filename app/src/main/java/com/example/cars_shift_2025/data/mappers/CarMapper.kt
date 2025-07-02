package com.example.cars_shift_2025.data.mappers

import com.example.cars_shift_2025.data.models.OneCarDto
import com.example.cars_shift_2025.domain.models.CarWithRents
import com.example.cars_shift_2025.domain.models.Car
import com.example.cars_shift_2025.domain.models.Steering

class CarMapper {

    fun toCar(oneCarDto : OneCarDto): Car {
        return Car(
            id = oneCarDto.id,
            name = oneCarDto.name,
            brand = oneCarDto.brand.toDomain(),
            imageUrl = oneCarDto.media.firstOrNull()?.url?.let { BASE_IMAGE_URL + it } ?: "",
            transmission = oneCarDto.transmission.toDomain(),
            price = oneCarDto.price
        )
    }

    fun toCarWithRents(oneCarDto : OneCarDto): CarWithRents {
        return CarWithRents(
            id = oneCarDto.id,
            name = oneCarDto.name,
            brand = oneCarDto.brand.toDomain(),
            imageUrl = oneCarDto.media.firstOrNull()?.url?.let { BASE_IMAGE_URL + it } ?: "",
            transmission = oneCarDto.transmission.toDomain(),
            price = oneCarDto.price,
            color = oneCarDto.color.toDomain(),
            bodyType = oneCarDto.bodyType.toDomain(),
            steering = oneCarDto.steering?.toDomain() ?: DEFAULT_STEERING_VALUE,
            startDate = oneCarDto.rents?.firstOrNull() ?: DEFAULT_DATE_VALUE ,
            endDate = oneCarDto.rents?.lastOrNull() ?: DEFAULT_DATE_VALUE
        )
    }

    fun toListCar(list : List<OneCarDto>): List<Car> {
        return list.map { toCar(it) }
    }

    companion object{
        private const val BASE_IMAGE_URL = "https://shift-intensive.ru"
        private val DEFAULT_STEERING_VALUE : Steering = Steering.LEFT
        private const val DEFAULT_DATE_VALUE = 0L
    }
}