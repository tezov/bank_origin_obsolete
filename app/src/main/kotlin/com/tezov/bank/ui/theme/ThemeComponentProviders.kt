/*
 *  *********************************************************************************
 *  Created by Tezov on 09/04/2023 21:33
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 09/04/2023 21:25
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.theme

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
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
    fun common() = ThemeComponentExtended.Common(
        topAppBar = TopAppBar.Style(),
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
        bottomSheet = BottomSheet.Style(),
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
    fun buttons() = ThemeComponentExtended.Buttons(
        primary = Button.StateColor.Style(
            outfitFrame = OutfitFrameStateColor(
                outfitShape = MaterialTheme.shapesExtended.button.normal.copy {
                    outfitState = OutfitStateDual(
                        active = MaterialTheme.colorsExtended.primary.default,
                        inactive = MaterialTheme.colorsExtended.primary.fade,
                    )
                }
            ),
            outfitText = MaterialTheme.typographiesExtended.button.normal.copy{
                outfitState = OutfitStateDual(
                    active = MaterialTheme.colorsExtended.onPrimary.default,
                    inactive = MaterialTheme.colorsExtended.onPrimary.fade,
                )
            }
        ),
        secondary = Button.StateColor.Style(
            outfitFrame = OutfitFrameStateColor(
                outfitShape = MaterialTheme.shapesExtended.button.normal.copy {
                    outfitState = OutfitStateDual(
                        active = MaterialTheme.colorsExtended.primary.shiny,
                        inactive = MaterialTheme.colorsExtended.primary.fade,
                    )
                },
                outfitBorder = MaterialTheme.bordersExtended.button.normal.copy {
                    outfitState = MaterialTheme.colorsExtended.primary.fade.asStateSimple
                }
            ),
            outfitText = MaterialTheme.typographiesExtended.button.normal.copy{
                outfitState = OutfitStateDual(
                    active = MaterialTheme.colorsExtended.onPrimary.default,
                    inactive = MaterialTheme.colorsExtended.onPrimary.fade,
                )
            }
        ),
        tertiary = Button.StateColor.Style(
            outfitFrame = OutfitFrameStateColor(
                outfitShape = MaterialTheme.shapesExtended.button.normal,
                outfitBorder =MaterialTheme.bordersExtended.button.big.copy {
                    outfitState = OutfitStateDual(
                        active = MaterialTheme.colorsExtended.primary.default,
                        inactive = MaterialTheme.colorsPalette.grayLight,
                    )
                }
            ),
            outfitText = MaterialTheme.typographiesExtended.button.big.copy{
                outfitState = OutfitStateDual(
                    active = MaterialTheme.colorsExtended.onPrimary.default,
                    inactive = MaterialTheme.colorsPalette.grayBlack,
                )
            }
        )
    )

    @Composable
    fun link() = ThemeComponentExtended.Links(
        primary = Link.StateColor.Style(
            outfitText = MaterialTheme.typographiesExtended.link.normal.copy {
                outfitState = OutfitStateDual(
                    active = MaterialTheme.colorsExtended.primary.default,
                    inactive = MaterialTheme.colorsPalette.grayLight,
                )
            }
        )
    )

    @Composable
    fun provideSectionRowStyle() = SectionActionRow.Style(
        iconStyle = Icon.Simple.Style(
            size = MaterialTheme.dimensionsIconExtended.info.normal,
            tint = MaterialTheme.colorsExtended.primary.default
        ),
        outfitTextHeader = MaterialTheme.typographiesExtended.title.small.copy {
            outfitState = MaterialTheme.colorsExtended.primary.default.asStateSimple
        },
        colorBackgroundHeader = MaterialTheme.colorsExtended.backgroundElevated.default,
        colorDivider = MaterialTheme.colorsPalette.grayLightOverlay,
        dimensionDivider = MaterialTheme.dimensionsCommonExtended.divider.normal,
        actionRowStyle = provideActionRowStyle()
    )

    @Composable
    fun provideActionRowStyle() = ActionRow.Style(
        iconInfoStyle = Icon.Simple.Style(
            size = MaterialTheme.dimensionsIconExtended.info.normal,
            tint = MaterialTheme.colorsExtended.primary.accent
        ),
        iconActionStyle = Icon.Simple.Style(
            size = MaterialTheme.dimensionsIconExtended.info.small,
            tint = MaterialTheme.colorsExtended.primary.accent
        ),
        outfitText = MaterialTheme.typographiesExtended.body.normal.copy {
            outfitState = MaterialTheme.colorsExtended.primary.default.asStateSimple
        },
    )

    @Composable
    fun provideSectionCardStyle() = SectionActionCard.Style(
        iconStyle = Icon.Simple.Style(
            size = MaterialTheme.dimensionsIconExtended.info.normal,
            tint = MaterialTheme.colorsExtended.primary.accent
        ),
        outfitTextHeader = MaterialTheme.typographiesExtended.body.normal.copy {
            outfitState = MaterialTheme.colorsExtended.primary.default.asStateSimple
        },
        colorBackgroundHeader = MaterialTheme.colorsExtended.backgroundElevated.default,
        actionCardStyle = provideActionCardStyle()
    )

    @Composable
    fun provideActionCardStyle() = ActionCard.Style(
        outfitFrame = OutfitFrameStateColor(
            outfitShape = MaterialTheme.shapesExtended.element.normal,
            outfitBorder = MaterialTheme.bordersExtended.element.normal.copy {
                outfitState = MaterialTheme.colorsExtended.backgroundElevated.default.asStateSimple
            }
        ),
        iconStyle = Icon.Simple.Style(
            size = MaterialTheme.dimensionsIconExtended.info.big,
            tint = MaterialTheme.colorsExtended.primary.accent
        ),
        outfitTextTitle = MaterialTheme.typographiesExtended.title.small.copy {
            outfitState = MaterialTheme.colorsExtended.primary.default.asStateSimple
            typo = typo.copy(
                fontWeight = FontWeight.SemiBold
            )
        },
        outfitTextSubtitle = MaterialTheme.typographiesExtended.body.normal.copy {
            outfitState = MaterialTheme.colorsExtended.primary.fade.asStateSimple
        }
    )

    @Composable
    fun pagerStyle() = HorizontalScrollable.Pager.Style(
        outfitShapeIndicator = OutfitShapeStateColor(
            outfitState = OutfitStateDual(
                active = MaterialTheme.colorsExtended.primary.default,
                inactive = MaterialTheme.colorsExtended.primary.default.copy(alpha = 0.5f),
            )
        ),
        dimensionIndicatorPaddingTop = MaterialTheme.dimensionsPaddingExtended.element.normal.vertical,
        dimensionIndicatorSize = 8.dp,
        dimensionIndicatorSpacing = MaterialTheme.dimensionsPaddingExtended.element.normal.horizontal,
    )

    @Composable
    fun provideCarouselStyle() = pagerStyle().copy {
        padding = PaddingValues(horizontal = 26.dp)
    }

}