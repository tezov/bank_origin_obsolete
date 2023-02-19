/*
 *  *********************************************************************************
 *  Created by Tezov on 19/02/2023 20:50
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 19/02/2023 19:48
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */
package com.tezov.lib_core_android_kotlin.ui.theme.style

import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


object OutfitColorsState {

    object Simple{

        open class Style(
            val active: Color = Color.Transparent,
            val inactive: Color = Color.Transparent,
        ) {

            companion object{

                fun Style.copy(
                    active: Color? = null,
                    inactive: Color? = null,
                ) = Style(
                    active = active ?: this.active,
                    inactive = inactive ?: this.inactive,
                )
            }

            constructor(style: Style) : this(
                active = style.active,
                inactive = style.inactive,
            )

            fun resolve(enabled:Boolean) = if(enabled) active else inactive

            @Composable
            fun colorButton() = ButtonDefaults.buttonColors(
                backgroundColor = active,
                disabledBackgroundColor = inactive,
            )

        }

    }

}