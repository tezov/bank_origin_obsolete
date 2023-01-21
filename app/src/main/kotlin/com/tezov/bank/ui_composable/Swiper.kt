package com.tezov.bank.ui_composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.tezov.lib_core_android_kotlin.ui.theme.definition.colorsWidgetExtended
import com.tezov.lib_core_android_kotlin.ui.theme.definition.dimensionsPaddingExtended
import com.tezov.lib_core_android_kotlin.ui.theme.definition.dimensionsWidgetExtended
import com.tezov.lib_core_android_kotlin.ui.theme.definition.shapeWidgetExtended

object Swiper {


    @OptIn(ExperimentalPagerApi::class, ExperimentalPagerApi::class)
    @Composable
    fun Pager(
        modifier: Modifier = Modifier,
        pages: List<@Composable () -> Unit>,
        pageSelected: Int = 0,
        onPageChange: (pageIndex: Int) -> Unit
    ) {
        val pagerState = rememberPagerState()
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalPager(
                modifier = modifier
                    .fillMaxWidth()
                    .weight(1f),
                count = pages.size, state = pagerState,
            ) { pageIndex ->
                pages[pageIndex].invoke()
            }
            HorizontalPagerIndicator(
                pagerState = pagerState,
                modifier = Modifier
                    .padding(top = MaterialTheme.dimensionsPaddingExtended.elementSmall_v),
                indicatorWidth = MaterialTheme.dimensionsWidgetExtended.swiperPagerIndicatorSizeNormal,
                indicatorHeight = MaterialTheme.dimensionsWidgetExtended.swiperPagerIndicatorSizeNormal,
                spacing = MaterialTheme.dimensionsWidgetExtended.swiperPagerIndicatorSpacingNormal,
                activeColor = MaterialTheme.colorsWidgetExtended.swiperPagerIndicatorActive,
                inactiveColor = MaterialTheme.colorsWidgetExtended.swiperPagerIndicatorInactive,
                indicatorShape = MaterialTheme.shapeWidgetExtended.swiperPagerIndicator
            )
        }
        LaunchedEffect(pagerState) {
            snapshotFlow { pagerState.currentPage }.collect { pageIndex ->
                onPageChange(pageIndex)
            }
        }
        LaunchedEffect(Unit) {
            pagerState.scrollToPage(pageSelected)
        }
    }
}