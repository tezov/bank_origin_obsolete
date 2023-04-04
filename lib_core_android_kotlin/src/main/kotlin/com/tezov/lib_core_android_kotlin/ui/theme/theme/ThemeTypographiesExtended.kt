/*
 *  *********************************************************************************
 *  Created by Tezov on 04/04/2023 13:51
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 04/04/2023 13:51
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.tezov.lib_core_android_kotlin.ui.component.plain.Button.StateColor.Style.Nucleus.asButtonNucleus
import com.tezov.lib_core_android_kotlin.ui.component.plain.Link.StateColor.Style.Nucleus.asLinkNucleus
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPaletteSize
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.StateColor.Style.Companion.asPaletteSizeStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.StateColor.Style.Companion.asStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextStateColor
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack
import com.tezov.lib_core_android_kotlin.ui.component.plain.Button.StateColor.Style.Nucleus.Typography as ButtonNucleus
import com.tezov.lib_core_android_kotlin.ui.component.plain.Link.StateColor.Style.Nucleus.Typography as LinkNucleus

val MaterialTheme.typographiesTextExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeTypographiesExtended.localTexts.current

infix fun MaterialTheme.provides(value: ThemeTypographiesExtended.Texts) =
    ThemeTypographiesExtended.localTexts provides value

val MaterialTheme.typographiesButtonExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeTypographiesExtended.localButtons.current

infix fun MaterialTheme.provides(value: ThemeTypographiesExtended.Buttons) =
    ThemeTypographiesExtended.localButtons provides value

val MaterialTheme.typographiesLinkExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeTypographiesExtended.localLinks.current

infix fun MaterialTheme.provides(value: ThemeTypographiesExtended.Links) =
    ThemeTypographiesExtended.localLinks provides value


object ThemeTypographiesExtended {

    class Texts(
        title: OutfitPaletteSize<OutfitTextStateColor>? = null,
        body: OutfitPaletteSize<OutfitTextStateColor>? = null,
        subtitle: OutfitPaletteSize<OutfitTextStateColor>? = null,
        helper: OutfitPaletteSize<OutfitTextStateColor>? = null,
        fieldValue: OutfitTextStateColor? = null,
        fieldLabel: OutfitTextStateColor? = null,
    ) {
        private val default = TextStyle(
            color = Color.Black,
            fontSize = 14.sp
        )

        val title: OutfitPaletteSize<OutfitTextStateColor> by DelegateNullFallBack(
            title,
            default.asPaletteSizeStateColor
        )
        val body: OutfitPaletteSize<OutfitTextStateColor> by DelegateNullFallBack(
            body,
            default.asPaletteSizeStateColor
        )
        val subtitle: OutfitPaletteSize<OutfitTextStateColor> by DelegateNullFallBack(
            subtitle,
            default.asPaletteSizeStateColor
        )
        val helper: OutfitPaletteSize<OutfitTextStateColor> by DelegateNullFallBack(
            helper,
            default.asPaletteSizeStateColor
        )
        val fieldValue: OutfitTextStateColor by DelegateNullFallBack(
            fieldValue,
            default.asStateColor
        )
        val fieldLabel: OutfitTextStateColor by DelegateNullFallBack(
            fieldLabel,
            default.asStateColor
        )
    }

    internal val localTexts: ProvidableCompositionLocal<Texts> = staticCompositionLocalOf {
        error("not provided")
    }

    class Buttons(
        primary: ButtonNucleus? = null,
        secondary: ButtonNucleus? = null,
        tertiary: ButtonNucleus? = null,
        confirm: ButtonNucleus? = null,
        cancel: ButtonNucleus? = null,
        proceed: ButtonNucleus? = null,
    ) : DelegateNullFallBack.Group<ButtonNucleus> {

        val primary: ButtonNucleus by DelegateNullFallBack(primary)
        val secondary: ButtonNucleus by DelegateNullFallBack(secondary)
        val tertiary: ButtonNucleus by DelegateNullFallBack(tertiary)
        val confirm: ButtonNucleus by DelegateNullFallBack(confirm)
        val cancel: ButtonNucleus by DelegateNullFallBack(cancel)
        val proceed: ButtonNucleus by DelegateNullFallBack(proceed)

        override fun groupFallBackRefs() =
            listOf(primary, secondary, tertiary, confirm, cancel, proceed)

        init {
            groupFallBackValue = TextStyle(
                color = Color.Black,
                fontSize = 16.sp
            ).asButtonNucleus
        }
    }

    internal val localButtons: ProvidableCompositionLocal<Buttons> = staticCompositionLocalOf {
        error("not provided")
    }

    class Links(
        primary: LinkNucleus? = null,
        secondary: LinkNucleus? = null,
        tertiary: LinkNucleus? = null,
    ) : DelegateNullFallBack.Group<LinkNucleus> {

        val primary: LinkNucleus by DelegateNullFallBack(primary)
        val secondary: LinkNucleus by DelegateNullFallBack(secondary)
        val tertiary: LinkNucleus by DelegateNullFallBack(tertiary)

        override fun groupFallBackRefs() = listOf(primary, secondary, tertiary)

        init {
            groupFallBackValue = TextStyle(
                color = Color.Black,
                fontSize = 16.sp,
                textDecoration = TextDecoration.Underline,
            ).asLinkNucleus
        }
    }

    internal val localLinks: ProvidableCompositionLocal<Links> = staticCompositionLocalOf {
        error("not provided")
    }

}