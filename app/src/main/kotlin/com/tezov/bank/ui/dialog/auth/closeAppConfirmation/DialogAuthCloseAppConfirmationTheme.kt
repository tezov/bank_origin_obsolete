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

package com.tezov.bank.ui.dialog.auth.closeAppConfirmation

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.tezov.lib_core_android_kotlin.ui.component.chunk.Link
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState.Simple.Style.Companion.asStateSimple
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.theme.colorsExtended
import com.tezov.lib_core_android_kotlin.ui.theme.theme.typographiesExtended

val DialogAuthCloseAppConfirmationTheme.colors: DialogAuthCloseAppConfirmationTheme.Colors
    @Composable
    @ReadOnlyComposable
    get() = localColors.current

infix fun DialogAuthCloseAppConfirmationTheme.provides(value: DialogAuthCloseAppConfirmationTheme.Colors) =
    localColors provides value

val DialogAuthCloseAppConfirmationTheme.typographies: DialogAuthCloseAppConfirmationTheme.Typographies
    @Composable
    @ReadOnlyComposable
    get() = localTypographies.current

infix fun DialogAuthCloseAppConfirmationTheme.provides(value: DialogAuthCloseAppConfirmationTheme.Typographies) =
    localTypographies provides value

val DialogAuthCloseAppConfirmationTheme.styles: DialogAuthCloseAppConfirmationTheme.Style
    @Composable
    @ReadOnlyComposable
    get() = localStyles.current

infix fun DialogAuthCloseAppConfirmationTheme.provides(value: DialogAuthCloseAppConfirmationTheme.Style) =
    localStyles provides value

object DialogAuthCloseAppConfirmationTheme {

    data class Colors(
        val onBackground: Color,
        val light: Color,
        val accent: Color,
    )

    @Composable
    fun provideColors() = Colors(
        onBackground = MaterialTheme.colorsExtended.onBackgroundElevated.default,
        light = MaterialTheme.colorsExtended.primary.default,
        accent = MaterialTheme.colorsExtended.primary.accent,
    )

    internal val localColors: ProvidableCompositionLocal<Colors> = staticCompositionLocalOf {
        error("not provided")
    }

    data class Typographies(
        val title: OutfitTextStateColor,
        val body: OutfitTextStateColor,
    )

    @Composable
    fun provideTypographies() = Typographies(
        title = MaterialTheme.typographiesExtended.title.big.copy {
            outfitState = colors.accent.asStateSimple
        },
        body = MaterialTheme.typographiesExtended.body.normal.copy {
            outfitState = colors.onBackground.asStateSimple
        },
    )

    internal val localTypographies: ProvidableCompositionLocal<Typographies> =
        staticCompositionLocalOf {
            error("not provided")
        }

    data class Style(
        val linkConfirm: Link.StateColor.Style,
        val linkCancel: Link.StateColor.Style,
    )

    @Composable
    fun provideStyles() = Style(
        linkConfirm = Link.StateColor.Style(
            outfitText = MaterialTheme.typographiesExtended.button.normal.copy {
                outfitState = colors.accent.asStateSimple
            }
        ),
        linkCancel = Link.StateColor.Style(
            outfitText = MaterialTheme.typographiesExtended.button.normal.copy {
                outfitState = colors.light.asStateSimple
            }
        ),
    )

    internal val localStyles: ProvidableCompositionLocal<Style> = staticCompositionLocalOf {
        error("not provided")
    }

}