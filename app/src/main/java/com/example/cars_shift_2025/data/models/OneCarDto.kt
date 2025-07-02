package com.example.cars_shift_2025.data.models

import com.google.gson.annotations.SerializedName


data class OneCarDto (

  @SerializedName("id"           ) var id           : String,
  @SerializedName("name"         ) var name         : String,
  @SerializedName("brand"        ) var brand        : Brand,
  @SerializedName("media"        ) var media        : ArrayList<MediaDto> = arrayListOf() ,
  @SerializedName("transmission" ) var transmission : Transmission,
  @SerializedName("price"        ) var price        : Long,
  @SerializedName("location"     ) var location     : String,
  @SerializedName("color"        ) var color        : Color,
  @SerializedName("bodyType"     ) var bodyType     : BodyType,
  @SerializedName("steering"     ) var steering     : Steering?          = null,
  @SerializedName("rents"     ) var rents     : ArrayList<Long>?          = null

)