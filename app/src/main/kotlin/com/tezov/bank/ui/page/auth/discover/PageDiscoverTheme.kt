/*
 *  *********************************************************************************
 *  Created by Tezov on 16/04/2023 22:13
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 16/04/2023 22:11
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.bank.ui.component.block.SectionActionCard
import com.tezov.bank.ui.component.block.SectionActionCard.Style.Companion.copy
import com.tezov.bank.ui.component.block.SectionActionRow
import com.tezov.bank.ui.component.block.SectionActionRow.Style.Companion.copy
import com.tezov.bank.ui.component.block.SectionCarouselCard
import com.tezov.bank.ui.component.block.SectionCarouselCard.Style.Companion.copy
import com.tezov.bank.ui.component.block.SectionRollerCard
import com.tezov.bank.ui.component.block.SectionRollerCard.Style.Companion.copy
import com.tezov.bank.ui.component.element.ActionCard.Style.Companion.copy
import com.tezov.bank.ui.component.element.ActionRow.Style.Companion.copy
import com.tezov.bank.ui.component.element.CarouselCard
import com.tezov.bank.ui.component.element.CarouselCard.Style.Button.Companion.copy
import com.tezov.bank.ui.component.element.CarouselCard.Style.Link.Companion.copy
import com.tezov.bank.ui.component.element.RollerCard.Style.Companion.copy
import com.tezov.bank.ui.theme.ThemeComponentProviders
import com.tezov.lib_core_android_kotlin.type.primaire.DpSize
import com.tezov.lib_core_android_kotlin.type.primaire.dpSize
import com.tezov.lib_core_android_kotlin.ui.component.block.HorizontalPager.Page.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Button.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Icon.Simple.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Image.Simple.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Link.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitBorder.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitFrame.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState.Simple.Style.Companion.asStateSimple
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.theme.colorsExtended
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsIconExtended
import com.tezov.lib_core_android_kotlin.ui.theme.theme.dimensionsPaddingExtended
import com.tezov.lib_core_android_kotlin.ui.theme.theme.typographiesExtended

val PageDiscoverTheme.colors: PageDiscoverTheme.Colors
    @Composable
    @ReadOnlyComposable
    get() = localColors.current

infix fun PageDiscoverTheme.provides(value: PageDiscoverTheme.Colors) = localColors provides value

val PageDiscoverTheme.typographies: PageDiscoverTheme.Typographies
    @Composable
    @ReadOnlyComposable
    get() = localTypographies.current

infix fun PageDiscoverTheme.provides(value: PageDiscoverTheme.Typographies) =
    localTypographies provides value

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

    data class Typographies(
        val headline: OutfitTextStateColor,
    )

    @Composable
    fun provideTypographies() = Typographies(
        headline = MaterialTheme.typographiesExtended.title.supra.copy {
            outfitState = colors.primary.asStateSimple
        },
    )

    internal val localTypographies: ProvidableCompositionLocal<Typographies> =
        staticCompositionLocalOf {
            error("not provided")
        }

    data class Dimensions(
        val header: Dp,
        val iconCard: DpSize,
        val imageCard: DpSize,
        val spacingTopSectionRowToBottomSectionCard: Dp,
    )

    @Composable
    fun provideDimensions() = Dimensions(
        header = 192.dp,
        iconCard = 64.dpSize,
        imageCard = 88.dpSize,
        spacingTopSectionRowToBottomSectionCard = 64.dp,
    )

    internal val localDimensions: ProvidableCompositionLocal<Dimensions> =
        staticCompositionLocalOf {
            error("not provided")
        }

    data class Style(
        val sectionCarouselCardButton: SectionCarouselCard.Style,
        val sectionCarouselCardLink: SectionCarouselCard.Style,
        val sectionRollerCard: SectionRollerCard.Style,
        val sectionActionRow: SectionActionRow.Style,
        val sectionActionCard: SectionActionCard.Style,
    )

    @Composable
    fun provideStyles() = Style(
        sectionCarouselCardButton = ThemeComponentProviders.sectionCarouselCardStyle(
            cardStyle = ThemeComponentProviders.carouselCardButtonStyle()
        ).copy{
            outfitTextTitle = outfitTextTitle?.copy {
                outfitState = colors.primary.asStateSimple
            }
            carouselStyle = carouselStyle.copy {
                paddingTopIndicator = MaterialTheme.dimensionsPaddingExtended.element.huge.vertical
                heightItemToHighest = true
            }
            cardStyle = (cardStyle as CarouselCard.Style.Button).copy {
                outfitFrame = outfitFrame.copy {
                    outfitBorder = outfitBorder.copy {
                        outfitState = colors.decor.asStateSimple
                    }
                    outfitShape = outfitShape.copy {
                        outfitState = colors.background.asStateSimple
                    }
                }
                iconInfoStyle = iconInfoStyle.copy {
                    size = dimensions.iconCard
                    tint = colors.accent.copy(alpha = 0.5f)
                }
                outfitTextTitle = outfitTextTitle?.copy {
                    outfitState = colors.primary.asStateSimple
                }
                outfitTextBody = outfitTextBody?.copy {
                    outfitState = colors.primary.asStateSimple
                }
                outfitTextTag = outfitTextTag?.copy {
                    outfitState = colors.accent.asStateSimple
                }
                outfitFrameTag = outfitFrameTag.copy {
                    outfitBorder = outfitBorder.copy {
                        outfitState = colors.accent.asStateSimple
                    }
                }
                actionStyle = actionStyle.copy {
                    outfitFrame = outfitFrame.copy {
                        outfitShape = outfitShape.copy {
                            outfitState = colors.accent.asStateSimple
                        }
                    }
                    outfitText = outfitText.copy {
                        outfitState = colors.background.asStateSimple
                    }
                }
            }
        },
        sectionCarouselCardLink = ThemeComponentProviders.sectionCarouselCardStyle(
            cardStyle = ThemeComponentProviders.carouselCardLinkStyle()
        ).copy{
            carouselStyle = carouselStyle.copy {
                paddingTopIndicator = MaterialTheme.dimensionsPaddingExtended.element.huge.vertical
                heightItemToHighest = true
            }
            outfitTextTitle = outfitTextTitle?.copy {
                outfitState = colors.primary.asStateSimple
                typo = typo.copy(
                    fontWeight = FontWeight.Bold
                )
            }
            cardStyle = (cardStyle as CarouselCard.Style.Link).copy {
                outfitFrame = outfitFrame.copy {
                    outfitShape = outfitShape.copy {
                        outfitState = colors.backgroundElevated.asStateSimple
                    }
                }
                iconInfoStyle = iconInfoStyle.copy {
                    tint = colors.accent
                }
                outfitTextTitle = outfitTextTitle?.copy {
                    outfitState = colors.primary.asStateSimple
                }
                outfitTextBody = outfitTextBody?.copy {
                    outfitState = colors.primary.asStateSimple
                }
                outfitFrameTag = outfitFrameTag.copy {
                    outfitBorder = outfitBorder.copy {
                        outfitState = colors.accent.asStateSimple
                    }
                }
                actionStyle = actionStyle.copy {
                    outfitText = outfitText.copy {
                        outfitState = colors.accent.asStateSimple
                    }
                }
            }
        },
        sectionRollerCard = ThemeComponentProviders.sectionRollerCardStyle().copy{
            outfitTextTitle = outfitTextTitle?.copy {
                outfitState = colors.primary.asStateSimple
            }
            outfitTextSubTitle = outfitTextSubTitle?.copy {
                outfitState = colors.accent.asStateSimple
            }
            actionStyle = actionStyle.copy {
                outfitFrame = outfitFrame.copy {
                    outfitShape = outfitShape.copy {
                        outfitState = colors.accent.asStateSimple
                    }
                }
                outfitText = outfitText.copy {
                    outfitState = colors.background.asStateSimple
                }
            }
            cardStyle = cardStyle.copy{
                outfitFrame = outfitFrame.copy {
                    outfitBorder = outfitBorder.copy {
                        outfitState = colors.decor.copy(alpha = 0.35f).asStateSimple
                    }
                    outfitShape = outfitShape.copy {
                        outfitState = colors.backgroundElevated.copy(alpha = 0.35f).asStateSimple
                    }
                }
                outfitTextTitle = outfitTextTitle?.copy {
                    outfitState = colors.primary.asStateSimple
                }
                imageStyle = imageStyle.copy{
                    size = dimensions.imageCard
                }
            }
        },
        sectionActionRow = ThemeComponentProviders.sectionActionRowStyle().copy {
            paddingBody = MaterialTheme.dimensionsPaddingExtended.page.normal.horizontal
            outfitTextTitle = MaterialTheme.typographiesExtended.title.huge.copy {
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
        sectionActionCard = ThemeComponentProviders.sectionActionCardStyle().copy {
            paddingBody = MaterialTheme.dimensionsPaddingExtended.page.normal.horizontal
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
                        outfitState = colors.backgroundElevated.asStateSimple
                    }
                }
            }
        },
    )

    internal val localStyles: ProvidableCompositionLocal<Style> = staticCompositionLocalOf {
        error("not provided")
    }

}