package com.example.mycarsapp.presentation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycarsapp.R
import com.example.mycarsapp.presentation.domain.samplePages
import com.example.mycarsapp.ui.theme.MyCarsAppTheme

@Composable
fun TopBarAndBackground(
    modifier: Modifier = Modifier,
    fontFamily: FontFamily = FontFamily(
        Font(R.font.inter_variablefont_opsz_wght)
    )
) {

    val options = listOf("HOME", "ABOUT", "GALLERY")

    var selectedOption by remember {
        mutableStateOf(options[0])
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(R.color.mid_night_dark))
            .padding(horizontal = 16.dp)
            .padding(top = WindowInsets.statusBars.asPaddingValues().calculateBottomPadding())
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
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

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {

            options.forEach { option ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .clickable { selectedOption = option } // Update selected option on click
                        .padding(horizontal = 10.dp)
                ) {
                    // Option text
                    Text(
                        text = option,
                        color = Color.White,
                        fontFamily = fontFamily,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                    )

                    // Underline indicator
                    Spacer(
                        modifier = Modifier
                            .height(2.dp)
                            .width(40.dp)
                            .background(if (selectedOption == option) colorResource(R.color.mustard_yellow) else Color.Transparent) // Only show underline for selected
                    )
                }
            }


            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.mustard_yellow),
                ),
                contentPadding = PaddingValues(vertical = 4.dp, horizontal = 8.dp), // Reduce inner padding to make button smaller
                modifier = Modifier
                    .height(30.dp)
            ) {
                Text(
                    text = "LOGIN",
                    style = TextStyle(
                        fontFamily = fontFamily,
                        fontSize = 10.sp, // Keep font size as desired
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                )
            }
        }

        ViewPagerSlider(
            pages = samplePages
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun TopBarPreview() {
    MyCarsAppTheme {
        TopBarAndBackground(
            modifier = Modifier.fillMaxSize()
        )
    }
}