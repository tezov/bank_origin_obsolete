/*
 *  *********************************************************************************
 *  Created by Tezov on 09/04/2023 15:37
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 09/04/2023 15:30
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.component.branch

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import com.tezov.lib_core_android_kotlin.ui.theme.style.*
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.Size.Companion.asShapeSize
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.StateColor.Style.Companion.asStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState.Simple.Style.Companion.asStateSimple
import com.tezov.lib_core_android_kotlin.ui.theme.theme.*
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack

object HorizontalScrollable {

    object Pager {

        open class StyleBuilder internal constructor(style: Style) {
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

        open class Style(
            outfitShapeIndicator: OutfitShapeStateColor? = null,
            dimensionIndicatorPaddingTop: Dp? = null,
            dimensionIndicatorSize: Dp? = null,
            dimensionIndicatorSpacing: Dp? = null,
            padding: PaddingValues? = null,
        ) {

            val outfitShapeIndicator: OutfitShapeStateColor by DelegateNullFallBack.Ref(
                outfitShapeIndicator,
                fallBackValue = {
                    OutfitShapeStateColor(
                        outfitState = OutfitStateDual(active = Color.Black, inactive = Color.Gray),
                        size = 6.dp.asShapeSize
                    )
                })
            val dimensionIndicatorPaddingTop: Dp by DelegateNullFallBack.Ref(
                dimensionIndicatorPaddingTop,
                fallBackValue = { 6.dp })
            val dimensionIndicatorSize: Dp by DelegateNullFallBack.Ref(
                dimensionIndicatorSize,
                fallBackValue = { 6.dp })
            val dimensionIndicatorSpacing: Dp by DelegateNullFallBack.Ref(
                dimensionIndicatorSpacing,
                fallBackValue = { 6.dp })
            val padding: PaddingValues by DelegateNullFallBack.Ref(
                padding,
                fallBackValue = { PaddingValues() })

            companion object {

                @Composable
                fun Style.copy(scope: @Composable StyleBuilder.() -> Unit) =
                    StyleBuilder(this).also {
                        it.scope()
                    }.get()

            }

            constructor(style: Style?) : this(
                outfitShapeIndicator = style?.outfitShapeIndicator,
                dimensionIndicatorSize = style?.dimensionIndicatorSize,
                dimensionIndicatorSpacing = style?.dimensionIndicatorSpacing,
                dimensionIndicatorPaddingTop = style?.dimensionIndicatorPaddingTop,
                padding = style?.padding,
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
                        activeColor = it.resolveColor(OutfitState.Dual.Selector.Enabled)
                            ?: LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
                        inactiveColor = it.resolveColor(OutfitState.Dual.Selector.Disabled)
                            ?: LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
                                .copy(
                                    ContentAlpha.disabled
                                ),
                        indicatorShape = it.getShape() ?: CircleShape
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

        class StyleBuilder internal constructor(style: Style) : Pager.StyleBuilder(style) {
            var outfitFrame = style.outfitFrame
            var marginCard = style.marginCard

            override fun get() = Style(
                pagerStyle = super.get(),
                outfitFrame = outfitFrame,
                marginCard = marginCard,
            )
        }

        class Style(
            pagerStyle: Pager.Style? = null,
            outfitFrame: OutfitFrameStateColor? = null,
            marginCard: PaddingValues = PaddingValues(horizontal = 4.dp),
        ) : Pager.Style(pagerStyle) {

            val outfitFrame: OutfitFrameStateColor by DelegateNullFallBack.Ref(
                outfitFrame,
                fallBackValue = {
                    OutfitFrameStateColor(
                        outfitShape = 8.asStateColor,
                        outfitBorder = OutfitBorderStateColor(
                            size = 1.dp,
                            outfitState = Color.Black.asStateSimple
                        ),
                    )
                }
            )
            val marginCard: PaddingValues by DelegateNullFallBack.Ref(
                marginCard,
                fallBackValue = { PaddingValues(horizontal = 4.dp) }
            )

            companion object {

                @Composable
                fun Style.copy(scope: @Composable StyleBuilder.() -> Unit) =
                    StyleBuilder(this).also {
                        it.scope()
                    }.get()

                @Composable
                fun Pager.Style.copyToCarouselCardStyle(scope: @Composable StyleBuilder.() -> Unit) =
                    StyleBuilder(Style(this)).also { it.scope() }.get()

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
                        shape = style.outfitFrame.getShape() ?: RectangleShape,
                        border = style.outfitFrame.resolveBorder(),
                        color = style.outfitFrame.resolveColorShape() ?: MaterialTheme.colors.surface,
                    ) {
                        content()
                    }
                }
            }, onPageChange)
        }
    }

}