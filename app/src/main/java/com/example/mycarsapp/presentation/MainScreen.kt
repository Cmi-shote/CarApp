package com.example.mycarsapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycarsapp.R
import com.example.mycarsapp.presentation.domain.PageData
import com.example.mycarsapp.presentation.domain.samplePages
import com.example.mycarsapp.ui.theme.MyCarsAppTheme

@Composable
fun PagerContent(pageData: PageData) {
    Box(modifier = Modifier.fillMaxSize()
//        .background(pageData.backgroundColor)
    ) {

        // Background Image
        Image(
            painter = painterResource(pageData.backgroundImage),
            contentDescription = "Page Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            alpha = 0.5f
        )

        Column(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.Center)
        ) {

            Text(
                text = buildAnnotatedString {
                    append(pageData.title)
                    withStyle(
                        style = SpanStyle(
                            color = colorResource(pageData.highlightColor)
                        )
                    ) {
                        append(" ${pageData.highlightedText}")
                    }
                },
                fontFamily = pageData.fontFamily,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 44.sp,
                color = Color.White,
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = pageData.contentText,
                fontFamily = pageData.fontFamily,
                fontSize = 15.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .width(350.dp)
            )

            Button(
                onClick = pageData.onButtonClick,
                modifier = Modifier
                    .padding(top = 16.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(pageData.buttonColor)
                )
            ) {
                Text(
                    text = pageData.buttonText,
                    style = MaterialTheme.typography.labelLarge,
                    color = Color.Black
                )
            }
        }
    }
}

@Preview
@Composable
fun PagerContentPreview() {
    val pageData = samplePages[0]
    MyCarsAppTheme {
        PagerContent(pageData)
    }
}