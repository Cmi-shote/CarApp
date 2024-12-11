package com.example.mycarsapp.presentation.gallery

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycarsapp.R
import com.example.mycarsapp.presentation.domain.CarModelData
import com.example.mycarsapp.presentation.domain.toDisplayableNo

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
            .padding()
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
                Image(
                    painter = painterResource(carModel.backgroundImage[0]),
                    contentDescription = "null",
                    modifier = Modifier
                        .size(150.dp)
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
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp),
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