package com.example.cars_shift_2025.di

import com.example.cars_shift_2025.data.CarRepositoryImpl
import com.example.cars_shift_2025.domain.CarRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun bindCarRepository(impl : CarRepositoryImpl) : CarRepository
}