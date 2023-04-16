/*
 *  *********************************************************************************
 *  Created by Tezov on 16/04/2023 17:05
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 16/04/2023 16:32
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.component.branch

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tezov.bank.ui.component.leaf.CarouselCard
import com.tezov.lib_core_android_kotlin.type.primaire.DpSize
import com.tezov.lib_core_android_kotlin.ui.component.branch.HorizontalScrollable
import com.tezov.lib_core_android_kotlin.ui.component.plain.Icon
import com.tezov.lib_core_android_kotlin.ui.component.plain.Text
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionModifier.thenOnNotNull
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsPaddingExtended
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack

object SectionCarouselCard {

    class StyleBuilder internal constructor(
        style: Style
    ) {
        var iconStyle = style.iconStyle
        var outfitTextHeader = style.outfitTextHeader
        var colorBackgroundHeader = style.colorBackgroundHeader
        var colorBackgroundBody = style.colorBackgroundBody
        var carouselStyle = style.carouselStyle
        var cardStyle = style.cardStyle

        fun get() = Style(
            iconStyle = iconStyle,
            outfitTextHeader = outfitTextHeader,
            colorBackgroundHeader = colorBackgroundHeader,
            colorBackgroundBody = colorBackgroundBody,
            carouselStyle = carouselStyle,
            cardStyle = cardStyle,
        )
    }

    class Style(
        iconStyle: Icon.Simple.Style? = null,
        val outfitTextHeader: OutfitText.StateColor.Style? = null,
        val colorBackgroundHeader: Color? = null,
        val colorBackgroundBody: Color? = null,
        carouselStyle: HorizontalScrollable.Pager.Style? = null,
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
        val carouselStyle: HorizontalScrollable.Pager.Style by DelegateNullFallBack.Ref(
            carouselStyle,
            fallBackValue = { HorizontalScrollable.Pager.Style() }
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
            outfitTextHeader = style.outfitTextHeader,
            colorBackgroundHeader = style.colorBackgroundHeader,
            colorBackgroundBody = style.colorBackgroundBody,
            carouselStyle = style.carouselStyle,
            cardStyle = style.cardStyle,
        )

    }

    data class Data(
        val iconId: Int? = null,
        val title: String? = null,
        val cards: List<CarouselCard.Data>
    )

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
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = modifier.width(MaterialTheme.dimensionsPaddingExtended.element.small.horizontal))
                    data.iconId?.let {
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
                        style = style.outfitTextHeader
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
                    (ArrayList<@Composable () -> Unit>()).apply {
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
                HorizontalScrollable.Pager(
                    modifier = Modifier
                        .fillMaxWidth(),
                    style = style.carouselStyle,
                    pages = cards
                ) {
                    onClick(it)
                }
            }
        }
    }

}