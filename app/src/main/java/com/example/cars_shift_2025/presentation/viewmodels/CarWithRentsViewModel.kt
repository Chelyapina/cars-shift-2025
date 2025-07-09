package com.example.cars_shift_2025.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cars_shift_2025.domain.usecases.GetCarByIdUseCase
import com.example.cars_shift_2025.presentation.mappers.toUi
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CarWithRentsViewModel @AssistedInject constructor(
    private val getCarByIdUseCase: GetCarByIdUseCase,
    @Assisted private val carId: String
) : ViewModel() {
    @AssistedFactory
    interface Factory {
        fun create(carId: String): CarWithRentsViewModel
    }

    private val _state = MutableStateFlow<CarWithRentsState>(CarWithRentsState.Loading)
    val stateFlow: StateFlow<CarWithRentsState> = _state.asStateFlow()

    init {
        loadCarWithRents()
    }

    fun loadCarWithRents() {
        viewModelScope.launch {
            _state.value = CarWithRentsState.Loading
            val result = getCarByIdUseCase(carId)

            if (result.isSuccess) {
                val carWithRents = result.getOrNull()?.toUi()
                _state.value = if (carWithRents != null) {
                    CarWithRentsState.Success(carWithRents)
                } else {
                    CarWithRentsState.Error(
                        message = "Данные не найдены",
                        retryAction = ::loadCarWithRents
                    )
                }
            } else {
                val errorMessage = when (result.exceptionOrNull()?.message) {
                    "Ошибка сети" -> "Проблемы с интернетом"
                    "Ошибка сервера" -> "Ошибка сервера"
                    else -> "Неизвестная ошибка"
                }
                _state.value = CarWithRentsState.Error(
                    message = errorMessage,
                    retryAction = ::loadCarWithRents
                )
            }
        }
    }
}