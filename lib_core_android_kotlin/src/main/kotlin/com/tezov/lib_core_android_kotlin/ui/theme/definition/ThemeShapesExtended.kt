package com.tezov.lib_core_android_kotlin.ui.theme.definition

import androidx.compose.foundation.BorderStroke
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*

val MaterialTheme.shapeCommonExtended: ThemeShapesExtended.Common
    @Composable
    @ReadOnlyComposable
    get() = ThemeShapesExtended.localCommon.current

val MaterialTheme.shapeBorderExtended: ThemeShapesExtended.Border
    @Composable
    @ReadOnlyComposable
    get() = ThemeShapesExtended.localBorder.current

val MaterialTheme.shapeWidgetExtended: ThemeShapesExtended.Widget
    @Composable
    @ReadOnlyComposable
    get() = ThemeShapesExtended.localWidget.current

object ThemeShapesExtended{

    @Immutable
    data class Common(
        val cardSmall: androidx.compose.ui.graphics.Shape,
        val cardNormal: androidx.compose.ui.graphics.Shape,
        val cardBig: androidx.compose.ui.graphics.Shape,
        val buttonSmall: androidx.compose.ui.graphics.Shape,
        val buttonNormal: androidx.compose.ui.graphics.Shape,
        val buttonBig: androidx.compose.ui.graphics.Shape,
        val dialog: androidx.compose.ui.graphics.Shape,
        val snackbar: androidx.compose.ui.graphics.Shape,
        val bottomSheet: androidx.compose.ui.graphics.Shape,
    )
    val localCommon: ProvidableCompositionLocal<Common> = staticCompositionLocalOf {
        error("not provided")
    }

    @Immutable
    data class Border(
        val dialog: BorderStroke,
        val button: BorderStroke,
    )
    val localBorder: ProvidableCompositionLocal<Border> = staticCompositionLocalOf {
        error("not provided")
    }

    @Immutable
    data class Widget(
        val swiperPagerIndicator: androidx.compose.ui.graphics.Shape,
    )
    val localWidget: ProvidableCompositionLocal<Widget> = staticCompositionLocalOf {
        error("not provided")
    }

}