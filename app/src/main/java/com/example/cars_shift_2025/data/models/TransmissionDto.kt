package com.example.cars_shift_2025.data.models

import com.google.gson.annotations.SerializedName

enum class TransmissionDto {
    @SerializedName("automatic")
    AUTOMATIC ,
    @SerializedName("manual")
    MANUAL ,
    UNKNOWN
}