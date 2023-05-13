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

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp

object ExtensionDensity {

    inline val Dp.toPx @Composable get() = this.toPx(LocalDensity.current.density)
    fun Dp.toPx(density: Float) = value * density

    val Int.toDp @Composable get() = this.toDp(LocalDensity.current.density)
    fun Int.toDp(density: Float) = Dp((this / density))

    val Float.toDp @Composable get() = this.toDp(LocalDensity.current.density)
    fun Float.toDp(density: Float) = Dp((this / density))

    @Composable
    fun CornerSize.toPx(size: Size) = this.toPx(size, LocalDensity.current)

}