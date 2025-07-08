package com.example.cars_shift_2025.data.models

import com.google.gson.annotations.SerializedName

enum class BodyTypeDto {
    @SerializedName("sedan")
    SEDAN ,
    @SerializedName("suv")
    SUV ,
    @SerializedName("coupe")
    COUPE ,
    @SerializedName("hatchback")
    HATCHBACK ,
    @SerializedName("cabriolet")
    CABRIOLET ,
    UNKNOWN
}