/*
 *  *********************************************************************************
 *  Created by Tezov on 03/03/2023 22:33
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 03/03/2023 22:28
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
import com.tezov.lib_core_android_kotlin.ui.activity.sub.bottomsheet.BottomSheet
import com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog.Dialog
import com.tezov.lib_core_android_kotlin.ui.activity.sub.snackbar.Snackbar
import com.tezov.lib_core_android_kotlin.ui.component.branch.HorizontalScrollable
import com.tezov.lib_core_android_kotlin.ui.component.branch.HorizontalScrollable.Pager.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.component.plain.Icon
import com.tezov.lib_core_android_kotlin.ui.theme.style.*
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitBorder.Simple.Style.Companion.copyToSimpleStyle
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.Simple.Style.Companion.copyToSimpleStyle
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.Simple.Style.Companion.copyToSimpleStyle
import com.tezov.lib_core_android_kotlin.ui.theme.theme.*

object ThemeComponents {

    @Composable
    fun provideComponents() = ThemeComponentExtended.Sketch(
        topAppBar = TopAppBar.Style(),
        bottomNavigation = BottomNavigation.Style(
            outfitText  = OutfitTextSketch(
                TextStyle(
                    fontFamily = MaterialTheme.fontUbuntu,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp
                )
            ),
            colorBackground  = ThemeColors.Common.whiteShady,
            outfitColor  = OutfitColorsState(
                active = ThemeColors.Common.blueSea,
                inactive = ThemeColors.Common.blueSea
            ),
        ),
        dialogCard = Dialog.Card.Style(
            elevation = 2.dp,
            outfitFrame = OutfitFrameSimple(
                outfitBorder = OutfitBorderSimple(
                    sketch = OutfitBorderSketch(
                        size = 2.dp,
                    ),
//                    color = ,
                ),
                outfitShape = OutfitShapeSimple(
                    sketch = OutfitShapeSketch(
                        size = OutfitShape.Size(8.dp)
                    )
//                    color = ,
                )
            )
        ),
        bottomSheet = BottomSheet.Style(),
        snackbar = Snackbar.Style(
            outfitTextMessage = OutfitTextSimple(
                sketch = OutfitTextSketch(
                    typo = TextStyle(
                        fontFamily = MaterialTheme.fontUbuntu,
                        fontWeight = FontWeight.Normal,
                        fontSize = 19.sp
                    )
                ),
//                color = ,
            ),
            outfitTextAction = OutfitTextSimple(
                sketch = OutfitTextSketch(
                    TextStyle(
                        fontFamily = MaterialTheme.fontUbuntu,
                        fontWeight = FontWeight.Bold,
                        fontSize = 19.sp
                    )
                ),
//                color = ,
            ),
            outfitShape = OutfitShapeSimple(
                sketch = OutfitShapeSketch(
                    size = OutfitShape.Size(12.dp)
                ),
//                color = ,
            ),
            elevation = 4.dp,
        ),
    )

    @Composable
    fun provideSectionRowStyle() = SectionActionRow.Style(
        dimensionPaddingBody_h = MaterialTheme.dimensionsPaddingExtended.page_h,
        iconStyle = Icon.Simple.Style(
            size = MaterialTheme.dimensionsSizeExtended.iconInfo,
            tint = MaterialTheme.colors.primary
        ),
        outfitTextHeader = MaterialTheme.typographiesSketchExtended.textNormal.copyToSimpleStyle {
            typo = typo.copy(
                fontWeight = FontWeight.SemiBold
            )
            color = MaterialTheme.colorsCommonExtended.onBackgroundElevated
        },
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
        outfitText = MaterialTheme.typographiesSketchExtended.textNormal.copyToSimpleStyle {
            typo = typo.copy(
                fontWeight = FontWeight.SemiBold
            )
            color = MaterialTheme.colorsCommonExtended.onBackgroundElevated
        }
    )

    @Composable
    fun provideSectionCardStyle() = SectionActionCard.Style(
        iconStyle = Icon.Simple.Style(
            size = MaterialTheme.dimensionsSizeExtended.iconInfo,
            tint = MaterialTheme.colors.primary
        ),
        outfitTextHeader = MaterialTheme.typographiesSketchExtended.textNormal.copyToSimpleStyle {
            typo = typo.copy(
                fontWeight = FontWeight.SemiBold
            )
            color = MaterialTheme.colorsCommonExtended.onBackgroundElevated
        },
        colorBackgroundHeader = MaterialTheme.colorsCommonExtended.backgroundElevated.copy(
            alpha = 0.14f
        ),
        dimensionPaddingBody_h = MaterialTheme.dimensionsPaddingExtended.page_h,
        actionCardStyle = provideActionCardStyle()
    )

    @Composable
    fun provideActionCardStyle() = ActionCard.Style(
        outfitFrame = OutfitFrameSimple(
            outfitShape = MaterialTheme.shapesSketchExtended.roundedCornerNormal.copyToSimpleStyle(),
            outfitBorder = MaterialTheme.bordersSketchExtended.strokeNormal.copyToSimpleStyle {
                color = MaterialTheme.colorsCommonExtended.backgroundElevated
            }
        ),
        iconStyle = Icon.Simple.Style(
            size = 56.dp,
            tint = MaterialTheme.colors.primary
        ),
        outfitTextTitle = MaterialTheme.typographiesSketchExtended.textNormal.copyToSimpleStyle {
            typo = typo.copy(
                fontWeight = FontWeight.SemiBold
            )
        },
        outfitTextSubtitle = MaterialTheme.typographiesSketchExtended.textNormal.copyToSimpleStyle {
            typo = typo.copy(
                fontWeight = FontWeight.SemiBold
            )
            color = MaterialTheme.colorsCommonExtended.onBackgroundElevated
        },
    )

    @Composable
    fun providePagerStyle() = HorizontalScrollable.Pager.Style(
        outfitShapeIndicator = OutfitShapeState(
            sketch = OutfitShapeSketch(
                template = OutfitShape.Template.Circle,
            ),
            outfitColor = OutfitColorsState(
                active = MaterialTheme.colorsCommonExtended.backgroundButtonConfirm.active,
                inactive = MaterialTheme.colorsCommonExtended.onSecondaryVariant,
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