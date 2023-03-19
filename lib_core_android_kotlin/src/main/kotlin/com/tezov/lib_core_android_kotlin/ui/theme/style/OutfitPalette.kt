/*
 *  *********************************************************************************
 *  Created by Tezov on 19/03/2023 12:48
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 19/03/2023 12:47
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */
package com.tezov.lib_core_android_kotlin.ui.theme.style

import androidx.compose.runtime.Composable

typealias OutfitPaletteColor = OutfitPalette.Color
typealias OutfitPaletteColorDual = OutfitStateDual<OutfitPaletteColor>
typealias OutfitPaletteColorSemantic = OutfitStateSemantic<OutfitPaletteColor>

object OutfitPalette {

    open class Color(
        val default: androidx.compose.ui.graphics.Color = androidx.compose.ui.graphics.Color.Unspecified,
        val light: androidx.compose.ui.graphics.Color = androidx.compose.ui.graphics.Color.Unspecified,
        val dark: androidx.compose.ui.graphics.Color = androidx.compose.ui.graphics.Color.Unspecified,
        val accent: androidx.compose.ui.graphics.Color = androidx.compose.ui.graphics.Color.Unspecified,
    ) {

        companion object{

            open class Builder internal constructor(style: Color) {
                var default = style.default
                var light = style.light
                var dark = style.dark
                var accent = style.accent

                internal fun get() = Color(
                    default = default,
                    light = light,
                    dark = dark,
                    accent = accent,
                )
            }

            @Composable
            fun Color.copy(builder: @Composable Builder.()->Unit = {}) = Builder(this).also {
                it.builder()
            }.get()
        }

        constructor(style: Color) : this(
            default = style.default,
            light = style.light,
            dark = style.dark,
            accent = style.accent,
        )
    }

}