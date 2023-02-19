/*
 *  *********************************************************************************
 *  Created by Tezov on 19/02/2023 18:23
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 19/02/2023 17:42
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
import com.tezov.bank.ui.component.branch.SectionActionRow
import com.tezov.bank.ui.theme.ThemeComponent
import com.tezov.lib_core_android_kotlin.ui.component.branch.HorizontalScrollable

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
    )

    @Composable
    fun provideColors() = Colors(
        background = MaterialTheme.colors.background,
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
        carousel = ThemeComponent.provideCarouselStyle(),
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
        sectionRow = ThemeComponent.provideSectionRowStyle(),
        sectionCard = ThemeComponent.provideSectionCardStyle(),
    )

    internal val localStyles: ProvidableCompositionLocal<Style> = staticCompositionLocalOf {
        error("not provided")
    }

}