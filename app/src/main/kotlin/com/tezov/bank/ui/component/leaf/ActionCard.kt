/*
 *  *********************************************************************************
 *  Created by Tezov on 02/04/2023 14:12
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 02/04/2023 14:12
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.component.leaf

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.type.primaire.SizeDp
import com.tezov.lib_core_android_kotlin.ui.component.plain.Icon
import com.tezov.lib_core_android_kotlin.ui.component.plain.Text
import com.tezov.lib_core_android_kotlin.ui.theme.style.*
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsPaddingExtended

object ActionCard {

    enum class Template {
        Undefined,
        IconTopEnd,
        IconTop,
        IconEnd;

        val isInlined get() = this == IconEnd
        val isUndefined get() = this == Undefined
        val isDefined get() = this != Undefined

        companion object{
            val InlineDefault get() = IconEnd
        }
    }

    @Immutable
    data class Style(
        val outfitFrame: OutfitFrame.Styl = OutfitFrame.Styl(
            outfitShape = OutfitShape.Style(
//                size = OutfitShape.Size(8.dp)
            ),
            outfitBorder = OutfitBorder.Style(
//                size = 1.dp,
//                color = Color.Black,
            )
        ),
        val iconStyle:Icon.Simple.Style =  Icon.Simple.Style(
            size = SizeDp(24.dp),
            tint = Color.Black
        ),
        val outfitTextTitle: OutfitText.StateColor = OutfitText.StateColor(),
        val outfitTextSubtitle: OutfitText.StateColor = OutfitText.StateColor(),
    )

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
        Row(
            modifier = modifier
                .border(style.outfitFrame)
                .background(style.outfitFrame)
                .clickable {
                    onClick()
                }
                .padding(
                    vertical = MaterialTheme.dimensionsPaddingExtended.blockNormal_v,
                    horizontal = MaterialTheme.dimensionsPaddingExtended.blockNormal_h
                )
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            ) {
                style.iconStyle.size?.let {
                    Spacer(modifier = Modifier.height(it.height))
                }
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
            Icon.Simple(
                style = style.iconStyle,
                resourceId = data.iconResourceId,
                description = data.title,
            )
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
                    vertical = MaterialTheme.dimensionsPaddingExtended.blockBig_v,
                    horizontal = MaterialTheme.dimensionsPaddingExtended.blockNormal_h
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
                .padding(
                    vertical = MaterialTheme.dimensionsPaddingExtended.blockNormal_v,
                    horizontal = MaterialTheme.dimensionsPaddingExtended.blockNormal_h
                ),
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.Bottom)
                    .weight(1f)
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
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                style = style.iconStyle,
                resourceId = data.iconResourceId,
                description = data.title,
            )
        }
    }


}