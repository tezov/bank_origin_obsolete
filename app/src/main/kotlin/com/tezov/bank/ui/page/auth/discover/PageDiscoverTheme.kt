/*
 *  *********************************************************************************
 *  Created by Tezov on 15/04/2023 19:41
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 15/04/2023 19:22
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
import androidx.compose.ui.text.font.FontWeight
import com.tezov.bank.ui.component.branch.SectionActionCard
import com.tezov.bank.ui.component.branch.SectionActionCard.Style.Companion.copy
import com.tezov.bank.ui.component.branch.SectionActionRow
import com.tezov.bank.ui.component.branch.SectionActionRow.Style.Companion.copy
import com.tezov.bank.ui.component.leaf.ActionCard.Style.Companion.copy
import com.tezov.bank.ui.component.leaf.ActionRow.Style.Companion.copy
import com.tezov.bank.ui.component.leaf.CarouselCard
import com.tezov.bank.ui.page.auth.payment.colors
import com.tezov.bank.ui.page.auth.profile.PageProfileTheme
import com.tezov.bank.ui.theme.ThemeComponentProviders
import com.tezov.lib_core_android_kotlin.type.primaire.DpSize
import com.tezov.lib_core_android_kotlin.type.primaire.dpSize
import com.tezov.lib_core_android_kotlin.ui.component.branch.HorizontalScrollable
import com.tezov.lib_core_android_kotlin.ui.component.plain.Icon
import com.tezov.lib_core_android_kotlin.ui.component.plain.Icon.Simple.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitBorder.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitFrame.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitFrameStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState.Simple.Style.Companion.asStateSimple
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.theme.*

val PageDiscoverTheme.colors: PageDiscoverTheme.Colors
    @Composable
    @ReadOnlyComposable
    get() = localColors.current

infix fun PageDiscoverTheme.provides(value: PageDiscoverTheme.Colors) = localColors provides value

val PageDiscoverTheme.dimensions: PageDiscoverTheme.Dimensions
    @Composable
    @ReadOnlyComposable
    get() = localDimensions.current

infix fun PageDiscoverTheme.provides(value: PageDiscoverTheme.Dimensions) =
    localDimensions provides value

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

    data class Dimensions(
        val spacingTopSectionRowToBottomSectionCard: DpSize,
    )

    @Composable
    fun provideDimensions() = Dimensions(
        spacingTopSectionRowToBottomSectionCard = 64.dpSize,
    )

    internal val localDimensions: ProvidableCompositionLocal<Dimensions> =
        staticCompositionLocalOf {
            error("not provided")
        }

    data class Style(
        val carousel: HorizontalScrollable.Pager.Style,
        val cardButton: CarouselCard.Style.Button,
        val cardLink: CarouselCard.Style.Link,
        val sectionRow: SectionActionRow.Style,
        val sectionCard: SectionActionCard.Style,
    )

    @Composable
    fun provideStyles() = Style(
        carousel = ThemeComponentProviders.provideCarouselStyle(),
        cardButton = CarouselCard.Style.Button(
            baseStyle = CarouselCard.Style.Base(
                outfitFrame = OutfitFrameStateColor(
                    outfitShape = MaterialTheme.shapesExtended.element.normal.copy {


                    },
                    outfitBorder = MaterialTheme.bordersExtended.element.normal.copy {
                        outfitState = colors.decor.asStateSimple
                    }
                ),
                iconInfoStyle = Icon.Simple.Style(
                    size = MaterialTheme.dimensionsIconExtended.info.normal,
                    tint = colors.accent
                ),
                outfitTextTitle = MaterialTheme.typographiesExtended.title.normal.copy {
                    outfitState = colors.primary.asStateSimple
                },
                outfitTextBody = MaterialTheme.typographiesExtended.title.normal.copy {
                    outfitState = colors.primary.asStateSimple
                },
                outfitTextTag = MaterialTheme.typographiesExtended.title.normal.copy {
                    outfitState = colors.primary.asStateSimple
                },
                outfitFrameTag = OutfitFrameStateColor(
                    outfitShape = MaterialTheme.shapesExtended.chunk.normal,
                    outfitBorder = MaterialTheme.bordersExtended.element.normal.copy {
                        outfitState = colors.decor.asStateSimple
                    }
                ),
            ),
            action = MaterialTheme.componentsButtonExtended.primary
        ),
        cardLink = CarouselCard.Style.Link(
            baseStyle = CarouselCard.Style.Base(
                outfitFrame = OutfitFrameStateColor(
                    outfitShape = MaterialTheme.shapesExtended.element.normal.copy {


                    },
                    outfitBorder = MaterialTheme.bordersExtended.element.normal.copy {
                        outfitState = colors.decor.asStateSimple
                    }
                ),
                iconInfoStyle = Icon.Simple.Style(
                    size = MaterialTheme.dimensionsIconExtended.info.normal,
                    tint = colors.accent
                ),
                outfitTextTitle = MaterialTheme.typographiesExtended.title.normal.copy {
                    outfitState = colors.primary.asStateSimple
                },
                outfitTextBody = MaterialTheme.typographiesExtended.title.normal.copy {
                    outfitState = colors.primary.asStateSimple
                },
                outfitTextTag = MaterialTheme.typographiesExtended.title.normal.copy {
                    outfitState = colors.primary.asStateSimple
                },
                outfitFrameTag = OutfitFrameStateColor(
                    outfitShape = MaterialTheme.shapesExtended.chunk.normal,
                    outfitBorder = MaterialTheme.bordersExtended.element.normal.copy {
                        outfitState = colors.decor.asStateSimple
                    }
                ),
            ),
            action = MaterialTheme.componentsLinkExtended.primary
        ),
        sectionRow = ThemeComponentProviders.provideSectionRowStyle().copy {
            dimensionPaddingBody = MaterialTheme.dimensionsPaddingExtended.page.normal.horizontal
            outfitTextHeader = MaterialTheme.typographiesExtended.title.huge.copy {
                outfitState = colors.primary.asStateSimple
                typo = typo.copy(
                    fontWeight = FontWeight.Bold
                )
            }
            colorBackgroundHeader = null
            colorDivider = colors.fade
            actionRowStyle = actionRowStyle.copy {
                iconInfoStyle = iconInfoStyle.copy { tint = colors.accent }
                iconActionStyle = iconActionStyle.copy { tint = colors.accent }
                outfitText = outfitText?.copy {
                    outfitState = colors.primary.asStateSimple
                }
            }
        },
        sectionCard = ThemeComponentProviders.provideSectionCardStyle().copy {
            dimensionPaddingBody = MaterialTheme.dimensionsPaddingExtended.page.normal.horizontal
            actionCardStyle = actionCardStyle.copy {
                iconStyle = iconStyle.copy {
                    tint = colors.accent
                    size = MaterialTheme.dimensionsIconExtended.info.huge
                }
                outfitTextTitle = outfitTextTitle?.copy {
                    outfitState = colors.primary.asStateSimple
                }
                outfitFrame = outfitFrame.copy {
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