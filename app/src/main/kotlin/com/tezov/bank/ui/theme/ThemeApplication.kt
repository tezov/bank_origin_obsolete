/*
 *  *********************************************************************************
 *  Created by Tezov on 08/04/2023 15:32
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/04/2023 15:29
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
                MaterialTheme provides ThemeColorProviders.common(),
                MaterialTheme provides ThemeDimensionProviders.paddings(),
                MaterialTheme provides ThemeDimensionProviders.common(),
                MaterialTheme provides ThemeDimensionProviders.paddings(),
                MaterialTheme provides ThemeDimensionProviders.icons(),
                MaterialTheme provides ThemeTypographyProviders.common(),
                MaterialTheme provides ThemeShapeProviders.common(),
                MaterialTheme provides ThemeBorderProviders.common(),
            ),
            parent = {
                arrayOf(
                    MaterialTheme provides ThemeComponentProviders.provideComponentsCommon(),
                )
            },
        ){
            MaterialTheme(
                colors = ThemeColorsExtended.materialLight(),
                typography = androidx.compose.material.Typography(),
                content = content
            )
        }

    }
}








