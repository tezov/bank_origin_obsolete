/*
 *  *********************************************************************************
 *  Created by Tezov on 06/02/2023 21:15
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 06/02/2023 20:39
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.ui.theme.definition.ThemeShapesExtended

object ThemeShapes {

    @Composable
    fun provideShapes() = ThemeShapesExtended.Shapes(
        roundedCornerHuge = RoundedCornerShape(28.dp),
        roundedCornerBig = RoundedCornerShape(20.dp),
        roundedCornerNormal = RoundedCornerShape(12.dp),
        roundedCornerSmall = RoundedCornerShape(8.dp),
        roundedCornerMicro = RoundedCornerShape(4.dp),
        dialog = RoundedCornerShape(8.dp),
        snackbar = RoundedCornerShape(12.dp),
        bottomSheet = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp),
    )

    @Composable
    fun provideBorders() = ThemeShapesExtended.Borders(
        strokeSmall =  BorderStroke(1.dp, MaterialTheme.colors.primary),
        strokeNormal =  BorderStroke(1.5.dp, MaterialTheme.colors.primary),
        strokeBig =  BorderStroke(2.2.dp, MaterialTheme.colors.primary),
        strokeHuge =  BorderStroke(4.dp, MaterialTheme.colors.primary),
        strokeSupra =  BorderStroke(5.5.dp, MaterialTheme.colors.primary),
        dialog =  BorderStroke(2.dp, MaterialTheme.colors.primary),
        button = BorderStroke(2.dp, MaterialTheme.colors.primary),
        buttonOutlined = BorderStroke(1.5.dp, MaterialTheme.colors.primary),
    )

}