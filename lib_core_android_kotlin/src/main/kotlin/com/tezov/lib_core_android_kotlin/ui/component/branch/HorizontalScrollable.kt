/*
 *  *********************************************************************************
 *  Created by Tezov on 19/02/2023 03:45
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 19/02/2023 03:45
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.component.branch

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import com.tezov.lib_core_android_kotlin.ui.theme.theme.*

object HorizontalScrollable {

    object Pager {

        internal val local: ProvidableCompositionLocal<Style> = staticCompositionLocalOf {
            error("not provided")
        }

       @Immutable
        open class Style(
           val colorIndicatorActive: Color = Default.colorIndicatorActive,
           val colorIndicatorInactive: Color = Default.colorIndicatorInactive,
           val dimensionIndicatorPaddingTop: Dp = Default.dimensionIndicatorPaddingTop,
           val dimensionIndicatorSize: Dp = Default.dimensionIndicatorSize,
           val dimensionIndicatorSpacing: Dp = Default.dimensionIndicatorSpacing,
           val shapeIndicator: Shape? = Default.shapeIndicator,
           val padding: PaddingValues = Default.padding,
        ){

            companion object{
                internal val Default = Style(
                    colorIndicatorActive = Color.Black,
                    colorIndicatorInactive = Color.Gray,
                    dimensionIndicatorPaddingTop = 6.dp,
                    dimensionIndicatorSize = 6.dp,
                    dimensionIndicatorSpacing = 6.dp,
                    shapeIndicator = CircleShape,
                    padding = PaddingValues(),
                )

                fun Style.copy(
                    colorIndicatorActive: Color? = null,
                    colorIndicatorInactive: Color? = null,
                    dimensionIndicatorPaddingTop: Dp? = null,
                    dimensionIndicatorSize: Dp? = null,
                    dimensionIndicatorSpacing: Dp? = null,
                    shapeIndicator: Shape? = null,
                    padding: PaddingValues? = null,
                ) = Style(
                    colorIndicatorActive = colorIndicatorActive ?: this.colorIndicatorActive,
                    colorIndicatorInactive = colorIndicatorInactive ?: this.colorIndicatorInactive,
                    dimensionIndicatorPaddingTop = dimensionIndicatorPaddingTop ?: this.dimensionIndicatorPaddingTop,
                    dimensionIndicatorSize = dimensionIndicatorSize ?: this.dimensionIndicatorSize,
                    dimensionIndicatorSpacing = dimensionIndicatorSpacing ?: this.dimensionIndicatorSpacing,
                    shapeIndicator = shapeIndicator ?: this.shapeIndicator,
                    padding = padding ?: this.padding,
                )
            }

            constructor(style:Style) : this(
                colorIndicatorActive = style.colorIndicatorActive,
                colorIndicatorInactive = style.colorIndicatorInactive,
                dimensionIndicatorPaddingTop = style.dimensionIndicatorPaddingTop,
                dimensionIndicatorSize = style.dimensionIndicatorSize,
                dimensionIndicatorSpacing = style.dimensionIndicatorSpacing,
                shapeIndicator = style.shapeIndicator,
                padding = style.padding,
            )
        }

        @OptIn(ExperimentalPagerApi::class)
        @Composable
        operator fun invoke(
            modifier: Modifier = Modifier,
            style:Style,
            pageSelected: Int = 0,
            pages: List<@Composable () -> Unit>,
            onPageChange: (pageIndex: Int) -> Unit = {}
        ) {
            val pagerState = rememberPagerState()
            Box(
                modifier = modifier,
            ) {
                val spacingIndicator = remember {
                    style.shapeIndicator?.let {
                        style.dimensionIndicatorPaddingTop + style.dimensionIndicatorSize
                    } ?: 0.dp
                }
                HorizontalPager(
                    modifier = Modifier.padding(bottom = spacingIndicator),
                    count = pages.size, state = pagerState,
                    contentPadding = style.padding
                ) { pageIndex ->
                    pages[pageIndex].invoke()
                }
                style.shapeIndicator?.let {
                    HorizontalPagerIndicator(
                        pagerState = pagerState,
                        modifier = Modifier
                            .align(Alignment.BottomCenter),
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
        open class Style(
            pagerStyle: Pager.Style = Pager.Style(),
            val marginCard: PaddingValues = Default.marginCard,
            val shapeCard: Shape = Default.shapeCard,
            val borderCard: BorderStroke = Default.borderCard,
            val backgroundCard: Color = Default.backgroundCard,
        ):Pager.Style(pagerStyle){

            companion object{
                internal val Default = Style(
                    marginCard = PaddingValues(horizontal = 4.dp),
                    shapeCard = RoundedCornerShape(8.dp),
                    borderCard = BorderStroke(1.dp, Color.Black),
                    backgroundCard = Color.Transparent,
                )

                fun Style.copy(
                    pagerStyle: Pager.Style? = null,
                    marginCard: PaddingValues? = null,
                    shapeCard: Shape? = null,
                    borderCard: BorderStroke? = null,
                    backgroundCard: Color? = null,
                ) = Style(
                    pagerStyle = pagerStyle ?: this,
                    marginCard = marginCard ?: this.marginCard,
                    shapeCard = shapeCard ?: this.shapeCard,
                    borderCard = borderCard ?: this.borderCard,
                    backgroundCard = backgroundCard ?: this.backgroundCard,
                )

                fun Pager.Style.copyAsStyleCarousel(
                    marginCard: PaddingValues = Style.Default.marginCard,
                    shapeCard: Shape = Style.Default.shapeCard,
                    borderCard: BorderStroke = Style.Default.borderCard,
                    backgroundCard: Color = Style.Default.backgroundCard,
                ) =  Style(
                    pagerStyle = this,
                    marginCard = marginCard,
                    shapeCard = shapeCard,
                    borderCard = borderCard,
                    backgroundCard = backgroundCard,
                )
            }

            constructor(style:Style) : this (
                marginCard = style.marginCard,
                shapeCard = style.shapeCard,
                borderCard = style.borderCard,
                backgroundCard = style.backgroundCard,
            )
        }

        @Composable
        operator fun invoke(
            modifier: Modifier = Modifier,
            style: Style,
            pageSelected: Int = 0,
            pages: List<@Composable () -> Unit>,
            onPageChange: (pageIndex: Int) -> Unit = {}
        ) {
            Pager(modifier, style, pageSelected, pages.map { content ->
                {
                    Surface(
                        modifier = modifier.padding(style.marginCard),
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