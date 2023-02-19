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

object OutfitFrame{
    
    object Simple{

        open class Style(
            val shape: OutfitShapeSimple = Default.shape,
            val border: OutfitBorderSimple = Default.border,
        ) {

            companion object{
                val Default = Style(
                    shape = OutfitShapeSimple(
                        color = Color.Gray
                    ),
                    border = OutfitBorderSimple(
                        color = Color.Black
                    ),
                )

                fun Style.copy(
                    shape: OutfitShapeSimple? = null,
                    border: OutfitBorderSimple? = null,
                ) = Style(
                    shape = shape ?: this.shape,
                    border = border ?: this.border,
                )
            }

            constructor(style: Style) : this(
                shape = style.shape,
                border = style.border,
            )

        }

    }

    object State{

        open class Style(
            val outfitShape: OutfitShapeState = Default.outfitShape,
            val border: OutfitBorderState = Default.border,
        ) {

            companion object{
                val Default = Style(
                    outfitShape = OutfitShapeState(
                        outfitColor = OutfitColorsSimple(
                            active = Color.Gray,
                            inactive = Color.Gray.copy(alpha = 0.25f)
                        )
                    ),
                    border = OutfitBorderState(
                        colors = OutfitColorsSimple(
                            active = Color.Black,
                            inactive = Color.Black.copy(alpha = 0.25f)
                        )
                    ),
                )

                fun Style.copy(
                    shape: OutfitShapeState? = null,
                    border: OutfitBorderState? = null,
                ) = Style(
                    outfitShape = shape ?: this.outfitShape,
                    border = border ?: this.border,
                )
            }

            constructor(style: Style) : this(
                outfitShape = style.outfitShape,
                border = style.border,
            )

        }

    }
    
}

