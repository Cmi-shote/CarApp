package com.example.mycarsapp.presentation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycarsapp.R
import com.example.mycarsapp.ui.theme.MyCarsAppTheme

@Composable
fun TopBarAndBackground(
    @DrawableRes backgroundImage: Int,
    modifier: Modifier = Modifier,
    fontFamily: FontFamily = FontFamily(
        Font(R.font.inter_variablefont_opsz_wght)
    )
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(R.color.mid_night_dark))
            .padding(horizontal = 16.dp)
            .padding(bottom = 16.dp)
    ) {
        Image(
            painter = painterResource(backgroundImage),
            contentDescription = "Car Image",
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            contentScale = ContentScale.Crop
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()
        ) {

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_car_logo),
                contentDescription = "Car Icon",
                tint = colorResource(R.color.mustard_yellow),
                modifier = Modifier.size(15.dp)
            )

            Text(
                text = "MiCARZ",
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 10.sp,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 5.dp)
            )
        }

        MainScreen(
            titleText = "anotatedString",
            contentText = stringResource(R.string.lorem_ipsum),
            fontFamily = fontFamily,
            modifier = Modifier.fillMaxWidth().padding(top = 30.dp)
        )
    }
}

@Preview
@Composable
fun TopBarPreview() {
    MyCarsAppTheme {
        TopBarAndBackground(
            backgroundImage = R.drawable.home_screen_image1,
            modifier = Modifier.fillMaxSize()
        )
    }
}