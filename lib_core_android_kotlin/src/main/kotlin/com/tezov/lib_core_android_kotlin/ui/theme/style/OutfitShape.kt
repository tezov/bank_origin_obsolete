/*
 *  *********************************************************************************
 *  Created by Tezov on 26/02/2023 14:06
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 26/02/2023 14:06
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_kotlin.util.UtilsNull.ifNotNull

object OutfitShape{

    enum class Template{
        Asymmetric,
        Symmetric,
        Circle;

        fun get(size: Size? = null) = size?.let {
            when(this){
                Asymmetric -> RoundedCornerShape(topStart = it.topStart, topEnd = it.topEnd, bottomStart = it.bottomStart, bottomEnd = it.bottomEnd)
                Symmetric, Circle -> RoundedCornerShape(corner = it.size)
            }
        }
    }

    data class Size private constructor(val topStart: CornerSize, val topEnd: CornerSize, val bottomStart: CornerSize, val bottomEnd: CornerSize, val isSymmetric:Boolean){
        constructor(topStart: CornerSize, topEnd: CornerSize, bottomStart: CornerSize, bottomEnd: CornerSize):this(
            topStart, topEnd, bottomStart, bottomEnd, false
        )
        constructor(percentTopStart: Int = 0, percentTopEnd: Int = 0, percentBottomStart: Int = 0, percentBottomEnd: Int = 0):this(
            CornerSize(percentTopStart), CornerSize(percentTopEnd), CornerSize(percentBottomStart), CornerSize(percentBottomEnd)
        )
        constructor(sizeTopStart: Dp = 0.dp, sizeTopEnd: Dp = 0.dp, sizeBottomStart: Dp = 0.dp, sizeBottomEnd: Dp = 0.dp):this(
            CornerSize(sizeTopStart), CornerSize(sizeTopEnd), CornerSize(sizeBottomStart), CornerSize(sizeBottomEnd)
        )

        constructor(size: CornerSize):this(size,size,size,size, true)
        constructor(percent: Int):this(CornerSize(percent))
        constructor(size: Dp):this(CornerSize(size))

        val size get() = topStart
    }

    object Simple{

        open class Style(
            template: Template = Template.Symmetric,
            size: Size? = null,
            val color: Color = Color.Transparent,
        ) {
            var template: Template =  template
                private set(value) {
                    when(value){
                        Template.Circle -> size = Size(50)
                        else -> { }
                    }
                    field = value
                }

            var size: Size? = size
                private set

            companion object{

                fun Style.copy(
                    template: Template? = null,
                    size: Size? = null,
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

            fun resolve():RoundedCornerShape? = template.get(size)
            fun resolveOrDefault() = resolve() ?: RoundedCornerShape(8.dp)
        }

    }


    object State{

        open class Style(
            template: Template = Template.Symmetric,
            size: Size? = null,
            val outfitColor: OutfitColorsSimple = OutfitColorsSimple(),
        ) {

            var template: Template =  template
                private set(value) {
                    when(value){
                        Template.Circle -> size = Size(50)
                        else -> { }
                    }
                    field = value
                }

            var size: Size? =  size
                private set

            companion object{

                fun Style.copy(
                    template: Template? = null,
                    size: Size? = null,
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

            fun resolve() = template.get(size)
            fun resolveOrDefault() = resolve() ?: RoundedCornerShape(8.dp)

        }

    }
    
}

