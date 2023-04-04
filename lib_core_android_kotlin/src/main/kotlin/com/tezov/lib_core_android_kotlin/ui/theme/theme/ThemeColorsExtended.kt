/*
 *  *********************************************************************************
 *  Created by Tezov on 04/04/2023 13:51
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 04/04/2023 13:03
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

val MaterialTheme.colorsCommonExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeColorsExtended.localCommon.current

infix fun MaterialTheme.provides(value: ThemeColorsExtended.Common) =
    ThemeColorsExtended.localCommon provides value

val MaterialTheme.colorsButtonExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeColorsExtended.localButtons.current

infix fun MaterialTheme.provides(value: ThemeColorsExtended.Buttons) =
    ThemeColorsExtended.localButtons provides value

val MaterialTheme.colorsLinkExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeColorsExtended.localLinks.current

infix fun MaterialTheme.provides(value: ThemeColorsExtended.Links) =
    ThemeColorsExtended.localLinks provides value


object ThemeColorsExtended {

    class Common(
        val background: OutfitPaletteColor,
        val onBackground: OutfitPaletteColor,

        val primary: OutfitPaletteColor,
        val onPrimary: OutfitPaletteColor,

        backgroundElevated: OutfitPaletteColor? = null,
        onBackgroundElevated: OutfitPaletteColor? = null,

        backgroundModal: OutfitPaletteColor? = null,
        onBackgroundModal: OutfitPaletteColor? = null,

        secondary: OutfitPaletteColor? = null,
        onSecondary: OutfitPaletteColor? = null,

        tertiary: OutfitPaletteColor? = null,
        onTertiary: OutfitPaletteColor? = null,

        semantic: OutfitPaletteColorSemantic? = null,
        onSemantic: OutfitPaletteColorSemantic? = null,

    ){

        val backgroundElevated: OutfitPaletteColor by DelegateNullFallBack(backgroundElevated, background)
        val onBackgroundElevated: OutfitPaletteColor by DelegateNullFallBack(onBackgroundElevated, onBackground)

        val backgroundModal: OutfitPaletteColor by DelegateNullFallBack(backgroundModal, background)
        val onBackgroundModal: OutfitPaletteColor by DelegateNullFallBack(onBackgroundModal, onBackground)

        val secondary: OutfitPaletteColor by DelegateNullFallBack(secondary, primary)
        val onSecondary: OutfitPaletteColor by DelegateNullFallBack(onSecondary, onPrimary)
        val tertiary: OutfitPaletteColor by DelegateNullFallBack(tertiary, primary)
        val onTertiary: OutfitPaletteColor by DelegateNullFallBack(onTertiary, onPrimary)

        val semantic: OutfitPaletteColorSemantic by DelegateNullFallBack(semantic, OutfitPaletteColorSemantic(primary))
        val onSemantic: OutfitPaletteColorSemantic by DelegateNullFallBack(onSemantic, OutfitPaletteColorSemantic(onPrimary))

    }

    internal val localCommon: ProvidableCompositionLocal<Common> = staticCompositionLocalOf {
        error("not provided")
    }

    class Buttons(
        val primary: ButtonNucleus,
        secondary: ButtonNucleus? = null,
        tertiary: ButtonNucleus? = null,
        confirm: ButtonNucleus? = null,
        cancel: ButtonNucleus? = null,
        proceed: ButtonNucleus? = null,
    ) : DelegateNullFallBack.Group<ButtonNucleus> {

        val secondary: ButtonNucleus by DelegateNullFallBack(secondary)
        val tertiary: ButtonNucleus by DelegateNullFallBack(tertiary)
        val confirm: ButtonNucleus by DelegateNullFallBack(confirm)
        val cancel: ButtonNucleus by DelegateNullFallBack(cancel)
        val proceed: ButtonNucleus by DelegateNullFallBack(proceed)

        override fun groupFallBackRefs() = listOf(secondary, tertiary, confirm, cancel, proceed)

        init {
            groupFallBackValue = primary
        }
    }

    internal val localButtons: ProvidableCompositionLocal<Buttons> = staticCompositionLocalOf {
        error("not provided")
    }

    class Links(
        val primary: LinkNucleus,
        secondary: LinkNucleus? = null,
        tertiary: LinkNucleus? = null,
    ) : DelegateNullFallBack.Group<LinkNucleus> {

        val secondary: LinkNucleus by DelegateNullFallBack(secondary)
        val tertiary: LinkNucleus by DelegateNullFallBack(tertiary)

        override fun groupFallBackRefs() = listOf(secondary, tertiary)

        init {
            groupFallBackValue = primary
        }
    }

    internal val localLinks: ProvidableCompositionLocal<Links> = staticCompositionLocalOf {
        error("not provided")
    }

}




