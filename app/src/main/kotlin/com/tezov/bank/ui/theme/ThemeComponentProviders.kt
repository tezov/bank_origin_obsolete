/*
 *  *********************************************************************************
 *  Created by Tezov on 22/04/2023 22:06
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 22/04/2023 20:36
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tezov.bank.ui.component.block.*
import com.tezov.bank.ui.component.element.*
import com.tezov.bank.ui.page.auth.discover.colors
import com.tezov.bank.ui.page.auth.discover.dimensions
import com.tezov.bank.ui.theme.font.fontIbm
import com.tezov.bank.ui.theme.font.fontRoboto
import com.tezov.lib_core_android_kotlin.navigation.bottom_navigation.BottomNavigation
import com.tezov.lib_core_android_kotlin.navigation.top_app_bar.TopAppBar
import com.tezov.lib_core_android_kotlin.type.primaire.dpSize
import com.tezov.lib_core_android_kotlin.ui.activity.sub.bottomsheet.BottomSheet
import com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog.Dialog
import com.tezov.lib_core_android_kotlin.ui.activity.sub.snackbar.Snackbar
import com.tezov.lib_core_android_kotlin.ui.component.block.HorizontalPager
import com.tezov.lib_core_android_kotlin.ui.component.block.HorizontalPager.Page.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.component.block.HorizontalRoller
import com.tezov.lib_core_android_kotlin.ui.component.block.HorizontalRoller.Page.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Button
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Button.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Icon
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Icon.Simple.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Image
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Link
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Link.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.*
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitBorder.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitFrame.StateColor.Style.Companion.copy
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
            outfitText = TextStyle(
                fontFamily = MaterialTheme.fontRoboto,
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.5.sp
            ).asTextStateColor,
            colorBackground = MaterialTheme.colorsPalette.whiteShady,
            outfitColor = OutfitStateDual(
                active = MaterialTheme.colorsPalette.blueSea,
                inactive = MaterialTheme.colorsPalette.blueShadow
            ),
        ),
        dialogCard = Dialog.Card.Style(
            elevation = 2.dp,
            outfitFrame = OutfitFrameStateColor(
                outfitBorder = OutfitBorderStateColor(
                    size = 1.2.dp,
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
                    fontFamily = MaterialTheme.fontIbm,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp
                ),
                outfitState = MaterialTheme.colorsExtended.onBackgroundModal.dark.asStateSimple,
            ),
            outfitTextAction = OutfitTextStateColor(
                typo = TextStyle(
                    fontFamily = MaterialTheme.fontIbm,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                ),
                outfitState = MaterialTheme.colorsExtended.onBackgroundModal.dark.asStateSimple,
            ),
            outfitShape = OutfitShapeStateColor(
                size = 8.dp.asShapeSize,
                outfitState = MaterialTheme.colorsExtended.backgroundModal.default.asStateSimple,
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
            outfitText = MaterialTheme.typographiesExtended.button.normal.copy {
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
            outfitText = MaterialTheme.typographiesExtended.button.normal.copy {
                outfitState = OutfitStateDual(
                    active = MaterialTheme.colorsExtended.onPrimary.default,
                    inactive = MaterialTheme.colorsExtended.onPrimary.fade,
                )
            }
        ),
        tertiary = Button.StateColor.Style(
            outfitFrame = OutfitFrameStateColor(
                outfitShape = MaterialTheme.shapesExtended.button.normal,
                outfitBorder = MaterialTheme.bordersExtended.button.big.copy {
                    outfitState = OutfitStateDual(
                        active = MaterialTheme.colorsExtended.primary.default,
                        inactive = MaterialTheme.colorsPalette.grayLight,
                    )
                }
            ),
            outfitText = MaterialTheme.typographiesExtended.button.big.copy {
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
        ),
        secondary = Link.StateColor.Style(
            outfitText = MaterialTheme.typographiesExtended.link.big.copy {
                outfitState = OutfitStateDual(
                    active = MaterialTheme.colorsExtended.primary.default,
                    inactive = MaterialTheme.colorsPalette.grayLight,
                )
            }
        ),
        tertiary = Link.StateColor.Style(
            outfitText = MaterialTheme.typographiesExtended.link.small.copy {
                outfitState = OutfitStateDual(
                    active = MaterialTheme.colorsExtended.primary.default,
                    inactive = MaterialTheme.colorsPalette.grayLight,
                )
            }
        )
    )

    @Composable
    fun sectionSimpleRowStyle() = SectionSimpleRow.Style(
        iconStyle = Icon.Simple.Style(
            size = MaterialTheme.dimensionsIconExtended.info.normal,
            tint = MaterialTheme.colorsExtended.primary.accent
        ),
        outfitTextTitle = MaterialTheme.typographiesExtended.title.normal.copy {
            outfitState = MaterialTheme.colorsExtended.primary.shady.asStateSimple
        },
        colorBackgroundHeader = MaterialTheme.colorsExtended.backgroundElevated.overlay,
        colorDivider = MaterialTheme.colorsExtended.backgroundElevated.fade,
        sizeDivider = MaterialTheme.dimensionsCommonExtended.divider.normal,
        rowStyle = simpleRowStyle()
    )

    @Composable
    fun simpleRowStyle() = SimpleRow.Style(
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
    fun sectionAccountValueSimpleRowStyle() = SectionAccountValueSimpleRow.Style(
        outfitTextTitle = MaterialTheme.typographiesExtended.title.normal.copy {
            outfitState = MaterialTheme.colorsExtended.primary.shady.asStateSimple
        },
        colorBackgroundHeader = MaterialTheme.colorsExtended.backgroundElevated.overlay,
        colorDivider = MaterialTheme.colorsExtended.primary.fade,
        sizeDivider = MaterialTheme.dimensionsCommonExtended.divider.normal,
        rowStyle = accountValueSimpleRowStyle()
    )

    @Composable
    fun accountValueSimpleRowStyle() = AccountValueSimpleRow.Style(
        iconInfoStyle = Icon.Simple.Style(
            size = MaterialTheme.dimensionsIconExtended.info.normal,
            tint = MaterialTheme.colorsExtended.primary.accent
        ),
        outfitTextTitle = MaterialTheme.typographiesExtended.body.normal.copy {
            outfitState = MaterialTheme.colorsExtended.primary.default.asStateSimple
        },
        outfitTextSubTitle = MaterialTheme.typographiesExtended.helper.normal.copy {
            outfitState = MaterialTheme.colorsExtended.primary.default.asStateSimple
        },
        outfitTextAmount = MaterialTheme.typographiesExtended.body.normal.copy {
            outfitState = MaterialTheme.colorsExtended.primary.default.asStateSimple
        },
    )

    @Composable
    fun sectionTileStyle() = SectionSimpleTile.Style(
        iconStyle = Icon.Simple.Style(
            size = MaterialTheme.dimensionsIconExtended.info.normal,
            tint = MaterialTheme.colorsExtended.primary.accent
        ),
        outfitTextTitle = MaterialTheme.typographiesExtended.title.huge.copy {
            outfitState = MaterialTheme.colorsExtended.primary.shady.asStateSimple
            typo = typo.copy(
                fontWeight = FontWeight.Bold
            )
        },
        colorBackgroundHeader = null,
        tileStyle = tileStyle()
    )

    @Composable
    fun tileStyle() = SimpleTile.Style(
        outfitFrame = OutfitFrameStateColor(
            outfitShape = MaterialTheme.shapesExtended.element.normal.copy {
                outfitState = MaterialTheme.colorsExtended.backgroundElevated.default.asStateSimple
            }
        ),
        iconStyle = Icon.Simple.Style(
            size = MaterialTheme.dimensionsIconExtended.info.normal,
            tint = MaterialTheme.colorsExtended.primary.accent
        ),
        outfitTextTitle = MaterialTheme.typographiesExtended.title.big.copy {
            outfitState = MaterialTheme.colorsExtended.primary.default.asStateSimple
        },
        outfitTextSubtitle = MaterialTheme.typographiesExtended.body.normal.copy {
            outfitState = MaterialTheme.colorsExtended.primary.fade.asStateSimple
        }
    )

    @Composable
    fun pagerStyle() = HorizontalPager.Page.Style(
        outfitShapeIndicator = OutfitShapeStateColor(
            outfitState = OutfitStateDual(
                active = MaterialTheme.colorsExtended.primary.accent,
                inactive = MaterialTheme.colorsExtended.primary.default.copy(alpha = 0.6f),
            )
        ),
        paddingTopIndicator = MaterialTheme.dimensionsPaddingExtended.element.normal.vertical,
        sizeIndicator = 12.dp,
        spacingIndicator = MaterialTheme.dimensionsPaddingExtended.element.big.horizontal,
    )

    @Composable
    fun sectionCarouselCardStyle(cardStyle: CarouselCard.Style.Base) =
        SectionCarouselCard.Style(
            iconStyle = Icon.Simple.Style(
                size = MaterialTheme.dimensionsIconExtended.info.normal,
                tint = MaterialTheme.colorsExtended.primary.accent
            ),
            outfitTextTitle = MaterialTheme.typographiesExtended.title.huge.copy {
                outfitState = MaterialTheme.colorsExtended.primary.shady.asStateSimple
                typo = typo.copy(
                    fontWeight = FontWeight.Bold
                )
            },
            carouselStyle = pagerStyle().copy {
                paddingContent =
                    PaddingValues(horizontal = MaterialTheme.dimensionsPaddingExtended.page.normal.horizontal)
                spacingItem = MaterialTheme.dimensionsPaddingExtended.page.normal.horizontal
            },
            colorBackgroundHeader = null,
            cardStyle = cardStyle,
        )

    @Composable
    fun carouselCardButtonStyle() = CarouselCard.Style.Button(
        baseStyle = CarouselCard.Style.Base(
            outfitFrame = OutfitFrameStateColor(
                outfitShape = MaterialTheme.shapesExtended.element.big.copy{
                    outfitState = MaterialTheme.colorsExtended.background.default.asStateSimple
                },
                outfitBorder = MaterialTheme.bordersExtended.element.normal.copy {
                    outfitState = MaterialTheme.colorsExtended.backgroundElevated.decor.asStateSimple
                },
            ),
            iconInfoStyle = Icon.Simple.Style(
                size = MaterialTheme.dimensionsIconExtended.info.big,
                tint = MaterialTheme.colorsExtended.primary.accent.copy(alpha = 0.5f)
            ),
            outfitTextTitle = MaterialTheme.typographiesExtended.title.big.copy {
                outfitState = MaterialTheme.colorsExtended.primary.default.asStateSimple
                typo = typo.copy(fontWeight = FontWeight.Bold)
            },
            outfitTextBody = MaterialTheme.typographiesExtended.body.normal.copy {
                outfitState = MaterialTheme.colorsExtended.primary.default.asStateSimple
            },
            outfitTextTag = MaterialTheme.typographiesExtended.label.big.copy {
                outfitState = MaterialTheme.colorsExtended.primary.accent.asStateSimple
            },
            outfitFrameTag = OutfitFrameStateColor(
                outfitShape = MaterialTheme.shapesExtended.element.big,
                outfitBorder = MaterialTheme.bordersExtended.element.big.copy {
                    outfitState = MaterialTheme.colorsExtended.primary.accent.asStateSimple
                }
            ),
        ),
        actionStyle = MaterialTheme.componentsButtonExtended.primary.copy {
            outfitFrame = outfitFrame.copy {
                outfitShape = MaterialTheme.shapesExtended.button.small.copy {
                    outfitState = MaterialTheme.colorsExtended.primary.accent.asStateSimple
                }
            }
            outfitText = MaterialTheme.typographiesExtended.button.small.copy {
                outfitState = MaterialTheme.colorsExtended.primary.shiny.asStateSimple
            }
        }
    )

    @Composable
    fun carouselCardLinkStyle() = CarouselCard.Style.Link(
        baseStyle = CarouselCard.Style.Base(
            outfitFrame = OutfitFrameStateColor(
                outfitShape = MaterialTheme.shapesExtended.element.big.copy {
                    outfitState = MaterialTheme.colorsExtended.backgroundElevated.overlay.asStateSimple
                },
            ),
            iconInfoStyle = Icon.Simple.Style(
                size = MaterialTheme.dimensionsIconExtended.info.normal,
                tint = MaterialTheme.colorsExtended.primary.accent
            ),
            outfitTextTitle = MaterialTheme.typographiesExtended.title.big.copy {
                outfitState = MaterialTheme.colorsExtended.primary.default.asStateSimple
                typo = typo.copy(fontWeight = FontWeight.Bold)
            },
            outfitTextBody = MaterialTheme.typographiesExtended.body.normal.copy {
                outfitState = MaterialTheme.colorsExtended.primary.default.asStateSimple
            },
            outfitFrameTag = OutfitFrameStateColor(
                outfitShape = MaterialTheme.shapesExtended.element.big,
                outfitBorder = MaterialTheme.bordersExtended.element.big.copy {
                    outfitState = MaterialTheme.colorsExtended.primary.accent.asStateSimple
                }
            ),
        ),
        actionStyle = MaterialTheme.componentsLinkExtended.primary.copy {
            outfitText = outfitText.copy {
                outfitState = MaterialTheme.colorsExtended.primary.accent.asStateSimple
            }
        }
    )

    @Composable
    fun rollerStyle() = HorizontalRoller.Page.Style()

    @Composable
    fun sectionRollerCardStyle() =
        SectionRollerCard.Style(
            iconStyle = Icon.Simple.Style(
                size = MaterialTheme.dimensionsIconExtended.info.normal,
                tint = MaterialTheme.colorsExtended.primary.accent
            ),
            outfitTextTitle = MaterialTheme.typographiesExtended.title.huge.copy {
                outfitState = MaterialTheme.colorsExtended.primary.default.asStateSimple
                typo = typo.copy(
                    fontWeight = FontWeight.Bold
                )
            },
            outfitTextSubTitle = MaterialTheme.typographiesExtended.title.normal.copy {
                outfitState = MaterialTheme.colorsExtended.primary.accent.asStateSimple
                typo = typo.copy(
                    fontWeight = FontWeight.Bold
                )
            },
            actionStyle = MaterialTheme.componentsButtonExtended.primary.copy {
                outfitText = outfitText.copy {
                    outfitState = MaterialTheme.colorsExtended.primary.shiny.asStateSimple
                }
                outfitFrame = outfitFrame.copy {
                    outfitShape = outfitShape.copy {
                        outfitState = MaterialTheme.colorsExtended.primary.accent.asStateSimple
                    }
                }
            },
            rollerStyle = rollerStyle().copy {
                paddingContent =
                    PaddingValues(horizontal = MaterialTheme.dimensionsPaddingExtended.page.normal.horizontal)
                spacingItem = MaterialTheme.dimensionsPaddingExtended.element.small.horizontal
            },
            cardStyle = rollerCardStyle()
        )

    @Composable
    fun rollerCardStyle() = RollerCard.Style(
        outfitFrame = OutfitFrameStateColor(
            outfitShape = MaterialTheme.shapesExtended.element.small.copy{
                outfitState = MaterialTheme.colorsExtended.backgroundElevated.default.asStateSimple
            },
            outfitBorder = MaterialTheme.bordersExtended.element.normal.copy {
                outfitState = MaterialTheme.colorsExtended.primary.fade.asStateSimple
            },
        ),
        imageStyle = Image.Simple.Style(
            size = 96.dpSize,
            contentScale = ContentScale.FillBounds
        ),
        outfitTextTitle = MaterialTheme.typographiesExtended.body.small.copy {
            outfitState = MaterialTheme.colorsExtended.primary.default.asStateSimple
        },
    )

}