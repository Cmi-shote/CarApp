package com.example.mycarsapp.presentation.general

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.example.mycarsapp.R

@Composable
fun ScreenLayout(content: @Composable () -> Unit) {
    Scaffold(
        topBar = { CustomTopBar() },
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
        content = { innerPadding ->
            Box (modifier = Modifier
                .padding(innerPadding)
                .background(colorResource(R.color.mid_night_dark)) // Set background color here
            ) {
                content()
            }
        }
    )
}
