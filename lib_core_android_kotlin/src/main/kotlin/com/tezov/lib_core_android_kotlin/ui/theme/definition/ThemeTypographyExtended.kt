package com.tezov.lib_core_android_kotlin.ui.theme.definition

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.text.TextStyle


val MaterialTheme.typographyExtended: ThemeTypographyExtended.Common
    @Composable
    @ReadOnlyComposable
    get() = ThemeTypographyExtended.localCommon.current
infix fun MaterialTheme.provides(value: ThemeTypographyExtended.Common) = ThemeTypographyExtended.localCommon provides value

object ThemeTypographyExtended{
    @Immutable
    data class Common(
        val textTitle: TextStyle,
        val textSubtitle: TextStyle,
        val textHelper: TextStyle,
        val textNormal: TextStyle,
        val textSupra: TextStyle,
        val textBig: TextStyle,
        val textHuge: TextStyle,
        val textSmall: TextStyle,
        val textFieldValue: TextStyle,
        val textFieldLabel: TextStyle,
        val textLink: TextStyle,
        val textButton: TextStyle,
        val textButtonOutline: TextStyle,
        val topNavigationTitle: TextStyle,
        val bottomNavigationLabel: TextStyle,
        val snackBarMessage: TextStyle,
        val snackBarAction: TextStyle,
    )
    internal val localCommon: ProvidableCompositionLocal<Common> = staticCompositionLocalOf {
        error("not provided")
    }

}