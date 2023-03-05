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

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.isSpecified

fun Modifier.background(style: OutfitState.Dual.Style<Color>, enabled: Boolean) =
    style.resolve(enabled).takeIf { it?.isSpecified == true }?.let { background(it) } ?: this

object OutfitState {

    interface Style<T>

    object Dual{

        open class Style<T>(
            val active: T? = null,
            val inactive: T? = null,
        ):OutfitState.Style<T> {

            companion object{

                open class Builder<T> internal constructor(style: Style<T>) {
                    var active = style.active
                    var inactive = style.inactive

                    internal fun get() = Style(
                        active = active,
                        inactive = inactive,
                    )
                }

                @Composable
                fun <T> Style<T>.copy(builder: @Composable Builder<T>.()->Unit = {}) = Builder(this).also {
                    it.builder()
                }.get()
            }

            constructor(style: Style<T>) : this(
                active = style.active,
                inactive = style.inactive,
            )

            fun resolve(enabled:Boolean) = if(enabled) active else inactive

//            @Composable
//            fun buttonColorsOrDefault() = if(active.isSpecified || inactive.isSpecified) ButtonDefaults.buttonColors(
//                backgroundColor = active,
//                disabledBackgroundColor = inactive,
//            )
//            else ButtonDefaults.buttonColors()

        }

    }

}