/*
 *  *********************************************************************************
 *  Created by Tezov on 08/04/2023 19:53
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/04/2023 19:38
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.theme

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tezov.bank.ui.component.branch.SectionActionCard
import com.tezov.bank.ui.component.branch.SectionActionRow
import com.tezov.bank.ui.component.leaf.ActionCard
import com.tezov.bank.ui.component.leaf.ActionRow
import com.tezov.bank.ui.theme.font.fontUbuntu
import com.tezov.lib_core_android_kotlin.navigation.bottom_navigation.BottomNavigation
import com.tezov.lib_core_android_kotlin.navigation.top_app_bar.TopAppBar
import com.tezov.lib_core_android_kotlin.type.primaire.DpSize
import com.tezov.lib_core_android_kotlin.ui.activity.sub.bottomsheet.BottomSheet
import com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog.Dialog
import com.tezov.lib_core_android_kotlin.ui.activity.sub.snackbar.Snackbar
import com.tezov.lib_core_android_kotlin.ui.component.branch.HorizontalScrollable
import com.tezov.lib_core_android_kotlin.ui.component.branch.HorizontalScrollable.Pager.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.component.plain.Button
import com.tezov.lib_core_android_kotlin.ui.component.plain.Icon
import com.tezov.lib_core_android_kotlin.ui.component.plain.Link
import com.tezov.lib_core_android_kotlin.ui.theme.style.*
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitBorder.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.Size.Companion.asShapeSize
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState.Simple.Style.Companion.asStateSimple
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.StateColor.Style.Companion.asTextStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.theme.*

object ThemeComponentProviders {

    @Composable
    fun provideComponentsCommon() = ThemeComponentExtended.Common(
        bottomNavigation = BottomNavigation.Style(
            outfitText  = TextStyle(
                fontFamily = MaterialTheme.fontUbuntu,
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp
            ).asTextStateColor,
            colorBackground  = MaterialTheme.colorsPalette.whiteShady,
            outfitColor  = OutfitStateDual(
                active = MaterialTheme.colorsPalette.blueElegant,
                inactive = MaterialTheme.colorsPalette.blueShadow
            ),
        ),
        dialogCard = Dialog.Card.Style(
            elevation = 2.dp,
            outfitFrame = OutfitFrameStateColor(
                outfitBorder = OutfitBorderStateColor(
                    size = 2.dp,
                    outfitState = MaterialTheme.colorsExtended.primary.default.asStateSimple,
                ),
                outfitShape = OutfitShapeStateColor(
                    size = 8.asShapeSize,
                    outfitState = MaterialTheme.colorsExtended.backgroundModal.default.asStateSimple,
                )
            )
        ),
        snackBar = Snackbar.Style(
            outfitTextMessage = OutfitTextStateColor(
                typo = TextStyle(
                    fontFamily = MaterialTheme.fontUbuntu,
                    fontWeight = FontWeight.Normal,
                    fontSize = 19.sp
                ),
                outfitState = MaterialTheme.colorsExtended.onBackgroundModal.dark.asStateSimple,
            ),
            outfitTextAction = OutfitTextStateColor(
                typo = TextStyle(
                    fontFamily = MaterialTheme.fontUbuntu,
                    fontWeight = FontWeight.Bold,
                    fontSize = 19.sp
                ),
                outfitState = MaterialTheme.colorsExtended.onBackgroundModal.accent.asStateSimple,
            ),
            outfitShape = OutfitShapeStateColor(
                size = 12.asShapeSize,
                outfitState = MaterialTheme.colorsExtended.backgroundModal.accent.asStateSimple,
            ),
            elevation = 4.dp,
        ),
    )

    @Composable
    fun provideComponentsButton() = ThemeComponentExtended.Buttons(
        primary = Button.StateColor.Style(
            outfitFrame = OutfitFrameStateColor(
                outfitShape = MaterialTheme.shapesExtended.button.normal.copy {
                    outfitState = OutfitStateDual(
                        active = MaterialTheme.colorsExtended.primary.default,
                        inactive = MaterialTheme.colorsPalette.grayOverlay,
                    )
                },
                outfitBorder = OutfitBorderStateColor(
                    outfitState = OutfitStateDual(
                        active = MaterialTheme.colorsExtended.primary.dark,
                        inactive = MaterialTheme.colorsPalette.grayDark,
                    )
                )
            ),
            outfitText = MaterialTheme.typographiesExtended.button.normal.copy{
                outfitState = OutfitStateDual(
                    active = MaterialTheme.colorsExtended.onPrimary.default,
                    inactive = MaterialTheme.colorsPalette.grayDark,
                )
            }
        )
    )

//        confirm = Button.StateColor.Style.TextFilled.copy {
//            outfitFrame = OutfitFrame.Styl(
//                outfitShape = MaterialTheme.shapesCommonExtended.roundedCorner.normal.copy {
//                    outfitState = OutfitStateDual(
//                        active = MaterialTheme.colorsCommonExtended.primary.default,
//                        inactive = MaterialTheme.colorsCommonExtended.primary.default,
//                    )
//                }
//            )
//            outfitText = OutfitText.StateColor(
//                typo = TextStyle(
//                    fontFamily = MaterialTheme.fontUbuntu,
//                    fontWeight = FontWeight.Normal,
//                    fontSize = 18.sp
//                ),
//                outfitState = OutfitStateDual(
//                    active = MaterialTheme.colorsCommonExtended.primary.default,
//                    inactive = MaterialTheme.colorsCommonExtended.primary.default,
//                )
//            )
//        },
//        cancel = Button.StateColor.Style.TextFilled.copy {
//            outfitFrame = OutfitFrame.Styl(
//                outfitShape = MaterialTheme.shapesCommonExtended.roundedCorner.normal.copy {
//                    outfitState = OutfitStateDual(
//                        active = MaterialTheme.colorsCommonExtended.primary.default,
//                        inactive = MaterialTheme.colorsCommonExtended.primary.default,
//                    )
//                }
//            )
//            outfitText = OutfitText.StateColor(
//                typo = TextStyle(
//                    fontFamily = MaterialTheme.fontUbuntu,
//                    fontWeight = FontWeight.Normal,
//                    fontSize = 18.sp
//                ),
//                outfitState = OutfitStateDual(
//                    active = MaterialTheme.colorsCommonExtended.primary.default,
//                    inactive = MaterialTheme.colorsCommonExtended.primary.default,
//                )
//            )
//        },
//        proceed = Button.StateColor.Style.TextFilled.copy {
//            outfitFrame = OutfitFrame.Styl(
//                outfitShape = MaterialTheme.shapesCommonExtended.roundedCorner.normal.copy {
//                    outfitState = OutfitStateDual(
//                        active = MaterialTheme.colorsCommonExtended.primary.default,
//                        inactive = MaterialTheme.colorsCommonExtended.primary.default,
//                    )
//                }
//            )
//            outfitText = OutfitText.StateColor(
//                typo = TextStyle(
//                    fontFamily = MaterialTheme.fontUbuntu,
//                    fontWeight = FontWeight.Normal,
//                    fontSize = 18.sp
//                ),
//                outfitState = OutfitStateDual(
//                    active = MaterialTheme.colorsCommonExtended.primary.default,
//                    inactive = MaterialTheme.colorsCommonExtended.primary.default,
//                )
//            )
//        },
//        primary = Button.StateColor.Style.TextFilled.copy {
//            outfitFrame = OutfitFrame.Styl(
//                outfitShape = MaterialTheme.shapesCommonExtended.roundedCorner.normal.copy {
//                    outfitState = OutfitStateDual(
//                        active = MaterialTheme.colorsCommonExtended.primary.default,
//                        inactive = MaterialTheme.colorsCommonExtended.primary.default,
//                    )
//                }
//            )
//            outfitText = OutfitText.StateColor(
//                typo = TextStyle(
//                    fontFamily = MaterialTheme.fontUbuntu,
//                    fontWeight = FontWeight.Normal,
//                    fontSize = 18.sp
//                ),
//                outfitState = OutfitStateDual(
//                    active = MaterialTheme.colorsCommonExtended.primary.default,
//                    inactive = MaterialTheme.colorsCommonExtended.primary.default,
//                )
//            )
//        },
//        secondary = Button.StateColor.Style.TextFilled.copy {
//            outfitFrame = OutfitFrame.Styl(
//                outfitShape = MaterialTheme.shapesCommonExtended.roundedCorner.normal.copy {
//                    outfitState = OutfitStateDual(
//                        active = MaterialTheme.colorsCommonExtended.primary.default,
//                        inactive = MaterialTheme.colorsCommonExtended.primary.default,
//                    )
//                }
//            )
//            outfitText = OutfitText.StateColor(
//                typo = TextStyle(
//                    fontFamily = MaterialTheme.fontUbuntu,
//                    fontWeight = FontWeight.Normal,
//                    fontSize = 18.sp
//                ),
//                outfitState = OutfitStateDual(
//                    active = MaterialTheme.colorsCommonExtended.primary.default,
//                    inactive = MaterialTheme.colorsCommonExtended.primary.default,
//                )
//            )
//        },
//        tertiary = Button.StateColor.Style.TextFilled.copy {
//            outfitFrame = OutfitFrame.Styl(
//                outfitShape = MaterialTheme.shapesCommonExtended.roundedCorner.normal.copy {
//                    outfitState = OutfitStateDual(
//                        active = MaterialTheme.colorsCommonExtended.primary.default,
//                        inactive = MaterialTheme.colorsCommonExtended.primary.default,
//                    )
//                }
//            )
//            outfitText = OutfitText.StateColor(
//                typo = TextStyle(
//                    fontFamily = MaterialTheme.fontUbuntu,
//                    fontWeight = FontWeight.Normal,
//                    fontSize = 18.sp
//                ),
//                outfitState = OutfitStateDual(
//                    active = MaterialTheme.colorsCommonExtended.primary.default,
//                    inactive = MaterialTheme.colorsCommonExtended.primary.default,
//                )
//            )
//        }

    @Composable
    fun provideComponentsLink() = ThemeComponentExtended.Links(
        primary = Link.StateColor.Style(
            outfitText = MaterialTheme.typographiesExtended.link.normal.copy {
                outfitState = Color.Black.asStateSimple
            }
        )
    )

    @Composable
    fun provideSectionRowStyle() = SectionActionRow.Style(
        dimensionPaddingBody_h = MaterialTheme.dimensionsPaddingExtended.page.horizontal.normal,
        iconStyle = Icon.Simple.Style(
            size = MaterialTheme.dimensionsIconExtended.info.normal,
            tint = MaterialTheme.colorsExtended.primary.default
        ),
//        outfitTextHeader = MaterialTheme.typographiesTextExtended.text.normal.copy {
//            typo = typo.copy(
//                fontWeight = FontWeight.SemiBold
//            )
//            outfitState = OutfitStateSimple(
//                MaterialTheme.colorsCommonExtended.onBackgroundElevated.default
//            )
//        },
        colorBackgroundHeader = MaterialTheme.colorsExtended.backgroundElevated.default.copy(
            alpha = 0.14f
        ),
        colorDivider = MaterialTheme.colorsExtended.backgroundElevated.default.copy(
            alpha = 0.05f
        ),
        dimensionDivider = MaterialTheme.dimensionsCommonExtended.divider.normal,
        actionRowStyle = provideActionRowStyle()
    )

    @Composable
    fun provideActionRowStyle() = ActionRow.Style(
        iconInfoStyle = Icon.Simple.Style(
            size = MaterialTheme.dimensionsIconExtended.info.normal,
            tint = MaterialTheme.colorsExtended.primary.default
        ),
        iconActionStyle = Icon.Simple.Style(
            size = MaterialTheme.dimensionsIconExtended.info.normal,
            tint = MaterialTheme.colorsExtended.primary.default
        ),
//        outfitText = MaterialTheme.typographiesTextExtended.text.normal.copy {
//            typo = typo.copy(
//                fontWeight = FontWeight.SemiBold
//            )
//            outfitState = OutfitStateSimple(
//                MaterialTheme.colorsCommonExtended.onBackgroundElevated.default
//            )
//        }
    )

    @Composable
    fun provideSectionCardStyle() = SectionActionCard.Style(
        iconStyle = Icon.Simple.Style(
            size = MaterialTheme.dimensionsIconExtended.info.normal,
            tint = MaterialTheme.colorsExtended.primary.default
        ),
//        outfitTextHeader = MaterialTheme.typographiesTextExtended.text.normal.copy {
//            typo = typo.copy(
//                fontWeight = FontWeight.SemiBold
//            )
//            outfitState = OutfitStateSimple(
//                MaterialTheme.colorsCommonExtended.onBackgroundElevated.default
//            )
//        },
        colorBackgroundHeader = MaterialTheme.colorsExtended.backgroundElevated.default.copy(
            alpha = 0.14f
        ),
        dimensionPaddingBody_h = MaterialTheme.dimensionsPaddingExtended.page.horizontal.normal,
        actionCardStyle = provideActionCardStyle()
    )

    @Composable
    fun provideActionCardStyle() = ActionCard.Style(
        outfitFrame = OutfitFrameStateColor(
            outfitShape = MaterialTheme.shapesExtended.chunk.normal,
            outfitBorder = MaterialTheme.bordersExtended.chunk.normal.copy {
                outfitState = MaterialTheme.colorsExtended.backgroundElevated.default.asStateSimple
            }
        ),
        iconStyle = Icon.Simple.Style(
            size = DpSize(56.dp),
            tint = MaterialTheme.colorsExtended.primary.default
        ),
//        outfitTextTitle = MaterialTheme.typographiesTextExtended.text.normal.copy {
//            typo = typo.copy(
//                fontWeight = FontWeight.SemiBold
//            )
//        },
//        outfitTextSubtitle = MaterialTheme.typographiesTextExtended.text.normal.copy {
//            typo = typo.copy(
//                fontWeight = FontWeight.SemiBold
//            )
//            outfitState = OutfitStateSimple(
//                MaterialTheme.colorsCommonExtended.onBackgroundElevated.default
//            )
//        },
    )

    @Composable
    fun providePagerStyle() = HorizontalScrollable.Pager.Style(
        outfitShapeIndicator = OutfitShapeStateColor(
            outfitState = OutfitStateDual(
                active = MaterialTheme.colorsExtended.onBackgroundElevated.default,
                inactive = MaterialTheme.colorsExtended.background.default,
            )
        ),
        dimensionIndicatorPaddingTop = MaterialTheme.dimensionsPaddingExtended.chunk.vertical.normal,
        dimensionIndicatorSize = 12.dp,
        dimensionIndicatorSpacing = MaterialTheme.dimensionsPaddingExtended.chunk.vertical.normal,
    )

    @Composable
    fun provideCarouselStyle() = providePagerStyle().copy {
        padding = PaddingValues(horizontal = 26.dp)
    }

}