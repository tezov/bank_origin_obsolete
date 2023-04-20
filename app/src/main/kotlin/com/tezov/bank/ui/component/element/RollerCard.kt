/*
 *  *********************************************************************************
 *  Created by Tezov on 20/04/2023 20:47
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 20/04/2023 20:09
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
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.type.primaire.DpSize
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Image
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Text
import com.tezov.lib_core_android_kotlin.ui.modifier.thenOnNotNull
import com.tezov.lib_core_android_kotlin.ui.theme.style.*
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.StateColor.Style.Companion.asStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState.Simple.Style.Companion.asStateSimple
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
                OutfitFrameStateColor(
                    outfitShape = 8.asStateColor,
                    outfitBorder = OutfitBorderStateColor(
                        size = 1.dp,
                        outfitState = Color.Black.asStateSimple,
                    )
                )
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
        val image: Int,
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
                .padding(MaterialTheme.dimensionsPaddingExtended.block.small)
                .thenOnNotNull(onClick){
                    clickable { it() }
                }
        ) {
            Image.Simple(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                resourceId = data.image,
                description = null,
                style = style.imageStyle
            )
            Text.StateColor(
                modifier = Modifier.padding(top = MaterialTheme.dimensionsPaddingExtended.element.small.vertical),
                text = data.title,
                style = style.outfitTextTitle
            )
        }
    }



}




