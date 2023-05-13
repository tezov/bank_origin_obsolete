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

package com.tezov.lib_core_android_kotlin.ui.extension

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection

object ExtensionPadding {

    inline val PaddingValues.start @Composable get() = this.start(LocalLayoutDirection.current)
    fun PaddingValues.start(layoutDirection: LayoutDirection) = calculateStartPadding(layoutDirection)

    inline val PaddingValues.end @Composable get() = this.end(LocalLayoutDirection.current)
    fun PaddingValues.end(layoutDirection: LayoutDirection) = calculateStartPadding(layoutDirection)

    inline val PaddingValues.top @Composable get() = this.top(LocalLayoutDirection.current)
    fun PaddingValues.top(layoutDirection: LayoutDirection) = calculateStartPadding(layoutDirection)

    inline val PaddingValues.bottom @Composable get() = this.bottom(LocalLayoutDirection.current)
    fun PaddingValues.bottom(layoutDirection: LayoutDirection) = calculateStartPadding(layoutDirection)

}