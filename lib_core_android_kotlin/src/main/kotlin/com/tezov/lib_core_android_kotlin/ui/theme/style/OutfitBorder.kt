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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object OutfitBorder{

    enum class Template{
        Fill;

        fun get(size: Dp?, color: Color) = size?.let {
            when(this){
                Fill -> BorderStroke(size, color)
            }
        }

    }

    object Simple{

        open class Style(
            val template: Template = Template.Fill,
            val size: Dp? = null,
            val color: Color = Color.Transparent,
        ) {

            companion object{

                fun Style.copy(
                    template: Template? = null,
                    size: Dp? = null,
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

            fun get() = template.get(size, color)
            fun getOrDefault() = get() ?: BorderStroke(1.dp, Color.Black)

        }

    }

    object State{

        open class Style(
            val template: Template = Template.Fill,
            val size: Dp? = null,
            val outfitColor: OutfitColorsSimple = OutfitColorsSimple(),
        ) {

            companion object{

                fun Style.copy(
                    template: Template? = null,
                    size: Dp? = null,
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

            fun get(enabled:Boolean) = template.get(size, outfitColor.resolve(enabled))
            fun getOrDefault(enabled:Boolean) = get(enabled) ?: BorderStroke(1.dp, Color.Black)
        }


    }
    
}

