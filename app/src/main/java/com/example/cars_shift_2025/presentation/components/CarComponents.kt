package com.example.cars_shift_2025.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.cars_shift_2025.R
import com.example.cars_shift_2025.presentation.Dimens
import com.example.cars_shift_2025.presentation.Dimens.IMAGE_CAR_HEIGHT
import com.example.cars_shift_2025.presentation.Dimens.IMAGE_CAR_WIDTH
import com.example.cars_shift_2025.presentation.models.CarUi

@Composable
fun CarList(
    cars : List<CarUi> ,
    modifier : Modifier = Modifier ,
    onCarClick : (CarUi) -> Unit
) {
    LazyColumn(modifier) {
        items(
            count = cars.size ,
            key = { index -> cars[index].id }
        ) { index ->
            val car = cars[index]
            CarItem(car , onCarClick)
        }
    }
}

@Composable
private fun CarItem(
    car : CarUi ,
    onCarClick : (CarUi) -> Unit ,
    modifier : Modifier = Modifier
) {
    Card(
        onClick = { onCarClick(car) } ,
        modifier = modifier
            .fillMaxWidth()
            .padding(Dimens.PADDING_NULL , Dimens.PADDING_SMALL) ,
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically ,
        ) {
            CarImage(car.imageRes)
            Spacer(modifier = Modifier.size(Dimens.PADDING_LARGE))
            CarInfo(car.title , car.transmission , car.price)
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CarImage(
    imageUrl : String? ,
    modifier : Modifier = Modifier
) {
    val validUrl = imageUrl.takeIf { !it.isNullOrBlank() }

    GlideImage(
        model = validUrl ,
        contentDescription = stringResource(R.string.content_description_car_image) ,
        alignment = Alignment.Center ,
        modifier = modifier.size(IMAGE_CAR_WIDTH , IMAGE_CAR_HEIGHT) ,
        requestBuilderTransform = { requestBuilder ->
            requestBuilder
                .placeholder(R.drawable.ic_car)
                .error(R.drawable.ic_car)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
        }
    )
}

@Composable
private fun CarInfo(title : String , transmission : String , price : String) {
    Column {
        Spacer(modifier = Modifier.size(Dimens.PADDING_SMALL))
        Text(title)
        Spacer(modifier = Modifier.size(Dimens.PADDING_SMALL))
        Text(transmission)
        Spacer(modifier = Modifier.size(Dimens.PADDING_SMALL))
        Text(price)
        Spacer(modifier = Modifier.size(Dimens.PADDING_SMALL))
    }
}