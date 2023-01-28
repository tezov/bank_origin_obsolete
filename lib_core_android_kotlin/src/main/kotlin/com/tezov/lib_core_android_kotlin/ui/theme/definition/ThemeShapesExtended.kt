package com.tezov.lib_core_android_kotlin.ui.theme.definition

import androidx.compose.foundation.BorderStroke
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*

val MaterialTheme.shapesExtended: ThemeShapesExtended.Shapes
    @Composable
    @ReadOnlyComposable
    get() = ThemeShapesExtended.localShapes.current
infix fun MaterialTheme.provides(value: ThemeShapesExtended.Shapes) = ThemeShapesExtended.localShapes provides value

val MaterialTheme.bordersExtended: ThemeShapesExtended.Borders
    @Composable
    @ReadOnlyComposable
    get() = ThemeShapesExtended.localBorders.current
infix fun MaterialTheme.provides(value: ThemeShapesExtended.Borders) = ThemeShapesExtended.localBorders provides value

object ThemeShapesExtended{

    @Immutable
    data class Shapes(
        val cardSmall: androidx.compose.ui.graphics.Shape,
        val cardNormal: androidx.compose.ui.graphics.Shape,
        val cardBig: androidx.compose.ui.graphics.Shape,
        val buttonSmall: androidx.compose.ui.graphics.Shape,
        val buttonNormal: androidx.compose.ui.graphics.Shape,
        val buttonBig: androidx.compose.ui.graphics.Shape,
        val buttonOutlinedSmall: androidx.compose.ui.graphics.Shape,
        val buttonOutlinedNormal: androidx.compose.ui.graphics.Shape,
        val buttonOutlinedBig: androidx.compose.ui.graphics.Shape,
        val dialog: androidx.compose.ui.graphics.Shape,
        val snackbar: androidx.compose.ui.graphics.Shape,
        val bottomSheet: androidx.compose.ui.graphics.Shape,
    )
    internal val localShapes: ProvidableCompositionLocal<Shapes> = staticCompositionLocalOf {
        error("not provided")
    }

    @Immutable
    data class Borders(
        val dialog: BorderStroke,
        val button: BorderStroke,
    )
    internal val localBorders: ProvidableCompositionLocal<Borders> = staticCompositionLocalOf {
        error("not provided")
    }

}