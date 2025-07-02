package com.example.cars_shift_2025.domain.models

data class Car(
    val id: String,
    val name: String,
    val brand: Brand,
    val imageUrl: String,
    val transmission: Transmission,
    val price: Long
)
