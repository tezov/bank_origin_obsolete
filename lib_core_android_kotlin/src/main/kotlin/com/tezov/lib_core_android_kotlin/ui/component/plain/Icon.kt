/*
 *  *********************************************************************************
 *  Created by Tezov on 05/03/2023 14:03
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 05/03/2023 13:42
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.component.plain

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.type.primaire.SizeDp
import com.tezov.lib_core_android_kotlin.type.primaire.size
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitFrame
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitFrameSimple
import com.tezov.lib_core_android_kotlin.ui.theme.style.background
import com.tezov.lib_core_android_kotlin.ui.theme.style.border

object Icon {

    object Simple{

        open class Style(
            val size: SizeDp? = null,
            val tint: Color = Color.Unspecified,
        ){
            companion object{

                open class Builder internal constructor(style: Style) {
                    var size = style.size
                    var tint = style.tint

                    internal fun get() = Style(
                        size = size,
                        tint = tint,
                    )
                }

                @Composable
                fun Style.copy(builder: @Composable Builder.()->Unit = {}) = Builder(this).also {
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
            style:Style = Style(),
            resourceId:Int,
            description:String? = null,
        ){
            style.size?.let {
                modifier.size(it)
            }
            Icon(
                modifier = modifier,
                painter = painterResource(id = resourceId),
                tint = style.tint,
                contentDescription = description,
            )
        }

    }

    object Frame{

        open class Style(
            val size: SizeDp? = null,
            val outfitFrame: OutfitFrameSimple = OutfitFrameSimple(),
        ){
            companion object{

                open class Builder internal constructor(style: Style) {
                    var size = style.size
                    var outfitFrame = style.outfitFrame

                    internal fun get() = Style(
                        size = size,
                        outfitFrame = outfitFrame,
                    )
                }

                @Composable
                fun Style.copy(builder: @Composable Builder.()->Unit = {}) = Builder(this).also {
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
            style:Style = Style(),
            resourceId:Int,
            description:String? = null,
        ){
            style.size?.let {
                modifier.size(it)
            }
            modifier.border(style.outfitFrame)
            Icon(
                modifier = modifier,
                painter = painterResource(id = resourceId),
                tint = style.outfitFrame.outfitShape.color,
                contentDescription = description,
            )
        }

    }









}