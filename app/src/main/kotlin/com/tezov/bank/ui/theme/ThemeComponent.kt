/*
 *  *********************************************************************************
 *  Created by Tezov on 26/02/2023 18:03
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 26/02/2023 18:03
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.theme

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tezov.bank.ui.component.branch.SectionActionCard
import com.tezov.bank.ui.component.branch.SectionActionRow
import com.tezov.bank.ui.component.leaf.ActionCard
import com.tezov.bank.ui.component.leaf.ActionRow
import com.tezov.lib_core_android_kotlin.ui.component.branch.HorizontalScrollable
import com.tezov.lib_core_android_kotlin.ui.component.branch.HorizontalScrollable.Pager.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.theme.*

object ThemeComponent {

    @Composable
    fun provideSectionRowStyle() = SectionActionRow.Style(
        dimensionPaddingBody_h = MaterialTheme.dimensionsPaddingExtended.page_h,
        iconStyle = MaterialTheme.colors.primary,
        dimensionIcon = MaterialTheme.dimensionsSizeExtended.iconInfo,
        typographyHeader = MaterialTheme.typographiesSimpleExtended.textNormal.typo.copy(
            color = MaterialTheme.colorsCommonExtended.onBackgroundElevated,
            fontWeight = FontWeight.SemiBold
        ),
        colorBackgroundHeader = MaterialTheme.colorsCommonExtended.backgroundElevated.copy(
            alpha = 0.14f
        ),
        colorDivider = MaterialTheme.colorsCommonExtended.backgroundElevated.copy(
            alpha = 0.05f
        ),
        dimensionDivider = MaterialTheme.dimensionsSizeExtended.dividerNormal,
        actionRowStyle = provideActionRowStyle()
    )

    @Composable
    fun provideActionRowStyle() = ActionRow.Style(
        colorIconInfo = MaterialTheme.colors.primary,
        dimensionIconInfo = MaterialTheme.dimensionsSizeExtended.iconInfo,
        outfitText = MaterialTheme.typographiesSimpleExtended.textNormal.typo.copy(
            fontWeight = FontWeight.SemiBold
        ),
        colorIconAction = MaterialTheme.colors.primary,
        dimensionIconAction = MaterialTheme.dimensionsSizeExtended.iconAction,
    )

    @Composable
    fun provideSectionCardStyle() = SectionActionCard.Style(
        dimensionPaddingBody_h = MaterialTheme.dimensionsPaddingExtended.page_h,
        colorIcon = MaterialTheme.colors.primary,
        dimensionIcon = MaterialTheme.dimensionsSizeExtended.iconInfo,
        typographyHeader = MaterialTheme.typographiesSimpleExtended.textNormal.typo.copy(
            color = MaterialTheme.colorsCommonExtended.onBackgroundElevated,
            fontWeight = FontWeight.SemiBold
        ),
        colorBackgroundHeader = MaterialTheme.colorsCommonExtended.backgroundElevated.copy(
            alpha = 0.14f
        ),
        actionCardStyle = provideActionCardStyle()
    )

    @Composable
    fun provideActionCardStyle() = ActionCard.Style(
        shapeCard = MaterialTheme.shapesExtended.roundedCornerNormal.get() ?: RoundedCornerShape(4.dp),
//        borderCard = MaterialTheme.bordersExtended.strokeNormal.copy(
//            brush = SolidColor(
//                MaterialTheme.colorsCommonExtended.backgroundElevated.copy(
//                    alpha = 0.12f
//                )
//            )
//        ),
        colorIcon = MaterialTheme.colors.primary,
        dimensionsIcon = 56.dp,
        outfitTextTitle = MaterialTheme.typographiesSimpleExtended.textNormal.typo.copy(
            fontWeight = FontWeight.Bold
        ),
        outfitTextSubtitle = MaterialTheme.typographiesSimpleExtended.textSubtitle.typo,
        background = MaterialTheme.colorsCommonExtended.backgroundElevated,
    )

    @Composable
    fun providePagerStyle() = HorizontalScrollable.Pager.Style(
        colorIndicatorActive = MaterialTheme.colorsCommonExtended.backgroundButtonConfirm.active,
        colorIndicatorInactive = MaterialTheme.colorsCommonExtended.onSecondaryVariant,
        dimensionIndicatorPaddingTop = MaterialTheme.dimensionsPaddingExtended.elementNormal_v,
        dimensionIndicatorSize = 12.dp,
        dimensionIndicatorSpacing = MaterialTheme.dimensionsSpacingExtended.normal_h,
        shapeIndicator = CircleShape
    )

    @Composable
    fun provideCarouselStyle() = providePagerStyle().copy(
        padding = PaddingValues(horizontal = 26.dp)
    )

}