package com.example.cars_shift_2025.di

import com.example.cars_shift_2025.data.CarApiFactory
import com.example.cars_shift_2025.data.CarApiService
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {
    @Provides
    fun provideCarApiService() : CarApiService {
        return CarApiFactory.apiService
    }
}