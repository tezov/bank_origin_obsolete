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
        cardBig = RoundedCornerShape(12.dp),
        cardNormal = RoundedCornerShape(8.dp),
        cardSmall = RoundedCornerShape(4.dp),

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