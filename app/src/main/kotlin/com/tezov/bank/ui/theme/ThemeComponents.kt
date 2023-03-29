/*
 *  *********************************************************************************
 *  Created by Tezov on 29/03/2023 22:26
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 29/03/2023 22:26
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
import com.tezov.lib_core_android_kotlin.type.primaire.SizeDp
import com.tezov.lib_core_android_kotlin.ui.activity.sub.bottomsheet.BottomSheet
import com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog.Dialog
import com.tezov.lib_core_android_kotlin.ui.activity.sub.snackbar.Snackbar
import com.tezov.lib_core_android_kotlin.ui.component.branch.HorizontalScrollable
import com.tezov.lib_core_android_kotlin.ui.component.branch.HorizontalScrollable.Pager.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.component.plain.Button
import com.tezov.lib_core_android_kotlin.ui.component.plain.Button.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.component.plain.Icon
import com.tezov.lib_core_android_kotlin.ui.component.plain.Link
import com.tezov.lib_core_android_kotlin.ui.component.plain.Link.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.*
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitBorder.StateColor.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.StateColor.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.StateColor.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.theme.*

object ThemeComponents {

    @Composable
    fun provideComponentsCommon() = ThemeComponentExtended.Common(
        bottomNavigation = BottomNavigation.Style(
            outfitText  = TextStyle(
                fontFamily = MaterialTheme.fontUbuntu,
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp
            ).asOutfitTextColor,
            colorBackground  = ThemeColors.Common.whiteShady,
            outfitColor  = OutfitStateDual(
                active = ThemeColors.Common.blueElegant,
                inactive = ThemeColors.Common.blueShadow
            ),
        ),
        dialogCard = Dialog.Card.Style(
            elevation = 2.dp,
            outfitFrame = OutfitFrame.StateColor(
                outfitBorder = OutfitBorder.StateColor(
                    size = 2.dp,
                    outfitState = MaterialTheme.colorsExtended.primary.default.asOutfitColor,
                ),
                outfitShape = OutfitShape.StateColor(
                    size = 8.asOutfitShapeSize,
                    outfitState = MaterialTheme.colorsExtended.backgroundModal.default.asOutfitColor,
                )
            )
        ),
        bottomSheet = BottomSheet.Style(),
        snackBar = Snackbar.Style(
            outfitTextMessage = OutfitText.StateColor(
                typo = TextStyle(
                    fontFamily = MaterialTheme.fontUbuntu,
                    fontWeight = FontWeight.Normal,
                    fontSize = 19.sp
                ),
                outfitState = MaterialTheme.colorsExtended.onBackgroundModal.dark.asOutfitColor,
            ),
            outfitTextAction = OutfitText.StateColor(
                typo = TextStyle(
                    fontFamily = MaterialTheme.fontUbuntu,
                    fontWeight = FontWeight.Bold,
                    fontSize = 19.sp
                ),
                outfitState = MaterialTheme.colorsExtended.onBackgroundModal.accent.asOutfitColor,
            ),
            outfitShape = OutfitShape.StateColor(
                size = 12.asOutfitShapeSize,
                outfitState = MaterialTheme.colorsExtended.backgroundModal.accent.asOutfitColor,
            ),
            elevation = 4.dp,
        ),
    )

//    backgroundButtonProceed = OutfitStateDual(
//    active = OutfitPaletteColor(
//    default = Common.whiteShiny
//    ),
//    inactive = OutfitPaletteColor(
//    default = Common.whiteDark
//    )
//    ),
//    onBackgroundButtonProceed = OutfitStateDual(
//    active = OutfitPaletteColor(
//    default = Common.blueNight
//    ),
//    inactive = OutfitPaletteColor(
//    default = Common.grayDark
//    )
//    ),
//    backgroundButtonConfirm = OutfitStateDual(
//    active = OutfitPaletteColor(
//    default = Common.blueElegant
//    ),
//    inactive = OutfitPaletteColor(
//    default = Common.whiteDark
//    )
//    ),
//    onBackgroundButtonConfirm = OutfitStateDual(
//    active = OutfitPaletteColor(
//    default = Common.whiteShiny
//    ),
//    inactive = OutfitPaletteColor(
//    default = Common.grayDark
//    )
//    ),
//    backgroundButtonCancel = OutfitStateDual(
//    active = OutfitPaletteColor(
//    default = Common.blueShadow
//    ),
//    inactive = OutfitPaletteColor(
//    default = Common.whiteDark
//    )
//    ),
//    onBackgroundButtonCancel = OutfitStateDual(
//    active = OutfitPaletteColor(
//    default = Common.blueElegant
//    ),
//    inactive = OutfitPaletteColor(
//    default = Common.grayDark
//    )
//    ),

    @Composable
    fun provideComponentsButton() = ThemeComponentExtended.Button(
        confirm = Button.StateColor.Style.TextFilled.copy {
            outfitFrame = OutfitFrame.StateColor(
                outfitShape = MaterialTheme.shapesExtended.roundedCornerNormal.copy {
                    outfitState = OutfitStateDual(
                        active = MaterialTheme.colorsExtended.primary.default,
                        inactive = MaterialTheme.colorsExtended.primary.default,
                    )
                }
            )
            outfitText = OutfitText.StateColor(
                typo = TextStyle(
                    fontFamily = MaterialTheme.fontUbuntu,
                    fontWeight = FontWeight.Normal,
                    fontSize = 18.sp
                ),
                outfitState = OutfitStateDual(
                    active = MaterialTheme.colorsExtended.primary.default,
                    inactive = MaterialTheme.colorsExtended.primary.default,
                )
            )
        },

    )

    @Composable
    fun provideComponentsLink() = ThemeComponentExtended.Link(
        primary = Link.StateColor.Style(
            outfitText = OutfitText.StateColor(
                typo = TextStyle(
                    fontFamily = MaterialTheme.fontUbuntu,
                    fontWeight = FontWeight.Normal,
                    fontSize = 20.sp,
                    textDecoration = TextDecoration.Underline
                ),
                outfitState = Color.Black.asOutfitColor,
            ),
        )
    )

    @Composable
    fun provideSectionRowStyle() = SectionActionRow.Style(
        dimensionPaddingBody_h = MaterialTheme.dimensionsPaddingExtended.page_h,
        iconStyle = Icon.Simple.Style(
            size = MaterialTheme.dimensionsSizeExtended.iconInfo,
            tint = MaterialTheme.colorsExtended.primary.default
        ),
        outfitTextHeader = MaterialTheme.typographiesExtended.textNormal.copy {
            typo = typo.copy(
                fontWeight = FontWeight.SemiBold
            )
            outfitState = OutfitStateSimple(
                MaterialTheme.colorsExtended.onBackgroundElevated.default
            )
        },
        colorBackgroundHeader = MaterialTheme.colorsExtended.backgroundElevated.default.copy(
            alpha = 0.14f
        ),
        colorDivider = MaterialTheme.colorsExtended.backgroundElevated.default.copy(
            alpha = 0.05f
        ),
        dimensionDivider = MaterialTheme.dimensionsSizeExtended.dividerNormal,
        actionRowStyle = provideActionRowStyle()
    )

    @Composable
    fun provideActionRowStyle() = ActionRow.Style(
        iconInfoStyle = Icon.Simple.Style(
            size = MaterialTheme.dimensionsSizeExtended.iconInfo,
            tint = MaterialTheme.colorsExtended.primary.default
        ),
        iconActionStyle = Icon.Simple.Style(
            size = MaterialTheme.dimensionsSizeExtended.iconAction,
            tint = MaterialTheme.colorsExtended.primary.default
        ),
        outfitText = MaterialTheme.typographiesExtended.textNormal.copy {
            typo = typo.copy(
                fontWeight = FontWeight.SemiBold
            )
            outfitState = OutfitStateSimple(
                MaterialTheme.colorsExtended.onBackgroundElevated.default
            )
        }
    )

    @Composable
    fun provideSectionCardStyle() = SectionActionCard.Style(
        iconStyle = Icon.Simple.Style(
            size = MaterialTheme.dimensionsSizeExtended.iconInfo,
            tint = MaterialTheme.colorsExtended.primary.default
        ),
        outfitTextHeader = MaterialTheme.typographiesExtended.textNormal.copy {
            typo = typo.copy(
                fontWeight = FontWeight.SemiBold
            )
            outfitState = OutfitStateSimple(
                MaterialTheme.colorsExtended.onBackgroundElevated.default
            )
        },
        colorBackgroundHeader = MaterialTheme.colorsExtended.backgroundElevated.default.copy(
            alpha = 0.14f
        ),
        dimensionPaddingBody_h = MaterialTheme.dimensionsPaddingExtended.page_h,
        actionCardStyle = provideActionCardStyle()
    )

    @Composable
    fun provideActionCardStyle() = ActionCard.Style(
        outfitFrame = OutfitFrame.StateColor(
            outfitShape = MaterialTheme.shapesExtended.roundedCornerNormal,
            outfitBorder = MaterialTheme.bordersExtended.strokeNormal.copy {
                outfitState = OutfitStateSimple(
                    MaterialTheme.colorsExtended.backgroundElevated.default
                )
            }
        ),
        iconStyle = Icon.Simple.Style(
            size = SizeDp(56.dp),
            tint = MaterialTheme.colorsExtended.primary.default
        ),
        outfitTextTitle = MaterialTheme.typographiesExtended.textNormal.copy {
            typo = typo.copy(
                fontWeight = FontWeight.SemiBold
            )
        },
        outfitTextSubtitle = MaterialTheme.typographiesExtended.textNormal.copy {
            typo = typo.copy(
                fontWeight = FontWeight.SemiBold
            )
            outfitState = OutfitStateSimple(
                MaterialTheme.colorsExtended.onBackgroundElevated.default
            )
        },
    )

    @Composable
    fun providePagerStyle() = HorizontalScrollable.Pager.Style(
        outfitShapeIndicator = OutfitShape.StateColor(
            template = OutfitShape.Template.Circle,
            outfitState = OutfitStateDual(
                active = MaterialTheme.colorsExtended.onBackgroundElevated.default,
                inactive = MaterialTheme.colorsExtended.background.default,
            )
        ),
        dimensionIndicatorPaddingTop = MaterialTheme.dimensionsPaddingExtended.elementNormal_v,
        dimensionIndicatorSize = 12.dp,
        dimensionIndicatorSpacing = MaterialTheme.dimensionsSpacingExtended.normal_h,
    )

    @Composable
    fun provideCarouselStyle() = providePagerStyle().copy {
        padding = PaddingValues(horizontal = 26.dp)
    }

}