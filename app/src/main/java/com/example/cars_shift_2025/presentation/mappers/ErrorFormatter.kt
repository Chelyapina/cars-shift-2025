package com.example.cars_shift_2025.presentation.mappers

import com.example.cars_shift_2025.R
import com.example.cars_shift_2025.di.StringProvider
import javax.inject.Inject

class ErrorFormatter @Inject constructor(private val stringProvider: StringProvider) {
    fun formatError(throwable: Throwable?): String {
        return when (throwable?.message) {
            "Ошибка сети" -> stringProvider.getString(R.string.error_network)
            "Ошибка сервера" -> stringProvider.getString(R.string.error_server)
            else -> stringProvider.getString(R.string.error_unknown)
        }
    }

    fun getNotFoundMessage(): String {
        return stringProvider.getString(R.string.error_data_not_found)
    }
}