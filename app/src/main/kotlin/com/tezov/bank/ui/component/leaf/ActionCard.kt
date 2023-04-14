/*
 *  *********************************************************************************
 *  Created by Tezov on 14/04/2023 22:46
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 14/04/2023 21:35
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.component.leaf

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.type.primaire.DpSize
import com.tezov.lib_core_android_kotlin.type.primaire.size
import com.tezov.lib_core_android_kotlin.ui.component.plain.Icon
import com.tezov.lib_core_android_kotlin.ui.component.plain.Text
import com.tezov.lib_core_android_kotlin.ui.theme.style.*
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.StateColor.Style.Companion.asStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState.Simple.Style.Companion.asStateSimple
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsPaddingExtended
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack

object ActionCard {

    enum class Template {
        Undefined,
        IconTopEnd,
        IconTop,
        IconEnd;

        val isInlined get() = this == IconEnd
        val isUndefined get() = this == Undefined
        val isDefined get() = this != Undefined

        companion object {
            val InlineDefault get() = IconEnd
        }
    }

    class StyleBuilder internal constructor(
        style: Style
    ) {
        var outfitFrame = style.outfitFrame
        var iconStyle = style.iconStyle
        var outfitTextTitle = style.outfitTextTitle
        var outfitTextSubtitle = style.outfitTextSubtitle

        fun get() = Style(
            outfitFrame = outfitFrame,
            iconStyle = iconStyle,
            outfitTextTitle = outfitTextTitle,
            outfitTextSubtitle = outfitTextSubtitle,
        )
    }

    class Style(
        outfitFrame: OutfitFrameStateColor? = null,
        iconStyle: Icon.Simple.Style? = null,
        val outfitTextTitle: OutfitTextStateColor? = null,
        val outfitTextSubtitle: OutfitTextStateColor? = null,
    ) {
        val outfitFrame: OutfitFrameStateColor by DelegateNullFallBack.Ref(
            outfitFrame,
            fallBackValue = {
                OutfitFrameStateColor(
                    outfitShape = 8.asStateColor,
                    outfitBorder = OutfitBorderStateColor(
                        size = 1.dp,
                        outfitState = Color.Black.asStateSimple,
                    )
                )
            }
        )

        val iconStyle: Icon.Simple.Style by DelegateNullFallBack.Ref(
            iconStyle,
            fallBackValue = {
                Icon.Simple.Style(
                    tint = Color.Black,
                    size = DpSize(24.dp)
                )
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
            outfitFrame = style.outfitFrame,
            iconStyle = style.iconStyle,
            outfitTextTitle = style.outfitTextTitle,
            outfitTextSubtitle = style.outfitTextSubtitle,
        )
    }

    data class Data(
        var template: Template = Template.Undefined,
        val title: String,
        val subtitle: String? = null,
        val iconResourceId: Int,
    )

    @Composable
    operator fun invoke(
        modifier: Modifier = Modifier,
        style: Style,
        data: Data,
        onClick: () -> Unit = {}
    ) {
        when (data.template) {
            Template.IconTopEnd, Template.Undefined -> {
                ContentIconTopEnd(style, modifier, data, onClick)
            }
            Template.IconTop -> {
                ContentIconTop(style, modifier, data, onClick)
            }
            Template.IconEnd -> {
                ContentIconEnd(style, modifier, data, onClick)
            }
        }
    }

    @Composable
    private fun ContentIconTopEnd(
        style: Style,
        modifier: Modifier,
        data: Data,
        onClick: () -> Unit = {}
    ) {
        Column(
            modifier = modifier
                .border(style.outfitFrame)
                .background(style.outfitFrame)
                .clickable { onClick() }
                .padding(MaterialTheme.dimensionsPaddingExtended.element.normal)
        ) {
            Icon.Simple(
                modifier = Modifier.align(Alignment.End),
                style = style.iconStyle,
                resourceId = data.iconResourceId,
                description = data.title,
            )
            Text.StateColor(
                text = data.title,
                style = style.outfitTextTitle,
                overflow = TextOverflow.Visible
            )
            data.subtitle?.let {
                Text.StateColor(
                    text = it,
                    style = style.outfitTextSubtitle,
                    overflow = TextOverflow.Visible
                )
            }
        }

    }

    @Composable
    private fun ContentIconTop(
        style: Style,
        modifier: Modifier,
        data: Data,
        onClick: () -> Unit
    ) {
        Column(
            modifier = modifier
                .border(style.outfitFrame)
                .background(style.outfitFrame)
                .clickable {
                    onClick()
                }
                .padding(
                    vertical = MaterialTheme.dimensionsPaddingExtended.block.big.vertical,
                    horizontal = MaterialTheme.dimensionsPaddingExtended.block.normal.horizontal
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon.Simple(
                style = style.iconStyle,
                resourceId = data.iconResourceId,
                description = data.title,
            )
            Text.StateColor(
                text = data.title,
                style = style.outfitTextTitle,
                overflow = TextOverflow.Visible
            )
            data.subtitle?.let {
                Text.StateColor(
                    text = it,
                    style = style.outfitTextSubtitle,
                    overflow = TextOverflow.Visible
                )
            }
        }

    }

    @Composable
    private fun ContentIconEnd(
        style: Style,
        modifier: Modifier,
        data: Data,
        onClick: () -> Unit
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .border(style.outfitFrame)
                .background(style.outfitFrame)
                .clickable { onClick() }
                .padding(MaterialTheme.dimensionsPaddingExtended.element.normal),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(1f),
            ) {
                Text.StateColor(
                    text = data.title,
                    style = style.outfitTextTitle
                )
                data.subtitle?.let {
                    Text.StateColor(
                        text = it,
                        style = style.outfitTextSubtitle
                    )
                }
            }
            Icon.Simple(
                style = style.iconStyle,
                resourceId = data.iconResourceId,
                description = data.title,
            )
        }
    }


}