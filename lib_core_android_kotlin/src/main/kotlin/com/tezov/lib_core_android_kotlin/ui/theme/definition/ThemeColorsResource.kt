package com.tezov.lib_core_android_kotlin.ui.theme.definition

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

val MaterialTheme.colorsResource: ThemeColorsResource.Data
    @Composable
    @ReadOnlyComposable
    get() = ThemeColorsResource.local.current

object ThemeColorsResource {

    object Data {
        val transparent: Color = Color.Transparent
        val red: Color = Color.Red
        val blue: Color = Color.Blue
        val green: Color = Color.Green
        val yellow: Color = Color.Yellow
        val black: Color = Color.Black
        val white: Color = Color.White
        val gray: Color = Color.Gray
        val grayLight: Color = Color(0xFFCFCCCC)
        val grayVeryLight: Color = Color(0xFFE9E7E7)
        val cian: Color = Color.Cyan
        val magenta: Color = Color.Magenta

        val whiteGrayDark: Color = Color(0xFF8D8D8D)
        val grayDark: Color = Color(0xFF4F5050)
        val whiteGrayLight: Color = Color(0xFFEFF3F0)

    }
    val local = staticCompositionLocalOf { Data }

}




