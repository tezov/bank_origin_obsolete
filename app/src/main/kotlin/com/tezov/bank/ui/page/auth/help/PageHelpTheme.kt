/*
 *  *********************************************************************************
 *  Created by Tezov on 02/02/2023 22:16
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 02/02/2023 22:16
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.auth.help

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.bank.ui.component.leaf.ActionRow
import com.tezov.bank.ui.component.branch.SectionActionRow
import com.tezov.bank.ui.theme.ThemeColors
import com.tezov.lib_core_android_kotlin.ui.theme.definition.*

val PageHelpTheme.colors: PageHelpTheme.Colors
    @Composable
    @ReadOnlyComposable
    get() = localColors.current

infix fun PageHelpTheme.provides(value: PageHelpTheme.Colors) = localColors provides value

val PageHelpTheme.dimensions: PageHelpTheme.Dimensions
    @Composable
    @ReadOnlyComposable
    get() = localDimensions.current

infix fun PageHelpTheme.provides(value: PageHelpTheme.Dimensions) = localDimensions provides value

val PageHelpTheme.typographies: PageHelpTheme.Typographies
    @Composable
    @ReadOnlyComposable
    get() = localTypographies.current

infix fun PageHelpTheme.provides(value: PageHelpTheme.Typographies) =
    localTypographies provides value

object PageHelpTheme {

    data class Colors(
        val background: Color,
        val backgroundSection: Color,
        val divider: Color,
        val textTitle: Color,
        val textNormal: Color,
        val icon: Color,
    )

    @Composable
    fun provideColors() = Colors(
        background = MaterialTheme.colors.background,
        backgroundSection = ThemeColors.Data.grayOverlay,
        divider = ThemeColors.Data.grayOverlay,
        textTitle = MaterialTheme.colors.primaryVariant,
        textNormal = MaterialTheme.colors.onSecondary,
        icon = MaterialTheme.colors.primary,
    )

    internal val localColors: ProvidableCompositionLocal<Colors> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Dimensions(
        val iconAction: Dp,
        val iconSection: Dp,
        val divider: Dp,
    )

    @Composable
    fun provideDimensions() = Dimensions(
        iconAction = 18.dp,
        iconSection = 42.dp,
        divider = 2.dp,
    )

    internal val localDimensions: ProvidableCompositionLocal<Dimensions> =
        staticCompositionLocalOf {
            error("not provided")
        }

    data class Typographies(
        val titleHuge: TextStyle,
        val titleBig: TextStyle,
        val titleNormal: TextStyle,
        val normal: TextStyle,
        val actionRow: TextStyle,
    )

    @Composable
    fun provideTypographies() = Typographies(
        titleHuge = MaterialTheme.typographyExtended.textHuge.copy(
            color = colors.textTitle,
            fontWeight = FontWeight.Bold
        ),
        titleBig = MaterialTheme.typographyExtended.textBig.copy(
            color = colors.textTitle,
            fontWeight = FontWeight.SemiBold
        ),
        titleNormal = MaterialTheme.typographyExtended.textTitle.copy(
            color = colors.textTitle,
            fontWeight = FontWeight.SemiBold
        ),
        normal = MaterialTheme.typographyExtended.textNormal.copy(
            color = colors.textNormal
        ),
        actionRow = MaterialTheme.typographyExtended.textNormal.copy(
            color = colors.textNormal
        ),
    )

    internal val localTypographies: ProvidableCompositionLocal<Typographies> =
        staticCompositionLocalOf {
            error("not provided")
        }

    @Composable
    fun provideSectionRowStyle() = SectionActionRow.Style(
        colorIcon = colors.icon,
        dimensionIcon = dimensions.iconSection,
        textStyleContent = typographies.titleNormal,
        colorBackground = colors.backgroundSection,
        colorDivider = colors.divider,
        dimensionDivider = dimensions.divider,
    )

    @Composable
    fun provideActionRowStyle() = ActionRow.Style(
        textStyleContent = typographies.actionRow,
        colorIconAction = colors.icon,
        dimensionIconAction = dimensions.iconAction,
    )

}