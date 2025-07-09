package com.example.cars_shift_2025.presentation.mappers

import com.example.cars_shift_2025.domain.models.Car
import com.example.cars_shift_2025.domain.models.CarWithRents
import com.example.cars_shift_2025.presentation.models.CarUi
import com.example.cars_shift_2025.presentation.models.CarWithRentsUi

fun Car.toUi(mappers : UiFormatters) : CarUi = with(mappers) {
    CarUi(
        id = id ,
        imageRes = imageUrl ,
        title = "${brand.toUi}\n${name}" ,
        transmission = transmission.toUi ,
        price = "$price ₽"
    )
}

fun CarWithRents.toUi(mappers : UiFormatters) : CarWithRentsUi = with(mappers) {
    CarWithRentsUi(
        imageRes = imageUrl ,
        title = "${brand.toUi}\n${name}" ,
        transmission = transmission.toUi ,
        steering = steering.toUi ,
        bodyType = bodyType.toUi ,
        color = color.toUi ,
        price = "$price ₽" ,
        startDate = formatDate(startDate) ,
        endDate = formatDate(endDate)
    )
}

