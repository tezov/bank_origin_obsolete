/*
 *  *********************************************************************************
 *  Created by Tezov on 15/04/2023 23:53
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 15/04/2023 23:47
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.component.branch

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionModifier.fillMaxHeightAuto
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
            var sizeIndicator = style.sizeIndicator
            var spacingItem = style.spacingItem
            var paddingTopIndicator = style.paddingTopIndicator
            var spacingIndicator = style.spacingIndicator
            var paddingContent = style.paddingContent

            internal open fun get() = Style(
                outfitShapeIndicator = outfitShapeIndicator,
                sizeIndicator = sizeIndicator,
                spacingItem = spacingItem,
                paddingTopIndicator = paddingTopIndicator,
                spacingIndicator = spacingIndicator,
                paddingContent = paddingContent,
            )
        }

        open class Style(
            outfitShapeIndicator: OutfitShapeStateColor? = null,
            spacingItem: Dp? = null,
            paddingTopIndicator: Dp? = null,
            sizeIndicator: Dp? = null,
            spacingIndicator: Dp? = null,
            paddingContent: PaddingValues? = null,
        ) {

            val outfitShapeIndicator: OutfitShapeStateColor by DelegateNullFallBack.Ref(
                outfitShapeIndicator,
                fallBackValue = {
                    OutfitShapeStateColor(
                        outfitState = OutfitStateDual(active = Color.Black, inactive = Color.Gray),
                        size = 6.dp.asShapeSize
                    )
                })
            val spacingItem: Dp by DelegateNullFallBack.Ref(
                spacingItem,
                fallBackValue = { 0.dp })
            val paddingTopIndicator: Dp by DelegateNullFallBack.Ref(
                paddingTopIndicator,
                fallBackValue = { 6.dp })
            val sizeIndicator: Dp by DelegateNullFallBack.Ref(
                sizeIndicator,
                fallBackValue = { 6.dp })
            val spacingIndicator: Dp by DelegateNullFallBack.Ref(
                spacingIndicator,
                fallBackValue = { 6.dp })
            val paddingContent: PaddingValues by DelegateNullFallBack.Ref(
                paddingContent,
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
                sizeIndicator = style?.sizeIndicator,
                spacingIndicator = style?.spacingIndicator,
                paddingTopIndicator = style?.paddingTopIndicator,
                paddingContent = style?.paddingContent,
                spacingItem = style?.spacingItem,
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
            val minHeightState = remember {
                mutableStateOf(Dp.Unspecified)
            }
            val pagerState = rememberPagerState()
            Column(
                modifier = modifier
            ) {
                HorizontalPager(
                    count = pages.size,
                    state = pagerState,
                    contentPadding = style.paddingContent,
                    itemSpacing = style.spacingItem,
                ) { pageIndex ->
                    Box(modifier = Modifier.fillMaxHeightAuto(minHeightState).background(Color.Red)){
                        pages[pageIndex].invoke()
                    }
                }
//                style.outfitShapeIndicator.let {
//                    HorizontalPagerIndicator(
//                        pagerState = pagerState,
//                        modifier = Modifier
//                            .padding(top = style.paddingTopIndicator)
//                            .align(Alignment.CenterHorizontally),
//                        indicatorWidth = style.sizeIndicator,
//                        indicatorHeight = style.sizeIndicator,
//                        spacing = style.spacingIndicator,
//                        activeColor = it.resolveColor(OutfitState.Dual.Selector.Enabled)
//                            ?: LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
//                        inactiveColor = it.resolveColor(OutfitState.Dual.Selector.Disabled)
//                            ?: LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
//                                .copy(
//                                    ContentAlpha.disabled
//                                ),
//                        indicatorShape = it.getShape() ?: CircleShape
//                    )
//                }
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
                        color = style.outfitFrame.resolveColorShape()
                            ?: MaterialTheme.colors.surface,
                    ) {
                        content()
                    }
                }
            }, onPageChange)
        }
    }

}