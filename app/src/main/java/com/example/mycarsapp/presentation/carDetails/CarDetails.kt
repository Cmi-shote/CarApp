package com.example.mycarsapp.presentation.carDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycarsapp.R
import com.example.mycarsapp.presentation.domain.CarModelData
import com.example.mycarsapp.presentation.domain.carItemsSample
import com.example.mycarsapp.presentation.domain.sampleInfo
import com.example.mycarsapp.presentation.domain.toDisplayableNo
import com.example.mycarsapp.presentation.general.ScreenLayout
import com.example.mycarsapp.presentation.general.ViewPagerSlider
import com.example.mycarsapp.ui.theme.MyCarsAppTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CarDetails(
    carModelData: CarModelData,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    ScreenLayout {
        Column(
            modifier = modifier
//                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .background(colorResource(R.color.mid_night_dark))
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.baseline_arrow_back_24),
                    contentDescription = null,
                    tint = colorResource(R.color.mustard_yellow),
                    modifier = Modifier.weight(0.25f).clickable {
                        onClick()
                    }
                )

                Text(
                    text = carModelData.model,
                    fontSize = 20.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(0.5f)
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.star_1),
                        contentDescription = "star",
                        tint = colorResource(R.color.mustard_yellow),
                        modifier = Modifier
                            .size(25.dp)
                            .padding(end = 5.dp)
                    )

                    Text(
                        text = "$ " + carModelData.price.toDisplayableNo().formatted,
                        fontSize = 15.sp,
                        color = Color.White
                    )
                }
            }

            ViewPagerSlider(
                pages = carModelData.backgroundImage,
                modifier = Modifier
                    .height(250.dp)
                    .align(Alignment.CenterHorizontally),
                content = { car -> CarImageSlider(car) }
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Text(
                    text = stringResource(R.string.overview),
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = stringResource(R.string.lorem_ipsum),
                    fontSize = 15.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    maxItemsInEachRow = 3,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    sampleInfo.forEach { info ->
                        ModelInformation(info)
                    }
                }
            }
        }
    }
}


@Preview(
    showBackground = true,
)
@Composable
fun CarDetailsPreview() {
    MyCarsAppTheme {
        CarDetails(
            carModelData = carItemsSample[0],
            modifier = Modifier,
            {}
        )
    }
}