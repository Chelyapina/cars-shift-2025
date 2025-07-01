package com.example.cars_shift_2025.domain.models

data class CarListItem(
    val id: String,
    val name: String,
    val brand: String,
    val imageUrl: String,
    val transmission: String,
    val price: Int
)
