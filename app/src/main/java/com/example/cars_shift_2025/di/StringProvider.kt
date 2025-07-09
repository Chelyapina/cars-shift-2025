package com.example.cars_shift_2025.di

import androidx.annotation.StringRes

interface StringProvider {
    fun getString(@StringRes resId : Int) : String
}