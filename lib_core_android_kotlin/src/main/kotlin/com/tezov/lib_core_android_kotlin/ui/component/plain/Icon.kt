/*
 *  *********************************************************************************
 *  Created by Tezov on 02/04/2023 14:12
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 02/04/2023 14:12
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.component.plain

import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.tezov.lib_core_android_kotlin.type.primaire.SizeDp
import com.tezov.lib_core_android_kotlin.type.primaire.size
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionModifier.then
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitFrame
import com.tezov.lib_core_android_kotlin.ui.theme.style.border

object Icon {

    object Simple {

        class Style(
            val size: SizeDp? = null,
            val tint: Color? = null,
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
            Icon(
                modifier = modifier.then(style.size, Modifier::size),
                painter = painterResource(id = resourceId),
                tint = style.tint
                    ?: LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
                contentDescription = description,
            )
        }

    }

    object StateColor {

        class Style(
            val size: SizeDp? = null,
            val outfitFrame: OutfitFrame.Styl = OutfitFrame.Styl(),
        ) {
            companion object {

                open class Builder internal constructor(style: Style) {
                    var size = style.size
                    var outfitFrame = style.outfitFrame

                    internal fun get() = Style(
                        size = size,
                        outfitFrame = outfitFrame,
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
            val sketch = style.outfitFrame.outfitShape.resolve(selector)
            Icon(
                modifier = modifier
                    .then(style.size, Modifier::size)
                    .then(sketch, {
                        border(style.outfitFrame.outfitBorder, selector, it)
                    }),
                painter = painterResource(id = resourceId),
                tint = sketch?.color
                    ?: LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
                contentDescription = description,
            )
        }

    }


}