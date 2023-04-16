/*
 *  *********************************************************************************
 *  Created by Tezov on 16/04/2023 22:13
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 16/04/2023 20:40
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.component.block

import android.media.midi.MidiDevice.MidiConnection
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
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionModifier.fillMaxHeightRemembered
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionModifier.thenOnTrue
import com.tezov.lib_core_android_kotlin.ui.theme.style.*
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.Size.Companion.asShapeSize
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.StateColor.Style.Companion.asStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState.Simple.Style.Companion.asStateSimple
import com.tezov.lib_core_android_kotlin.ui.theme.theme.*
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack

object HorizontalPager {

    object Page {

        open class StyleBuilder internal constructor(style: Style) {
            var outfitShapeIndicator = style.outfitShapeIndicator
            var sizeIndicator = style.sizeIndicator
            var spacingItem = style.spacingItem
            var paddingTopIndicator = style.paddingTopIndicator
            var spacingIndicator = style.spacingIndicator
            var paddingContent = style.paddingContent
            var heightItemToHighest = style.heightItemToHighest

            internal open fun get() = Style(
                outfitShapeIndicator = outfitShapeIndicator,
                sizeIndicator = sizeIndicator,
                spacingItem = spacingItem,
                paddingTopIndicator = paddingTopIndicator,
                spacingIndicator = spacingIndicator,
                paddingContent = paddingContent,
                heightItemToHighest = heightItemToHighest,
            )
        }

        open class Style(
            outfitShapeIndicator: OutfitShapeStateColor? = null,
            spacingItem: Dp? = null,
            paddingTopIndicator: Dp? = null,
            sizeIndicator: Dp? = null,
            spacingIndicator: Dp? = null,
            paddingContent: PaddingValues? = null,
            heightItemToHighest: Boolean? = null,
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
            val heightItemToHighest: Boolean by DelegateNullFallBack.Ref(
                heightItemToHighest,
                fallBackValue = { false })

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
                heightItemToHighest = style?.heightItemToHighest,
            )
        }

        @OptIn(ExperimentalPagerApi::class)
        @Composable
        operator fun invoke(
            modifier: Modifier = Modifier,
            style: Style,
            itemSelected: Int = 0,
            items: List<@Composable PagerScope.() -> Unit>,
            onItemChange: ((index: Int) -> Unit)? = null
        ) {
            val pagerState = rememberPagerState()
            Column(
                modifier = modifier
            ) {
                HorizontalPager(
                    modifier = Modifier
                        .thenOnTrue(style.heightItemToHighest){
                            fillMaxHeightRemembered()
                        },
                    count = items.size,
                    state = pagerState,
                    contentPadding = style.paddingContent,
                    itemSpacing = style.spacingItem,
                ) { index ->
                    items[index]()
                }
                style.outfitShapeIndicator.let {
                    HorizontalPagerIndicator(
                        pagerState = pagerState,
                        modifier = Modifier
                            .padding(top = style.paddingTopIndicator)
                            .align(Alignment.CenterHorizontally),
                        indicatorWidth = style.sizeIndicator,
                        indicatorHeight = style.sizeIndicator,
                        spacing = style.spacingIndicator,
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
            onItemChange?.let {
                LaunchedEffect(pagerState) {
                    snapshotFlow { pagerState.currentPage }.collect { index ->
                        onItemChange(index)
                    }
                }
            }
            LaunchedEffect(Unit) {
                pagerState.scrollToPage(itemSelected)
            }
        }
    }

    object Card {

        class StyleBuilder internal constructor(style: Style) : Page.StyleBuilder(style) {
            var outfitFrame = style.outfitFrame
            var marginCard = style.marginCard

            override fun get() = Style(
                pagerStyle = super.get(),
                outfitFrame = outfitFrame,
                marginCard = marginCard,
            )
        }

        class Style(
            pagerStyle: Page.Style? = null,
            outfitFrame: OutfitFrameStateColor? = null,
            marginCard: PaddingValues = PaddingValues(horizontal = 4.dp),
        ) : Page.Style(pagerStyle) {

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
                fallBackValue = { PaddingValues() }
            )

            companion object {

                @Composable
                fun Style.copy(scope: @Composable StyleBuilder.() -> Unit) =
                    StyleBuilder(this).also {
                        it.scope()
                    }.get()

                @Composable
                fun Page.Style.copyToCarouselCardStyle(scope: @Composable StyleBuilder.() -> Unit) =
                    StyleBuilder(Style(this)).also { it.scope() }.get()

            }

            constructor(style: Style) : this(
                pagerStyle = style,
                outfitFrame = style.outfitFrame,
                marginCard = style.marginCard,
            )
        }

        @OptIn(ExperimentalPagerApi::class)
        @Composable
        operator fun invoke(
            modifier: Modifier = Modifier,
            style: Style,
            itemSelected: Int = 0,
            items: List<@Composable PagerScope.() -> Unit>,
            onItemChange: ((index: Int) -> Unit)? = null
        ) {
            Page(modifier, style, itemSelected, items.map { content ->
                {
                    Surface(
                        modifier = Modifier.padding(style.marginCard),
                        shape = style.outfitFrame.getShape() ?: RectangleShape,
                        border = style.outfitFrame.resolveBorder(),
                        color = style.outfitFrame.resolveColorShape() ?: MaterialTheme.colors.surface,
                    ) {
                        content()
                    }
                }
            }, onItemChange)
        }
    }

}