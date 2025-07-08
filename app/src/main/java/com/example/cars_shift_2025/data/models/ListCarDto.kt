package com.example.cars_shift_2025.data.models

data class ListCarDto(
    val success : Boolean ,
    val data : List<OneCarDto> = listOf() ,
    val meta : MetaDto = MetaDto()
)