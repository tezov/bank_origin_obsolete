/*
 *  *********************************************************************************
 *  Created by Tezov on 02/04/2023 14:12
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 02/04/2023 14:12
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */
package com.tezov.lib_core_android_kotlin.ui.theme.style

import androidx.compose.runtime.Composable
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack
import androidx.compose.ui.graphics.Color as ColorImport

typealias OutfitPaletteColor = OutfitPalette.Color
typealias OutfitPaletteColorDual = OutfitStateDual<OutfitPaletteColor>
typealias OutfitPaletteColorSemantic = OutfitStateSemantic<OutfitPaletteColor>

object OutfitPalette {

    class Color(
        val default: ColorImport,
        light: ColorImport? = null,
        dark: ColorImport? = null,
        accent: ColorImport? = null,
    ) : DelegateNullFallBack.Setter<ColorImport> {

        val light: ColorImport by DelegateNullFallBack(light)
        val dark: ColorImport by DelegateNullFallBack(dark)
        val accent: ColorImport by DelegateNullFallBack(accent)

        override fun refs() = listOf(light, dark, accent)

        init {
            nullFallback = { default }
        }

        companion object {

            class Builder internal constructor(val style: Color) {
                var default = style.default
                var light = style.light
                var dark = style.dark
                var accent = style.accent

                internal fun get() = Color(
                    default = default,
                    light = light,
                    dark = dark,
                    accent = accent,
                ).also {
                    it.nullFallback = style.nullFallback
                }
            }

            @Composable
            fun Color.copy(builder: @Composable Builder.() -> Unit = {}) = Builder(this).also {
                it.builder()
            }.get()
        }

        constructor(style: Color) : this(
            default = style.default,
            light = style.light,
            dark = style.dark,
            accent = style.accent,
        ){
            nullFallback = style.nullFallback
        }
    }

    class Variant<T : Any>(
        val normal: T,
        micro: T? = null,
        small: T? = null,
        big: T? = null,
        huge: T? = null,
        supra: T? = null,
    ) : DelegateNullFallBack.Setter<T> {

        val micro: T by DelegateNullFallBack(micro)
        val small: T by DelegateNullFallBack(small)
        val big: T by DelegateNullFallBack(big)
        val huge: T by DelegateNullFallBack(huge)
        val supra: T by DelegateNullFallBack(supra)

        override fun refs() = listOf(micro, small, big, huge, supra)

        init {
            nullFallback = { normal }
        }

        companion object {

            class Builder<T : Any> internal constructor(val style: Variant<T>) {
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
                ).also {
                    it.nullFallback = style.nullFallback
                }
            }

            @Composable
            fun <T : Any> Variant<T>.copy(builder: @Composable Builder<T>.() -> Unit = {}) =
                Builder(this).also {
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
        ){
            nullFallback = style.nullFallback
        }
    }

    class Direction<T : Any>(
        vertical: T? = null,
        horizontal: T? = null,
    ) : DelegateNullFallBack.Setter<T> {

        val vertical: T by DelegateNullFallBack(vertical)
        val horizontal: T by DelegateNullFallBack(horizontal)

        override fun refs() = listOf(vertical, horizontal)

        init {
            nullFallback = {
                horizontal ?: (vertical ?: throw UninitializedPropertyAccessException())
            }
        }

        companion object {

            class Builder<T : Any> internal constructor(val style: Direction<T>) {
                var vertical = style.vertical
                var horizontal = style.horizontal

                internal fun get() = Direction(
                    vertical = vertical,
                    horizontal = horizontal,
                ).also {
                    it.nullFallback = style.nullFallback
                }
            }

            @Composable
            fun <T : Any> Direction<T>.copy(builder: @Composable Builder<T>.() -> Unit = {}) =
                Builder(this).also {
                    it.builder()
                }
        }

        constructor(style: Direction<T>) : this(
            vertical = style.vertical,
            horizontal = style.horizontal,
        ){
            nullFallback = style.nullFallback
        }
    }

}