/*
 *  *********************************************************************************
 *  Created by Tezov on 16/04/2023 22:13
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 16/04/2023 22:08
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.component.block

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerScope
import com.tezov.bank.ui.component.element.CarouselCard
import com.tezov.lib_core_android_kotlin.type.primaire.DpSize
import com.tezov.lib_core_android_kotlin.ui.component.block.HorizontalPager
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Icon
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Text
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionModifier.thenOnNotNull
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsPaddingExtended
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack

object SectionCarouselCard {

    class StyleBuilder internal constructor(
        style: Style
    ) {
        var iconStyle = style.iconStyle
        var outfitTextTitle = style.outfitTextTitle
        var colorBackgroundHeader = style.colorBackgroundHeader
        var colorBackgroundBody = style.colorBackgroundBody
        var carouselStyle = style.carouselStyle
        var cardStyle = style.cardStyle

        fun get() = Style(
            iconStyle = iconStyle,
            outfitTextTitle = outfitTextTitle,
            colorBackgroundHeader = colorBackgroundHeader,
            colorBackgroundBody = colorBackgroundBody,
            carouselStyle = carouselStyle,
            cardStyle = cardStyle,
        )
    }

    class Style(
        iconStyle: Icon.Simple.Style? = null,
        val outfitTextTitle: OutfitText.StateColor.Style? = null,
        val colorBackgroundHeader: Color? = null,
        val colorBackgroundBody: Color? = null,
        carouselStyle: HorizontalPager.Page.Style? = null,
        cardStyle: CarouselCard.Style.Base? = null
    ) {

        val iconStyle: Icon.Simple.Style by DelegateNullFallBack.Ref(
            iconStyle,
            fallBackValue = {
                Icon.Simple.Style(
                    tint = Color.Black,
                    size = DpSize(24.dp)
                )
            }
        )
        val carouselStyle: HorizontalPager.Page.Style by DelegateNullFallBack.Ref(
            carouselStyle,
            fallBackValue = { HorizontalPager.Page.Style() }
        )
        val cardStyle: CarouselCard.Style.Base by DelegateNullFallBack.Ref(
            cardStyle,
            fallBackValue = { CarouselCard.Style.Button() }
        )

        companion object {

            @Composable
            fun Style.copy(
                scope: @Composable StyleBuilder.() -> Unit = {}
            ) = StyleBuilder(this).also {
                it.scope()
            }.get()

        }

        constructor(style: Style) : this(
            iconStyle = style.iconStyle,
            outfitTextTitle = style.outfitTextTitle,
            colorBackgroundHeader = style.colorBackgroundHeader,
            colorBackgroundBody = style.colorBackgroundBody,
            carouselStyle = style.carouselStyle,
            cardStyle = style.cardStyle,
        )

    }

    data class Data(
        val icon: Int? = null,
        val title: String? = null,
        val cards: List<CarouselCard.Data>
    )

    @OptIn(ExperimentalPagerApi::class)
    @Composable
    operator fun invoke(
        modifier: Modifier = Modifier,
        style: Style,
        data: Data,
        onClick: (Int) -> Unit = {}
    ) {
        if (data.cards.isEmpty()) {
            return
        }
        Column(
            modifier = modifier
                .fillMaxWidth()
        ) {
            data.title?.let { text ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .thenOnNotNull(style.colorBackgroundHeader) {
                            modifier.background(it)
                        }
                        .padding(start = MaterialTheme.dimensionsPaddingExtended.element.small.horizontal),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    data.icon?.let {
                        Icon.Simple(
                            modifier = Modifier
                                .padding(end = MaterialTheme.dimensionsPaddingExtended.element.small.horizontal),
                            style = style.iconStyle,
                            resourceId = it,
                            description = text,
                        )
                    }
                    Text.StateColor(
                        modifier = Modifier.padding(vertical = MaterialTheme.dimensionsPaddingExtended.element.big.vertical),
                        text = text,
                        style = style.outfitTextTitle
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .thenOnNotNull(style.colorBackgroundBody) {
                        background(it)
                    },
            ) {
                val cards = remember(data.cards) {
                    (ArrayList<@Composable PagerScope.() -> Unit>()).apply {
                        data.cards.forEach { card ->
                            add {
                                CarouselCard(
                                    modifier = Modifier.fillMaxSize(),
                                    data = card,
                                    style = style.cardStyle
                                )
                            }
                        }
                    }
                }
                HorizontalPager.Page(
                    modifier = Modifier
                        .fillMaxWidth(),
                    style = style.carouselStyle,
                    items = cards
                ) {
                    onClick(it)
                }
            }
        }
    }

}