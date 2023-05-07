/*
 *  *********************************************************************************
 *  Created by Tezov on 07/05/2023 23:36
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 07/05/2023 23:25
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
import androidx.compose.ui.draw.clip
import com.tezov.bank.R
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Icon
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Text
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsPaddingExtended
import com.tezov.lib_core_android_kotlin.ui.theme.theme.shapesExtended
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack

object SimpleRow {

    class StyleBuilder internal constructor(
        style: Style
    ) {
        var styleIconInfo = style.styleIconInfo
        var styleIconAction = style.styleIconAction
        var outfitText = style.outfitText

        fun get() = Style(
            styleIconInfo = styleIconInfo,
            styleIconAction = styleIconAction,
            outfitText = outfitText,
        )
    }

    class Style(
        styleIconInfo: Icon.Simple.Style? = null,
        styleIconAction: Icon.Simple.Style? = null,
        val outfitText: OutfitTextStateColor? = null,
    ) {
        val styleIconInfo: Icon.Simple.Style by DelegateNullFallBack.Ref(
            styleIconInfo,
            fallBackValue = {
                Icon.Simple.Style()
            }
        )
        val styleIconAction: Icon.Simple.Style by DelegateNullFallBack.Ref(
            styleIconAction,
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
            styleIconInfo = style.styleIconInfo,
            styleIconAction = style.styleIconAction,
            outfitText = style.outfitText,
        )

    }

    class Data(
        val iconInfoId: Int? = null,
        val title: String,
        val iconActionId: Int = R.drawable.ic_arrow_cut_right_24dp,
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
                .clip(MaterialTheme.shapesExtended.clip.normal)
                .clickable { onClick() },
            verticalAlignment = Alignment.CenterVertically
        ) {
            data.iconInfoId?.let {
                Icon.Simple(
                    style = style.styleIconInfo,
                    resourceId = it,
                    description = null,
                )
                Spacer(modifier = Modifier.width(MaterialTheme.dimensionsPaddingExtended.element.normal.horizontal))
            }
            Text.StateColor(
                modifier = Modifier
                    .weight(1f),
                text = data.title,
                style = style.outfitText
            )
            Icon.Simple(
                style = style.styleIconAction,
                resourceId = data.iconActionId,
                description = data.title,
            )
        }
    }

}