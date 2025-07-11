package com.example.cars_shift_2025.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.example.cars_shift_2025.domain.models.BodyType
import com.example.cars_shift_2025.domain.models.Brand
import com.example.cars_shift_2025.domain.models.Car
import com.example.cars_shift_2025.domain.models.Color
import com.example.cars_shift_2025.domain.models.FilterParams
import com.example.cars_shift_2025.domain.models.Transmission
import com.example.cars_shift_2025.presentation.mappers.UiFormatters
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class FilterViewModel @Inject constructor(
    private val uiFormatters: UiFormatters
) : ViewModel() {

    data class UiParamState(
        val availableBrands: List<String>,
        val availableTransmissions: List<String>,
        val availableBodyTypes: List<String>,
        val availableColors: List<String>,
        val selectedBrand: String? = null,
        val selectedTransmission: String? = null,
        val selectedBodyType: String? = null,
        val selectedColor: String? = null,
        val maxPrice: Long? = null
    )

    private var _originalCars: List<Car> = emptyList()
    private val _uiState = MutableStateFlow(loadInitialState())
    val uiState: StateFlow<UiParamState> = _uiState.asStateFlow()

    fun initWithCars(cars: List<Car>) {
        _originalCars = cars
        _uiState.value = loadInitialState()
    }

    private fun loadInitialState(): UiParamState {
        return with(uiFormatters) {
            UiParamState(
                availableBrands = _originalCars.map { it.brand.toUi }.distinct(),
                availableTransmissions = Transmission.entries.map { it.toUi },
                availableBodyTypes = BodyType.entries.map { it.toUi },
                availableColors = Color.entries.map { it.toUi }
            )
        }
    }

    fun updateSelection(
        brand: String? = null,
        transmission: String? = null,
        bodyType: String? = null,
        color: String? = null,
        price: Long? = null
    ) {
        _uiState.update { current ->
            current.copy(
                selectedBrand = brand ?: current.selectedBrand,
                selectedTransmission = transmission ?: current.selectedTransmission,
                selectedBodyType = bodyType ?: current.selectedBodyType,
                selectedColor = color ?: current.selectedColor,
                maxPrice = price ?: current.maxPrice
            )
        }
    }

    fun getCurrentFilter(): FilterParams {
        return with(uiState.value) {
            FilterParams(
                brand = selectedBrand?.let { str ->
                    Brand.entries.first {
                        val brand = it
                        uiFormatters.run { brand.toUi } == str
                    }
                },
                transmission = selectedTransmission?.let { str ->
                    Transmission.entries.first {
                        val transmission = it
                        uiFormatters.run { transmission.toUi } == str
                    }
                },
                bodyType = selectedBodyType?.let { str ->
                    BodyType.entries.first {
                        val bodyType = it
                        uiFormatters.run { bodyType.toUi } == str
                    }
                },
                color = selectedColor?.let { str ->
                    Color.entries.first {
                        val color = it
                        uiFormatters.run { color.toUi } == str
                    }
                },
                maxPrice = maxPrice
            )
        }
    }
}