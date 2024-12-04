package com.example.mycarsapp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycarsapp.R
import com.example.mycarsapp.presentation.domain.CarModelData
import com.example.mycarsapp.presentation.domain.carItemsSample
import com.example.mycarsapp.presentation.domain.toDisplayableNo
import com.example.mycarsapp.ui.theme.MyCarsAppTheme

@Composable
fun Gallery(
    carItems: List<CarModelData>,
    modifier: Modifier,
) {
    var searchText by remember {
        mutableStateOf("Search car model")
    }

    var selectedTabIndex by remember {
        mutableStateOf(0)
    }

    Column(modifier = modifier.fillMaxSize()) {
        OutlinedTextField(
            value = searchText,
            onValueChange = { text ->
                searchText = text
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 16.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(3)
        ) {
            items(carItems) {carItem ->
                CarGrid(carItem)
            }
        }
    }
}

@Composable
fun CarGrid(
    carModel: CarModelData,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .size(200.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(colorResource(R.color.dark_gray))
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
                colors = CardDefaults.cardColors(containerColor = colorResource(R.color.light_gray)),
        ) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_car),
                    contentDescription = "null",
                    modifier = Modifier
                        .size(200.dp)
                        .align(Alignment.Center)
                )

                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.star_1),
                    contentDescription = "star",
                    tint = colorResource(R.color.mustard_yellow),
                    modifier = Modifier
                        .size(25.dp)
                        .align(Alignment.BottomEnd)
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
        ) {
            Text(
                text = carModel.model,
                fontSize = 15.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
            )

            Text(
                text = carModel.size,
                color = Color.White,
                fontSize = 10.sp,
                lineHeight = 10.sp,
                fontWeight = FontWeight.Light,
            )

            Row(
                modifier = Modifier.fillMaxWidth().padding(bottom = 5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$ ${carModel.price.toDisplayableNo().formatted}",
                    color = Color.White,
                    fontSize = 15.sp,
                    modifier = Modifier.weight(1f)
                )

                Button(
                    onClick = {},
                    contentPadding = PaddingValues(vertical = 4.dp, horizontal = 8.dp),
                    modifier = Modifier
                        .height(25.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.mustard_yellow)
                    )
                ) {
                    Text(
                        text = "see more",
                        style = MaterialTheme.typography.labelSmall,
                        color = Color.Black
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
            carItems = carItemsSample,
            modifier = Modifier
        )
    }
}