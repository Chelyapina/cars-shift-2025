package com.example.cars_shift_2025.presentation.mappers

import com.example.cars_shift_2025.R
import com.example.cars_shift_2025.domain.models.BodyType
import com.example.cars_shift_2025.domain.models.Brand
import com.example.cars_shift_2025.domain.models.Color
import com.example.cars_shift_2025.domain.models.Steering
import com.example.cars_shift_2025.domain.models.Transmission
import com.example.cars_shift_2025.presentation.ResourceProvider

val BodyType.toUi : String
    get() = when (this) {
        BodyType.SEDAN -> ResourceProvider.get().getString(R.string.body_type_sedan)
        BodyType.SUV -> ResourceProvider.get().getString(R.string.body_type_suv)
        BodyType.COUPE -> ResourceProvider.get().getString(R.string.body_type_coupe)
        BodyType.HATCHBACK -> ResourceProvider.get().getString(R.string.body_type_hatchback)
        BodyType.CABRIOLET -> ResourceProvider.get().getString(R.string.body_type_cabriolet)
    }

val Brand.toUi : String
    get() = when (this) {
        Brand.HYUNDAI -> ResourceProvider.get().getString(R.string.brand_hyundai)
        Brand.VOLKSWAGEN -> ResourceProvider.get().getString(R.string.brand_volkswagen)
        Brand.HAVAL -> ResourceProvider.get().getString(R.string.brand_haval)
        Brand.KIA -> ResourceProvider.get().getString(R.string.brand_kia)
        Brand.GEELY -> ResourceProvider.get().getString(R.string.brand_geely)
        Brand.MERCEDES -> ResourceProvider.get().getString(R.string.brand_mercedes)
        Brand.GARDEN_CAR -> ResourceProvider.get().getString(R.string.brand_garden_car)
        Brand.GROCERY_CAR -> ResourceProvider.get().getString(R.string.brand_grocery_cart)
        Brand.HAIER -> ResourceProvider.get().getString(R.string.brand_haier)
        Brand.INVALID -> ResourceProvider.get().getString(R.string.brand_invalid)
    }

val Color.toUi : String
    get() = when (this) {
        Color.BLACK -> ResourceProvider.get().getString(R.string.color_black)
        Color.WHITE -> ResourceProvider.get().getString(R.string.color_white)
        Color.RED -> ResourceProvider.get().getString(R.string.color_red)
        Color.SILVER -> ResourceProvider.get().getString(R.string.color_silver)
        Color.BLUE -> ResourceProvider.get().getString(R.string.color_blue)
        Color.GREY -> ResourceProvider.get().getString(R.string.color_grey)
        Color.ORANGE -> ResourceProvider.get().getString(R.string.color_orange)
    }

val Steering.toUi : String
    get() = when (this) {
        Steering.LEFT -> ResourceProvider.get().getString(R.string.steering_left)
        Steering.RIGHT -> ResourceProvider.get().getString(R.string.steering_right)
        Steering.NO_STEERING -> ResourceProvider.get().getString(R.string.steering_no_steering)
    }

val Transmission.toUi : String
    get() = when (this) {
        Transmission.AUTOMATIC -> ResourceProvider.get().getString(R.string.transmission_automatic)
        Transmission.MANUAL -> ResourceProvider.get().getString(R.string.transmission_manual)
    }