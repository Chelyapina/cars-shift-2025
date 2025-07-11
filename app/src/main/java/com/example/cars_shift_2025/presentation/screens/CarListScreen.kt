package com.example.cars_shift_2025.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.cars_shift_2025.R
import com.example.cars_shift_2025.presentation.Dimens
import com.example.cars_shift_2025.presentation.components.CarList
import com.example.cars_shift_2025.presentation.components.EmptyState
import com.example.cars_shift_2025.presentation.components.FilterButton
import com.example.cars_shift_2025.presentation.components.SearchBar
import com.example.cars_shift_2025.presentation.models.CarUi

@Composable
fun CarListScreen(
    cars : List<CarUi> ,
    onCarClick : (String) -> Unit ,
    onClickFilterButton : () -> Unit
) {
    var searchText by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.padding(Dimens.PADDING_LARGE) ,
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxWidth() ,
                verticalArrangement = Arrangement.Center ,
                content = {
                    Text(
                        text = stringResource(R.string.name) ,
                        style = MaterialTheme.typography.headlineLarge
                    )
                    Spacer(modifier = Modifier.size(Dimens.PADDING_SMALL))

                    SearchBar(
                        text = searchText ,
                        onTextChange = { searchText = it }
                    )

                    Spacer(modifier = Modifier.size(Dimens.PADDING_SMALL))

                    FilterButton(onClick = {
                        onClickFilterButton()
                    })

                    if (cars.isEmpty()) {
                        EmptyState()
                    } else {
                        CarList(
                            cars = cars ,
                            onCarClick = { car ->
                                onCarClick(car.id)
                            }
                        )
                    }
                }
            )
        }
    )
}
