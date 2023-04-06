/*
 *  *********************************************************************************
 *  Created by Tezov on 06/04/2023 11:00
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 06/04/2023 11:00
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */
package com.tezov.lib_core_android_kotlin.ui.theme.style

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack
import com.tezov.lib_core_kotlin.extension.ExtensionCollection.firstNotNull
import androidx.compose.ui.graphics.Color as ColorImport

typealias OutfitPaletteColor = OutfitPalette.Color.Style
typealias OutfitPaletteColorDual = OutfitStateDual<OutfitPaletteColor>
typealias OutfitPaletteColorSemantic = OutfitStateSemantic<OutfitPaletteColor>

typealias OutfitPaletteSize<T> = OutfitPalette.Size.Style<T>
typealias OutfitPaletteDirection<T> = OutfitPalette.Direction.Style<T>

object OutfitPalette {

    object Color {

        class StyleBuilder internal constructor(val style: Style) {
            var default = style.default
            var light = style.light
            var dark = style.dark
            var accent = style.accent

            internal fun get() = Style(
                default = default,
                light = light,
                dark = dark,
                accent = accent,
            )
        }

        class Style(
            val default: ColorImport,
            light: ColorImport? = null,
            dark: ColorImport? = null,
            accent: ColorImport? = null,
        ) : DelegateNullFallBack.Group<ColorImport> {

            val light: ColorImport by DelegateNullFallBack(light)
            val dark: ColorImport by DelegateNullFallBack(dark)
            val accent: ColorImport by DelegateNullFallBack(accent)

            override fun groupFallBackRefs() = listOf(light, dark, accent)

            init {
                groupLazyFallBackValue = { default }
            }

            companion object {

                @Composable
                fun Style.copy(builder: @Composable StyleBuilder.() -> Unit = {}) =
                    StyleBuilder(this).also {
                        it.builder()
                    }.get()

                inline val ColorImport.asPaletteColor: Style
                    get() = Style(default = this)

            }

            constructor(style: Style) : this(
                default = style.default,
                light = style.light,
                dark = style.dark,
                accent = style.accent,
            )
        }

    }

    object Size {

        class StyleBuilder<T : Any> internal constructor(val style: Style<T>) {
            var micro = style.micro
            var small = style.small
            var normal = style.normal
            var big = style.big
            var huge = style.huge
            var supra = style.supra


            internal fun get() = Style(
                micro = micro,
                small = small,
                normal = normal,
                big = big,
                huge = huge,
                supra = supra,
            )
        }

        class Style<T : Any>(
            val normal: T,
            micro: T? = null,
            small: T? = null,
            big: T? = null,
            huge: T? = null,
            supra: T? = null,
        ) : DelegateNullFallBack.Group<T> {

            val micro: T by DelegateNullFallBack(micro)
            val small: T by DelegateNullFallBack(small)
            val big: T by DelegateNullFallBack(big)
            val huge: T by DelegateNullFallBack(huge)
            val supra: T by DelegateNullFallBack(supra)

            override fun groupFallBackRefs() = listOf(micro, small, big, huge, supra)

            init {
                groupLazyFallBackValue = { normal }
            }

            companion object {

                @Composable
                fun <T : Any> Style<T>.copy(builder: @Composable StyleBuilder<T>.() -> Unit = {}) =
                    StyleBuilder(this).also {
                        it.builder()
                    }.get()

                inline val Dp.asPaletteSize: Style<Dp>
                    get() = Style(normal = this)

                inline val Int.asPaletteSize: Style<Dp>
                    get() = this.dp.asPaletteSize

                inline val Double.asPaletteSize: Style<Dp>
                    get() = this.dp.asPaletteSize

            }

            constructor(style: Style<T>) : this(
                micro = style.micro,
                small = style.small,
                normal = style.normal,
                big = style.big,
                huge = style.huge,
                supra = style.supra,
            )
        }

    }

    object Direction {

        class StyleBuilder<T : Any> internal constructor(val style: Style<T>) {
            var vertical = style.vertical
            var horizontal = style.horizontal

            internal fun get() = Style(
                vertical = vertical,
                horizontal = horizontal,
            )
        }

        class Style<T : Any>(
            vertical: T? = null,
            horizontal: T? = null,
        ) : DelegateNullFallBack.Group<T> {

            val vertical: T by DelegateNullFallBack(vertical)
            val horizontal: T by DelegateNullFallBack(horizontal)

            override fun groupFallBackRefs() = listOf(vertical, horizontal)

            init {
                groupFallBackRefs().firstNotNull()?.let {
                    groupLazyFallBackValue = { it }
                }
            }

            companion object {

                @Composable
                fun <T : Any> Style<T>.copy(builder: @Composable StyleBuilder<T>.() -> Unit = {}) =
                    StyleBuilder(this).also {
                        it.builder()
                    }

                inline val Dp.asPaletteDirection: Style<Dp>
                    get() = Style(all = this)

                inline val Int.asPaletteSize: Style<Dp>
                    get() = this.dp.asPaletteDirection

                inline val Double.asPaletteSize: Style<Dp>
                    get() = this.dp.asPaletteDirection
            }

            constructor(all: T? = null) : this(
                vertical = all,
                horizontal = all,
            )

            constructor(style: Style<T>) : this(
                vertical = style.vertical,
                horizontal = style.horizontal,
            )
        }

    }

}