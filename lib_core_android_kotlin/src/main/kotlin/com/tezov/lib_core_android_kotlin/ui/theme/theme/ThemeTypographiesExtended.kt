/*
 *  *********************************************************************************
 *  Created by Tezov on 08/04/2023 14:32
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/04/2023 13:01
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
import androidx.compose.ui.unit.sp
import com.tezov.lib_core_android_kotlin.ui.component.plain.Button
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPaletteSize
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.StateColor.Style.Companion.asPaletteSize
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.StateColor.Style.Companion.asTextStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextStateColor
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack


val MaterialTheme.typographiesCommonExtended
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
    ) : DelegateNullFallBack.Group<OutfitPaletteSize<OutfitTextStateColor>> {

        val title: OutfitPaletteSize<OutfitTextStateColor> by DelegateNullFallBack(title)
        val body: OutfitPaletteSize<OutfitTextStateColor> by DelegateNullFallBack(body)
        val subtitle: OutfitPaletteSize<OutfitTextStateColor> by DelegateNullFallBack(subtitle)
        val helper: OutfitPaletteSize<OutfitTextStateColor> by DelegateNullFallBack(helper)
        val button: OutfitPaletteSize<OutfitTextStateColor> by DelegateNullFallBack(button)
        val link: OutfitPaletteSize<OutfitTextStateColor> by DelegateNullFallBack(link)
        val input: OutfitPaletteSize<OutfitTextStateColor> by DelegateNullFallBack(input)
        val label: OutfitPaletteSize<OutfitTextStateColor> by DelegateNullFallBack(label)
        val caption: OutfitPaletteSize<OutfitTextStateColor> by DelegateNullFallBack(caption)

        override fun groupFallBackRefs() =
            listOf(title, body, subtitle, helper, button, link, input, label, caption)

        init {
            groupLazyFallBackValue = {
                TextStyle(
                    color = Color.Black,
                    fontSize = 14.sp
                ).asTextStateColor.asPaletteSize
            }
        }

    }

    internal val localCommon: ProvidableCompositionLocal<Common> = staticCompositionLocalOf {
        error("not provided")
    }



}