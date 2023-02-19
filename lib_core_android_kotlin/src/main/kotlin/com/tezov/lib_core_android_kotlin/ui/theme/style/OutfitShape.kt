/*
 *  *********************************************************************************
 *  Created by Tezov on 19/02/2023 20:50
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 19/02/2023 20:50
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.theme.style

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object OutfitShape{

    enum class Template{
        Rounded;

        fun get(size: CornerSize?) = size?.let {
            when(this){
                Rounded -> RoundedCornerShape(corner = size)
            }
        }
    }

    object Simple{

        open class Style(
            val template: Template = Template.Rounded,
            val size: CornerSize? = null,
            val color: Color = Color.Transparent,
        ) {

            companion object{

                fun Style.copy(
                    template: Template? = null,
                    size: CornerSize? = null,
                    color: Color? = null,
                ) = Style(
                    template = template ?: this.template,
                    size = size ?: this.size,
                    color = color ?: this.color,
                )
            }

            constructor(style: Style) : this(
                template = style.template,
                size = style.size,
                color = style.color,
            )

            fun get() = template.get(size)
            fun getOrDefault() = get() ?: RoundedCornerShape(8.dp)
        }

    }

    object State{

        open class Style(
            val template: Template = Template.Rounded,
            val size: CornerSize? = null,
            val outfitColor: OutfitColorsSimple = OutfitColorsSimple(),
        ) {

            companion object{

                fun Style.copy(
                    template: Template? = null,
                    size: CornerSize? = null,
                    outfitColor: OutfitColorsSimple? = null,
                ) = Style(
                    template = template ?: this.template,
                    size = size ?: this.size,
                    outfitColor = outfitColor ?: this.outfitColor,
                )
            }

            constructor(style: Style) : this(
                template = style.template,
                size = style.size,
                outfitColor = style.outfitColor,
             )

            fun get() = template.get(size)
            fun getOrDefault() = get() ?: RoundedCornerShape(8.dp)

        }

    }
    
}

