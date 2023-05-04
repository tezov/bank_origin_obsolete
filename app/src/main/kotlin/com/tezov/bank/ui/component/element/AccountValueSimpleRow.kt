/*
 *  *********************************************************************************
 *  Created by Tezov on 04/05/2023 20:17
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 04/05/2023 19:59
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.component.element

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.type.primaire.DpSize
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Icon
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Icon.Simple.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Icon.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Text
import com.tezov.lib_core_android_kotlin.ui.modifier.thenOnNotNull
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitFrame.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState.Simple.Style.Companion.asStateSimple
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsPaddingExtended
import com.tezov.lib_core_android_kotlin.ui.theme.theme.shapesExtended
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack

object AccountValueSimpleRow {

    class StyleBuilder internal constructor(
        style: Style
    ) {
        var iconInfoStyle = style.iconInfoStyle
        var outfitTextTitle = style.outfitTextTitle
        var outfitTextSubTitle = style.outfitTextSubTitle
        var outfitTextAmount = style.outfitTextAmount
        var background = style.background

        fun get() = Style(
            iconInfoStyle = iconInfoStyle,
            outfitTextTitle = outfitTextTitle,
            outfitTextSubTitle = outfitTextSubTitle,
            outfitTextAmount = outfitTextAmount,
            background = background,
        )
    }

    class Style(
        iconInfoStyle: Icon.StateColor.Style? = null,
        val outfitTextTitle: OutfitTextStateColor? = null,
        val outfitTextSubTitle: OutfitTextStateColor? = null,
        val outfitTextAmount: OutfitTextStateColor? = null,
        val background: Color? = null,
    ) {
        val iconInfoStyle: Icon.StateColor.Style by DelegateNullFallBack.Ref(
            iconInfoStyle,
            fallBackValue = {
                Icon.StateColor.Style()
            }
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
            iconInfoStyle = style.iconInfoStyle,
            outfitTextTitle = style.outfitTextTitle,
            outfitTextSubTitle = style.outfitTextSubTitle,
            outfitTextAmount = style.outfitTextAmount,
            background = style.background,
        )

    }

    class Data(
        val iconInfoId: Int,
        val iconInfoColor: Color,
        val title: String,
        val subTitle: String,
        val amount: String,
    )

    @Composable
    operator fun invoke(
        modifier: Modifier = Modifier,
        style: Style,
        data: Data,
        onClick: () -> Unit = {}
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .thenOnNotNull(style.background) {
                    background(it)
                }
                .clip(MaterialTheme.shapesExtended.clip.normal)
                .clickable { onClick() },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon.StateColor(
                style = style.iconInfoStyle.copy {
                    outfitFrame = outfitFrame?.copy{
                        outfitShape = outfitShape.copy{
                            outfitState = data.iconInfoColor.asStateSimple
                        }
                    }
                },
                resourceId = data.iconInfoId,
                description = null,
            )
            Spacer(modifier = Modifier.width(MaterialTheme.dimensionsPaddingExtended.element.normal.horizontal))
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(
                        end = MaterialTheme.dimensionsPaddingExtended.element.normal.horizontal,
                    )
            ) {
                Text.StateColor(
                    text = data.title,
                    style = style.outfitTextTitle,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text.StateColor(
                    text = data.subTitle,
                    style = style.outfitTextSubTitle,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Text.StateColor(
                modifier = Modifier
                    .fillMaxHeight()
                    .align(Alignment.Top),
                text = data.amount,
                style = style.outfitTextAmount
            )
        }
    }

}