/*
 *  *********************************************************************************
 *  Created by Tezov on 04/05/2023 20:17
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 04/05/2023 19:30
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.component.chunk

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.tezov.lib_core_android_kotlin.type.primaire.DpSize
import com.tezov.lib_core_android_kotlin.type.primaire.size
import com.tezov.lib_core_android_kotlin.ui.modifier.thenOnNotNull
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitFrameStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.background
import com.tezov.lib_core_android_kotlin.ui.theme.theme.ThemeColorsExtended
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack
import androidx.compose.ui.graphics.Color as ColorImport

object Icon {

    object Simple {

        class StyleBuilder internal constructor(style: Style) {
            var size = style.size
            var tint = style.tint

            internal fun get() = Style(
                size = size,
                tint = tint,
            )
        }

        class Style(
            val size: DpSize? = null,
            tint: ColorImport? = null,
        ) {

            val tint: ColorImport by DelegateNullFallBack.Ref(tint, fallBackValue = {
                ThemeColorsExtended.Dummy.pink
            })

            companion object {

                @Composable
                fun Style.copy(builder: @Composable StyleBuilder.() -> Unit = {}) =
                    StyleBuilder(this).also {
                        it.builder()
                    }.get()

            }

            constructor(style: Style) : this(
                size = style.size,
                tint = style.tint,
            )
        }

        @Composable
        operator fun invoke(
            modifier: Modifier = Modifier,
            style: Style = Style(),
            painter: Painter,
            description: String? = null,
        ) {
            Icon(
                modifier = modifier
                    .thenOnNotNull(style.size) {
                        size(it)
                    },
                painter = painter,
                tint = style.tint,
                contentDescription = description,
            )
        }

        @Composable
        operator fun invoke(
            modifier: Modifier = Modifier,
            style: Style = Style(),
            resourceId: Int,
            description: String? = null,
        ) {
            invoke(
                modifier,
                style,
                painterResource(id = resourceId),
                description
            )
        }

    }

    object StateColor {

        class StyleBuilder internal constructor(style: Style) {
            var size = style.size
            var tint = style.tint
            var outfitFrame = style.outfitFrame

            internal fun get() = Style(
                size = size,
                tint = tint,
                outfitFrame = outfitFrame,
            )
        }

        class Style(
            val size: DpSize? = null,
            tint: ColorImport? = null,
            val outfitFrame: OutfitFrameStateColor? = null,
        ) {

            val tint: ColorImport by DelegateNullFallBack.Ref(tint, fallBackValue = {
                ThemeColorsExtended.Dummy.pink
            })

            companion object {

                @Composable
                fun Style.copy(builder: @Composable StyleBuilder.() -> Unit = {}) =
                    StyleBuilder(this).also {
                        it.builder()
                    }.get()

            }

            constructor(style: Style) : this(
                size = style.size,
                tint = style.tint,
                outfitFrame = style.outfitFrame,
            )
        }

        @Composable
        operator fun invoke(
            modifier: Modifier = Modifier,
            style: Style = Style(),
            painter: Painter,
            description: String? = null,
            selector: Any? = null
        ) {
            Icon(
                modifier = modifier
                    .thenOnNotNull(style.size) {
                        size(it)
                    }
                    .thenOnNotNull(style.outfitFrame) {
                        background(it, selector)
                    }
                    .thenOnNotNull(style.size?.padding) {
                        padding(it)
                    },
                painter = painter,
                tint = style.tint,
                contentDescription = description,
            )
        }

        @Composable
        operator fun invoke(
            modifier: Modifier = Modifier,
            style: Style = Style(),
            resourceId: Int,
            description: String? = null,
            selector: Any? = null
        ) {
            invoke(
                modifier,
                style,
                painterResource(id = resourceId),
                description,
                selector
            )
        }
    }
}