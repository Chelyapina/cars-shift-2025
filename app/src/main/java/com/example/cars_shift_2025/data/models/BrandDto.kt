package com.example.cars_shift_2025.data.models

import com.example.cars_shift_2025.domain.models.Brand
import com.google.gson.annotations.SerializedName

enum class BrandDto{
    @SerializedName("Haval") HAVAL,
    @SerializedName("Hyundai") HYUNDAI,
    @SerializedName("Volkswagen") VOLKSWAGEN,
    @SerializedName("Kia") KIA,
    @SerializedName("Geely") GEELY,
    @SerializedName("Mercedes") MERCEDES,
    @SerializedName("Garden car") GARDEN_CAR,
    @SerializedName("Grocery cart") GROCERY_CAR,
    @SerializedName("Haier") HAIER,
    @SerializedName("Invalid") INVALID,
    UNKNOWN;

    fun toDomain(): Brand = try {
        when(this) {
            HAVAL -> Brand.HAVAL
            HYUNDAI -> Brand.HYUNDAI
            VOLKSWAGEN -> Brand.VOLKSWAGEN
            KIA -> Brand.KIA
            GEELY -> Brand.GEELY
            MERCEDES -> Brand.MERCEDES
            GARDEN_CAR -> Brand.GARDEN_CAR
            GROCERY_CAR -> Brand.GROCERY_CAR
            HAIER -> Brand.HAIER
            INVALID -> Brand.INVALID
            UNKNOWN -> throw IllegalArgumentException("Unknown brand")
        }
    } catch (e: Exception) {
        Brand.UNKNOWN
    }
}
