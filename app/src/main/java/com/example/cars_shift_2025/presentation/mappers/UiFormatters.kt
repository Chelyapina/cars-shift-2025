package com.example.cars_shift_2025.presentation.mappers

import com.example.cars_shift_2025.R
import com.example.cars_shift_2025.di.StringProvider
import com.example.cars_shift_2025.domain.models.BodyType
import com.example.cars_shift_2025.domain.models.Brand
import com.example.cars_shift_2025.domain.models.Color
import com.example.cars_shift_2025.domain.models.Steering
import com.example.cars_shift_2025.domain.models.Transmission
import javax.inject.Inject

class UiFormatters @Inject constructor(
    private val stringProvider : StringProvider ,
    private val dateFormatter : DateFormatter
) {
    val BodyType.toUi : String
        get() = when (this) {
            BodyType.SEDAN -> stringProvider.getString(R.string.body_type_sedan)
            BodyType.SUV -> stringProvider.getString(R.string.body_type_suv)
            BodyType.COUPE -> stringProvider.getString(R.string.body_type_coupe)
            BodyType.HATCHBACK -> stringProvider.getString(R.string.body_type_hatchback)
            BodyType.CABRIOLET -> stringProvider.getString(R.string.body_type_cabriolet)
        }

    val Brand.toUi : String
        get() = when (this) {
            Brand.HYUNDAI -> stringProvider.getString(R.string.brand_hyundai)
            Brand.VOLKSWAGEN -> stringProvider.getString(R.string.brand_volkswagen)
            Brand.HAVAL -> stringProvider.getString(R.string.brand_haval)
            Brand.KIA -> stringProvider.getString(R.string.brand_kia)
            Brand.GEELY -> stringProvider.getString(R.string.brand_geely)
            Brand.MERCEDES -> stringProvider.getString(R.string.brand_mercedes)
            Brand.GARDEN_CAR -> stringProvider.getString(R.string.brand_garden_car)
            Brand.GROCERY_CAR -> stringProvider.getString(R.string.brand_grocery_cart)
            Brand.HAIER -> stringProvider.getString(R.string.brand_haier)
            Brand.INVALID -> stringProvider.getString(R.string.brand_invalid)
        }

    val Color.toUi : String
        get() = when (this) {
            Color.BLACK -> stringProvider.getString(R.string.color_black)
            Color.WHITE -> stringProvider.getString(R.string.color_white)
            Color.RED -> stringProvider.getString(R.string.color_red)
            Color.SILVER -> stringProvider.getString(R.string.color_silver)
            Color.BLUE -> stringProvider.getString(R.string.color_blue)
            Color.GREY -> stringProvider.getString(R.string.color_grey)
            Color.ORANGE -> stringProvider.getString(R.string.color_orange)
        }

    val Steering.toUi : String
        get() = when (this) {
            Steering.LEFT -> stringProvider.getString(R.string.steering_left)
            Steering.RIGHT -> stringProvider.getString(R.string.steering_right)
            Steering.NO_STEERING -> stringProvider.getString(R.string.steering_no_steering)
        }

    val Transmission.toUi : String
        get() = when (this) {
            Transmission.AUTOMATIC -> stringProvider.getString(R.string.transmission_automatic)
            Transmission.MANUAL -> stringProvider.getString(R.string.transmission_manual)
        }

    fun formatDate(timestamp : Long?) : String = dateFormatter.formatDate(timestamp)
}