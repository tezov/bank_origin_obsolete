/*
 *  *********************************************************************************
 *  Created by Tezov on 12/02/2023 19:14
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 12/02/2023 19:10
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.component.branch

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import com.tezov.lib_core_android_kotlin.ui.theme.definition.*

infix fun HorizontalScrollable.Pager.provides(value: HorizontalScrollable.Pager.Style) =
    local provides value

infix fun HorizontalScrollable.CarouselCard.provides(value: HorizontalScrollable.CarouselCard.Style) =
    local provides value

object HorizontalScrollable {

    object Pager {

        internal val local: ProvidableCompositionLocal<Style> = staticCompositionLocalOf {
            error("not provided")
        }

        @Immutable
        data class Style(
            val colorIndicatorActive: Color = Color.Black,
            val colorIndicatorInactive: Color = Color.Gray,
            val dimensionIndicatorPaddingTop: Dp = 6.dp,
            val dimensionIndicatorSize: Dp = 6.dp,
            val dimensionIndicatorSpacing: Dp = 6.dp,
            val shapeIndicator: Shape? = CircleShape,
            val contentPadding: PaddingValues = PaddingValues(),
        )

        @Composable
        operator fun invoke(
            modifier: Modifier = Modifier,
            pageSelected: Int = 0,
            pages: List<@Composable () -> Unit>,
            onPageChange: (pageIndex: Int) -> Unit = {}
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
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val style = local.current
                HorizontalPager(
                    modifier = modifier
                        .fillMaxWidth(),
                    count = pages.size, state = pagerState,
                    contentPadding = style.contentPadding
                ) { pageIndex ->
                    pages[pageIndex].invoke()
                }
                style.shapeIndicator?.let {
                    HorizontalPagerIndicator(
                        pagerState = pagerState,
                        modifier = Modifier
                            .padding(top = style.dimensionIndicatorPaddingTop),
                        indicatorWidth = style.dimensionIndicatorSize,
                        indicatorHeight = style.dimensionIndicatorSize,
                        spacing = style.dimensionIndicatorSpacing,
                        activeColor = style.colorIndicatorActive,
                        inactiveColor = style.colorIndicatorInactive,
                        indicatorShape = it
                    )
                }
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

    object CarouselCard {

        internal val local: ProvidableCompositionLocal<Style> = staticCompositionLocalOf {
            error("not provided")
        }

        @Immutable
        data class Style(
            val paddingCard: PaddingValues = PaddingValues(horizontal = 4.dp),
            val shapeCard: Shape = RoundedCornerShape(8.dp),
            val borderCard: BorderStroke = BorderStroke(1.dp, Color.Black),
            val backgroundCard: Color = Color.Transparent,
        )

        @Composable
        operator fun invoke(
            modifier: Modifier = Modifier,
            pageSelected: Int = 0,
            pages: List<@Composable () -> Unit>,
            onPageChange: (pageIndex: Int) -> Unit = {}
        ) {
            Content(modifier, pageSelected, pages, onPageChange)
        }

        @Composable
        private fun Content(
            modifier: Modifier = Modifier,
            pageSelected: Int,
            pages: List<@Composable () -> Unit>,
            onPageChange: (pageIndex: Int) -> Unit
        ) {
            val style = local.current
            Pager(modifier, pageSelected, pages.map { content ->
                {
                    Surface(
                        modifier = modifier.padding(style.paddingCard),
                        shape = style.shapeCard,
                        border = style.borderCard,
                        color = style.backgroundCard,
                    ) {
                        content()
                    }
                }
            }, onPageChange)
        }
    }

}