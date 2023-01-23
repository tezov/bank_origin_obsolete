package com.tezov.bank.ui.dialog.login.auth

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tezov.bank.ui.theme.ThemeColors
import com.tezov.lib_core_android_kotlin.ui.theme.definition.*

val DialogLoginAuthTheme.colors: DialogLoginAuthTheme.Colors
    @Composable
    @ReadOnlyComposable
    get() = DialogLoginAuthTheme.localColors.current

val DialogLoginAuthTheme.dimensions: DialogLoginAuthTheme.Dimensions
    @Composable
    @ReadOnlyComposable
    get() = DialogLoginAuthTheme.localDimensions.current

val DialogLoginAuthTheme.shapes: DialogLoginAuthTheme.Shapes
    @Composable
    @ReadOnlyComposable
    get() = DialogLoginAuthTheme.localShapes.current

object DialogLoginAuthTheme {

    data class Colors(
        val background: Color,
        val onBackground: Color,
        val backgroundButtonDark: Color,
        val backgroundInactive: Color,
        val textContent: Color,
        val textButtonDark: Color,
        val textButtonLight: Color,
    )
    @Composable
    fun provideColors() = Colors(
        background = ThemeColors.Data.blackOverlay,
        onBackground = MaterialTheme.colorsCommonExtended.onPrimaryLight,
        backgroundButtonDark = MaterialTheme.colorsCommonExtended.backgroundButtonConfirm,
        backgroundInactive = MaterialTheme.colorsCommonExtended.backgroundInactive,
        textContent = MaterialTheme.colorsCommonExtended.onPrimaryLight,
        textButtonDark = MaterialTheme.colorsCommonExtended.onBackgroundButtonConfirm,
        textButtonLight = MaterialTheme.colorsCommonExtended.onBackgroundButtonCancel,
    )
    val localColors: ProvidableCompositionLocal<Colors> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Dimensions(
        val textTitle: TextUnit,
        val textNormal:TextUnit,
        val textButton:TextUnit,
        val textLink:TextUnit,

        val paddingHorizontalButton:Dp,
        val paddingVerticalButton:Dp,

    )
    @Composable
    fun provideDimensions() = Dimensions(
        textTitle = MaterialTheme.dimensionsFontExtended.textTitle,
        textNormal = MaterialTheme.dimensionsFontExtended.textNormal,
        textButton = MaterialTheme.dimensionsFontExtended.textButton,
        textLink = MaterialTheme.dimensionsFontExtended.textLink,

        paddingHorizontalButton = MaterialTheme.dimensionsPaddingExtended.buttonNormal_h,
        paddingVerticalButton = MaterialTheme.dimensionsPaddingExtended.buttonNormal_v,
    )
    val localDimensions: ProvidableCompositionLocal<Dimensions> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Shapes(
        val button: Shape,

    )
    @Composable
    fun provideShapes() = Shapes(
        button = RoundedCornerShape(35),
    )
    val localShapes: ProvidableCompositionLocal<Shapes> = staticCompositionLocalOf {
        error("not provided")
    }


}