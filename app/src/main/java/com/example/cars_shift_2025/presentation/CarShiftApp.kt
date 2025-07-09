package com.example.cars_shift_2025.presentation

import android.app.Application
import com.example.cars_shift_2025.di.AppComponent
import com.example.cars_shift_2025.di.DaggerAppComponent

class CarShiftApp : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory()
            .create(this)
    }
}