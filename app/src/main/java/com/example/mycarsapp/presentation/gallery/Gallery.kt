package com.example.mycarsapp.presentation.gallery

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuDefaults.outlinedTextFieldColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycarsapp.R
import com.example.mycarsapp.presentation.domain.CarModelData
import com.example.mycarsapp.presentation.domain.carItemsSample
import com.example.mycarsapp.presentation.general.ScreenLayout
import com.example.mycarsapp.ui.theme.MyCarsAppTheme

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun Gallery(
    carItems: List<CarModelData>,
    modifier: Modifier = Modifier,
) {
    ScreenLayout {
        var searchText by remember {
            mutableStateOf("Search car model")
        }

        Column(
            modifier = modifier
                .fillMaxSize()
                .background(colorResource(R.color.mid_night_dark))
        ) {
            OutlinedTextField(
                value = searchText,
                onValueChange = { text ->
                    searchText = text
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp),
                colors = outlinedTextFieldColors(
                    cursorColor = Color.White, // Cursor color
                    focusedBorderColor = Color.White, // Border color when focused
                    unfocusedBorderColor = Color.Gray, // Border color when not focused
                ),
            )

            Spacer(modifier = Modifier.height(20.dp))

            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                maxItemsInEachRow = 3,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
            ) {
                carItems.forEach { carItem ->
                    CarGrid(
                        carModel = carItem,
                        modifier = Modifier.width(180.dp)
                    )
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GalleryPreview() {
    MyCarsAppTheme {
        Gallery(
            carItems = carItemsSample
        )
    }
}