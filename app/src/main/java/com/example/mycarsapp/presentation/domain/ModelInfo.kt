package com.example.mycarsapp.presentation.domain

import androidx.annotation.DrawableRes
import com.example.mycarsapp.R

data class ModelInfo(
    val title: Int,
    val value: String,
    val unit: String,
    val speed: String,
    @DrawableRes val imageId: Int,
)

val sampleInfo = listOf(
    ModelInfo(
        title = R.string.acceleration,
        value = "5.6",
        unit = "sec",
        speed = "0-60 mph",
        imageId = R.drawable.ic_accelerator
    ),
    ModelInfo(
        title = R.string.power,
        value = "410",
        unit = "hp",
        speed = "5000-5250 rpm",
        imageId = R.drawable.ic_power
    ),
    ModelInfo(
        title = R.string.torque,
        value = "450",
        unit = "lb-ft",
        speed = "2000-2500 rpm",
        imageId = R.drawable.ic_torque
    ),
)