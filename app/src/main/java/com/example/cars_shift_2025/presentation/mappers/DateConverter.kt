package com.example.cars_shift_2025.presentation.mappers

import com.example.cars_shift_2025.R
import com.example.cars_shift_2025.presentation.ResourceProvider
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun formatDate(timestamp : Long?) : String {
    return when {
        timestamp == null || timestamp == 0L ->
            ResourceProvider.get().getString(R.string.error_date)

        else ->
            SimpleDateFormat("dd.MM.yyyy" , Locale.getDefault())
                .format(Date(timestamp))
    }
}