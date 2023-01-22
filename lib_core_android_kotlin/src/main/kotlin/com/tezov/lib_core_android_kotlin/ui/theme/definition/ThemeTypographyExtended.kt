package com.tezov.lib_core_android_kotlin.ui.theme.definition

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.text.TextStyle


val MaterialTheme.typographyExtended: ThemeTypographyExtended.Data
    @Composable
    @ReadOnlyComposable
    get() = ThemeTypographyExtended.local.current

object ThemeTypographyExtended{
    @Immutable
    data class Data(
        val textTitle: TextStyle,
        val textSubtitle: TextStyle,
        val textHelper: TextStyle,
        val textNormal: TextStyle,
        val textBig: TextStyle,
        val textHuge: TextStyle,
        val textSmall: TextStyle,
        val textField: TextStyle,
        val textLink: TextStyle,
        val textButton: TextStyle,
        val textButtonIcon: TextStyle,
        val topNavigationTitle: TextStyle,
        val bottomNavigationLabel: TextStyle,
        val snackBarMessage: TextStyle,
        val snackBarAction: TextStyle,
    )
    val local: ProvidableCompositionLocal<Data> = staticCompositionLocalOf {
        error("not provided")
    }

}