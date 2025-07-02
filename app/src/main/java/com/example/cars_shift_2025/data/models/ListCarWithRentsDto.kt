package com.example.cars_shift_2025.data.models

import com.google.gson.annotations.SerializedName


data class ListCarWithRentsDto (

  @SerializedName("success" ) var success : Boolean?        = null ,
  @SerializedName("data"    ) var data    : OneCarDto,
)