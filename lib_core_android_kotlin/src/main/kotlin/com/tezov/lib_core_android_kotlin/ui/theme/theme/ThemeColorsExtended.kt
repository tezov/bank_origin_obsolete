/*
 *  *********************************************************************************
 *  Created by Tezov on 02/04/2023 16:46
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 02/04/2023 16:46
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.theme.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPaletteColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPaletteColorSemantic
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack
import com.tezov.lib_core_android_kotlin.ui.component.plain.Button.StateColor.Style.Nucleus.Color as ButtonNucleus
import com.tezov.lib_core_android_kotlin.ui.component.plain.Link.StateColor.Style.Nucleus.Color as LinkNucleus

val MaterialTheme.colorsExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeColorsExtended.localCommon.current

infix fun MaterialTheme.provides(value: ThemeColorsExtended.Common) =
    ThemeColorsExtended.localCommon provides value

val MaterialTheme.colorsButtonExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeColorsExtended.localButtons.current

infix fun MaterialTheme.provides(value: ThemeColorsExtended.Button) =
    ThemeColorsExtended.localButtons provides value

val MaterialTheme.colorsLinkExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeColorsExtended.localLinks.current

infix fun MaterialTheme.provides(value: ThemeColorsExtended.Link) =
    ThemeColorsExtended.localLinks provides value


object ThemeColorsExtended {

    data class Common(
        val background: OutfitPaletteColor,
        val onBackground: OutfitPaletteColor,

        val backgroundElevated: OutfitPaletteColor,
        val onBackgroundElevated: OutfitPaletteColor,

        val backgroundModal: OutfitPaletteColor,
        val onBackgroundModal: OutfitPaletteColor,

        val primary: OutfitPaletteColor,
        val onPrimary: OutfitPaletteColor,

        val secondary: OutfitPaletteColor,
        val onSecondary: OutfitPaletteColor,

        val tertiary: OutfitPaletteColor,
        val onTertiary: OutfitPaletteColor,

        val semantic: OutfitPaletteColorSemantic,
        val onSemantic: OutfitPaletteColorSemantic,

        )

    internal val localCommon: ProvidableCompositionLocal<Common> = staticCompositionLocalOf {
        error("not provided")
    }

    class Button(
        val primary: ButtonNucleus,
        secondary: ButtonNucleus? = null,
        tertiary: ButtonNucleus? = null,
        confirm: ButtonNucleus? = null,
        cancel: ButtonNucleus? = null,
        proceed: ButtonNucleus? = null,
    ) : DelegateNullFallBack.Setter<ButtonNucleus> {

        val secondary: ButtonNucleus by DelegateNullFallBack(secondary)
        val tertiary: ButtonNucleus by DelegateNullFallBack(tertiary)
        val confirm: ButtonNucleus by DelegateNullFallBack(confirm)
        val cancel: ButtonNucleus by DelegateNullFallBack(cancel)
        val proceed: ButtonNucleus by DelegateNullFallBack(proceed)

        override fun refs() = listOf(secondary, tertiary, confirm, cancel, proceed)

        init {
            nullFallback = { primary }
        }
    }

    internal val localButtons: ProvidableCompositionLocal<Button> = staticCompositionLocalOf {
        error("not provided")
    }

    class Link(
        val primary: LinkNucleus,
        secondary: LinkNucleus? = null,
        tertiary: LinkNucleus? = null,
    ) : DelegateNullFallBack.Setter<LinkNucleus> {

        val secondary: LinkNucleus by DelegateNullFallBack(secondary)
        val tertiary: LinkNucleus by DelegateNullFallBack(tertiary)

        override fun refs() = listOf(secondary, tertiary)

        init {
            nullFallback = { primary }
        }
    }

    internal val localLinks: ProvidableCompositionLocal<Link> = staticCompositionLocalOf {
        error("not provided")
    }

}




