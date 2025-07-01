package com.example.cars_shift_2025.domain.models

data class CarDetails(
    val id: String,
    val name: String,
    val brand: String,
    val imageUrl: String,
    val transmission: String,
    val price: Int,
    val color: String,
    val bodyType: String,
    val steering: String,
    val startDate: String,
    val endDate: String
)
