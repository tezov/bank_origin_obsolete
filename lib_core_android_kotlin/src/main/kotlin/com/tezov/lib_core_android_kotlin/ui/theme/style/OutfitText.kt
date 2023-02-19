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

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

object OutfitText {

    object State{

        open class Style(
            val text: TextStyle = Default.text,
            val outfitColor: OutfitColorsSimple = Default.outfitColor,
        ) {

            companion object{
                val Default = Style(
                    text = TextStyle(),
                    outfitColor = OutfitColorsSimple(
                        active = Color.Black,
                        inactive = Color.Black.copy(alpha = 0.5f)
                    ),
                )

                fun Style.copy(
                    text: TextStyle? = null,
                    outfitColors: OutfitColorsSimple? = null,
                ) = Style(
                    text = text ?: this.text,
                    outfitColor = outfitColors ?: this.outfitColor,
                )
            }

            constructor(style: Style) : this(
                text = style.text,
                outfitColor = style.outfitColor,
            )

        }

    }


}