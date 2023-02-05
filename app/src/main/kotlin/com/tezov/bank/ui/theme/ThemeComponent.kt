/*
 *  *********************************************************************************
 *  Created by Tezov on 05/02/2023 14:26
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 05/02/2023 14:24
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tezov.bank.ui.component.branch.SectionActionCard
import com.tezov.bank.ui.component.branch.SectionActionRow
import com.tezov.bank.ui.component.leaf.ActionCard
import com.tezov.bank.ui.component.leaf.ActionRow
import com.tezov.lib_core_android_kotlin.ui.theme.definition.*

object ThemeComponent {

    @Composable
    fun provideSectionRowStyle() = SectionActionRow.Style(
        colorIcon = MaterialTheme.colors.primaryVariant,
        dimensionIcon = MaterialTheme.dimensionsSizeExtended.iconInfo,
        typographyHeader = MaterialTheme.typographyExtended.textNormal.copy(
            color = MaterialTheme.colorsCommonExtended.onBackgroundElevated
        ),
        colorBackgroundHeader = MaterialTheme.colorsCommonExtended.backgroundElevated,
        colorDivider = MaterialTheme.colorsCommonExtended.backgroundElevated.copy(
            alpha = 0.05f
        ),
        dimensionDivider = 1.dp,
    )

    @Composable
    fun provideActionRowStyle() = ActionRow.Style(
        colorIconInfo = MaterialTheme.colors.primary,
        dimensionIconInfo = MaterialTheme.dimensionsSizeExtended.iconInfo,
        typography = MaterialTheme.typographyExtended.textNormal.copy(
            fontWeight = FontWeight.SemiBold
        ),
        colorIconAction = MaterialTheme.colors.primary,
        dimensionIconAction = MaterialTheme.dimensionsSizeExtended.iconAction,
    )

    @Composable
    fun provideSectionCardStyle() = SectionActionCard.Style(
        colorIcon = MaterialTheme.colors.primaryVariant,
        dimensionIcon = MaterialTheme.dimensionsSizeExtended.iconInfo,
        typographyHeader = MaterialTheme.typographyExtended.textNormal.copy(
            color = MaterialTheme.colorsCommonExtended.onBackgroundElevated
        ),
        colorBackgroundHeader = MaterialTheme.colorsCommonExtended.backgroundElevated
    )

    @Composable
    fun provideActionCardStyle() = ActionCard.Style(
        shapeCard = MaterialTheme.shapesExtended.cardNormal,
        borderCard = MaterialTheme.bordersExtended.dialog.copy(
            brush = SolidColor(
                MaterialTheme.colorsCommonExtended.backgroundElevated.copy(
                    alpha = 0.15f
                )
            )
        ),
        colorIcon = MaterialTheme.colors.primary,
        dimensionsIcon = 56.dp,
        typographyTitle = MaterialTheme.typographyExtended.textNormal.copy(
            fontWeight = FontWeight.Bold
        ),
        typographySubtitle = MaterialTheme.typographyExtended.textSubtitle,
        background = MaterialTheme.colorsCommonExtended.backgroundElevated.copy(
            alpha = 0.05f
        ),
    )


}