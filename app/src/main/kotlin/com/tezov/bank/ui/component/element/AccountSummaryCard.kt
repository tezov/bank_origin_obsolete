/*
 *  *********************************************************************************
 *  Created by Tezov on 18/04/2023 20:56
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 18/04/2023 20:42
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


object AccountSummaryCard {

    class StyleBuilder internal constructor(
        style: Style
    ) {
        var outfitFrame = style.outfitFrame
        var outfitTextTitle = style.outfitTextTitle
        var outfitTextSubTitle = style.outfitTextSubTitle
        var outfitTextAmount = style.outfitTextAmount

        internal fun get() = Style(
            outfitFrame = outfitFrame,
            outfitTextTitle = outfitTextTitle,
            outfitTextSubTitle = outfitTextSubTitle,
            outfitTextAmount = outfitTextAmount,
        )
    }

    class Style(
        outfitFrame: OutfitFrameStateColor? = null,
        val outfitTextTitle: OutfitTextStateColor? = null,
        val outfitTextSubTitle: OutfitTextStateColor? = null,
        val outfitTextAmount: OutfitTextStateColor? = null,
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
            outfitTextTitle = style?.outfitTextTitle,
            outfitTextSubTitle = style?.outfitTextSubTitle,
            outfitTextAmount = style?.outfitTextAmount,
        )

    }

    data class Data(
        val title: String,
        val subTitle: String,
        val amount: String,
    )

    @Composable
    operator fun invoke(
        modifier: Modifier = Modifier,
        style: Style,
        data: Data,
        onClick: (() -> Unit)? = null
    ) {
        Surface(
            color = style.outfitFrame.resolveColorShape() ?: MaterialTheme.colors.surface,
            shape = style.outfitFrame.getShape() ?: MaterialTheme.shapes.small,
            border = style.outfitFrame.resolveBorder()
        ) {
            Column(
                modifier = modifier
                    .padding(MaterialTheme.dimensionsPaddingExtended.block.small)
                    .thenOnNotNull(onClick){
                        clickable { it() }
                    }
            ) {
                Text.StateColor(
                    modifier = Modifier.padding(top = MaterialTheme.dimensionsPaddingExtended.element.small.vertical),
                    text = data.title,
                    style = style.outfitTextTitle
                )
                Text.StateColor(
                    modifier = Modifier.padding(top = MaterialTheme.dimensionsPaddingExtended.element.small.vertical),
                    text = data.subTitle,
                    style = style.outfitTextSubTitle
                )
                Text.StateColor(
                    modifier = Modifier.padding(top = MaterialTheme.dimensionsPaddingExtended.element.small.vertical),
                    text = data.amount,
                    style = style.outfitTextAmount
                )
            }
        }
    }



}




