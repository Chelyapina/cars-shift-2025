package com.example.cars_shift_2025.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.cars_shift_2025.domain.models.FilterParams
import com.example.cars_shift_2025.presentation.components.CarWithRentsTopBar
import com.example.cars_shift_2025.presentation.components.TwoButtonGroup
import com.example.cars_shift_2025.presentation.viewmodels.FilterViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterScreen(
    viewModel: FilterViewModel = viewModel(),
    navController: NavController,
    onApplyFilters: (FilterParams) -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        topBar = {
            CarWithRentsTopBar(
                onBackClick = { navController.popBackStack() }
            )
        },
        bottomBar = {
            TwoButtonGroup(
                firstButtonText = "Сбросить",
                secondButtonText = "Применить",
                onClickFirst = {
                    viewModel.updateSelection(
                        brand = null,
                        transmission = null,
                        bodyType = null,
                        color = null,
                        price = null
                    )
                    navController.popBackStack()
                },
                onClickSecond = {
                    onApplyFilters(viewModel.getCurrentFilter())
                    navController.popBackStack()
                }
            )
        },
        content = { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
            ) {
                item {
                    FiltersContent(
                        uiState = uiState,
                        onBrandSelected = { viewModel.updateSelection(brand = it) },
                        onTransmissionSelected = { viewModel.updateSelection(transmission = it) },
                        onBodyTypeSelected = { viewModel.updateSelection(bodyType = it) },
                        onColorSelected = { viewModel.updateSelection(color = it) },
                        onPriceChanged = { viewModel.updateSelection(price = it) },
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                }
            }
        }
    )
}

@Composable
fun FiltersContent(
    uiState: FilterViewModel.UiParamState,
    onBrandSelected: (String?) -> Unit,
    onTransmissionSelected: (String?) -> Unit,
    onBodyTypeSelected: (String?) -> Unit,
    onColorSelected: (String?) -> Unit,
    onPriceChanged: (Long?) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {

        FilterDropdownMenu(
            title = "Бренд",
            items = uiState.availableBrands,
            selectedId = uiState.selectedBrand,
            onItemSelected = onBrandSelected
        )

        Spacer(Modifier.height(16.dp))

        FilterSegmentedButtons(
            title = "Коробка передач",
            items = uiState.availableTransmissions,
            selectedId = uiState.selectedTransmission,
            onItemSelected = onTransmissionSelected
        )

        Spacer(Modifier.height(16.dp))

        FilterDropdownMenu(
            title = "Тип кузова",
            items = uiState.availableBodyTypes,
            selectedId = uiState.selectedBodyType,
            onItemSelected = onBodyTypeSelected
        )

        Spacer(Modifier.height(16.dp))

        FilterDropdownMenu(
            title = "Цвет",
            items = uiState.availableColors,
            selectedId = uiState.selectedColor,
            onItemSelected = onColorSelected
        )

        Spacer(Modifier.height(16.dp))

        PriceSlider(
            currentPrice = uiState.maxPrice ?: 50000L,
            onPriceChanged = onPriceChanged
        )
    }
}

@Composable
fun PriceSlider(
    currentPrice: Long,
    onPriceChanged: (Long) -> Unit
) {
    var sliderPosition by remember { mutableStateOf(currentPrice.toFloat()) }

    Column {
        Text(text = "Максимальная цена: ${currentPrice.toInt()} ₽")
        Slider(
            value = sliderPosition,
            onValueChange = {
                sliderPosition = it
                onPriceChanged(it.toLong())
            },
            valueRange = 0f..50000f,
            steps = 10
        )
    }
}


@Composable
fun FilterSegmentedButtons(
    title: String,
    items: List<String>,
    selectedId: String?,
    onItemSelected: (String?) -> Unit
) {
    Column {
      Text(title)
        SingleChoiceSegmentedButtonRow {
            items.forEach { item ->
                SegmentedButton(
                    shape = MaterialTheme.shapes.small,
                    onClick = { onItemSelected(if (selectedId == item) null else item) },
                    selected = selectedId == item,
                    colors = SegmentedButtonDefaults.colors(
                        activeContainerColor = MaterialTheme.colorScheme.primaryContainer,
                        inactiveContainerColor = MaterialTheme.colorScheme.surface
                    )
                ) {
                    Text(item)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterDropdownMenu(
    title: String,
    items: List<String>,
    selectedId: String?,
    onItemSelected: (String?) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = it }
    ) {
        TextField(
            modifier = Modifier.menuAnchor().fillMaxWidth(),
            value = selectedId ?: "Любой $title",
            onValueChange = {},
            readOnly = true,
            label = { Text(title) },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded) }
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                text = { Text("Любой $title") },
                onClick = {
                    onItemSelected(null)
                    expanded = false
                }
            )
            items.forEach { item ->
                DropdownMenuItem(
                    text = { Text(item) },
                    onClick = {
                        onItemSelected(item)
                        expanded = false
                    }
                )
            }
        }
    }
}