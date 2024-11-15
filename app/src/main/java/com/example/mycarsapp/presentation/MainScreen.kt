package com.example.mycarsapp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycarsapp.R
import com.example.mycarsapp.ui.theme.MyCarsAppTheme

@Composable
fun MainScreen(
    titleText: String,
    contentText: String,
    fontFamily: FontFamily,
    modifier: Modifier = Modifier
) {
    val options = listOf("HOME", "ABOUT", "GALLERY")

    var selectedOption by remember {
        mutableStateOf(options[0])
    }

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {

            options.forEach { option ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .clickable { selectedOption = option } // Update selected option on click
                        .padding(horizontal = 16.dp)
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

        Spacer(modifier = Modifier.height(120.dp))

        Text(
            text = buildAnnotatedString {
                append("Your Driving Experience Just Got")
                withStyle(
                    style = SpanStyle(
                        color = colorResource(R.color.mustard_yellow),
                    )
                ) {
                    append(" BETTER!")
                }
            },
            fontFamily = fontFamily,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 44.sp,
            color = Color.White,
            modifier = Modifier.padding(top = 16.dp).fillMaxWidth()
        )

        Text(
            text = contentText,
            fontFamily = fontFamily,
            fontSize = 15.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 16.dp).width(350.dp)
        )

        Button(
            modifier = Modifier.padding(top = 16.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.mustard_yellow), // Background color
            ),
            onClick = { /*TODO*/ }
        ) {
            Text(
                text = "View Gallery" + "  " + ">",
                style = TextStyle(
                    fontFamily = fontFamily,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Black,
                    color = Color.Black
                ),
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .align(Alignment.CenterVertically)
            )
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MyCarsAppTheme {
        MainScreen(
            titleText = "Android",
            contentText = stringResource(R.string.lorem_ipsum),
            fontFamily = FontFamily(
                Font(R.font.inter_variablefont_opsz_wght)
            ),
            modifier = Modifier.fillMaxSize()
        )
    }
}