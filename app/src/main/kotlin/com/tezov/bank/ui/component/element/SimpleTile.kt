/*
 *  *********************************************************************************
 *  Created by Tezov on 07/05/2023 17:59
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 07/05/2023 17:49
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.component.element

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Icon
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Icon.Simple.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Text
import com.tezov.lib_core_android_kotlin.ui.theme.style.*
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.theme.ThemeColorsExtended
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsPaddingExtended
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack

object SimpleTile {

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
                ThemeColorsExtended.Dummy.outfitFrameState
            }
        )

        val iconStyle: Icon.Simple.Style by DelegateNullFallBack.Ref(
            iconStyle,
            fallBackValue = {
                Icon.Simple.Style()
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

        @Composable
        internal fun iconStyle(color: Color?) = color?.let {
            iconStyle.copy {
                tint = it
            }
        } ?: run {
            iconStyle
        }

    }

    data class Data(
        var template: Template = Template.Undefined,
        val title: String,
        val subtitle: String? = null,
        val iconId: Int,
        val iconColor: Color? = null,

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
                .background(style.outfitFrame)
                .clickable { onClick() }
                .padding(MaterialTheme.dimensionsPaddingExtended.element.normal)
        ) {
            Icon.Simple(
                modifier = Modifier.align(Alignment.End),
                style = style.iconStyle(color = data.iconColor),
                resourceId = data.iconId,
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
                style = style.iconStyle(color = data.iconColor),
                resourceId = data.iconId,
                description = data.title,
            )
            Column (
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ){
                Text.StateColor(
                    modifier = Modifier.fillMaxWidth(),
                    text = data.title,
                    style = style.outfitTextTitle?.copy{
                        typo = typo.copy(textAlign = TextAlign.Center)
                    },
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
                style = style.iconStyle(color = data.iconColor),
                resourceId = data.iconId,
                description = data.title,
            )
        }
    }


}