/*
 *  *********************************************************************************
 *  Created by Tezov on 19/03/2023 17:35
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 19/03/2023 16:57
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.component.plain

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.tezov.lib_core_android_kotlin.type.primaire.SizeDp
import com.tezov.lib_core_android_kotlin.type.primaire.size
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitFrame
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState
import com.tezov.lib_core_android_kotlin.ui.theme.style.border

object Image {

    object Simple {

        open class Style(
            val size: SizeDp? = null,
            val tint: Color? = null,
            val contentScale: ContentScale = ContentScale.Fit,
        ) {
            companion object {

                open class Builder internal constructor(style: Style) {
                    var size = style.size
                    var tint = style.tint

                    internal fun get() = Style(
                        size = size,
                        tint = tint,
                    )
                }

                @Composable
                fun Style.copy(builder: @Composable Builder.() -> Unit = {}) = Builder(this).also {
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
            resourceId: Int,
            description: String? = null,
        ) {
            style.size?.let {
                modifier.size(it)
            }
            Image(
                modifier = modifier,
                painter = painterResource(id = resourceId),
                colorFilter = style.tint?.let { ColorFilter.tint(it) },
                contentDescription = description,
                contentScale = style.contentScale
            )
        }

    }

    object StateColor {

        open class Style(
            val size: SizeDp? = null,
            val outfitFrame: OutfitFrame.StateColor = OutfitFrame.StateColor(),
            val contentScale: ContentScale = ContentScale.Fit
        ) {
            companion object {

                open class Builder internal constructor(style: Style) {
                    var size = style.size
                    var outfitFrame = style.outfitFrame
                    var contentScale = style.contentScale

                    internal fun get() = Style(
                        size = size,
                        outfitFrame = outfitFrame,
                        contentScale = contentScale,
                    )
                }

                @Composable
                fun Style.copy(builder: @Composable Builder.() -> Unit = {}) = Builder(this).also {
                    it.builder()
                }.get()

            }

            constructor(style: Style) : this(
                size = style.size,
                outfitFrame = style.outfitFrame,
                contentScale = style.contentScale,
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
            style.size?.let {
                modifier.size(it)
            }
            val sketch = style.outfitFrame.outfitShape?.resolve(selector)
            style.outfitFrame.outfitBorder?.let {
                modifier.border(it, selector, sketch)
            }
            Image(
                modifier = modifier,
                painter = painterResource(id = resourceId),
                colorFilter = sketch?.color?.let { ColorFilter.tint(it) },
                contentDescription = description,
                contentScale = style.contentScale
            )
        }

    }


}