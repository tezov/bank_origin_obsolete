/*
 *  *********************************************************************************
 *  Created by Tezov on 17/04/2023 21:26
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 17/04/2023 19:24
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.component.block

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tezov.bank.ui.component.element.RollerCard
import com.tezov.lib_core_android_kotlin.type.primaire.DpSize
import com.tezov.lib_core_android_kotlin.ui.component.block.HorizontalRoller
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Button
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Icon
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Text
import com.tezov.lib_core_android_kotlin.ui.modifier.thenOnNotNull
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsPaddingExtended
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack

object SectionRollerCard {

    class StyleBuilder internal constructor(
        style: Style
    ) {
        var iconStyle = style.iconStyle
        var outfitTextTitle = style.outfitTextTitle
        var outfitTextSubTitle = style.outfitTextSubTitle
        var colorBackgroundHeader = style.colorBackgroundHeader
        var colorBackgroundBody = style.colorBackgroundBody
        var actionStyle = style.actionStyle
        var rollerStyle = style.rollerStyle
        var cardStyle = style.cardStyle

        fun get() = Style(
            iconStyle = iconStyle,
            outfitTextTitle = outfitTextTitle,
            outfitTextSubTitle = outfitTextSubTitle,
            colorBackgroundHeader = colorBackgroundHeader,
            colorBackgroundBody = colorBackgroundBody,
            actionStyle = actionStyle,
            rollerStyle = rollerStyle,
            cardStyle = cardStyle,
        )
    }

    class Style(
        iconStyle: Icon.Simple.Style? = null,
        val outfitTextTitle: OutfitText.StateColor.Style? = null,
        val outfitTextSubTitle: OutfitText.StateColor.Style? = null,
        val colorBackgroundHeader: Color? = null,
        val colorBackgroundBody: Color? = null,
        actionStyle: Button.StateColor.Style? = null,
        rollerStyle: HorizontalRoller.Page.Style? = null,
        cardStyle: RollerCard.Style? = null
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
        val actionStyle: Button.StateColor.Style by DelegateNullFallBack.Ref(
            actionStyle,
            fallBackValue = { Button.StateColor.Style() }
        )
        val rollerStyle: HorizontalRoller.Page.Style by DelegateNullFallBack.Ref(
            rollerStyle,
            fallBackValue = { HorizontalRoller.Page.Style() }
        )
        val cardStyle: RollerCard.Style by DelegateNullFallBack.Ref(
            cardStyle,
            fallBackValue = { RollerCard.Style() }
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
            outfitTextSubTitle = style.outfitTextSubTitle,
            colorBackgroundHeader = style.colorBackgroundHeader,
            colorBackgroundBody = style.colorBackgroundBody,
            actionStyle = style.actionStyle,
            rollerStyle = style.rollerStyle,
            cardStyle = style.cardStyle,
        )

    }

    data class Data(
        val icon: Int? = null,
        val title: String? = null,
        val subTitle: String? = null,
        val action: String? = null,
        val cards: List<RollerCard.Data>
    )


    @Composable
    operator fun invoke(
        modifier: Modifier = Modifier,
        style: Style,
        data: Data,
        onClickCard: ((Int) -> Unit)? = null,
        onClickButton: () -> Unit = {}
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
            data.subTitle?.let { text ->
                Text.StateColor(
                    modifier = Modifier
                        .padding(
                            start = MaterialTheme.dimensionsPaddingExtended.element.small.horizontal,
                            bottom = MaterialTheme.dimensionsPaddingExtended.element.normal.vertical
                        ),
                    text = text,
                    style = style.outfitTextSubTitle
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .thenOnNotNull(style.colorBackgroundBody) {
                        background(it)
                    },
            ) {
                val cards = remember(data.cards) {
                    (ArrayList<@Composable LazyItemScope.() -> Unit>()).apply {
                        data.cards.forEachIndexed { index, card ->
                            add {
                                RollerCard(
                                    modifier = Modifier.fillMaxSize(),
                                    data = card,
                                    style = style.cardStyle,
                                    onClick = onClickCard?.let { { it(index) } }
                                )
                            }
                        }
                    }
                }
                HorizontalRoller.Page(
                    modifier = Modifier
                        .fillMaxWidth(),
                    style = style.rollerStyle,
                    items = cards,
                )
            }
            data.action?.let {
                Button.StateColor(
                    modifierButton = Modifier
                        .fillMaxWidth(0.7f)
                        .align(Alignment.CenterHorizontally)
                        .padding(
                            top = MaterialTheme.dimensionsPaddingExtended.element.big.vertical
                        ),
                    text = data.action,
                    style = style.actionStyle,
                    onClick = onClickButton,
                )
            }

        }
    }

}