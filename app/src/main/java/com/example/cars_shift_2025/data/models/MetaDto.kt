package com.example.cars_shift_2025.data.models

import com.google.gson.annotations.SerializedName


data class MetaDto (

  @SerializedName("total"      ) var total      : Int? = null,
  @SerializedName("page"       ) var page       : Int? = null,
  @SerializedName("limit"      ) var limit      : Int? = null,
  @SerializedName("totalPages" ) var totalPages : Int? = null

)