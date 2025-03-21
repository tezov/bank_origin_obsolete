/*
 *  ********************************************************************************
 *  Created by Tezov under MIT LICENCE.
 *  For any request, please send me an email to tezov.app@gmail.com.
 *  I'll be glad to answer you if your request is sane :)
 *  ********************************************************************************
 *
 *
 */

/*
 *  ********************************************************************************
 *  Created by Tezov under MIT LICENCE.
 *  For any request, please send me an email to tezov.app@gmail.com.
 *  I'll be glad to answer you if your request is sane :)
 *  ********************************************************************************
 *
 *
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
import com.tezov.bank.ui.theme.font.fontIbm
import com.tezov.bank.ui.theme.font.fontIndie
import com.tezov.bank.ui.theme.font.fontRoboto
import com.tezov.lib_core_android_kotlin.navigation.bottom_navigation.BottomNavigation
import com.tezov.lib_core_android_kotlin.navigation.top_app_bar.TopAppBar
import com.tezov.lib_core_android_kotlin.type.primaire.dpSize
import com.tezov.lib_core_android_kotlin.ui.activity.sub.bottomsheet.BottomSheet
import com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog.Dialog
import com.tezov.lib_core_android_kotlin.ui.activity.sub.snackbar.Snackbar
import com.tezov.lib_core_android_kotlin.ui.component.block.HorizontalPager
import com.tezov.lib_core_android_kotlin.ui.component.block.HorizontalPager.WithIndicator.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.component.block.HorizontalRoller
import com.tezov.lib_core_android_kotlin.ui.component.block.HorizontalRoller.Simple.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.component.chunk.*
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Button.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Link.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.*
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitBorder.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitFrame.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState.Simple.Style.Companion.asStateSimple
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.StateColor.Style.Companion.asTextStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.theme.*

object ThemeComponentProviders {

    @Composable
    fun common() = ThemeComponentExtended.Common(
        topAppBar = TopAppBar.Style(
            elevation = MaterialTheme.dimensionsCommonExtended.elevation.normal,
            outfitText = OutfitTextStateColor(
                typo = TextStyle(
                    fontFamily = MaterialTheme.fontIndie,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.5.sp,
                ),
                outfitState = MaterialTheme.colorsExtended.primary.default.asStateSimple
            ),
            colorBackground = MaterialTheme.colorsExtended.backgroundElevated.shady,
            colorIconLeading = MaterialTheme.colorsExtended.primary.accent,
        ),
        bottomNavigation = BottomNavigation.Style(
            elevation = MaterialTheme.dimensionsCommonExtended.elevation.normal,
            outfitText = TextStyle(
                fontFamily = MaterialTheme.fontRoboto,
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.5.sp
            ).asTextStateColor,
            colorBackground = MaterialTheme.colorsExtended.backgroundElevated.fade,
            outfitColor = OutfitStateBiStable(
                active = MaterialTheme.colorsExtended.primary.accent,
                inactive = MaterialTheme.colorsExtended.primary.dark,
            ),
        ),
        dialogCard = Dialog.Card.Style(
            elevation = MaterialTheme.dimensionsCommonExtended.elevation.normal,
            outfitFrame = OutfitFrameStateColor(
                outfitBorder = MaterialTheme.bordersExtended.block.big.copy {
                    outfitState = MaterialTheme.colorsExtended.backgroundModal.decor.asStateSimple
                },
                outfitShape = MaterialTheme.shapesExtended.block.normal.copy {
                    outfitState = MaterialTheme.colorsExtended.backgroundModal.default.asStateSimple
                }
            )
        ),
        bottomSheet = BottomSheet.Sheet.Style(
            outfitShape = MaterialTheme.shapesExtended.block.big.copy{
                size = size?.firstNotNull?.let {
                    OutfitShape.Size(
                        topStart = it,
                        topEnd = it
                    )
                }
                outfitState = MaterialTheme.colorsExtended.backgroundModal.default.asStateSimple
            }
        ),
        snackBar = Snackbar.Style(
            outfitTextMessage = OutfitTextStateColor(
                typo = TextStyle(
                    fontFamily = MaterialTheme.fontIbm,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp
                ),
                outfitState = OutfitStateTemplate(
                    a = MaterialTheme.colorsExtended.onBackgroundModal.default,
                ),
            ),
            outfitTextAction = OutfitTextStateColor(
                typo = TextStyle(
                    fontFamily = MaterialTheme.fontIbm,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                ),
                outfitState = OutfitStateTemplate(
                    a = MaterialTheme.colorsExtended.onBackgroundModal.default,
                ),
            ),
            outfitShape = MaterialTheme.shapesExtended.block.normal.copy {
                outfitState = OutfitStateTemplate(
                    a = MaterialTheme.colorsExtended.backgroundModal.fade,
                )
            },
            elevation = MaterialTheme.dimensionsCommonExtended.elevation.big,
        ),
    )

    @Composable
    fun buttons() = ThemeComponentExtended.Buttons(
        primary = Button.StateColor.Style(
            outfitFrame = OutfitFrameStateColor(
                outfitShape = MaterialTheme.shapesExtended.button.normal.copy {
                    outfitState = OutfitStateBiStable(
                        active = MaterialTheme.colorsExtended.primary.default,
                        inactive = MaterialTheme.colorsExtended.primary.fade,
                    )
                }
            ),
            outfitText = MaterialTheme.typographiesExtended.button.normal.copy {
                outfitState = OutfitStateBiStable(
                    active = MaterialTheme.colorsExtended.onPrimary.default,
                    inactive = MaterialTheme.colorsExtended.onPrimary.fade,
                )
            }
        ),
        secondary = Button.StateColor.Style(
            outfitFrame = OutfitFrameStateColor(
                outfitShape = MaterialTheme.shapesExtended.button.normal.copy {
                    outfitState = OutfitStateBiStable(
                        active = MaterialTheme.colorsExtended.primary.shiny,
                        inactive = MaterialTheme.colorsExtended.primary.fade,
                    )
                },
                outfitBorder = MaterialTheme.bordersExtended.button.normal.copy {
                    outfitState = MaterialTheme.colorsExtended.primary.fade.asStateSimple
                }
            ),
            outfitText = MaterialTheme.typographiesExtended.button.normal.copy {
                outfitState = OutfitStateBiStable(
                    active = MaterialTheme.colorsExtended.onPrimary.default,
                    inactive = MaterialTheme.colorsExtended.onPrimary.fade,
                )
            }
        ),
        tertiary = Button.StateColor.Style(
            outfitFrame = OutfitFrameStateColor(
                outfitShape = MaterialTheme.shapesExtended.button.normal,
                outfitBorder = MaterialTheme.bordersExtended.button.big.copy {
                    outfitState = OutfitStateBiStable(
                        active = MaterialTheme.colorsExtended.primary.default,
                        inactive = MaterialTheme.colorsPalette.grayLight,
                    )
                }
            ),
            outfitText = MaterialTheme.typographiesExtended.button.big.copy {
                outfitState = OutfitStateBiStable(
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
                outfitState = OutfitStateBiStable(
                    active = MaterialTheme.colorsExtended.primary.default,
                    inactive = MaterialTheme.colorsPalette.grayLight,
                )
            }
        ),
        secondary = Link.StateColor.Style(
            outfitText = MaterialTheme.typographiesExtended.link.big.copy {
                outfitState = OutfitStateBiStable(
                    active = MaterialTheme.colorsExtended.primary.default,
                    inactive = MaterialTheme.colorsPalette.grayLight,
                )
            }
        ),
        tertiary = Link.StateColor.Style(
            outfitText = MaterialTheme.typographiesExtended.link.small.copy {
                outfitState = OutfitStateBiStable(
                    active = MaterialTheme.colorsExtended.primary.default,
                    inactive = MaterialTheme.colorsPalette.grayLight,
                )
            }
        )
    )

    @Composable
    fun dropDownMenu() = DropDownMenu.StateColor.Style(
        outfitText = MaterialTheme.typographiesExtended.menu.normal.copy {
            outfitState = MaterialTheme.colorsExtended.onBackgroundModal.default.asStateSimple
        },
        colorBackgroundMenu = MaterialTheme.colorsExtended.backgroundModal.default
    )

    @Composable
    fun accountSummaryCard() = AccountSummaryCard.Style(
        outfitFrame = OutfitFrameStateColor(
            outfitShape = MaterialTheme.shapesExtended.element.big.copy {
                outfitState = MaterialTheme.colorsExtended.primary.default.asStateSimple
            }
        ),
        styleIconInfo = Icon.Simple.Style(
            size = MaterialTheme.dimensionsIconExtended.action.normal,
            tint = MaterialTheme.colorsExtended.onPrimary.default
        ),
        outfitTextSurtitle = MaterialTheme.typographiesExtended.label.normal.copy {
            outfitState = MaterialTheme.colorsExtended.onPrimary.default.asStateSimple
            typo = typo.copy(
                fontWeight = FontWeight.SemiBold
            )
        },
        outfitTextTitle = MaterialTheme.typographiesExtended.body.normal.copy {
            outfitState = MaterialTheme.colorsExtended.onPrimary.default.asStateSimple
            typo = typo.copy(
                fontWeight = FontWeight.Bold
            )
        },
        outfitTextSubtitle = MaterialTheme.typographiesExtended.label.normal.copy {
            outfitState = MaterialTheme.colorsExtended.onPrimary.fade.asStateSimple
        },
        outfitTextAmount = MaterialTheme.typographiesExtended.title.big.copy {
            outfitState = MaterialTheme.colorsExtended.onPrimary.default.asStateSimple
            typo = typo.copy(
                fontWeight = FontWeight.Bold
            )
        },
        styleDropDownMenu = dropDownMenu(),
    )

    @Composable
    fun sectionSimpleRowStyle() = SectionSimpleRow.Style(
        styleIconInfo = Icon.Simple.Style(
            size = MaterialTheme.dimensionsIconExtended.info.normal,
            tint = MaterialTheme.colorsExtended.primary.accent
        ),
        outfitTextTitle = MaterialTheme.typographiesExtended.title.normal.copy {
            outfitState = MaterialTheme.colorsExtended.primary.shady.asStateSimple
        },
        colorBackgroundHeader = MaterialTheme.colorsExtended.backgroundElevated.overlay,
        colorDivider = MaterialTheme.colorsExtended.backgroundElevated.fade,
        sizeDivider = MaterialTheme.dimensionsCommonExtended.divider.normal,
        styleRow = simpleRowStyle()
    )

    @Composable
    fun simpleRowStyle() = SimpleRow.Style(
        styleIconInfo = Icon.Simple.Style(
            size = MaterialTheme.dimensionsIconExtended.info.normal,
            tint = MaterialTheme.colorsExtended.primary.accent
        ),
        styleIconAction = Icon.Simple.Style(
            size = MaterialTheme.dimensionsIconExtended.action.small,
            tint = MaterialTheme.colorsExtended.primary.accent
        ),
        outfitTextTitle = MaterialTheme.typographiesExtended.body.normal.copy {
            outfitState = MaterialTheme.colorsExtended.primary.default.asStateSimple
        },
    )

    @Composable
    fun pagerWidthTabRowStyle() = HorizontalPager.WithTabRow.Style(
        outfitText = MaterialTheme.typographiesExtended.title.normal.copy {
            outfitState = OutfitStateBiStable(
                active = MaterialTheme.colorsExtended.primary.accent,
                inactive = MaterialTheme.colorsExtended.primary.fade,
            )
        },
        colorIndicator = OutfitStateBiStable(
            active = MaterialTheme.colorsExtended.primary.accent,
            inactive = MaterialTheme.colorsExtended.backgroundElevated.overlay,
        ),
    )

    @Composable
    fun sectionMessageRowStyle() = SectionMessageRow.Style(
        styleIconInfo = Icon.Simple.Style(
            size = MaterialTheme.dimensionsIconExtended.info.normal,
            tint = MaterialTheme.colorsExtended.primary.accent
        ),
        outfitTextTitle = MaterialTheme.typographiesExtended.title.normal.copy {
            outfitState = MaterialTheme.colorsExtended.primary.shady.asStateSimple
        },
        colorBackgroundHeader = MaterialTheme.colorsExtended.backgroundElevated.overlay,
        colorDivider = MaterialTheme.colorsExtended.backgroundElevated.fade,
        sizeDivider = MaterialTheme.dimensionsCommonExtended.divider.normal,
        styleRow = messageRowStyle()
    )

    @Composable
    fun messageRowStyle() = MessageRow.Style(
        colorBadge = MaterialTheme.colorsPalette.redBlood,
        styleIconAction = Icon.Simple.Style(
            size = MaterialTheme.dimensionsIconExtended.action.small,
            tint = MaterialTheme.colorsExtended.primary.accent
        ),
        outfitTextTitle = MaterialTheme.typographiesExtended.title.normal.copy {
            outfitState = MaterialTheme.colorsExtended.primary.default.asStateSimple
            typo = typo.copy(
                fontWeight = FontWeight.Normal
            )
        },
        outfitTextSubtitle = MaterialTheme.typographiesExtended.subtitle.normal.copy {
            outfitState = MaterialTheme.colorsExtended.primary.fade.asStateSimple
        },
    )

    @Composable
    fun sectionAccountValueSimpleRowStyle() = SectionAccountValueSimpleRow.Style(
        outfitTextTitle = MaterialTheme.typographiesExtended.label.big.copy {
            outfitState = MaterialTheme.colorsExtended.primary.shady.asStateSimple
        },
        styleIconInfo = Icon.StateColor.Style(
            size = MaterialTheme.dimensionsIconExtended.info.micro,
            tint = MaterialTheme.colorsExtended.background.default,
            outfitFrame = OutfitFrameStateColor(
                outfitShape = MaterialTheme.shapesExtended.icon.normal.copy {
                    outfitState = MaterialTheme.colorsExtended.primary.accent.asStateSimple
                }
            )
        ),
        colorBackgroundHeader = null,
        colorDivider = MaterialTheme.colorsExtended.backgroundElevated.fade,
        sizeDivider = MaterialTheme.dimensionsCommonExtended.divider.normal,
        styleRow = accountValueSimpleRowStyle()
    )

    @Composable
    fun accountValueSimpleRowStyle() = AccountValueSimpleRow.Style(
        styleIconInfo = Icon.StateColor.Style(
            size = MaterialTheme.dimensionsIconExtended.info.small,
            tint = MaterialTheme.colorsExtended.background.default,
            outfitFrame = OutfitFrameStateColor(
                outfitShape = MaterialTheme.shapesExtended.icon.normal
            )

        ),
        outfitTextTitle = MaterialTheme.typographiesExtended.body.small.copy {
            outfitState = MaterialTheme.colorsExtended.primary.default.asStateSimple
        },
        outfitTextSubTitle = MaterialTheme.typographiesExtended.label.normal.copy {
            outfitState = MaterialTheme.colorsExtended.primary.fade.asStateSimple
        },
        outfitTextAmount = MaterialTheme.typographiesExtended.body.normal.copy {
            outfitState = MaterialTheme.colorsExtended.primary.default.asStateSimple
        },
    )

    @Composable
    fun sectionTileStyle() = SectionSimpleTile.Style(
        styleIconInfo = Icon.Simple.Style(
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
        styleTile = tileStyle()
    )

    @Composable
    fun tileStyle() = SimpleTile.Style(
        outfitFrame = OutfitFrameStateColor(
            outfitShape = MaterialTheme.shapesExtended.element.normal.copy {
                outfitState = MaterialTheme.colorsExtended.backgroundElevated.default.asStateSimple
            }
        ),
        styleIconInfo = Icon.Simple.Style(
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
    fun pagerWidthIndicatorStyle() = HorizontalPager.WithIndicator.Style(
        outfitShapeIndicator = OutfitShapeStateColor(
            outfitState = OutfitStateBiStable(
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
            styleIconInfo = Icon.Simple.Style(
                size = MaterialTheme.dimensionsIconExtended.info.normal,
                tint = MaterialTheme.colorsExtended.primary.accent
            ),
            outfitTextTitle = MaterialTheme.typographiesExtended.title.huge.copy {
                outfitState = MaterialTheme.colorsExtended.primary.shady.asStateSimple
                typo = typo.copy(
                    fontWeight = FontWeight.Bold
                )
            },
            styleCarousel = pagerWidthIndicatorStyle().copy {
                paddingContent =
                    PaddingValues(horizontal = MaterialTheme.dimensionsPaddingExtended.page.normal.horizontal + MaterialTheme.dimensionsPaddingExtended.element.big.horizontal)
                spacingItem = MaterialTheme.dimensionsPaddingExtended.page.normal.horizontal
            },
            colorBackgroundHeader = null,
            styleCard = cardStyle,
        )

    @Composable
    fun carouselCardButtonStyle() = CarouselCard.Style.Button(
        baseStyle = CarouselCard.Style.Base(
            outfitFrame = OutfitFrameStateColor(
                outfitShape = MaterialTheme.shapesExtended.element.big.copy {
                    outfitState = MaterialTheme.colorsExtended.background.default.asStateSimple
                },
                outfitBorder = MaterialTheme.bordersExtended.element.normal.copy {
                    outfitState =
                        MaterialTheme.colorsExtended.backgroundElevated.decor.asStateSimple
                },
            ),
            styleIconInfo = Icon.Simple.Style(
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
        }
    )

    @Composable
    fun carouselCardLinkStyle() = CarouselCard.Style.Link(
        baseStyle = CarouselCard.Style.Base(
            outfitFrame = OutfitFrameStateColor(
                outfitShape = MaterialTheme.shapesExtended.element.big.copy {
                    outfitState =
                        MaterialTheme.colorsExtended.backgroundElevated.overlay.asStateSimple
                },
            ),
            styleIconInfo = Icon.Simple.Style(
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
    fun rollerStyle() = HorizontalRoller.Simple.Style()

    @Composable
    fun sectionRollerCardStyle() =
        SectionRollerCard.Style(
            styleIconInfo = Icon.Simple.Style(
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
            styleAction = MaterialTheme.componentsButtonExtended.primary.copy {
                outfitText = outfitText.copy {
                    outfitState = MaterialTheme.colorsExtended.primary.shiny.asStateSimple
                }
                outfitFrame = outfitFrame.copy {
                    outfitShape = outfitShape.copy {
                        outfitState = MaterialTheme.colorsExtended.primary.accent.asStateSimple
                    }
                }
            },
            styleRoller = rollerStyle().copy {
                paddingContent =
                    PaddingValues(horizontal = MaterialTheme.dimensionsPaddingExtended.page.normal.horizontal)
                spacingItem = MaterialTheme.dimensionsPaddingExtended.element.small.horizontal
            },
            styleCard = rollerCardStyle()
        )

    @Composable
    fun rollerCardStyle() = RollerCard.Style(
        outfitFrame = OutfitFrameStateColor(
            outfitShape = MaterialTheme.shapesExtended.element.small,
            outfitBorder = MaterialTheme.bordersExtended.element.normal.copy {
                outfitState = MaterialTheme.colorsExtended.primary.fade.asStateSimple
            },
        ),
        styleImage = Image.Simple.Style(
            size = 96.dpSize,
            contentScale = ContentScale.FillBounds
        ),
        outfitTextTitle = MaterialTheme.typographiesExtended.body.small.copy {
            outfitState = MaterialTheme.colorsExtended.primary.default.asStateSimple
        },
    )

}