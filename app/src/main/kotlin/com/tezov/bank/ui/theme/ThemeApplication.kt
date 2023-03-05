/*
 *  *********************************************************************************
 *  Created by Tezov on 05/03/2023 14:03
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 04/03/2023 22:50
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.tezov.bank.ui.theme.ThemeColors.colorsLightExtended
import com.tezov.bank.ui.theme.ThemeDimensions.dimensionsElevationExtended
import com.tezov.bank.ui.theme.ThemeDimensions.dimensionsPaddingExtended
import com.tezov.bank.ui.theme.ThemeDimensions.dimensionsSizeExtended
import com.tezov.bank.ui.theme.ThemeDimensions.dimensionsSpacingExtended
import com.tezov.lib_core_android_kotlin.ui.theme.theme.*
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionCompositionLocal

object ThemeApplication {
    @Composable
    fun BankDefault(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {

        ExtensionCompositionLocal.CompositionLocalProvider(
            ancestor = arrayOf(
                //colors
                MaterialTheme provides ThemeColorsResource.Common,
                MaterialTheme provides colorsLightExtended,
                //dimensions
                MaterialTheme provides dimensionsPaddingExtended,
                MaterialTheme provides dimensionsSpacingExtended,
                MaterialTheme provides dimensionsElevationExtended,
                MaterialTheme provides dimensionsSizeExtended,
            ),
            parent = {
                arrayOf(
                    //shapes
                    MaterialTheme provides ThemeShapes.provideShapes(),
                    MaterialTheme provides ThemeShapes.provideBorders(),
                    //Typography
                    MaterialTheme provides ThemeTypography.providesTypographies(),
                )
            },
            child = {
                arrayOf(
                    //components
                    MaterialTheme provides ThemeComponents.provideComponents(),
                )
            },
        ){
            MaterialTheme(
                colors = ThemeColors.providesColorsLightMaterial(),
                typography = androidx.compose.material.Typography(),
                content = content
            )
        }

    }
}








