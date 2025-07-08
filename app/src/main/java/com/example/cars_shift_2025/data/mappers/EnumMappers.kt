package com.example.cars_shift_2025.data.mappers

import com.example.cars_shift_2025.data.models.BodyTypeDto
import com.example.cars_shift_2025.data.models.BodyTypeDto.CABRIOLET
import com.example.cars_shift_2025.data.models.BodyTypeDto.COUPE
import com.example.cars_shift_2025.data.models.BodyTypeDto.HATCHBACK
import com.example.cars_shift_2025.data.models.BodyTypeDto.SEDAN
import com.example.cars_shift_2025.data.models.BodyTypeDto.SUV
import com.example.cars_shift_2025.data.models.BrandDto
import com.example.cars_shift_2025.data.models.BrandDto.GARDEN_CAR
import com.example.cars_shift_2025.data.models.BrandDto.GEELY
import com.example.cars_shift_2025.data.models.BrandDto.GROCERY_CAR
import com.example.cars_shift_2025.data.models.BrandDto.HAIER
import com.example.cars_shift_2025.data.models.BrandDto.HAVAL
import com.example.cars_shift_2025.data.models.BrandDto.HYUNDAI
import com.example.cars_shift_2025.data.models.BrandDto.INVALID
import com.example.cars_shift_2025.data.models.BrandDto.KIA
import com.example.cars_shift_2025.data.models.BrandDto.MERCEDES
import com.example.cars_shift_2025.data.models.BrandDto.VOLKSWAGEN
import com.example.cars_shift_2025.data.models.ColorDto
import com.example.cars_shift_2025.data.models.ColorDto.BLACK
import com.example.cars_shift_2025.data.models.ColorDto.BLUE
import com.example.cars_shift_2025.data.models.ColorDto.GREY
import com.example.cars_shift_2025.data.models.ColorDto.ORANGE
import com.example.cars_shift_2025.data.models.ColorDto.RED
import com.example.cars_shift_2025.data.models.ColorDto.SILVER
import com.example.cars_shift_2025.data.models.ColorDto.WHITE
import com.example.cars_shift_2025.data.models.SteeringDto
import com.example.cars_shift_2025.data.models.SteeringDto.LEFT
import com.example.cars_shift_2025.data.models.SteeringDto.RIGHT
import com.example.cars_shift_2025.data.models.TransmissionDto
import com.example.cars_shift_2025.data.models.TransmissionDto.AUTOMATIC
import com.example.cars_shift_2025.data.models.TransmissionDto.MANUAL
import com.example.cars_shift_2025.domain.models.BodyType
import com.example.cars_shift_2025.domain.models.Brand
import com.example.cars_shift_2025.domain.models.Color
import com.example.cars_shift_2025.domain.models.Steering
import com.example.cars_shift_2025.domain.models.Transmission

fun BodyTypeDto.toDomain() : BodyType = when (this) {
    SEDAN -> BodyType.SEDAN
    SUV -> BodyType.SUV
    COUPE -> BodyType.COUPE
    HATCHBACK -> BodyType.HATCHBACK
    CABRIOLET -> BodyType.CABRIOLET
    BodyTypeDto.UNKNOWN -> throw IllegalArgumentException("Unknown body type: $this")
}

fun BrandDto.toDomain() : Brand = when (this) {
    HAVAL -> Brand.HAVAL
    HYUNDAI -> Brand.HYUNDAI
    VOLKSWAGEN -> Brand.VOLKSWAGEN
    KIA -> Brand.KIA
    GEELY -> Brand.GEELY
    MERCEDES -> Brand.MERCEDES
    GARDEN_CAR -> Brand.GARDEN_CAR
    GROCERY_CAR -> Brand.GROCERY_CAR
    HAIER -> Brand.HAIER
    INVALID -> Brand.INVALID
    BrandDto.UNKNOWN -> throw IllegalArgumentException("Unknown brand: $this")
}

fun ColorDto.toDomain() : Color = when (this) {
    BLACK -> Color.BLACK
    WHITE -> Color.WHITE
    RED -> Color.RED
    SILVER -> Color.SILVER
    BLUE -> Color.BLUE
    GREY -> Color.GREY
    ORANGE -> Color.ORANGE
    ColorDto.UNKNOWN -> throw IllegalArgumentException("Unknown color: $this")
}

fun SteeringDto.toDomain() : Steering = when (this) {
    LEFT -> Steering.LEFT
    RIGHT -> Steering.RIGHT
    SteeringDto.UNKNOWN -> Steering.NO_STEERING
}

fun TransmissionDto.toDomain() : Transmission = when (this) {
    AUTOMATIC -> Transmission.AUTOMATIC
    MANUAL -> Transmission.MANUAL
    TransmissionDto.UNKNOWN -> throw IllegalArgumentException("Unknown transmission: $this")
}