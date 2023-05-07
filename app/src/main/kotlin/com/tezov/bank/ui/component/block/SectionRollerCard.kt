/*
 *  *********************************************************************************
 *  Created by Tezov on 07/05/2023 23:36
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 07/05/2023 23:34
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
import com.tezov.bank.ui.component.element.RollerCard
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
        var styleIcon = style.styleIcon
        var outfitTextTitle = style.outfitTextTitle
        var outfitTextSubTitle = style.outfitTextSubTitle
        var colorBackgroundHeader = style.colorBackgroundHeader
        var colorBackgroundBody = style.colorBackgroundBody
        var styleAction = style.styleAction
        var styleRoller = style.styleRoller
        var styleCard = style.styleCard

        fun get() = Style(
            styleIcon = styleIcon,
            outfitTextTitle = outfitTextTitle,
            outfitTextSubTitle = outfitTextSubTitle,
            colorBackgroundHeader = colorBackgroundHeader,
            colorBackgroundBody = colorBackgroundBody,
            styleAction = styleAction,
            styleRoller = styleRoller,
            styleCard = styleCard,
        )
    }

    class Style(
        styleIcon: Icon.Simple.Style? = null,
        val outfitTextTitle: OutfitText.StateColor.Style? = null,
        val outfitTextSubTitle: OutfitText.StateColor.Style? = null,
        val colorBackgroundHeader: Color? = null,
        val colorBackgroundBody: Color? = null,
        styleAction: Button.StateColor.Style? = null,
        styleRoller: HorizontalRoller.Simple.Style? = null,
        styleCard: RollerCard.Style? = null
    ) {

        val styleIcon: Icon.Simple.Style by DelegateNullFallBack.Ref(
            styleIcon,
            fallBackValue = {
                Icon.Simple.Style()
            }
        )
        val styleAction: Button.StateColor.Style by DelegateNullFallBack.Ref(
            styleAction,
            fallBackValue = { Button.StateColor.Style() }
        )
        val styleRoller: HorizontalRoller.Simple.Style by DelegateNullFallBack.Ref(
            styleRoller,
            fallBackValue = { HorizontalRoller.Simple.Style() }
        )
        val styleCard: RollerCard.Style by DelegateNullFallBack.Ref(
            styleCard,
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
            styleIcon = style.styleIcon,
            outfitTextTitle = style.outfitTextTitle,
            outfitTextSubTitle = style.outfitTextSubTitle,
            colorBackgroundHeader = style.colorBackgroundHeader,
            colorBackgroundBody = style.colorBackgroundBody,
            styleAction = style.styleAction,
            styleRoller = style.styleRoller,
            styleCard = style.styleCard,
        )

    }

    data class Data(
        val iconId: Int? = null,
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
                    data.iconId?.let {
                        Icon.Simple(
                            modifier = Modifier
                                .padding(end = MaterialTheme.dimensionsPaddingExtended.element.small.horizontal),
                            style = style.styleIcon,
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
                                    style = style.styleCard,
                                    onClick = onClickCard?.let { { it(index) } }
                                )
                            }
                        }
                    }
                }
                HorizontalRoller.Simple(
                    modifier = Modifier
                        .fillMaxWidth(),
                    style = style.styleRoller,
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
                    style = style.styleAction,
                    onClick = onClickButton,
                )
            }

        }
    }

}