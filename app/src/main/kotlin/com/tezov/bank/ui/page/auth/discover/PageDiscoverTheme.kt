/*
 *  *********************************************************************************
 *  Created by Tezov on 10/04/2023 13:55
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 10/04/2023 13:48
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.auth.discover

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.tezov.bank.ui.component.branch.SectionActionCard
import com.tezov.bank.ui.component.branch.SectionActionCard.Style.Companion.copy
import com.tezov.bank.ui.component.branch.SectionActionRow
import com.tezov.bank.ui.component.branch.SectionActionRow.Style.Companion.copy
import com.tezov.bank.ui.component.leaf.ActionCard.Style.Companion.copy
import com.tezov.bank.ui.component.leaf.ActionRow.Style.Companion.copy
import com.tezov.bank.ui.page.lobby.help_and_service.colors
import com.tezov.bank.ui.theme.ThemeComponentProviders
import com.tezov.lib_core_android_kotlin.ui.component.branch.HorizontalScrollable
import com.tezov.lib_core_android_kotlin.ui.component.plain.Icon.Simple.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitBorder.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitFrame.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState.Simple.Style.Companion.asStateSimple
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.theme.colorsExtended
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsPaddingExtended

val PageDiscoverTheme.colors: PageDiscoverTheme.Colors
    @Composable
    @ReadOnlyComposable
    get() = localColors.current

infix fun PageDiscoverTheme.provides(value: PageDiscoverTheme.Colors) = localColors provides value

val PageDiscoverTheme.styles: PageDiscoverTheme.Style
    @Composable
    @ReadOnlyComposable
    get() = localStyles.current

infix fun PageDiscoverTheme.provides(value: PageDiscoverTheme.Style) = localStyles provides value

object PageDiscoverTheme {

    data class Colors(
        val background: Color,
        val backgroundElevated: Color,
        val accent: Color,
        val primary: Color,
        val neutral: Color,
        val decor: Color,
        val fade: Color,
    )

    @Composable
    fun provideColors() = Colors(
        background = MaterialTheme.colorsExtended.background.default,
        backgroundElevated = MaterialTheme.colorsExtended.backgroundElevated.default,
        accent = MaterialTheme.colorsExtended.primary.accent,
        primary = MaterialTheme.colorsExtended.primary.default,
        neutral = MaterialTheme.colorsExtended.primary.shady,
        decor = MaterialTheme.colorsExtended.backgroundElevated.decor,
        fade = MaterialTheme.colorsExtended.primary.fade,
    )

    internal val localColors: ProvidableCompositionLocal<Colors> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Style(
        val carousel: HorizontalScrollable.Pager.Style,
//        val cardButton: CarouselCard.Style,
//        val cardLink: CarouselCard.Style,
        val sectionRow: SectionActionRow.Style,
        val sectionCard: SectionActionCard.Style,
    )

    @Composable
    fun provideStyles() = Style(
        carousel = ThemeComponentProviders.provideCarouselStyle(),
//        cardButton = CarouselCard.Style(
//            colorIconInfo =  MaterialTheme.colors.primary,
//            dimensionIconInfo = 92.dp,
//
//            typographyTag = MaterialTheme.typographyExtended.textNormal.copy(
//                color = MaterialTheme.colors.primary
//            ),
//            shapeTag = MaterialTheme.shapesExtended.roundedCornerBig,
//            borderTag = MaterialTheme.bordersExtended.strokeNormal,
//
//            typographyTitle = MaterialTheme.typographyExtended.textTitle.copy(
//                fontWeight = FontWeight.SemiBold
//            ),
//            typographyText = MaterialTheme.typographyExtended.textNormal,
//
//            button = Button.TextFilled.Style(
//                outfitShape = MaterialTheme.shapesExtended.roundedCornerNormal,
//                backgroundColorActive =  MaterialTheme.colors.primary,
//                textStyle = MaterialTheme.typographyExtended.textButton.copy(
//                    color = Color.White,
//                    fontWeight = FontWeight.SemiBold
//                ),
//                textColorActive = Color.White
//            ),
//
//            shape = MaterialTheme.shapesExtended.roundedCornerBig,
//        ),
//        cardLink = CarouselCard.Style(),

        sectionRow = ThemeComponentProviders.provideSectionRowStyle().copy {
            dimensionPaddingBody = MaterialTheme.dimensionsPaddingExtended.page.normal.horizontal
            colorDivider = colors.fade
            actionRowStyle = actionRowStyle.copy{
                iconInfoStyle = iconInfoStyle.copy { tint = colors.accent }
                iconActionStyle = iconActionStyle.copy { tint = colors.accent }
                outfitText = outfitText?.copy {
                    outfitState = colors.primary.asStateSimple
                }
            }
        },
        sectionCard = ThemeComponentProviders.provideSectionCardStyle().copy {
            dimensionPaddingBody = MaterialTheme.dimensionsPaddingExtended.page.normal.horizontal
            actionCardStyle = actionCardStyle.copy{
                iconStyle = iconStyle.copy { tint = colors.accent }
                outfitTextTitle = outfitTextTitle?.copy {
                    outfitState = colors.primary.asStateSimple
                }
                outfitFrame = outfitFrame.copy{
                    outfitShape = outfitShape.copy {
                        outfitState = colors.decor.asStateSimple
                    }
                }
            }
        },
    )

    internal val localStyles: ProvidableCompositionLocal<Style> = staticCompositionLocalOf {
        error("not provided")
    }

}