package com.example.cars_shift_2025.data.models

import com.example.cars_shift_2025.domain.models.BodyType
import com.google.gson.annotations.SerializedName

enum class BodyTypeDto {
    @SerializedName("sedan") SEDAN,
    @SerializedName("suv") SUV,
    @SerializedName("coupe") COUPE,
    @SerializedName("hatchback") HATCHBACK,
    @SerializedName("cabriolet") CABRIOLET,
    UNKNOWN;

    fun toDomain(): BodyType = try {
        when(this) {
            SEDAN -> BodyType.SEDAN
            SUV -> BodyType.SUV
            COUPE -> BodyType.COUPE
            HATCHBACK -> BodyType.HATCHBACK
            CABRIOLET -> BodyType.CABRIOLET
            UNKNOWN -> throw IllegalArgumentException("Unknown body type")
        }
    } catch (e: Exception) {
        BodyType.UNKNOWN
    }
}