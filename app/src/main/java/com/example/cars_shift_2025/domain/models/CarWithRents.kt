package com.example.cars_shift_2025.domain.models

data class CarWithRents(
    val id: String,
    val name: String,
    val brand: Brand,
    val imageUrl: String,
    val transmission: Transmission,
    val price: Long,
    val color: Color,
    val bodyType: BodyType,
    val steering: Steering,
    val startDate: Long,
    val endDate: Long
)
