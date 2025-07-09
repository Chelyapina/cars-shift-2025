package com.example.cars_shift_2025.di

import androidx.lifecycle.ViewModel
import com.example.cars_shift_2025.presentation.viewmodels.MainScreenViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainScreenViewModel::class)
    abstract fun bindMainScreenViewModel(viewModel : MainScreenViewModel) : ViewModel
}