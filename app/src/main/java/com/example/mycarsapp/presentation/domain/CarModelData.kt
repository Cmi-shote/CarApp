package com.example.mycarsapp.presentation.domain

import com.example.mycarsapp.R
import kotlinx.serialization.Serializable
import java.text.NumberFormat
import java.util.Locale

@Serializable
data class CarModelData(
    val backgroundImage: List<Int>,
    val model: String,
    val size: String,
    val price: String
)

data class DisplayableNumber(
    val value: String,
    val formatted: String
)

val carItemsSample = listOf(
    CarModelData(
        backgroundImage = listOf(R.drawable.silver_jeep, R.drawable.red_jeep, R.drawable.blue_jeep),
        model = "GS-570",
        size = "Medium",
        price = "568090"
    ),
    CarModelData(
        backgroundImage = listOf(R.drawable.silver_car),
        model = "GS-570",
        size = "Medium",
        price = "568090"
    ),
    CarModelData(
        backgroundImage = listOf(R.drawable.ic_car),
        model = "GS-570",
        size = "Medium",
        price = "568090"
    ),
)

fun String.toDisplayableNo(): DisplayableNumber {
    // Parse the string to a number (assuming the string is a valid number)
    val number = this.toLongOrNull() ?: 0L  // Default to 0 if parsing fails

    // Create a NumberFormat instance to format the number with commas
    val formatter = NumberFormat.getNumberInstance(Locale.getDefault()).apply {
        minimumFractionDigits = 0 // No decimal places for price
        maximumFractionDigits = 0
    }

    // Format the number and return a DisplayableNumber object
    return DisplayableNumber(
        value = this,
        formatted = formatter.format(number)
    )
}