/*
 *  *********************************************************************************
 *  Created by Tezov on 08/04/2023 21:07
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/04/2023 21:05
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
    ) : DelegateNullFallBack.Group<OutfitPaletteSize<Dp>> {

        val divider: OutfitPaletteSize<Dp> by DelegateNullFallBack(divider)
        val elevation: OutfitPaletteSize<Dp> by DelegateNullFallBack(elevation)

        override fun groupFallBackRefs() = listOf(divider, elevation)

        init {
            groupLazyFallBackValue = { 2.dp.asPaletteSize }
        }
    }

    internal val localCommon: ProvidableCompositionLocal<Common> = staticCompositionLocalOf {
        error("not provided")
    }

    class Paddings(
        page: OutfitPaletteDirection<OutfitPaletteSize<Dp>>? = null,
        cluster: OutfitPaletteDirection<OutfitPaletteSize<Dp>>? = null,
        block: OutfitPaletteDirection<OutfitPaletteSize<Dp>>? = null,
        chunk: OutfitPaletteDirection<OutfitPaletteSize<Dp>>? = null,
        button: OutfitPaletteDirection<OutfitPaletteSize<Dp>>? = null,
        icon: OutfitPaletteDirection<OutfitPaletteSize<Dp>>? = null,
        text: OutfitPaletteDirection<OutfitPaletteSize<Dp>>? = null,
    ) : DelegateNullFallBack.Group<OutfitPaletteDirection<OutfitPaletteSize<Dp>>> {

        val page: OutfitPaletteDirection<OutfitPaletteSize<Dp>> by DelegateNullFallBack(page)
        val cluster: OutfitPaletteDirection<OutfitPaletteSize<Dp>> by DelegateNullFallBack(cluster)
        val block: OutfitPaletteDirection<OutfitPaletteSize<Dp>> by DelegateNullFallBack(block)
        val chunk: OutfitPaletteDirection<OutfitPaletteSize<Dp>> by DelegateNullFallBack(chunk)
        val button: OutfitPaletteDirection<OutfitPaletteSize<Dp>> by DelegateNullFallBack(button)
        val icon: OutfitPaletteDirection<OutfitPaletteSize<Dp>> by DelegateNullFallBack(icon)
        val text: OutfitPaletteDirection<OutfitPaletteSize<Dp>> by DelegateNullFallBack(text)

        override fun groupFallBackRefs() = listOf(page, cluster, block, chunk, button, icon, text)

        init {
            groupLazyFallBackValue = { 6.dp.asPaletteSize.asPaletteDirection }
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
    ) : DelegateNullFallBack.Group<OutfitPaletteSize<DpSize>> {

        val modal: OutfitPaletteSize<DpSize> by DelegateNullFallBack(modal)
        val info: OutfitPaletteSize<DpSize> by DelegateNullFallBack(info)
        val action: OutfitPaletteSize<DpSize> by DelegateNullFallBack(action)
        val fieldInfo: OutfitPaletteSize<DpSize> by DelegateNullFallBack(fieldInfo)
        val fieldAction: OutfitPaletteSize<DpSize> by DelegateNullFallBack(fieldAction)

        override fun groupFallBackRefs() = listOf(modal, info, action, fieldInfo, fieldAction)

        init {
            groupLazyFallBackValue = { 24.dpSize.asPaletteSize }
        }
    }

    internal val localIcons: ProvidableCompositionLocal<Icons> = staticCompositionLocalOf {
        error("not provided")
    }

}


