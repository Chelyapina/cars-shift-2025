package com.example.cars_shift_2025.di

import android.app.Application
import com.example.cars_shift_2025.presentation.MainActivity
import com.example.cars_shift_2025.presentation.mappers.DateFormatter
import com.example.cars_shift_2025.presentation.mappers.UiFormatters
import com.example.cars_shift_2025.presentation.viewmodels.CarWithRentsViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ViewModelModule::class ,
        UseCaseModule::class ,
        RepositoryModule::class ,
        NetworkModule::class ,
        AppModule::class
    ]
)
interface AppComponent {
    fun inject(activity : MainActivity)
    fun viewModelFactory() : DaggerViewModelFactory
    fun carWithRentsViewModelFactory() : CarWithRentsViewModel.Factory
    fun stringProvider() : StringProvider
    fun dateFormatter() : DateFormatter
    fun uiFormatters() : UiFormatters

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application : Application
        ) : AppComponent
    }
}