package com.example.cars_shift_2025.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cars_shift_2025.data.CarApiFactory
import com.example.cars_shift_2025.data.CarRepositoryImpl
import com.example.cars_shift_2025.presentation.mappers.toUi
import com.example.cars_shift_2025.domain.usecases.GetCarsListUseCase
import com.example.cars_shift_2025.presentation.viewmodels.CarListState.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainScreenViewModel @Inject constructor(
    private val getCarsListUseCase: GetCarsListUseCase
) : ViewModel() {
    private val _state = MutableStateFlow<CarListState>(Loading)
    val stateFlow: StateFlow<CarListState> = _state.asStateFlow()

    init {
        loadCars()
    }

    fun loadCars() {
        viewModelScope.launch {
            _state.value = Loading
            val result = getCarsListUseCase()

            if (result.isSuccess) {
                val cars = result.getOrNull()
                _state.value = if (cars.isNullOrEmpty()) {
                    Empty
                } else {
                    Success(cars.map { it.toUi() })
                }
            } else {
                val errorMessage = when (result.exceptionOrNull()?.message) {
                    "Ошибка сети" -> "Проблемы с интернетом"
                    "Ошибка сервера" -> "Ошибка сервера"
                    else -> "Неизвестная ошибка"
                }
                _state.value = Error(
                    message = errorMessage,
                    retryAction = ::loadCars
                )
            }
        }
    }
}