/*
 *  *********************************************************************************
 *  Created by Tezov on 06/04/2023 23:14
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 06/04/2023 23:14
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
import com.tezov.lib_core_android_kotlin.ui.component.plain.Icon
import com.tezov.lib_core_android_kotlin.ui.component.plain.Link
import com.tezov.lib_core_android_kotlin.ui.theme.style.*
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitBorder.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.Size.Companion.asShapeSize
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState.Simple.Style.Companion.asStateSimple
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.StateColor.Style.Companion.asTextStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.theme.*

object ThemeComponentProviders {

    @Composable
    fun provideComponentsCommon() = ThemeComponentExtended.Common(
        topAppBar = TopAppBar.Style(),
        bottomNavigation = BottomNavigation.Style(
            outfitText  = TextStyle(
                fontFamily = MaterialTheme.fontUbuntu,
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp
            ).asTextStateColor,
            colorBackground  = ThemeColorProviders.Resource.whiteShady,
            outfitColor  = OutfitStateDual(
                active = ThemeColorProviders.Resource.blueElegant,
                inactive = ThemeColorProviders.Resource.blueShadow
            ),
        ),
        dialogCard = Dialog.Card.Style(
            elevation = 2.dp,
            outfitFrame = OutfitFrameStateColor(
                outfitBorder = OutfitBorderStateColor(
                    size = 2.dp,
                    outfitState = MaterialTheme.colorsCommonExtended.primary.default.asStateSimple,
                ),
                outfitShape = OutfitShapeStateColor(
                    size = 8.asShapeSize,
                    outfitState = MaterialTheme.colorsCommonExtended.backgroundModal.default.asStateSimple,
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
                outfitState = MaterialTheme.colorsCommonExtended.onBackgroundModal.dark.asStateSimple,
            ),
            outfitTextAction = OutfitTextStateColor(
                typo = TextStyle(
                    fontFamily = MaterialTheme.fontUbuntu,
                    fontWeight = FontWeight.Bold,
                    fontSize = 19.sp
                ),
                outfitState = MaterialTheme.colorsCommonExtended.onBackgroundModal.accent.asStateSimple,
            ),
            outfitShape = OutfitShapeStateColor(
                size = 12.asShapeSize,
                outfitState = MaterialTheme.colorsCommonExtended.backgroundModal.accent.asStateSimple,
            ),
            elevation = 4.dp,
        ),
    )

    @Composable
    fun provideComponentsButton() = ThemeComponentExtended.Buttons(
        primary = TODO()
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
    )

    @Composable
    fun provideComponentsLink() = ThemeComponentExtended.Links(
        primary = Link.StateColor.Style(
            outfitText = OutfitTextStateColor(
                typo = TextStyle(
                    fontFamily = MaterialTheme.fontUbuntu,
                    fontWeight = FontWeight.Normal,
                    fontSize = 20.sp,
                    textDecoration = TextDecoration.Underline
                ),
                outfitState = Color.Black.asStateSimple,
            ),
        ),
    )

    @Composable
    fun provideSectionRowStyle() = SectionActionRow.Style(
        dimensionPaddingBody_h = MaterialTheme.dimensionsPaddingExtended.page.horizontal,
        iconStyle = Icon.Simple.Style(
            size = MaterialTheme.dimensionsIconExtended.iconInfo,
            tint = MaterialTheme.colorsCommonExtended.primary.default
        ),
//        outfitTextHeader = MaterialTheme.typographiesTextExtended.text.normal.copy {
//            typo = typo.copy(
//                fontWeight = FontWeight.SemiBold
//            )
//            outfitState = OutfitStateSimple(
//                MaterialTheme.colorsCommonExtended.onBackgroundElevated.default
//            )
//        },
        colorBackgroundHeader = MaterialTheme.colorsCommonExtended.backgroundElevated.default.copy(
            alpha = 0.14f
        ),
        colorDivider = MaterialTheme.colorsCommonExtended.backgroundElevated.default.copy(
            alpha = 0.05f
        ),
        dimensionDivider = MaterialTheme.dimensionsIconExtended.divider.normal,
        actionRowStyle = provideActionRowStyle()
    )

    @Composable
    fun provideActionRowStyle() = ActionRow.Style(
        iconInfoStyle = Icon.Simple.Style(
            size = MaterialTheme.dimensionsIconExtended.iconInfo,
            tint = MaterialTheme.colorsCommonExtended.primary.default
        ),
        iconActionStyle = Icon.Simple.Style(
            size = MaterialTheme.dimensionsIconExtended.iconAction,
            tint = MaterialTheme.colorsCommonExtended.primary.default
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
            size = MaterialTheme.dimensionsIconExtended.iconInfo,
            tint = MaterialTheme.colorsCommonExtended.primary.default
        ),
//        outfitTextHeader = MaterialTheme.typographiesTextExtended.text.normal.copy {
//            typo = typo.copy(
//                fontWeight = FontWeight.SemiBold
//            )
//            outfitState = OutfitStateSimple(
//                MaterialTheme.colorsCommonExtended.onBackgroundElevated.default
//            )
//        },
        colorBackgroundHeader = MaterialTheme.colorsCommonExtended.backgroundElevated.default.copy(
            alpha = 0.14f
        ),
        dimensionPaddingBody_h = MaterialTheme.dimensionsPaddingExtended.page.horizontal,
        actionCardStyle = provideActionCardStyle()
    )

    @Composable
    fun provideActionCardStyle() = ActionCard.Style(
        outfitFrame = OutfitFrameStateColor(
            outfitShape = MaterialTheme.shapesCommonExtended.roundedCorner.normal,
            outfitBorder = MaterialTheme.bordersCommonExtended.stroke.normal.copy {
                outfitState = MaterialTheme.colorsCommonExtended.backgroundElevated.default.asStateSimple
            }
        ),
        iconStyle = Icon.Simple.Style(
            size = DpSize(56.dp),
            tint = MaterialTheme.colorsCommonExtended.primary.default
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
            template = OutfitShape.Template.Circle,
            outfitState = OutfitStateDual(
                active = MaterialTheme.colorsCommonExtended.onBackgroundElevated.default,
                inactive = MaterialTheme.colorsCommonExtended.background.default,
            )
        ),
        dimensionIndicatorPaddingTop = MaterialTheme.dimensionsPaddingExtended.element.vertical.normal,
        dimensionIndicatorSize = 12.dp,
        dimensionIndicatorSpacing = MaterialTheme.dimensionsCommonExtended.element.vertical.normal,
    )

    @Composable
    fun provideCarouselStyle() = providePagerStyle().copy {
        padding = PaddingValues(horizontal = 26.dp)
    }

}