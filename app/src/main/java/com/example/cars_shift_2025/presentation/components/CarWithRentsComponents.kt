package com.example.cars_shift_2025.presentation.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.cars_shift_2025.R
import com.example.cars_shift_2025.presentation.Dimens.IMAGE_CAR_HEIGHT_LARGE
import com.example.cars_shift_2025.presentation.Dimens.IMAGE_CAR_WIDTH_LARGE
import com.example.cars_shift_2025.presentation.Dimens.IMAGE_ROUNDED_CORNER_SHAPE
import com.example.cars_shift_2025.presentation.Dimens.PADDING_LARGE
import com.example.cars_shift_2025.presentation.Dimens.PADDING_SMALL
import com.example.cars_shift_2025.presentation.models.CarWithRentsUi
import com.example.cars_shift_2025.presentation.theme.Colors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarWithRentsTopBar(
    onBackClick : () -> Unit
) {
    TopAppBar(
        title = {
            Text(stringResource(R.string.name))
        } ,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent ,
            scrolledContainerColor = Color.Transparent
        ) ,
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_back) ,
                    contentDescription = stringResource(R.string.content_description_back) ,
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
            }
        }
    )
}

@Composable
fun CarWithRentsContent(
    car : CarWithRentsUi ,
    modifier : Modifier = Modifier ,
    onBackClick : () -> Unit ,
    onSaveClick : () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth() ,
        verticalArrangement = Arrangement.spacedBy(PADDING_LARGE)
    ) {
        CarImageSection(car.imageRes)
        CarTitleSection(car.title)
        CarCharacteristicsSection(car)
        CarPriceSection(car)
        ActionButtonsSection(
            onBackClick = onBackClick ,
            onSaveClick = onSaveClick
        )
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CarImageSection(
    imageUrl : String? ,
    modifier : Modifier = Modifier
) {
    Box(
        modifier = Modifier.fillMaxWidth() ,
        contentAlignment = Alignment.Center
    ) {
        val validUrl = imageUrl.takeIf { !it.isNullOrBlank() }

        GlideImage(
            model = validUrl ,
            contentDescription = stringResource(R.string.content_description_car_image) ,
            alignment = Alignment.Center ,
            modifier = modifier.size(IMAGE_CAR_WIDTH_LARGE , IMAGE_CAR_HEIGHT_LARGE) ,
            requestBuilderTransform = { requestBuilder ->
                requestBuilder
                    .placeholder(R.drawable.ic_car)
                    .error(R.drawable.ic_car)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .transform(RoundedCorners(IMAGE_ROUNDED_CORNER_SHAPE))
            }
        )
    }
}

@Composable
fun CarTitleSection(title : String) {
    Text(
        text = title ,
        modifier = Modifier.fillMaxWidth() ,
        style = MaterialTheme.typography.headlineMedium
    )
}

@Composable
fun CarCharacteristicsSection(car : CarWithRentsUi) {
    Column {
        SectionTitle(text = stringResource(R.string.characteristics_title))
        CharacteristicItem(label = stringResource(R.string.transmission) , value = car.transmission)
        CharacteristicItem(label = stringResource(R.string.steering) , value = car.steering)
        CharacteristicItem(label = stringResource(R.string.body_type) , value = car.bodyType)
        CharacteristicItem(label = stringResource(R.string.color) , value = car.color)
        CharacteristicItem(label = stringResource(R.string.price) , value = car.price)
    }
}

@Composable
private fun SectionTitle(text : String) {
    Text(
        text = text ,
        modifier = Modifier.fillMaxWidth() ,
        style = MaterialTheme.typography.bodyLarge
    )
    Spacer(modifier = Modifier.size(PADDING_LARGE))
}

@Composable
fun CarPriceSection(car : CarWithRentsUi) {
    Column {
        SectionTitle(
            text = stringResource(R.string.rent) + " ${car.startDate} - ${car.endDate}"
        )
    }
}

@Composable
fun ActionButtonsSection(
    onBackClick : () -> Unit ,
    onSaveClick : () -> Unit
) {
    TwoButtonGroup(
        firstButtonText = stringResource(R.string.button_back) ,
        secondButtonText = stringResource(R.string.button_save) ,
        onClickSecond = onSaveClick ,
        onClickFirst = onBackClick
    )
}

@Composable
fun CharacteristicItem(
    label : String ,
    value : String
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth() ,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            label.CharacteristicItemLabel(isSystemInDarkTheme())
            Text(text = value)
        }
        HorizontalDivider(
            modifier = Modifier.padding(vertical = PADDING_SMALL) ,
            thickness = 1.dp ,
            color = Color.Gray
        )
    }
}

@Composable
fun String.CharacteristicItemLabel(
    isDarkTheme : Boolean
) {
    if (isDarkTheme) Text(
        text = this ,
        style = MaterialTheme.typography.bodyMedium ,
        color = Colors.DarkTextSecondary
    ) else Text(
        text = this ,
        style = MaterialTheme.typography.bodyMedium ,
        color = Colors.LightTextSecondary
    )
}