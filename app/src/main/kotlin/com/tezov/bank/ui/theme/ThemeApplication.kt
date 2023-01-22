package com.tezov.bank.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.tezov.bank.ui.theme.ThemeColors.colorsLight
import com.tezov.bank.ui.theme.ThemeColors.colorsLightCommonExtended
import com.tezov.bank.ui.theme.ThemeDimensions.dimensionsElevationExtended
import com.tezov.bank.ui.theme.ThemeDimensions.dimensionsFontExtended
import com.tezov.bank.ui.theme.ThemeDimensions.dimensionsPaddingExtended
import com.tezov.bank.ui.theme.ThemeDimensions.dimensionsSpacingExtended
import com.tezov.bank.ui.theme.ThemeShapes.shapeBorderExtended
import com.tezov.bank.ui.theme.ThemeShapes.shapeCommonExtended
import com.tezov.bank.ui.theme.ThemeTypography.typography
import com.tezov.bank.ui.theme.ThemeTypography.typographyExtended
import com.tezov.lib_core_android_kotlin.ui.theme.definition.*
import com.tezov.bank.ui.theme.font.FontRoboto
import com.tezov.bank.ui.theme.font.FontUbuntu

object ThemeApplication {
    @Composable
    fun BankDefault(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
        CompositionLocalProvider(
            //resource
            ThemeColorsResource.local provides ThemeColorsResource.Data,
            //font
            FontRoboto.local provides FontRoboto.fontFamily,
            FontUbuntu.local provides FontUbuntu.fontFamily,
            //theme extension
            //color
            ThemeColorsExtended.localCommon provides colorsLightCommonExtended,
            //shape
            ThemeShapesExtended.localCommon provides shapeCommonExtended,
            ThemeShapesExtended.localBorder provides shapeBorderExtended,
            //dimension
            ThemeDimensionsExtended.localFont provides dimensionsFontExtended,
            ThemeDimensionsExtended.localPadding provides dimensionsPaddingExtended,
            ThemeDimensionsExtended.localSpacing provides dimensionsSpacingExtended,
            ThemeDimensionsExtended.localElevation provides dimensionsElevationExtended,
            //typography
            ThemeTypographyExtended.local provides typographyExtended,
        ) {
            MaterialTheme(
                colors = colorsLight,
                typography = typography,
                content = content
            )
        }
    }
}








