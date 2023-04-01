/*
 *  *********************************************************************************
 *  Created by Tezov on 01/04/2023 21:02
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 01/04/2023 20:46
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */
package com.tezov.lib_core_android_kotlin.ui.theme.style

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp

typealias OutfitPaletteColor = OutfitPalette.Color
typealias OutfitPaletteColorDual = OutfitStateDual<OutfitPaletteColor>
typealias OutfitPaletteColorSemantic = OutfitStateSemantic<OutfitPaletteColor>

object OutfitPalette {

    class Color(
        val default: androidx.compose.ui.graphics.Color = androidx.compose.ui.graphics.Color.Unspecified,
        val light: androidx.compose.ui.graphics.Color = androidx.compose.ui.graphics.Color.Unspecified,
        val dark: androidx.compose.ui.graphics.Color = androidx.compose.ui.graphics.Color.Unspecified,
        val accent: androidx.compose.ui.graphics.Color = androidx.compose.ui.graphics.Color.Unspecified,
    ) {

        companion object{

            class Builder internal constructor(style: Color) {
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

    class Variant<T:Any>(
        val micro: T,
        val small: T,
        val normal: T,
        val big: T,
        val huge: T,
        val supra: T,
    ) {

        companion object{

            class Builder<T:Any> internal constructor(style: Variant<T>) {
                var micro = style.micro
                var small = style.small
                var normal = style.normal
                var big = style.big
                var huge = style.huge
                var supra = style.supra


                internal fun get() = Variant(
                    micro = micro,
                    small = small,
                    normal = normal,
                    big = big,
                    huge = huge,
                    supra = supra,
                )
            }

            @Composable
            fun <T:Any> Variant<T>.copy(builder: @Composable Builder<T>.()->Unit = {}) = Builder(this).also {
                it.builder()
            }.get()
        }

        constructor(style: Variant<T>) : this(
            micro = style.micro,
            small = style.small,
            normal = style.normal,
            big = style.big,
            huge = style.huge,
            supra = style.supra,
        )
    }

    class Direction<T:Any>(
        val vertical: T,
        val horizontal: T,
    ) {

        companion object{

            class Builder<T:Any> internal constructor(style: Direction<T>) {
                var vertical = style.vertical
                var horizontal = style.horizontal

                internal fun get() = Direction(
                    vertical = vertical,
                    horizontal = horizontal,
                )
            }

            @Composable
            fun <T:Any> Direction<T>.copy(builder: @Composable Builder<T>.()->Unit = {}) = Builder(this).also {
                it.builder()
            }.get()
        }

        constructor(style: Direction<T>) : this(
            vertical = style.vertical,
            horizontal = style.horizontal,
        )
    }



}