package com.example.cars_shift_2025.data.models

import com.google.gson.annotations.SerializedName


data class CarDto (

  @SerializedName("success" ) var success : Boolean?        = null ,
  @SerializedName("data"    ) var data    : ArrayList<DataDto> = arrayListOf() ,
  @SerializedName("meta"    ) var meta    : MetaDto?           = MetaDto()

)