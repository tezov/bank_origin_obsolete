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

package com.tezov.lib_core_android_kotlin.ui.theme.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPaletteSize
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.StateColor.Style.Companion.asPaletteSize
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.StateColor.Style.Companion.asTextStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextStateColor
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack

val MaterialTheme.typographiesExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeTypographiesExtended.localCommon.current

infix fun MaterialTheme.provides(value: ThemeTypographiesExtended.Common) =
    ThemeTypographiesExtended.localCommon provides value

object ThemeTypographiesExtended {

    class Common(
        title: OutfitPaletteSize<OutfitTextStateColor>? = null,
        body: OutfitPaletteSize<OutfitTextStateColor>? = null,
        subtitle: OutfitPaletteSize<OutfitTextStateColor>? = null,
        helper: OutfitPaletteSize<OutfitTextStateColor>? = null,
        button: OutfitPaletteSize<OutfitTextStateColor>? = null,
        link: OutfitPaletteSize<OutfitTextStateColor>? = null,
        input: OutfitPaletteSize<OutfitTextStateColor>? = null,
        label: OutfitPaletteSize<OutfitTextStateColor>? = null,
        caption: OutfitPaletteSize<OutfitTextStateColor>? = null,
        menu: OutfitPaletteSize<OutfitTextStateColor>? = null,
    ) {

        private val delegates =
            DelegateNullFallBack.Group<OutfitPaletteSize<OutfitTextStateColor>>()
        val title: OutfitPaletteSize<OutfitTextStateColor> by delegates.ref(title)
        val body: OutfitPaletteSize<OutfitTextStateColor> by delegates.ref(body)
        val subtitle: OutfitPaletteSize<OutfitTextStateColor> by delegates.ref(subtitle)
        val helper: OutfitPaletteSize<OutfitTextStateColor> by delegates.ref(helper)
        val button: OutfitPaletteSize<OutfitTextStateColor> by delegates.ref(button)
        val link: OutfitPaletteSize<OutfitTextStateColor> by delegates.ref(link)
        val input: OutfitPaletteSize<OutfitTextStateColor> by delegates.ref(input)
        val label: OutfitPaletteSize<OutfitTextStateColor> by delegates.ref(label)
        val caption: OutfitPaletteSize<OutfitTextStateColor> by delegates.ref(caption)
        val menu: OutfitPaletteSize<OutfitTextStateColor> by delegates.ref(menu)

        init {
            delegates.fallBackValue = {
                ThemeColorsExtended.Dummy.outfitTextState.asPaletteSize
            }
        }

    }

    internal val localCommon: ProvidableCompositionLocal<Common> = staticCompositionLocalOf {
        error("not provided")
    }


}