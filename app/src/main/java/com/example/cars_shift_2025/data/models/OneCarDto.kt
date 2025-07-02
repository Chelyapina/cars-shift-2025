package com.example.cars_shift_2025.data.models

import com.google.gson.annotations.SerializedName


data class OneCarDto (

  @SerializedName("id"           ) var id           : String ,
  @SerializedName("name"         ) var name         : String ,
  @SerializedName("brand"        ) var brand        : BrandDto ,
  @SerializedName("media"        ) var media        : ArrayList<MediaDto> = arrayListOf() ,
  @SerializedName("transmission" ) var transmission : TransmissionDto ,
  @SerializedName("price"        ) var price        : Long ,
  @SerializedName("location"     ) var location     : String ,
  @SerializedName("color"        ) var color        : ColorDto ,
  @SerializedName("bodyType"     ) var bodyType     : BodyTypeDto ,
  @SerializedName("steering"     ) var steering     : SteeringDto?          = null ,
  @SerializedName("rents"     ) var rents     : ArrayList<Long>?          = null

)