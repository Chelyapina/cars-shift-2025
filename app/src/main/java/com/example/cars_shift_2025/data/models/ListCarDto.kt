package com.example.cars_shift_2025.data.models

import com.google.gson.annotations.SerializedName


data class ListCarDto (

  @SerializedName("success" ) var success : Boolean?        = null ,
  @SerializedName("data"    ) var data    : ArrayList<OneCarDto> = arrayListOf() ,
  @SerializedName("meta"    ) var meta    : MetaDto           = MetaDto()

)