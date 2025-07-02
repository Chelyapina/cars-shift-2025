package com.example.cars_shift_2025.data.models

import com.example.cars_shift_2025.domain.models.Steering
import com.google.gson.annotations.SerializedName

enum class SteeringDto {
    @SerializedName("left") LEFT,
    @SerializedName("right") RIGHT,
    UNKNOWN;

    fun toDomain(): Steering = try {
        when(this) {
            LEFT -> Steering.LEFT
            RIGHT -> Steering.RIGHT
            UNKNOWN -> throw IllegalArgumentException("Unknown steering")
        }
    } catch (e: Exception) {
        Steering.LEFT
    }
}