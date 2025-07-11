package com.example.cars_shift_2025.data.mappers

import com.example.cars_shift_2025.data.models.ListCarDto
import com.example.cars_shift_2025.data.models.OneCarDto
import com.example.cars_shift_2025.domain.models.Car
import com.example.cars_shift_2025.domain.models.CarWithRents

fun OneCarDto.toCar() : Car {
    return Car(
        id = id ,
        name = name ,
        brand = brand.toDomain() ,
        imageUrl = media.firstOrNull()?.url?.let { BASE_IMAGE_URL + it } ?: "" ,
        transmission = transmission.toDomain() ,
        price = price,
        color = color.toDomain() ,
        bodyType = bodyType.toDomain() ,
        steering = steering?.toDomain() ?: DEFAULT_STEERING_VALUE ,
    )
}

fun OneCarDto.toCarWithRents() : CarWithRents {
    return CarWithRents(
        id = id ,
        name = name ,
        brand = brand.toDomain() ,
        imageUrl = media.firstOrNull()?.url?.let { BASE_IMAGE_URL + it } ?: "" ,
        transmission = transmission.toDomain() ,
        price = price ,
        color = color.toDomain() ,
        bodyType = bodyType.toDomain() ,
        steering = steering?.toDomain() ?: DEFAULT_STEERING_VALUE ,
        startDate = rents?.firstOrNull() ,
        endDate = rents?.lastOrNull()
    )
}

fun ListCarDto.toListCar() : List<Car> {
    return this.data.map { it.toCar() }
}