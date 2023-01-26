package com.tezov.bank.ui.dialog.login.auth

import androidx.compose.foundation.BorderStroke
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
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

val DialogLoginAuthTheme.borders: DialogLoginAuthTheme.Borders
    @Composable
    @ReadOnlyComposable
    get() = DialogLoginAuthTheme.localBorders.current

val DialogLoginAuthTheme.typographies: DialogLoginAuthTheme.Typographies
    @Composable
    @ReadOnlyComposable
    get() = DialogLoginAuthTheme.localTypographies.current

object DialogLoginAuthTheme {

    data class Colors(
        val background: Color,
        val onBackground: Color,
        val backgroundButtonDark: Color,
        val backgroundInactive: Color,
        val textButtonDark: Color,
    )
    @Composable
    fun provideColors() = Colors(
        background = ThemeColors.Data.blackOverlay,
        onBackground = MaterialTheme.colorsCommonExtended.onPrimaryLight,
        backgroundButtonDark = MaterialTheme.colorsCommonExtended.backgroundButtonConfirm,
        backgroundInactive = MaterialTheme.colorsCommonExtended.backgroundInactive,
        textButtonDark = MaterialTheme.colorsCommonExtended.onBackgroundButtonConfirm,
    )
    val localColors: ProvidableCompositionLocal<Colors> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Dimensions(
        val paddingKeyboard_v:Dp,
        val paddingKeyboard_h:Dp,
        val spacingTopToTitle:Dp,
        val spacingTopFromButton:Dp,
        val paddingTopFromLink:Dp,
        val iconCloseSize:Dp,
        val iconFieldSize:Dp,
        val paddingHorizontalButton:Dp,
        val paddingVerticalButton:Dp,
    )
    @Composable
    fun provideDimensions() = Dimensions(
        paddingKeyboard_v = MaterialTheme.dimensionsPaddingExtended.elementMicro_v,
        paddingKeyboard_h = MaterialTheme.dimensionsPaddingExtended.elementMicro_h,
        spacingTopToTitle = MaterialTheme.dimensionsSpacingExtended.big_v,
        spacingTopFromButton = MaterialTheme.dimensionsSpacingExtended.huge_v,
        paddingTopFromLink = MaterialTheme.dimensionsPaddingExtended.elementNormal_v,
        iconCloseSize = MaterialTheme.dimensionsSizeExtended.iconModal,
        iconFieldSize = MaterialTheme.dimensionsSizeExtended.iconField,
        paddingHorizontalButton = MaterialTheme.dimensionsPaddingExtended.buttonNormal_h,
        paddingVerticalButton = MaterialTheme.dimensionsPaddingExtended.buttonNormal_v,
    )
    val localDimensions: ProvidableCompositionLocal<Dimensions> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Shapes(
        val button: Shape,
        val authCard: Shape,
    )
    @Composable
    fun provideShapes() = Shapes(
        button = MaterialTheme.shapesExtended.buttonNormal,
        authCard = MaterialTheme.shapesExtended.cardSmall,
    )
    val localShapes: ProvidableCompositionLocal<Shapes> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Borders(
        val authCard: BorderStroke,
    )

    @Composable
    fun provideBorders() = Borders(
        authCard = BorderStroke(
            1.5.dp,
            colors.onBackground
        ),
    )

    val localBorders: ProvidableCompositionLocal<Borders> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Typographies(
        val title: TextStyle,
        val field: TextStyle,
        val button: TextStyle,
        val link: TextStyle,
    )

    @Composable
    fun provideTypographies() = Typographies(
        title = MaterialTheme.typographyExtended.textTitle.copy(
            color = colors.onBackground
        ),
        field = MaterialTheme.typographyExtended.textField.copy(
            color = colors.onBackground
        ),
        button = MaterialTheme.typographyExtended.textButton.copy(
            fontSize = MaterialTheme.dimensionsFontExtended.textButton,
            color = colors.onBackground
        ),
        link = MaterialTheme.typographyExtended.textLink.copy(
            fontSize = MaterialTheme.dimensionsFontExtended.textLink,
            color = colors.onBackground,
        )

    )

    val localTypographies: ProvidableCompositionLocal<Typographies> = staticCompositionLocalOf {
        error("not provided")
    }



}