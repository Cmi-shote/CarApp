package com.example.mycarsapp.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.mycarsapp.presentation.carDetails.CarDetails
import com.example.mycarsapp.presentation.domain.CarModelData
import com.example.mycarsapp.presentation.gallery.Gallery
import com.example.mycarsapp.presentation.home.Home
import com.example.mycarsapp.utils.Constants
import kotlin.reflect.typeOf

@Composable
fun CarsNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.StartScreen) {
        composable<Screens.StartScreen> {
            Home()
        }

//        composable<Screens.ViewGallery> {
//            Gallery()
//        }
//
//        composable<Screens.ViewCarDetails> (
//            typeMap = mapOf(
//                typeOf<CarModelData>() to Constants.CustomNavType(
//                    CarModelData::class,
//                    CarModelData.serializer()
//                )
//            )
//        ) {
//            val myArguments = it.toRoute<Screens.ViewCarDetails>()
//            CarDetails(modifier = Modifier.fillMaxSize())
//        }
    }

}
