package com.example.cars_shift_2025.data.models

import com.example.cars_shift_2025.domain.models.Color
import com.google.gson.annotations.SerializedName

enum class ColorDto {
    @SerializedName("black") BLACK,
    @SerializedName("white") WHITE,
    @SerializedName("red") RED,
    @SerializedName("silver") SILVER,
    @SerializedName("blue") BLUE,
    @SerializedName("grey") GREY,
    @SerializedName("orange") ORANGE,
    UNKNOWN;

    fun toDomain(): Color = try {
        when(this) {
            BLACK -> Color.BLACK
            WHITE -> Color.WHITE
            RED -> Color.RED
            SILVER -> Color.SILVER
            BLUE -> Color.BLUE
            GREY -> Color.GREY
            ORANGE -> Color.ORANGE
            UNKNOWN -> throw IllegalArgumentException("Unknown color")
        }
    } catch (e: Exception) {
        Color.UNKNOWN
    }
}