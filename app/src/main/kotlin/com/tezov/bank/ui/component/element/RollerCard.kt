/*
 *  *********************************************************************************
 *  Created by Tezov on 07/05/2023 17:59
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 07/05/2023 17:55
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
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.type.primaire.DpSize
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Image
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Text
import com.tezov.lib_core_android_kotlin.ui.modifier.thenOnNotNull
import com.tezov.lib_core_android_kotlin.ui.theme.style.*
import com.tezov.lib_core_android_kotlin.ui.theme.theme.ThemeColorsExtended
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsPaddingExtended
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack


object RollerCard {

    class StyleBuilder internal constructor(
        style: Style
    ) {
        var outfitFrame = style.outfitFrame
        var imageStyle = style.imageStyle
        var outfitTextTitle = style.outfitTextTitle

        internal fun get() = Style(
            outfitFrame = outfitFrame,
            imageStyle = imageStyle,
            outfitTextTitle = outfitTextTitle,
        )
    }

    class Style(
        outfitFrame: OutfitFrameStateColor? = null,
        imageStyle: Image.Simple.Style? = null,
        val outfitTextTitle: OutfitTextStateColor? = null,
    ) {
        val outfitFrame: OutfitFrameStateColor by DelegateNullFallBack.Ref(
            outfitFrame,
            fallBackValue = {
                ThemeColorsExtended.Dummy.outfitFrameState
            }
        )
        val imageStyle: Image.Simple.Style by DelegateNullFallBack.Ref(
            imageStyle,
            fallBackValue = {
                Image.Simple.Style(
                    size = DpSize(96.dp)
                )
            }
        )

        companion object {

            @Composable
            fun Style.copy(
                builder: @Composable StyleBuilder.() -> Unit = {}
            ) = StyleBuilder(this).also {
                it.builder()
            }.get()

        }

        constructor(style: Style?) : this(
            outfitFrame = style?.outfitFrame,
            imageStyle = style?.imageStyle,
            outfitTextTitle = style?.outfitTextTitle,
        )

    }

    data class Data(
        val imageId: Int,
        val title: String,
    )

    @Composable
    operator fun invoke(
        modifier: Modifier = Modifier,
        style: Style,
        data: Data,
        onClick: (() -> Unit)? = null
    ) {
        Column(
            modifier = modifier
                .background(style.outfitFrame)
                .thenOnNotNull(onClick) {
                    clickable { it() }
                }
                .padding(MaterialTheme.dimensionsPaddingExtended.block.small)
        ) {
            Image.Simple(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                resourceId = data.imageId,
                description = null,
                style = style.imageStyle
            )
            Box(
                modifier = Modifier
                    .padding(top = MaterialTheme.dimensionsPaddingExtended.element.small.vertical)
                    .height(40.dp)
            ) {
                Text.StateColor(
                    modifier = Modifier.align(Alignment.BottomStart),
                    text = data.title,
                    style = style.outfitTextTitle
                )
            }
        }
    }


}




