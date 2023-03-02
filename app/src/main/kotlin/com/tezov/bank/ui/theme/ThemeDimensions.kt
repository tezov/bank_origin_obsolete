/*
 *  *********************************************************************************
 *  Created by Tezov on 02/03/2023 22:02
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 02/03/2023 22:02
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.theme

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tezov.lib_core_android_kotlin.ui.theme.theme.ThemeDimensionsExtended

object ThemeDimensions {

    val dimensionsPaddingExtended = ThemeDimensionsExtended.Paddings(
        page_h = 6.dp,
        page_v = 4.dp,
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
        blockBig_v = 18.dp,
        blockNormal_v = 10.dp,
        blockSmall_v = 6.dp,
        blockBig_h = 18.dp,
        blockNormal_h = 10.dp,
        blockSmall_h = 6.dp,
        bottomNavigation = 4.dp,
        topNavigation = 4.dp
    )

    val dimensionsSpacingExtended = ThemeDimensionsExtended.Spacings(
        micro_v = 4.dp,
        small_v = 8.dp,
        normal_v = 14.dp,
        big_v = 22.dp,
        huge_v = 38.dp,
        micro_h = 6.dp,
        small_h = 12.dp,
        normal_h = 18.dp,
        big_h = 28.dp,
        huge_h = 42.dp,
    )

    val dimensionsElevationExtended = ThemeDimensionsExtended.Elevations(
        elevationBig = 10.dp,
        elevationNormal = 6.dp,
        elevationSmall = 3.dp,
        dialog = 2.dp,
        snackbar = 4.dp,
        bottomSheet = 2.dp,
    )

    val dimensionsSizeExtended = ThemeDimensionsExtended.Sizes(
        iconModal = 42.dp,
        iconInfo = 36.dp,
        iconAction = 22.dp,
        iconFieldInfo = 32.dp,
        iconFieldAction = 22.dp,
        dividerSmall = 0.8.dp,
        dividerNormal = 1.2.dp,
        dividerBig = 2.4.dp,
    )
}