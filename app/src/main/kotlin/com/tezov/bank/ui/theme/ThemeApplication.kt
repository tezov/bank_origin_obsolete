package com.tezov.bank.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.tezov.bank.ui.theme.ThemeColors.colorsLight
import com.tezov.bank.ui.theme.ThemeColors.colorsLightCommonExtended
import com.tezov.bank.ui.theme.ThemeDimensions.dimensionsElevationExtended
import com.tezov.bank.ui.theme.ThemeDimensions.dimensionsFontExtended
import com.tezov.bank.ui.theme.ThemeDimensions.dimensionsPaddingExtended
import com.tezov.bank.ui.theme.ThemeDimensions.dimensionsSizeExtended
import com.tezov.bank.ui.theme.ThemeDimensions.dimensionsSpacingExtended
import com.tezov.lib_core_android_kotlin.ui.theme.definition.*
import com.tezov.bank.ui.theme.font.FontRoboto
import com.tezov.bank.ui.theme.font.FontUbuntu
import com.tezov.lib_core_android_kotlin.ui.util.ExtensionCompositionLocal

object ThemeApplication {
    @Composable
    fun BankDefault(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
        ExtensionCompositionLocal.CompositionLocalProvider(
            parent = arrayOf(
                //colors
                MaterialTheme provides ThemeColorsResource.Common,
                MaterialTheme provides colorsLightCommonExtended,
                //dimensions
                MaterialTheme provides dimensionsFontExtended,
                MaterialTheme provides dimensionsPaddingExtended,
                MaterialTheme provides dimensionsSpacingExtended,
                MaterialTheme provides dimensionsElevationExtended,
                MaterialTheme provides dimensionsSizeExtended,
            ),
            child = {
                arrayOf(
                    //shapes
                    MaterialTheme provides ThemeShapes.provideShapes(),
                    MaterialTheme provides ThemeShapes.provideBorders(),
                    //Typography
                    MaterialTheme provides ThemeTypography.providesTypographiesExtended(),
                )
            }
        ) {
            MaterialTheme(
                colors = colorsLight,
                typography = ThemeTypography.providesTypographies(),
                content = content
            )
        }

    }
}








