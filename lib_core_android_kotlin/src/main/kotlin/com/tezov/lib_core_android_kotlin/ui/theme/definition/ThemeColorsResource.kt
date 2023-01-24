package com.tezov.lib_core_android_kotlin.ui.theme.definition

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

val MaterialTheme.colorsCommonResource: ThemeColorsResource.Common
    @Composable
    @ReadOnlyComposable
    get() = ThemeColorsResource.local.current

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
    val local = staticCompositionLocalOf { Common }

}




