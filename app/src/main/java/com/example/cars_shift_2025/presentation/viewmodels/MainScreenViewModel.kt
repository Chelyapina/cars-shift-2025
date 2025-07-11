package com.example.cars_shift_2025.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cars_shift_2025.domain.models.Car
import com.example.cars_shift_2025.domain.models.FilterParams
import com.example.cars_shift_2025.domain.usecases.GetCarsListUseCase
import com.example.cars_shift_2025.presentation.mappers.UiFormatters
import com.example.cars_shift_2025.presentation.mappers.toUi
import com.example.cars_shift_2025.presentation.models.CarUi
import com.example.cars_shift_2025.presentation.viewmodels.CarListState.Empty
import com.example.cars_shift_2025.presentation.viewmodels.CarListState.Error
import com.example.cars_shift_2025.presentation.viewmodels.CarListState.Loading
import com.example.cars_shift_2025.presentation.viewmodels.CarListState.Success
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainScreenViewModel @Inject constructor(
    private val getCarsListUseCase : GetCarsListUseCase ,
    internal val uiFormatters : UiFormatters
) : ViewModel() {
    private val _state = MutableStateFlow<CarListState>(Loading)
    val stateFlow : StateFlow<CarListState> = _state.asStateFlow()

    private var _originalCars: List<Car> = emptyList()
    val originalCars: List<Car> get() = _originalCars

    init {
        loadCars()
    }

    fun retryLoad() {
        loadCars()
    }

    fun updateFilteredCars(filtered: List<CarUi>) {
        _state.value = Success(filtered)
    }

    fun applyFilters(filterParams: FilterParams): List<CarUi> {
        return originalCars
            .filter { car ->
                filterParams.brand?.let { car.brand == it } ?: true &&
                        filterParams.transmission?.let { car.transmission == it } ?: true &&
                        filterParams.bodyType?.let { car.bodyType == it } ?: true &&
                        filterParams.color?.let { car.color == it } ?: true &&
                        filterParams.maxPrice?.let { car.price <= it } ?: true
            }
            .map { it.toUi(uiFormatters) }
    }

    private fun loadCars() {
        viewModelScope.launch {
            _state.value = Loading
            val result = getCarsListUseCase()

            if (result.isSuccess) {
                val cars = result.getOrNull()
                _originalCars = cars ?: emptyList()
                _state.value = if (cars.isNullOrEmpty()) {
                    Empty
                } else {
                    Success(cars.map { it.toUi(uiFormatters) })
                }
            } else {
                _state.value = when {
                    result.isSuccess && !result.getOrNull().isNullOrEmpty() -> {
                        Success(result.getOrNull()!!.map { it.toUi(uiFormatters) })
                    }

                    result.isSuccess -> Empty
                    else -> Error(uiFormatters.formatError(result.exceptionOrNull()))
                }
            }
        }
    }
}