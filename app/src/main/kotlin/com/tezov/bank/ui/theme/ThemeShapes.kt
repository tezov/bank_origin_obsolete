package com.tezov.bank.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp
import com.tezov.bank.ui.theme.ThemeColors.colorsLight
import com.tezov.lib_core_android_kotlin.ui.theme.definition.ThemeShapesExtended

object ThemeShapes {

    val shapeCommonExtended = ThemeShapesExtended.Common(
        cardBig = RoundedCornerShape(12.dp),
        cardNormal = RoundedCornerShape(8.dp),
        cardSmall = RoundedCornerShape(4.dp),

        buttonBig = RoundedCornerShape(12.dp),
        buttonNormal = RoundedCornerShape(8.dp),
        buttonSmall = RoundedCornerShape(4.dp),

        dialog = RoundedCornerShape(8.dp),
        snackbar = RoundedCornerShape(12.dp),
        bottomSheet = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp),
    )

    val shapeBorderExtended = ThemeShapesExtended.Border(
        dialog =  BorderStroke(2.dp, colorsLight.primary),
        button = BorderStroke(2.dp, colorsLight.primary),
    )

    val shapeWidgetExtended = ThemeShapesExtended.Widget(
        swiperPagerIndicator = CircleShape
    )

}