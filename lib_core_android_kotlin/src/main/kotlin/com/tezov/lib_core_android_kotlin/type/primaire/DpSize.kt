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
package com.tezov.lib_core_android_kotlin.type.primaire

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_kotlin.type.primaire.Scale

fun Modifier.size(size: DpSize): Modifier {
    return if (size.width != 0.dp && size.height != 0.dp) {
        width(size.width).height(size.height)
    } else if (size.width != 0.dp) {
        width(size.width).aspectRatio(1.0f)
    } else {
        height(size.height).aspectRatio(1.0f)
    }
}

inline val Int.dpSize: DpSize get() = DpSize(this)
inline val Double.dpSize: DpSize get() = DpSize(this)

class DpSize constructor(var width: Dp = 0.dp, var height: Dp = 0.dp, var padding:PaddingValues? = null) {

    constructor(size: Dp) : this(size, size)
    constructor(size: Int) : this(size.dp, size.dp)
    constructor(size: Double) : this(size.dp, size.dp)

    fun swap() {
        height = width.also { width = height }
    }

    val ratio
        get() = if (width.value != 0f) {
            height.value / width.value
        } else {
            Float.NaN
        }

    fun scaleTo(s: Scale) {
        width *= s.w
        height *= s.h
    }

    fun scaleFrom(s: Scale) {
        width /= s.w
        height /= s.h
    }

}