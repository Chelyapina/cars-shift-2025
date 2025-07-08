package com.example.cars_shift_2025.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.cars_shift_2025.R

@Composable
fun SearchBar(
    text : String ,
    onTextChange : (String) -> Unit ,
    modifier : Modifier = Modifier
) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth() ,
        value = text ,
        onValueChange = onTextChange ,
        singleLine = true ,
        label = { Text(stringResource(R.string.search)) } ,
        placeholder = { Text(stringResource(R.string.search)) }
    )
}

@Composable
fun FilterButton(
    onClick : () -> Unit ,
    modifier : Modifier = Modifier
) {
    Button(
        modifier = modifier.fillMaxWidth() ,
        onClick = onClick ,
        contentPadding = ButtonDefaults.ButtonWithIconContentPadding ,
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_tune) ,
            contentDescription = stringResource(R.string.content_description_tune) ,
            modifier = Modifier.size(ButtonDefaults.IconSize) ,
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(stringResource(R.string.tune))
    }
}

@Composable
fun EmptyState(modifier : Modifier = Modifier) {
    Text(
        text = stringResource(R.string.empty_state) ,
        modifier = modifier
    )
}