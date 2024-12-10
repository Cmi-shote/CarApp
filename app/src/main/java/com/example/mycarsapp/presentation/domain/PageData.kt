package com.example.mycarsapp.presentation.domain

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import com.example.mycarsapp.R

data class PageData(
    @DrawableRes val backgroundImage: Int,
    val backgroundColor: Color = Color(0xFF101010),
    val title: String,
    val highlightedText: String,
    val contentText: String,
    val fontFamily: FontFamily,
    val highlightColor: Int,
    val buttonColor: Int,
    val buttonText: String,
    val onButtonClick: () -> Unit
)

//todo delete
val samplePages = listOf(
    PageData(
        backgroundImage = R.drawable.home_screen_image1,
        title = "Your Driving Experience Just Got",
        highlightedText = "BETTER!",
        contentText = "Explore the best cars at unbeatable prices.",
        fontFamily = FontFamily.Default,
        highlightColor = R.color.mustard_yellow,
        buttonColor = R.color.mustard_yellow,
        buttonText = "View Gallery >",
        onButtonClick = { /* TODO: Handle click */ }
    ),
    PageData(
        backgroundImage = R.drawable.home_screen_image2,
//        backgroundColor = Color.Black,
        title = "Unleash the Power of",
        highlightedText = "PERFORMANCE!",
        contentText = "Discover high-performance cars for every journey.",
        fontFamily = FontFamily.Default,
        highlightColor = R.color.mustard_yellow,
        buttonColor = R.color.mustard_yellow,
        buttonText = "Learn More >",
        onButtonClick = { /* TODO: Handle click */ }
    )
)
