package com.example.mycarsapp.utils

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import com.example.mycarsapp.presentation.domain.CarModelData
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object CustomNavType {
    val CarModelType = object : NavType<CarModelData>(
        isNullableAllowed = false
    ) {
        override fun get(bundle: Bundle, key: String): CarModelData? {
            return Json.decodeFromString(bundle.getString(key) ?: return null)
        }

        override fun parseValue(value: String): CarModelData {
            return Json.decodeFromString(Uri.decode(value))
        }

        override fun serializeAsValue(value: CarModelData): String {
            return Uri.encode(Json.encodeToString(value))
        }

        override fun put(bundle: Bundle, key: String, value: CarModelData) {
            bundle.putString(key, Json.encodeToString(value))
        }

    }

}