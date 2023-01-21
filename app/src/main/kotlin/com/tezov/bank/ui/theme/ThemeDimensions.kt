package com.tezov.bank.ui.theme

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tezov.lib_core_android_kotlin.ui.theme.definition.ThemeDimensionsExtended

object ThemeDimensions {

    val dimensionsFontExtended = ThemeDimensionsExtended.Font(
        textTitle = 20.sp,
        textSubtitle = 15.sp,
        textHelper = 12.sp,
        textHuge = 20.sp,
        textBig = 16.sp,
        textNormal = 14.sp,
        textSmall = 12.sp,
        textMicro = 10.sp,
        textField = 14.sp,
        textLink = 16.sp,
        textButton = 22.sp,
        textButton_icon = 16.sp,
        bottomNavigation = 14.sp,
        topNavigation = 19.sp,
        snackBarMessage = 19.sp,
        snackBarAction = 19.sp,
    )
    val dimensionsPaddingExtended = ThemeDimensionsExtended.Padding(
        screen_h = 6.dp,
        screen_v = 4.dp,
        elementHuge_v = 18.dp,
        elementBig_v = 14.dp,
        elementNormal_v = 6.dp,
        elementSmall_v = 4.dp,
        elementMicro_v = 2.dp,
        elementHuge_h = 16.dp,
        elementBig_h = 10.dp,
        elementNormal_h = 6.dp,
        elementSmall_h = 2.dp,
        elementMicro_h = 1.dp,
        textBig_v = 8.dp,
        textNormal_v = 4.dp,
        textSmall_v = 2.dp,
        textBig_h = 8.dp,
        textNormal_h = 4.dp,
        textSmall_h = 2.dp,
        buttonBig_v = 8.dp,
        buttonNormal_v = 4.dp,
        buttonSmall_v = 2.dp,
        buttonBig_h = 8.dp,
        buttonNormal_h = 4.dp,
        buttonSmall_h = 2.dp,
        blockBig_v = 12.dp,
        blockNormal_v = 6.dp,
        blockSmall_v = 3.dp,
        blockBig_h = 18.dp,
        blockNormal_h = 14.dp,
        blockSmall_h = 9.dp,
        bottomNavigation = 4.dp,
        topNavigation = 4.dp
    )
    val dimensionsElevationExtended = ThemeDimensionsExtended.Elevation(
        elevationBig = 10.dp,
        elevationNormal = 6.dp,
        elevationSmall = 3.dp,
    )
    val dimensionsWidgetExtended = ThemeDimensionsExtended.Widget(
        swiperPagerIndicatorSizeNormal = 14.dp,
        swiperPagerIndicatorSpacingNormal = 16.dp,
    )
}