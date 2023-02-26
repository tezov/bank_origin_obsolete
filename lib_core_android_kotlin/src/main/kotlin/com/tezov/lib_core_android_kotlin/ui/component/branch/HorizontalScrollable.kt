/*
 *  *********************************************************************************
 *  Created by Tezov on 26/02/2023 18:59
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 26/02/2023 18:59
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.component.branch

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import com.tezov.lib_core_android_kotlin.ui.theme.style.*
import com.tezov.lib_core_android_kotlin.ui.theme.theme.*

object HorizontalScrollable {

    object Pager {

        internal val local: ProvidableCompositionLocal<Style> = staticCompositionLocalOf {
            error("not provided")
        }

       @Immutable
        open class Style(
           val outfitShapeIndicator: OutfitShapeState? = Default.outfitShapeIndicator,
           val dimensionIndicatorPaddingTop: Dp = Default.dimensionIndicatorPaddingTop,
           val dimensionIndicatorSize: Dp = Default.dimensionIndicatorSize,
           val dimensionIndicatorSpacing: Dp = Default.dimensionIndicatorSpacing,
           val padding: PaddingValues = Default.padding,
        ){

            companion object{
                internal val Default = Style(
                    outfitShapeIndicator = OutfitShapeState(
                        template = OutfitShape.Template.Symmetric,
                        outfitColor = OutfitColorsSimple(active = Color.Black, inactive = Color.Gray),
                    ),
                    dimensionIndicatorSize = 6.dp,
                    dimensionIndicatorSpacing = 6.dp,
                    dimensionIndicatorPaddingTop = 6.dp,
                    padding = PaddingValues(),
                )

                fun Style.copy(
                    outfitShapeIndicator: OutfitShapeState? = null,
                    dimensionIndicatorSize: Dp? = null,
                    dimensionIndicatorSpacing: Dp? = null,
                    dimensionIndicatorPaddingTop: Dp? = null,
                    padding: PaddingValues? = null,
                ) = Style(
                    outfitShapeIndicator = outfitShapeIndicator ?: this.outfitShapeIndicator,
                    dimensionIndicatorSize = dimensionIndicatorSize ?: this.dimensionIndicatorSize,
                    dimensionIndicatorSpacing = dimensionIndicatorSpacing ?: this.dimensionIndicatorSpacing,
                    dimensionIndicatorPaddingTop = dimensionIndicatorPaddingTop ?: this.dimensionIndicatorPaddingTop,
                    padding = padding ?: this.padding,
                )
            }

            constructor(style:Style) : this(
                outfitShapeIndicator = style.outfitShapeIndicator,
                dimensionIndicatorSize = style.dimensionIndicatorSize,
                dimensionIndicatorSpacing = style.dimensionIndicatorSpacing,
                dimensionIndicatorPaddingTop = style.dimensionIndicatorPaddingTop,
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
                    style.outfitShapeIndicator?.let {
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
                style.outfitShapeIndicator?.let {
                    HorizontalPagerIndicator(
                        pagerState = pagerState,
                        modifier = Modifier
                            .align(Alignment.BottomCenter),
                        indicatorWidth = style.dimensionIndicatorSize,
                        indicatorHeight = style.dimensionIndicatorSize,
                        spacing = style.dimensionIndicatorSpacing,
                        activeColor = it.outfitColor.active,
                        inactiveColor = it.outfitColor.inactive,
                        indicatorShape = it.resolveOrDefault()
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
            val outfitFrame:OutfitFrameSimple = Default.outfitFrame,
            val marginCard: PaddingValues = Default.marginCard,
        ):Pager.Style(pagerStyle){

            companion object{
                internal val Default = Style(
                    outfitFrame = OutfitFrameSimple(
                        outfitShape = OutfitShapeSimple(
                            size = OutfitShape.Size(8.dp),
                        ),
                        outfitBorder = OutfitBorderSimple(
                            size = 1.dp,
                            color = Color.Black
                        ),
                    ),
                    marginCard = PaddingValues(horizontal = 4.dp),
                )

                fun Style.copy(
                    pagerStyle: Pager.Style? = null,
                    outfitFrame: OutfitFrameSimple? = null,
                    marginCard: PaddingValues? = null,
                ) = Style(
                    pagerStyle = pagerStyle ?: this,
                    outfitFrame = outfitFrame ?: this.outfitFrame,
                    marginCard = marginCard ?: this.marginCard,
                )

                fun Pager.Style.copyAsStyleCarousel(
                    outfitFrame: OutfitFrameSimple = Default.outfitFrame,
                    marginCard: PaddingValues = Default.marginCard,
                ) =  Style(
                    pagerStyle = this,
                    outfitFrame = outfitFrame,
                    marginCard = marginCard,
                )
            }

            constructor(style:Style) : this (
                outfitFrame = style.outfitFrame,
                marginCard = style.marginCard,
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
                        shape = style.outfitFrame.outfitShape.resolveOrDefault(),
                        border = style.outfitFrame.outfitBorder.resolve(),
                        color = style.outfitFrame.outfitShape.color,
                    ) {
                        content()
                    }
                }
            }, onPageChange)
        }
    }

}