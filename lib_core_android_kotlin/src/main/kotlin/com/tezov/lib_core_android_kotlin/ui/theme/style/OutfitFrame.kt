/*
 *  *********************************************************************************
 *  Created by Tezov on 19/02/2023 20:50
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 19/02/2023 19:59
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.theme.style


object OutfitFrame{
    
    object Simple{

        open class Style(
            val shape: OutfitShapeSimple = OutfitShapeSimple(),
            val border: OutfitBorderSimple = OutfitBorderSimple(),
        ) {

            companion object{

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
            val outfitShape: OutfitShapeState = OutfitShapeState(),
            val outfitBorder: OutfitBorderState = OutfitBorderState(),
        ) {

            companion object{

                fun Style.copy(
                    shape: OutfitShapeState? = null,
                    border: OutfitBorderState? = null,
                ) = Style(
                    outfitShape = shape ?: this.outfitShape,
                    outfitBorder = border ?: this.outfitBorder,
                )
            }

            constructor(style: Style) : this(
                outfitShape = style.outfitShape,
                outfitBorder = style.outfitBorder,
            )

        }

    }
    
}

