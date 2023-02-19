/*
 *  *********************************************************************************
 *  Created by Tezov on 19/02/2023 18:23
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 19/02/2023 18:23
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
        Fill,
    }

    object Simple{

        open class Style(
            val template: Template = Default.template,
            val size: Dp? = Default.size,
            val color: Color = Default.color,
        ) {

            companion object{
                val Default = Style(
                    size = 1.dp,
                    color = Color.Black,
                    template = Template.Fill,
                )

                val Transparent = Style(
                    size = null,
                )

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

            fun get() = size?.let {
                when(template){
                    Template.Fill -> BorderStroke(size, color)
                }
            }

        }

    }

    object State{

        open class Style(
            val template: Template = Default.template,
            val size: Dp? = Default.size,
            val colors: OutfitColorsSimple = Default.colors,
        ) {

            companion object{
                val Default = Style(
                    template =  Template.Fill,
                    size = 1.dp,
                    colors = OutfitColorsSimple(
                        active = Color.Black,
                        inactive = Color.Black.copy(alpha = 0.25f)
                    ),
                )

                val Transparent = Style(
                    size = null,
                )

                fun Style.copy(
                    template: Template? = null,
                    size: Dp? = null,
                    colors: OutfitColorsSimple? = null,
                ) = Style(
                    template = template ?: this.template,
                    size = size ?: this.size,
                    colors = colors ?: this.colors,
                )
            }

            constructor(style: Style) : this(
                template = style.template,
                size = style.size,
                colors = style.colors,
            )

            fun get(enabled:Boolean) = size?.let {
                when(template){
                    Template.Fill -> BorderStroke(size, colors.resolve(enabled))
                }
            }

        }

    }
    
}

