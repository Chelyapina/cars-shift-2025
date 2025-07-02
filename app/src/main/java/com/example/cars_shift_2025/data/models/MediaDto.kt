package com.example.cars_shift_2025.data.models

import com.google.gson.annotations.SerializedName


data class MediaDto (

  @SerializedName("url"     ) var url     : String,
  @SerializedName("isCover" ) var isCover : Boolean

)