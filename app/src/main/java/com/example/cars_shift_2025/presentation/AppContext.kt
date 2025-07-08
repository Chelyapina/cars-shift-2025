package com.example.cars_shift_2025.presentation

import android.annotation.SuppressLint
import android.content.Context
import androidx.annotation.StringRes

class ResourceProvider private constructor(private val context: Context) {
    companion object {
        @SuppressLint("StaticFieldLeak")
        @Volatile
        private var INSTANCE: ResourceProvider? = null

        fun initialize(context: Context) {
            INSTANCE = ResourceProvider(context.applicationContext)
        }

        fun get(): ResourceProvider {
            return INSTANCE ?: throw IllegalStateException("ResourceProvider not initialized")
        }
    }

    fun getString(@StringRes resId: Int): String = context.getString(resId)
}