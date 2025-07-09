package com.example.cars_shift_2025.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cars_shift_2025.presentation.viewmodels.CarWithRentsViewModel
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class DaggerViewModelFactory @Inject constructor(
    private val viewModelProviders : Map<Class<out ViewModel> , @JvmSuppressWildcards Provider<ViewModel>> ,
    private val carWithRentsFactory : CarWithRentsViewModel.Factory
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass : Class<T>) : T {
        val creator = viewModelProviders[modelClass]
            ?: throw IllegalArgumentException("Unknown ViewModel class: $modelClass")
        return creator.get() as T
    }

    fun create(carId : String) : CarWithRentsViewModel {
        return carWithRentsFactory.create(carId)
    }
}