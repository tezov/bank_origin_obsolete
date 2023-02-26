/*
 *  *********************************************************************************
 *  Created by Tezov on 26/02/2023 21:19
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 26/02/2023 21:08
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.component.plain

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.Dp
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextState

object Icon {

    object Simple{

        open class Style(
            val size: Dp? = null,
            val tint: Color? = null,
        ){
            companion object{

                open class Scope internal constructor(style: Style) {
                    var size = style.size
                    var tint = style.tint

                    internal fun get() = Style(
                        size = size,
                        tint = tint,
                    )
                }

                @Composable
                fun Style.copy(scope: @Composable Scope.()->Unit) = Scope(this).also {
                    it.scope()
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
            style.size?.let { modifier.size(it) }
            Icon(
                modifier = modifier,
                painter = painterResource(id = resourceId),
                tint = style.tint ?: LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
                contentDescription = description,
            )
        }

    }











}