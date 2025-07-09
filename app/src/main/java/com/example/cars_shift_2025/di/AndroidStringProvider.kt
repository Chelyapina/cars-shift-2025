package com.example.cars_shift_2025.di

import android.content.Context
import javax.inject.Inject

class AndroidStringProvider @Inject constructor(
    private val context : Context
) : StringProvider {
    override fun getString(resId : Int) : String = context.getString(resId)
}