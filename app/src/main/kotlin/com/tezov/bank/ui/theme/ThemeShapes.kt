/*
 *  *********************************************************************************
 *  Created by Tezov on 30/01/2023 20:18
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 30/01/2023 20:11
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
import com.tezov.bank.ui.theme.ThemeColors.colorsLight
import com.tezov.lib_core_android_kotlin.ui.theme.definition.ThemeShapesExtended

object ThemeShapes {

    @Composable
    fun provideShapes() = ThemeShapesExtended.Shapes(
        cardBig = RoundedCornerShape(22.dp),
        cardNormal = RoundedCornerShape(12.dp),
        cardSmall = RoundedCornerShape(8.dp),

        buttonBig = RoundedCornerShape(20.dp),
        buttonNormal = RoundedCornerShape(14.dp),
        buttonSmall = RoundedCornerShape(8.dp),

        buttonOutlinedBig = RoundedCornerShape(50),
        buttonOutlinedNormal = RoundedCornerShape(35),
        buttonOutlinedSmall = RoundedCornerShape(15),

        dialog = RoundedCornerShape(8.dp),
        snackbar = RoundedCornerShape(12.dp),
        bottomSheet = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp),
    )

    @Composable
    fun provideBorders() = ThemeShapesExtended.Borders(
        dialog =  BorderStroke(2.dp, MaterialTheme.colors.primary),
        button = BorderStroke(2.dp, MaterialTheme.colors.primary),
    )

}