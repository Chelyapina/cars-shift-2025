package com.example.cars_shift_2025.data.models

import com.example.cars_shift_2025.domain.models.Transmission
import com.google.gson.annotations.SerializedName

enum class TransmissionDto {
    @SerializedName("automatic") AUTOMATIC,
    @SerializedName("manual") MANUAL,
    UNKNOWN;

    fun toDomain(): Transmission = try {
        when(this) {
            AUTOMATIC -> Transmission.AUTOMATIC
            MANUAL -> Transmission.MANUAL
            UNKNOWN -> throw IllegalArgumentException("Unknown transmission")
        }
    } catch (e: Exception) {
        Transmission.AUTOMATIC
    }
}