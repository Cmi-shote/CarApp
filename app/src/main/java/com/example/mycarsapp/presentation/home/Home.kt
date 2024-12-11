package com.example.mycarsapp.presentation.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mycarsapp.presentation.domain.samplePages
import com.example.mycarsapp.presentation.general.ScreenLayout
import com.example.mycarsapp.presentation.general.ViewPagerSlider
import com.example.mycarsapp.ui.theme.MyCarsAppTheme

@Composable
fun Home(modifier: Modifier = Modifier) {
    ScreenLayout {
        ViewPagerSlider(
            pages = samplePages,
            modifier = modifier.fillMaxSize(),
            content = { pageData -> PagerContent(pageData) }
        )
    }
}

@Preview
@Composable
fun HomePreview() {
    MyCarsAppTheme {
        Home(
            modifier = Modifier.fillMaxSize()
        )
    }
}