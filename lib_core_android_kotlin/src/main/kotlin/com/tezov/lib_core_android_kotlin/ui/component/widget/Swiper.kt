/*
 *  *********************************************************************************
 *  Created by Tezov on 30/01/2023 20:18
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 30/01/2023 20:11
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.component.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.tezov.lib_core_android_kotlin.ui.theme.definition.*

infix fun Swiper.Pager.provides(value: Swiper.Pager.Style) = local provides value

object Swiper {

    object Pager {

        internal val local: ProvidableCompositionLocal<Style> = staticCompositionLocalOf {
            error("not provided")
        }

        @Immutable
        data class Style(
            val colorIndicatorActive: Color,
            val colorIndicatorInactive: Color,
            val dimensionIndicatorPaddingTop: Dp,
            val dimensionIndicatorSize: Dp,
            val dimensionIndicatorSpacing: Dp,
            val shapeIndicator: Shape,
        )

        @Composable
        operator fun invoke(
            modifier: Modifier = Modifier,
            pageSelected: Int = 0,
            pages: List<@Composable () -> Unit>,
            onPageChange: (pageIndex: Int) -> Unit
        ) {
            Content(modifier, pageSelected, pages, onPageChange)
        }

        @OptIn(ExperimentalPagerApi::class)
        @Composable
        private fun Content(
            modifier: Modifier = Modifier,
            pageSelected: Int,
            pages: List<@Composable () -> Unit>,
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
                val style = local.current
                HorizontalPagerIndicator(
                    pagerState = pagerState,
                    modifier = Modifier
                        .padding(top = style.dimensionIndicatorPaddingTop),
                    indicatorWidth = style.dimensionIndicatorSize,
                    indicatorHeight = style.dimensionIndicatorSize,
                    spacing = style.dimensionIndicatorSpacing,
                    activeColor = style.colorIndicatorActive,
                    inactiveColor = style.colorIndicatorInactive,
                    indicatorShape = style.shapeIndicator
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

}