/*
 *  *********************************************************************************
 *  Created by Tezov on 08/05/2023 03:00
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/05/2023 02:36
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tezov.bank.R
import com.tezov.bank.ui.component.element.MessageRow.Style.Companion.ICON_INFO_SIZE
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Icon
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Text
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.theme.ThemeColorsExtended
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsPaddingExtended
import com.tezov.lib_core_android_kotlin.ui.theme.theme.shapesExtended
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack

object MessageRow {

    class StyleBuilder internal constructor(
        style: Style
    ) {
        var colorIconInfo = style.colorIconInfo
        var styleIconAction = style.styleIconAction
        var outfitTextTitle = style.outfitTextTitle
        var outfitTextSubTitle = style.outfitTextSubtitle

        fun get() = Style(
            colorIconInfo = colorIconInfo,
            styleIconAction = styleIconAction,
            outfitTextTitle = outfitTextTitle,
            outfitTextSubtitle = outfitTextSubTitle,
        )
    }

    class Style(
        val colorIconInfo: Color = ThemeColorsExtended.Dummy.pink,
        styleIconAction: Icon.Simple.Style? = null,
        val outfitTextTitle: OutfitTextStateColor? = null,
        val outfitTextSubtitle: OutfitTextStateColor? = null,
    ) {

        val styleIconAction: Icon.Simple.Style by DelegateNullFallBack.Ref(
            styleIconAction,
            fallBackValue = {
                Icon.Simple.Style()
            }
        )

        companion object {

            internal val ICON_INFO_SIZE = 8.dp

            @Composable
            fun Style.copy(
                scope: @Composable StyleBuilder.() -> Unit = {}
            ) = StyleBuilder(this).also {
                it.scope()
            }.get()

        }

        constructor(style: Style) : this(
            colorIconInfo = style.colorIconInfo,
            styleIconAction = style.styleIconAction,
            outfitTextTitle = style.outfitTextTitle,
            outfitTextSubtitle = style.outfitTextSubtitle,
        )

    }

    class Data(
        val title: String,
        val subtitle: String,
        val iconActionId: Int = R.drawable.ic_arrow_cut_right_24dp,
        val hasBeenRead: Boolean = false
    )

    @Composable
    operator fun invoke(
        modifier: Modifier = Modifier,
        style: Style,
        data: Data,
        onClick: () -> Unit = {}
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .clip(MaterialTheme.shapesExtended.clip.normal)
                .clickable { onClick() },
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (!data.hasBeenRead) {
                    Box(
                        modifier = Modifier
                            .background(style.colorIconInfo, CircleShape)
                            .size(ICON_INFO_SIZE)
                    )
                    Spacer(modifier = Modifier.width(MaterialTheme.dimensionsPaddingExtended.chunk.small.horizontal))
                }
                Text.StateColor(
                    modifier = Modifier.weight(1f),
                    text = data.title,
                    style = if (data.hasBeenRead) {
                        style.outfitTextTitle?.copy{
                            typo = typo.copy(
                                fontWeight = FontWeight.Normal
                            )
                        }
                    } else {
                        style.outfitTextTitle
                    }
                )
                Icon.Simple(
                    style = style.styleIconAction,
                    resourceId = data.iconActionId,
                    description = data.title,
                )
            }
            Text.StateColor(
                modifier = Modifier
                    .fillMaxWidth(),
                text = data.subtitle,
                style = style.outfitTextSubtitle
            )
        }


    }

}