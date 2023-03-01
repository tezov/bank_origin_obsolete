/*
 *  *********************************************************************************
 *  Created by Tezov on 01/03/2023 22:00
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 01/03/2023 21:56
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.component.branch

import androidx.compose.foundation.layout.*
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

        @Immutable
        open class Style(
            val outfitShapeIndicator: OutfitShapeState? = OutfitShapeState(
                sketch = OutfitShapeSketch(
                    template = OutfitShape.Template.Circle
                ),
                outfitColor = OutfitColorsSimple(active = Color.Black, inactive = Color.Gray),
            ),
            val dimensionIndicatorPaddingTop: Dp = 6.dp,
            val dimensionIndicatorSize: Dp = 6.dp,
            val dimensionIndicatorSpacing: Dp = 6.dp,
            val padding: PaddingValues = PaddingValues(),
        ) {

            companion object {

                open class Scope internal constructor(style: Style) {
                    var outfitShapeIndicator = style.outfitShapeIndicator
                    var dimensionIndicatorSize = style.dimensionIndicatorSize
                    var dimensionIndicatorSpacing = style.dimensionIndicatorSpacing
                    var dimensionIndicatorPaddingTop = style.dimensionIndicatorPaddingTop
                    var padding = style.padding

                    internal open fun get() = Style(
                        outfitShapeIndicator = outfitShapeIndicator,
                        dimensionIndicatorSize = dimensionIndicatorSize,
                        dimensionIndicatorSpacing = dimensionIndicatorSpacing,
                        dimensionIndicatorPaddingTop = dimensionIndicatorPaddingTop,
                        padding = padding,
                    )
                }

                @Composable
                fun Style.copy(scope: @Composable Scope.() -> Unit) = Scope(this).also {
                    it.scope()
                }.get()

            }

            constructor(style: Style) : this(
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
            style: Style,
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

        @Immutable
        open class Style(
            pagerStyle: Pager.Style = Pager.Style(),
            val outfitFrame: OutfitFrameSimple = OutfitFrameSimple(
                outfitShape = OutfitShapeSimple(
                    sketch = OutfitShapeSketch(
                        size = OutfitShape.Size(8.dp),
                    )
                ),
                outfitBorder = OutfitBorderSimple(
                    size = 1.dp,
                    color = Color.Black
                ),
            ),
            val marginCard: PaddingValues = PaddingValues(horizontal = 4.dp),
        ) : Pager.Style(pagerStyle) {

            companion object {

                open class Scope internal constructor(style: Style) :
                    Pager.Style.Companion.Scope(style) {
                    var outfitFrame = style.outfitFrame
                    var marginCard = style.marginCard

                    override fun get() = Style(
                        pagerStyle = super.get(),
                        outfitFrame = outfitFrame,
                        marginCard = marginCard,
                    )
                }

                @Composable
                fun Style.copy(scope: @Composable Scope.() -> Unit) = Scope(this).also {
                    it.scope()
                }.get()

                @Composable
                fun Pager.Style.copyToCarouselCardStyle(scope: @Composable Scope.() -> Unit) =
                    Scope(Style(this)).also { it.scope() }.get()

            }

            constructor(style: Style) : this(
                pagerStyle = style,
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