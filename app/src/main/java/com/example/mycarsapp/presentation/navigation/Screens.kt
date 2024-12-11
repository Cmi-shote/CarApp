package com.example.mycarsapp.presentation.navigation

import com.example.mycarsapp.presentation.domain.CarModelData
import kotlinx.serialization.Serializable

sealed class Screens {

    @Serializable
    data object StartScreen: Screens()

    @Serializable
    data class ViewGallery(val carModels: CarModelData): Screens()

    @Serializable
    data class ViewCarDetails(val carModels: CarModelData) : Screens()

}