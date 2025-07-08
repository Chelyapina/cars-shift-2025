package com.example.cars_shift_2025.data.models

import com.google.gson.annotations.SerializedName

enum class BrandDto {
    @SerializedName("Haval")
    HAVAL ,
    @SerializedName("Hyundai")
    HYUNDAI ,
    @SerializedName("Volkswagen")
    VOLKSWAGEN ,
    @SerializedName("Kia")
    KIA ,
    @SerializedName("Geely")
    GEELY ,
    @SerializedName("Mercedes")
    MERCEDES ,
    @SerializedName("Garden car")
    GARDEN_CAR ,
    @SerializedName("Grocery cart")
    GROCERY_CAR ,
    @SerializedName("Haier")
    HAIER ,
    @SerializedName("Invalid")
    INVALID ,
    UNKNOWN
}
