/*
 *  *********************************************************************************
 *  Created by Tezov on 26/02/2023 18:59
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 26/02/2023 18:59
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tezov.bank.ui.component.branch.SectionActionCard
import com.tezov.bank.ui.component.branch.SectionActionRow
import com.tezov.bank.ui.component.leaf.ActionCard
import com.tezov.bank.ui.component.leaf.ActionRow
import com.tezov.lib_core_android_kotlin.ui.component.branch.HorizontalScrollable
import com.tezov.lib_core_android_kotlin.ui.component.branch.HorizontalScrollable.Pager.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.component.plain.Icon
import com.tezov.lib_core_android_kotlin.ui.theme.style.*
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitBorder.Simple.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.Simple.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.Simple.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.theme.*

object ThemeComponent {

    @Composable
    fun provideSectionRowStyle() = SectionActionRow.Style(
        dimensionPaddingBody_h = MaterialTheme.dimensionsPaddingExtended.page_h,
        iconStyle = Icon.Simple.Style(
            size = MaterialTheme.dimensionsSizeExtended.iconInfo,
            tint = MaterialTheme.colors.primary
        ),
        outfitTextHeader = MaterialTheme.typographiesSimpleExtended.textNormal.copy(
            typo = MaterialTheme.typographiesSimpleExtended.textNormal.typo.copy(
                fontWeight = FontWeight.SemiBold
            ),
            color = MaterialTheme.colorsCommonExtended.onBackgroundElevated
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
        iconInfoStyle = Icon.Simple.Style(
            size = MaterialTheme.dimensionsSizeExtended.iconInfo,
            tint = MaterialTheme.colors.primary
        ),
        iconActionStyle = Icon.Simple.Style(
            size = MaterialTheme.dimensionsSizeExtended.iconAction,
            tint = MaterialTheme.colors.primary
        ),
        outfitText = MaterialTheme.typographiesSimpleExtended.textNormal.copy(
            typo = MaterialTheme.typographiesSimpleExtended.textNormal.typo.copy(
                fontWeight = FontWeight.SemiBold
            ),
            color = MaterialTheme.colorsCommonExtended.onBackgroundElevated
        )
    )

    @Composable
    fun provideSectionCardStyle() = SectionActionCard.Style(
        iconStyle = Icon.Simple.Style(
            size = MaterialTheme.dimensionsSizeExtended.iconInfo,
            tint = MaterialTheme.colors.primary
        ),
        outfitTextHeader = MaterialTheme.typographiesSimpleExtended.textNormal.copy(
            typo = MaterialTheme.typographiesSimpleExtended.textNormal.typo.copy(
                fontWeight = FontWeight.SemiBold
            ),
            color = MaterialTheme.colorsCommonExtended.onBackgroundElevated
        ),
        colorBackgroundHeader = MaterialTheme.colorsCommonExtended.backgroundElevated.copy(
            alpha = 0.14f
        ),
        dimensionPaddingBody_h = MaterialTheme.dimensionsPaddingExtended.page_h,
        actionCardStyle = provideActionCardStyle()
    )

    @Composable
    fun provideActionCardStyle() = ActionCard.Style(
        outfitFrame = OutfitFrameSimple(
            outfitShape = MaterialTheme.shapesSimpleExtended.roundedCornerNormal,
            outfitBorder = MaterialTheme.bordersSimpleExtended.strokeNormal.copy(
                color = MaterialTheme.colorsCommonExtended.backgroundElevated
            )
        ),
        iconStyle = Icon.Simple.Style(
            size = 56.dp,
            tint = MaterialTheme.colors.primary
        ),
        outfitTextTitle = MaterialTheme.typographiesSimpleExtended.textNormal.copy(
            typo = MaterialTheme.typographiesSimpleExtended.textNormal.typo.copy(
                fontWeight = FontWeight.SemiBold
            ),
        ),
        outfitTextSubtitle = MaterialTheme.typographiesSimpleExtended.textNormal.copy(
            typo = MaterialTheme.typographiesSimpleExtended.textNormal.typo.copy(
                fontWeight = FontWeight.SemiBold
            ),
            color = MaterialTheme.colorsCommonExtended.onBackgroundElevated,
        ),
    )

    @Composable
    fun providePagerStyle() = HorizontalScrollable.Pager.Style(
        outfitShapeIndicator = OutfitShapeState(
            template = OutfitShape.Template.Circle,
            outfitColor = OutfitColorsSimple(
                active = MaterialTheme.colorsCommonExtended.backgroundButtonConfirm.active,
                inactive = MaterialTheme.colorsCommonExtended.onSecondaryVariant,
            )
        ),
        dimensionIndicatorPaddingTop = MaterialTheme.dimensionsPaddingExtended.elementNormal_v,
        dimensionIndicatorSize = 12.dp,
        dimensionIndicatorSpacing = MaterialTheme.dimensionsSpacingExtended.normal_h,
    )

    @Composable
    fun provideCarouselStyle() = providePagerStyle().copy(
        padding = PaddingValues(horizontal = 26.dp)
    )

}