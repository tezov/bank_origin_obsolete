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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.type.primaire.DpSize
import com.tezov.lib_core_android_kotlin.type.primaire.dpSize
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPalette.Direction.Style.Companion.asPaletteDirection
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPalette.Size.Style.Companion.asPaletteSize
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPaletteDirection
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitPaletteSize
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack

val MaterialTheme.dimensionsCommonExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeDimensionsExtended.localCommon.current

infix fun MaterialTheme.provides(value: ThemeDimensionsExtended.Common) =
    ThemeDimensionsExtended.localCommon provides value

val MaterialTheme.dimensionsPaddingExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeDimensionsExtended.localPaddings.current

infix fun MaterialTheme.provides(value: ThemeDimensionsExtended.Paddings) =
    ThemeDimensionsExtended.localPaddings provides value

val MaterialTheme.dimensionsIconExtended
    @Composable
    @ReadOnlyComposable
    get() = ThemeDimensionsExtended.localIcons.current

infix fun MaterialTheme.provides(value: ThemeDimensionsExtended.Icons) =
    ThemeDimensionsExtended.localIcons provides value

object ThemeDimensionsExtended {

    class Common(
        divider: OutfitPaletteSize<Dp>? = null,
        elevation: OutfitPaletteSize<Dp>? = null,
    ) {

        private val delegates = DelegateNullFallBack.Group<OutfitPaletteSize<Dp>>()
        val divider: OutfitPaletteSize<Dp> by delegates.ref(divider)
        val elevation: OutfitPaletteSize<Dp> by delegates.ref(elevation)

        init {
            delegates.fallBackValue = { 2.dp.asPaletteSize }
        }
    }

    internal val localCommon: ProvidableCompositionLocal<Common> = staticCompositionLocalOf {
        error("not provided")
    }

    class Paddings(
        page: OutfitPaletteSize<OutfitPaletteDirection<Dp>>? = null,
        cluster: OutfitPaletteSize<OutfitPaletteDirection<Dp>>? = null,
        block: OutfitPaletteSize<OutfitPaletteDirection<Dp>>? = null,
        element: OutfitPaletteSize<OutfitPaletteDirection<Dp>>? = null,
        chunk: OutfitPaletteSize<OutfitPaletteDirection<Dp>>? = null,
        button: OutfitPaletteSize<OutfitPaletteDirection<Dp>>? = null,
        text: OutfitPaletteSize<OutfitPaletteDirection<Dp>>? = null,
    ) {

        private val delegates =
            DelegateNullFallBack.Group<OutfitPaletteSize<OutfitPaletteDirection<Dp>>>()
        val page: OutfitPaletteSize<OutfitPaletteDirection<Dp>> by delegates.ref(page)
        val cluster: OutfitPaletteSize<OutfitPaletteDirection<Dp>> by delegates.ref(cluster)
        val block: OutfitPaletteSize<OutfitPaletteDirection<Dp>> by delegates.ref(block)
        val element: OutfitPaletteSize<OutfitPaletteDirection<Dp>> by delegates.ref(element)
        val chunk: OutfitPaletteSize<OutfitPaletteDirection<Dp>> by delegates.ref(chunk)
        val button: OutfitPaletteSize<OutfitPaletteDirection<Dp>> by delegates.ref(button)
        val text: OutfitPaletteSize<OutfitPaletteDirection<Dp>> by delegates.ref(text)

        init {
            delegates.fallBackValue = { 6.dp.asPaletteDirection.asPaletteSize }
        }
    }

    internal val localPaddings: ProvidableCompositionLocal<Paddings> = staticCompositionLocalOf {
        error("not provided")
    }

    class Icons(
        modal: OutfitPaletteSize<DpSize>? = null,
        info: OutfitPaletteSize<DpSize>? = null,
        action: OutfitPaletteSize<DpSize>? = null,
        fieldInfo: OutfitPaletteSize<DpSize>? = null,
        fieldAction: OutfitPaletteSize<DpSize>? = null,
    ) {

        private val delegates = DelegateNullFallBack.Group<OutfitPaletteSize<DpSize>>()
        val modal: OutfitPaletteSize<DpSize> by delegates.ref(modal)
        val info: OutfitPaletteSize<DpSize> by delegates.ref(info)
        val action: OutfitPaletteSize<DpSize> by delegates.ref(action)
        val fieldInfo: OutfitPaletteSize<DpSize> by delegates.ref(fieldInfo)
        val fieldAction: OutfitPaletteSize<DpSize> by delegates.ref(fieldAction)

        init {
            delegates.fallBackValue = { 24.dpSize.asPaletteSize }
        }
    }

    internal val localIcons: ProvidableCompositionLocal<Icons> = staticCompositionLocalOf {
        error("not provided")
    }

}


