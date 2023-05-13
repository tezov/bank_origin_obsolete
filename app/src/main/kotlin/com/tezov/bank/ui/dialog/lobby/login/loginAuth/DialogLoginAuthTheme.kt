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

package com.tezov.bank.ui.dialog.lobby.login.loginAuth

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.tezov.bank.ui.theme.font.fontRoboto
import com.tezov.lib_core_android_kotlin.ui.component.block.KeyBoard
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Button
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Button.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Link
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Link.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitBorder.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitFrame.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitFrameStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState.Simple.Style.Companion.asStateSimple
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitStateBiStable
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.theme.*

val DialogLoginAuthTheme.colors: DialogLoginAuthTheme.Colors
    @Composable
    @ReadOnlyComposable
    get() = localColors.current

infix fun DialogLoginAuthTheme.provides(value: DialogLoginAuthTheme.Colors) =
    localColors provides value

val DialogLoginAuthTheme.typographies: DialogLoginAuthTheme.Typographies
    @Composable
    @ReadOnlyComposable
    get() = localTypographies.current

infix fun DialogLoginAuthTheme.provides(value: DialogLoginAuthTheme.Typographies) =
    localTypographies provides value

val DialogLoginAuthTheme.styles: DialogLoginAuthTheme.Style
    @Composable
    @ReadOnlyComposable
    get() = localStyles.current

infix fun DialogLoginAuthTheme.provides(value: DialogLoginAuthTheme.Style) =
    localStyles provides value

object DialogLoginAuthTheme {

    data class Colors(
        val background: Color,
        val onBackground: Color,
        val dark: Color,
        val light: Color,
        val fade: Color,
    )

    @Composable
    fun provideColors() = Colors(
        background = MaterialTheme.colorsExtended.background.dark,
        onBackground = MaterialTheme.colorsExtended.onBackground.dark,
        dark = MaterialTheme.colorsExtended.primary.shady,
        light = MaterialTheme.colorsExtended.primary.accent,
        fade = MaterialTheme.colorsExtended.primary.fade,
    )

    internal val localColors: ProvidableCompositionLocal<Colors> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Typographies(
        val title: OutfitTextStateColor,
        val input: OutfitTextStateColor,
        val label: OutfitTextStateColor,
    )

    @Composable
    fun provideTypographies() = Typographies(
        title = MaterialTheme.typographiesExtended.title.big.copy {
            outfitState = colors.onBackground.asStateSimple
            typo = typo.copy(textAlign = TextAlign.Center)
        },
        input = MaterialTheme.typographiesExtended.input.normal.copy {
            outfitState = colors.onBackground.asStateSimple
        },
        label = MaterialTheme.typographiesExtended.label.normal.copy {
            outfitState = colors.onBackground.asStateSimple
        }
    )

    internal val localTypographies: ProvidableCompositionLocal<Typographies> =
        staticCompositionLocalOf {
            error("not provided")
        }

    data class Style(
        val keyBoardGridCube: KeyBoard.GridCube.Style,
        val button: Button.StateColor.Style,
        val link: Link.StateColor.Style,
    )

    @Composable
    fun provideStyles() = Style(
        keyBoardGridCube = KeyBoard.GridCube.Style(
            outfitText = OutfitTextStateColor(
                typo = androidx.compose.ui.text.TextStyle(
                    fontFamily = MaterialTheme.fontRoboto,
                    fontWeight = FontWeight.SemiBold,
                ),
                outfitState = colors.onBackground.asStateSimple
            ),
            outfitFrameOuter = OutfitFrameStateColor(
                outfitBorder = MaterialTheme.bordersExtended.block.normal.copy {
                    outfitState = colors.onBackground.asStateSimple
                    size?.let {
                        size = (it.value * 0.65f).dp
                    }
                },
                outfitShape = MaterialTheme.shapesExtended.block.small.copy {
                    size?.firstNotNull?.let {
                        size = OutfitShape.Size(bottomStart = it, bottomEnd = it)
                    }
                }
            ),
            outfitBorderInner = MaterialTheme.bordersExtended.block.small.copy {
                outfitState = colors.onBackground.asStateSimple
            },
        ),
        button = MaterialTheme.componentsButtonExtended.primary.copy {
            outfitFrame = outfitFrame.copy {
                outfitShape = outfitShape.copy {
                    outfitState = OutfitStateBiStable(
                        active = colors.light,
                        inactive = colors.dark
                    )
                }
            }
            outfitText = outfitText.copy {
                outfitState = colors.onBackground.asStateSimple
            }
        },
        link = MaterialTheme.componentsLinkExtended.primary.copy {
            outfitText = outfitText.copy {
                outfitState = colors.onBackground.asStateSimple
            }
        }
    )

    internal val localStyles: ProvidableCompositionLocal<Style> = staticCompositionLocalOf {
        error("not provided")
    }


}