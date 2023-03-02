/*
 *  *********************************************************************************
 *  Created by Tezov on 02/03/2023 20:30
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 02/03/2023 20:30
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

fun Modifier.background(style: OutfitColorsState.Simple.Style, enabled: Boolean) =
    style.resolve(enabled).takeIf { it.isSpecified }?.let { background(it) } ?: this

object OutfitColorsState {

    object Simple{

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