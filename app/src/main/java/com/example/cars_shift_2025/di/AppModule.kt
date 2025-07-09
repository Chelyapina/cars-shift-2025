package com.example.cars_shift_2025.di

import android.app.Application
import android.content.Context
import com.example.cars_shift_2025.presentation.mappers.DateFormatter
import com.example.cars_shift_2025.presentation.mappers.ErrorFormatter
import com.example.cars_shift_2025.presentation.mappers.UiFormatters
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideContext(application : Application) : Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun provideStringProvider(context : Context) : StringProvider {
        return AndroidStringProvider(context)
    }

    @Provides
    @Singleton
    fun provideDateFormatter(stringProvider : StringProvider) : DateFormatter {
        return DateFormatter(stringProvider)
    }

    @Provides
    @Singleton
    fun provideUiFormatters(
        stringProvider : StringProvider ,
        dateFormatter : DateFormatter ,
        errorFormatter : ErrorFormatter
    ) : UiFormatters {
        return UiFormatters(stringProvider , dateFormatter , errorFormatter)
    }
}