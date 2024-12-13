package com.example.mycarsapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.mycarsapp.presentation.carDetails.CarDetails
import com.example.mycarsapp.presentation.domain.CarModelData
import com.example.mycarsapp.presentation.domain.carItemsSample
import com.example.mycarsapp.presentation.gallery.Gallery
import com.example.mycarsapp.utils.CustomNavType
import kotlinx.serialization.Serializable
import kotlin.reflect.typeOf

@Composable
fun CarsNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = GalleryScreen) {
//        composable<Screens.StartScreen> {
//            Home()
//        }

        composable<GalleryScreen> {
            Gallery(
                carItemsSample,
                onClick = { carModelData->
                    navController.navigate(CarDetailsScreen(carModelData = carModelData))
                }
            )
        }

        composable<CarDetailsScreen>(
            typeMap = mapOf(
                typeOf<CarModelData>() to CustomNavType.CarModelType
            )
        ) {
            val arguments = it.toRoute<CarDetailsScreen>()
            CarDetails(
                arguments.carModelData,
                onClick = {
                    navController.popBackStack()
                }
            )
        }
    }

}

@Serializable
data object GalleryScreen

@Serializable
data class CarDetailsScreen(
    val carModelData: CarModelData
)
