/*
 *  *********************************************************************************
 *  Created by Tezov on 05/04/2023 23:47
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 05/04/2023 23:47
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
import com.tezov.lib_core_android_kotlin.ui.theme.theme.*
import com.tezov.lib_core_android_kotlin.ui.extension.ExtensionCompositionLocal

object ThemeApplication {
    @Composable
    fun BankDefault(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {

        ExtensionCompositionLocal.CompositionLocalProvider(
            ancestor = arrayOf(
                MaterialTheme provides ThemeColorsResource.Common,
                MaterialTheme provides ThemeColorProviders.common(),
                MaterialTheme provides ThemeColorProviders.buttons(),
                MaterialTheme provides ThemeColorProviders.links(),
                MaterialTheme provides ThemeDimensionProviders.paddings(),
                MaterialTheme provides ThemeDimensionProviders.spacings(),
                MaterialTheme provides ThemeDimensionProviders.elevations(),
                MaterialTheme provides ThemeDimensionProviders.sizes(),
            ),
            parent = {
                arrayOf(
                    MaterialTheme provides ThemeTypographyProviders.common(),
                    MaterialTheme provides ThemeTypographyProviders.buttons(),
                    MaterialTheme provides ThemeTypographyProviders.links(),
                    MaterialTheme provides ThemeShapeProviders.common(),
                    MaterialTheme provides ThemeShapeProviders.buttons(),
                    MaterialTheme provides ThemeBorderProviders.common(),
                    MaterialTheme provides ThemeBorderProviders.buttons(),
                )
            },
            child = {
                arrayOf(
                    //components
                    MaterialTheme provides ThemeComponentProviders.provideComponentsCommon(),
                    MaterialTheme provides ThemeComponentProviders.provideComponentsButton(),
                    MaterialTheme provides ThemeComponentProviders.provideComponentsLink(),
                )
            },
        ){
            MaterialTheme(
                colors = ThemeColorProviders.material(),
                typography = androidx.compose.material.Typography(),
                content = content
            )
        }

    }
}








