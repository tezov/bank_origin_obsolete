/*
 *  *********************************************************************************
 *  Created by Tezov on 05/03/2023 17:17
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 05/03/2023 15:57
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */
package com.tezov.lib_core_android_kotlin.ui.theme.style

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object OutfitColor {

    object Semantic{

        open class Style(
            val neutral: Color = Color.Unspecified,
            val info: Color = Color.Unspecified,
            val alert: Color = Color.Unspecified,
            val error: Color = Color.Unspecified,
            val success: Color = Color.Unspecified,
        ) {

            companion object{

                open class Builder internal constructor(style: Style) {
                    var neutral = style.neutral
                    var info = style.info
                    var alert = style.alert
                    var error = style.error
                    var success = style.success

                    internal fun get() = Style(
                        neutral = neutral,
                        info = info,
                        alert = alert,
                        error = error,
                        success = success,
                    )
                }

                @Composable
                fun Style.copy(builder: @Composable Builder.()->Unit = {}) = Builder(this).also {
                    it.builder()
                }.get()
            }

            constructor(style: Style) : this(
                neutral = style.neutral,
                info = style.info,
                alert = style.alert,
                error = style.error,
                success = style.success,
            )
        }

    }

    object Palette{

        open class Style(
            val default: Color = Color.Unspecified,
            val light: Color = Color.Unspecified,
            val dark: Color = Color.Unspecified,
            val accent: Color = Color.Unspecified,
        ) {

            companion object{

                open class Builder internal constructor(style: Style) {
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

                @Composable
                fun Style.copy(builder: @Composable Builder.()->Unit = {}) = Builder(this).also {
                    it.builder()
                }.get()
            }

            constructor(style: Style) : this(
                default = style.default,
                light = style.light,
                dark = style.dark,
                accent = style.accent,
            )
        }

    }

}