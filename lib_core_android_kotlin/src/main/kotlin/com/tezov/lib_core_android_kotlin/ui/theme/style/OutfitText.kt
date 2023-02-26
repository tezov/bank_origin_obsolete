/*
 *  *********************************************************************************
 *  Created by Tezov on 26/02/2023 12:51
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 26/02/2023 12:03
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */
package com.tezov.lib_core_android_kotlin.ui.theme.style

import androidx.compose.foundation.BorderStroke
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

object OutfitText {

    object Simple{

        open class Style(
            val typo: TextStyle = TextStyle(),
            val color: Color = Color.Black,
        ) {

            companion object{

                fun Style.copy(
                    text: TextStyle? = null,
                    color: Color? = null,
                ) = Style(
                    typo = text ?: this.typo,
                    color = color ?: this.color,
                )
            }

            constructor(style: Style) : this(
                typo = style.typo,
                color = style.color,
            )

            fun resolve() = typo.copy(color = color)
        }

    }

    object State{

        open class Style(
            val typo: TextStyle = TextStyle(),
            val outfitColor: OutfitColorsSimple = OutfitColorsSimple(
                active = Color.Black,
                inactive = Color.Black
            ),
        ) {

            companion object{

                fun Style.copy(
                    text: TextStyle? = null,
                    outfitColors: OutfitColorsSimple? = null,
                ) = Style(
                    typo = text ?: this.typo,
                    outfitColor = outfitColors ?: this.outfitColor,
                )
            }

            constructor(style: Style) : this(
                typo = style.typo,
                outfitColor = style.outfitColor,
            )

            fun resolve(enabled:Boolean) = typo.copy(color = outfitColor.resolve(enabled))

        }

    }


}