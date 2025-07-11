package com.example.cars_shift_2025.domain.models

data class FilterParams(
    val brand : Brand? = null,
    val bodyType : BodyType? = null,
    val steering : Steering? = null,
    val transmission : Transmission? = null,
    val maxPrice : Long? = null,
    val color : Color? = null
) {
    fun isEmpty() = listOf(
        brand, bodyType, steering,
        transmission, maxPrice, color
    ).all { it == null }
}