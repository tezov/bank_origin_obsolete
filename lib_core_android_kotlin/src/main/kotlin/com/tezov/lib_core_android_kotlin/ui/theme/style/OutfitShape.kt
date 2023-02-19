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

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

object OutfitShape{

    enum class Template{
        Rounded,
    }

    object Simple{

        open class Style(
            val template: Template = Default.template,
            val size: CornerSize? = Default.size,
            val color: Color = Default.color,
        ) {

            companion object{
                val Default = Style(
                    template = Template.Rounded,
                    size = CornerSize(8.dp),
                    color = Color.Gray,
                )

                val Transparent = Style(
                    color = Color.Transparent,
                )

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

            fun get() = size?.let {
                when(template){
                    Template.Rounded -> RoundedCornerShape(corner = size)
                }
            }
        }

    }

    object State{

        open class Style(
            val template: Template = Simple.Style.Default.template,
            val size: CornerSize? = Default.size,
            val outfitColor: OutfitColorsSimple = Default.outfitColor,
        ) {

            companion object{
                val Default = Style(
                    template = Template.Rounded,
                    size = CornerSize(8.dp),
                    outfitColor = OutfitColorsSimple(
                        active = Color.Gray,
                        inactive = Color.Gray.copy(alpha = 0.25f)
                    ),
                )

                val Transparent = Style(
                    outfitColor = OutfitColorsSimple.Transparent,
                )

                fun Style.copy(
                    template: Template? = null,
                    size: CornerSize? = null,
                    colors: OutfitColorsSimple? = null,
                ) = Style(
                    template = template ?: this.template,
                    size = size ?: this.size,
                    outfitColor = colors ?: this.outfitColor,
                )
            }

            constructor(style: Style) : this(
                template = style.template,
                size = style.size,
                outfitColor = style.outfitColor,
            )

            fun get() = size?.let {
                when(template){
                    Template.Rounded -> RoundedCornerShape(corner = size)
                }
            }

        }

    }
    
}

