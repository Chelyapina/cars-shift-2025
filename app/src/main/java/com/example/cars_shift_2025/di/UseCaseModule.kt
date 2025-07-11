package com.example.cars_shift_2025.di

import com.example.cars_shift_2025.data.CarRepositoryImpl
import com.example.cars_shift_2025.domain.usecases.FilterCarsUseCase
import com.example.cars_shift_2025.domain.usecases.GetCarByIdUseCase
import com.example.cars_shift_2025.domain.usecases.GetCarsListUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {
    @Provides
    fun provideGetCarsListUseCase(repository : CarRepositoryImpl) : GetCarsListUseCase {
        return GetCarsListUseCase(repository)
    }

    @Provides
    fun provideGetCarByIdUseCase(repository : CarRepositoryImpl) : GetCarByIdUseCase {
        return GetCarByIdUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideFilterCarsUseCase(): FilterCarsUseCase = FilterCarsUseCase()
}