/*
 *  *********************************************************************************
 *  Created by Tezov on 04/03/2023 21:37
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 04/03/2023 21:28
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */
package com.tezov.lib_core_android_kotlin.ui.theme.style

import androidx.compose.foundation.background
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.isSpecified

fun Modifier.background(style: OutfitColors.State.Style, enabled: Boolean) =
    style.resolve(enabled).takeIf { it.isSpecified }?.let { background(it) } ?: this

object OutfitColors {

    object Palette{

        open class Style(
            val default: Color = Color.Unspecified,
            val light: Color = Color.Unspecified,
            val accent: Color = Color.Unspecified,
        ) {

            companion object{

                open class Builder internal constructor(style: Style) {
                    var default = style.default
                    var light = style.light
                    var accent = style.accent

                    internal fun get() = Style(
                        default = default,
                        light = light,
                        accent = accent,
                    )
                }

                @Composable
                fun Style.copy(builder: @Composable Builder.()->Unit = {}) = Builder(this).also {
                    it.builder()
                }.get()
            }

            constructor(style: Style) : this(
                default = style.default,
                light = style.light,
                accent = style.accent,
            )
        }

    }

    object State{

        open class Style(
            val active: Color = Color.Unspecified,
            val inactive: Color = Color.Unspecified,
        ) {

            companion object{

                open class Builder internal constructor(style: Style) {
                    var active = style.active
                    var inactive = style.inactive

                    internal fun get() = Style(
                        active = active,
                        inactive = inactive,
                    )
                }

                @Composable
                fun Style.copy(builder: @Composable Builder.()->Unit = {}) = Builder(this).also {
                    it.builder()
                }.get()
            }

            constructor(style: Style) : this(
                active = style.active,
                inactive = style.inactive,
            )

            fun resolve(enabled:Boolean) = if(enabled) active else inactive

            @Composable
            fun buttonColorsOrDefault() = if(active.isSpecified || inactive.isSpecified) ButtonDefaults.buttonColors(
                backgroundColor = active,
                disabledBackgroundColor = inactive,
            )
            else ButtonDefaults.buttonColors()

        }

    }

}