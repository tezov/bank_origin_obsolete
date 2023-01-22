package com.tezov.lib_core_android_kotlin.ui.theme.definition

import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp

val ThemeWidgetExtended.swiperPager: ThemeWidgetExtended.SwiperPager
    @Composable
    @ReadOnlyComposable
    get() = ThemeWidgetExtended.localSwiperPager.current

object ThemeWidgetExtended{

    val localSwiperPager: ProvidableCompositionLocal<SwiperPager> = staticCompositionLocalOf {
        error("not provided")
    }

    @Immutable
    data class SwiperPager(
        val colorIndicatorActive: Color,
        val colorIndicatorInactive: Color,
        val dimensionIndicatorPaddingTop: Dp,
        val dimensionIndicatorSize: Dp,
        val dimensionIndicatorSpacing: Dp,
        val shapeIndicator: Shape,
    )


}


