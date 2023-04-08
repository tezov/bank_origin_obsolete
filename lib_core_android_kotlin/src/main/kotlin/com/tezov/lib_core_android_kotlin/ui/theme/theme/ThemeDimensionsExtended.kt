/*
 *  *********************************************************************************
 *  Created by Tezov on 08/04/2023 22:36
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/04/2023 21:40
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
        page: OutfitPaletteSize<OutfitPaletteDirection<Dp>>? = null,
        cluster: OutfitPaletteSize<OutfitPaletteDirection<Dp>>? = null,
        block: OutfitPaletteSize<OutfitPaletteDirection<Dp>>? = null,
        chunk: OutfitPaletteSize<OutfitPaletteDirection<Dp>>? = null,
        button: OutfitPaletteSize<OutfitPaletteDirection<Dp>>? = null,
        icon: OutfitPaletteSize<OutfitPaletteDirection<Dp>>? = null,
        text: OutfitPaletteSize<OutfitPaletteDirection<Dp>>? = null,
    ) : DelegateNullFallBack.Group<OutfitPaletteSize<OutfitPaletteDirection<Dp>>> {

        val page: OutfitPaletteSize<OutfitPaletteDirection<Dp>> by DelegateNullFallBack(page)
        val cluster: OutfitPaletteSize<OutfitPaletteDirection<Dp>> by DelegateNullFallBack(cluster)
        val block: OutfitPaletteSize<OutfitPaletteDirection<Dp>> by DelegateNullFallBack(block)
        val chunk: OutfitPaletteSize<OutfitPaletteDirection<Dp>> by DelegateNullFallBack(chunk)
        val button: OutfitPaletteSize<OutfitPaletteDirection<Dp>> by DelegateNullFallBack(button)
        val icon: OutfitPaletteSize<OutfitPaletteDirection<Dp>> by DelegateNullFallBack(icon)
        val text: OutfitPaletteSize<OutfitPaletteDirection<Dp>> by DelegateNullFallBack(text)

        override fun groupFallBackRefs() = listOf(page, cluster, block, chunk, button, icon, text)

        init {
            groupLazyFallBackValue = { 6.dp.asPaletteDirection.asPaletteSize }
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


