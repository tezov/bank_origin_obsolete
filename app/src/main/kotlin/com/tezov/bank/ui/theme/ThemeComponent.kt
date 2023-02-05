/*
 *  *********************************************************************************
 *  Created by Tezov on 05/02/2023 01:03
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 05/02/2023 01:02
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.tezov.bank.ui.component.branch.SectionActionCard
import com.tezov.bank.ui.component.branch.SectionActionRow
import com.tezov.bank.ui.component.leaf.ActionCard
import com.tezov.bank.ui.component.leaf.ActionRow
import com.tezov.lib_core_android_kotlin.ui.theme.definition.colorsCommonExtended
import com.tezov.lib_core_android_kotlin.ui.theme.definition.dimensionsSizeExtended
import com.tezov.lib_core_android_kotlin.ui.theme.definition.typographyExtended

object ThemeComponent {

    @Composable
    fun provideSectionRowStyle() = SectionActionRow.Style(
//        colorIcon = MaterialTheme.colors.primary,
//        dimensionIcon = MaterialTheme.dimensionsSizeExtended.iconModal,
//        typographyHeader = MaterialTheme.typographyExtended.textNormal,
//        colorBackgroundHeader = MaterialTheme.colorsCommonExtended.onBackgroundButtonProceed,
//        colorDivider = MaterialTheme.colors.primary,
//        dimensionDivider = MaterialTheme.dimensionsSizeExtended.iconModal,
    )

    @Composable
    fun provideActionRowStyle() = ActionRow.Style(
//        typography = MaterialTheme.typographyExtended.textNormal,
//        colorIconAction = MaterialTheme.colors.primary,
//        dimensionIconAction = MaterialTheme.dimensionsSizeExtended.iconModal,
    )

    @Composable
    fun provideSectionCardStyle() = SectionActionCard.Style(


    )
    @Composable
    fun provideActionCardStyle() = ActionCard.Style(


    )



}