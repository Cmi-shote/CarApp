package com.example.mycarsapp.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycarsapp.R
import com.example.mycarsapp.presentation.domain.PageData
import com.example.mycarsapp.presentation.domain.samplePages
import com.example.mycarsapp.ui.theme.MyCarsAppTheme
import kotlinx.coroutines.delay

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ViewPagerSlider(
    pages: List<PageData>, // Each page data holds the required properties
    autoScrollDelay: Long = 2000L // Delay for auto-scroll
) {
    val pagerState = rememberPagerState(pageCount = { pages.size })

    // Auto-scroll logic
    LaunchedEffect(pagerState) {
        while (true) {
            delay(autoScrollDelay)
            val nextPage = (pagerState.currentPage + 1) % pages.size
            pagerState.animateScrollToPage(nextPage)
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            PagerContent(pageData = pages[page])
        }

        HorizontalPagerIndicatorCustom(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(
                    bottom = WindowInsets.navigationBars
                        .asPaddingValues()
                        .calculateBottomPadding() + 16.dp
                ),
            activeColor = colorResource(R.color.mustard_yellow),
            inactiveColor = Color.Gray
        )
    }
}

// Custom Horizontal Pager Indicator
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerIndicatorCustom(
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    activeColor: Color,
    inactiveColor: Color
) {
    val pageCount = pagerState.pageCount
    val currentPage = pagerState.currentPage

    // Add indicator logic
    Box(modifier = modifier) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            repeat(pageCount) { index ->
                Box(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .size(8.dp)
                        .background(
                            if (index == currentPage) activeColor else inactiveColor,
                            shape = CircleShape
                        )
                )
            }
        }
    }
}

@Preview
@Composable
fun ViewPagerSliderPreview() {
    MyCarsAppTheme {
        ViewPagerSlider(pages = samplePages)
    }
}
