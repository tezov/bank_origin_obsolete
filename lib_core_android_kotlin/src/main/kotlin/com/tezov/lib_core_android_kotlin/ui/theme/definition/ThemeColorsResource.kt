/*
 *  *********************************************************************************
 *  Created by Tezov on 30/01/2023 20:18
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 30/01/2023 20:11
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.theme.definition

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

val MaterialTheme.colorsCommonResource: ThemeColorsResource.Common
    @Composable
    @ReadOnlyComposable
    get() = ThemeColorsResource.localCommon.current
infix fun MaterialTheme.provides(value: ThemeColorsResource.Common) = ThemeColorsResource.localCommon provides value

object ThemeColorsResource {

    object Common {
        val transparent: Color = Color.Transparent
        val red: Color = Color(0xFFFF0000)
        val green: Color = Color(0xFF00FF00)
        val blue: Color = Color(0xFF0000FF)
        val yellow: Color = Color(0xFFFFFF00)
        val black: Color = Color(0xFF000000)
        val white: Color = Color(0xFFFFFFFF)
        val cian: Color = Color(0xFF00FFFF)
        val magenta: Color = Color(0xFFFF00FF)
        val gray: Color = Color(0xFF888888)
        val grayLight: Color = Color(0xFF4F5050)
        val whiteGray: Color = Color(0xFF8D8D8D)
        val orange: Color = Color(0xFFD37A73)
        val orangeGray: Color = Color(0xFFDF9C86)
        val orangeLight: Color = Color(0xFFE4B8AA)
        val blueLight: Color = Color(0xFF6741BB)
        val greenMelon: Color = Color(0xFF52E057)

    }
    internal val localCommon = staticCompositionLocalOf { Common }

}




