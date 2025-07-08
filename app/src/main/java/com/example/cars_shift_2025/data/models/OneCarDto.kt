package com.example.cars_shift_2025.data.models

data class OneCarDto(
    val id : String ,
    val name : String ,
    val brand : BrandDto ,
    val media : List<MediaDto> = listOf() ,
    val transmission : TransmissionDto ,
    val price : Long ,
    val location : String ,
    val color : ColorDto ,
    val bodyType : BodyTypeDto ,
    val steering : SteeringDto? = null ,
    val rents : List<Long>? = null
)