package com.example.cars_shift_2025.di

import android.app.Application
import com.example.cars_shift_2025.presentation.MainActivity
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
        NetworkModule::class
    ]
)
interface AppComponent {
    fun inject(activity : MainActivity)
    fun viewModelFactory() : DaggerViewModelFactory
    fun carWithRentsViewModelFactory() : CarWithRentsViewModel.Factory

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application : Application
        ) : AppComponent
    }
}