/*
 *  *********************************************************************************
 *  Created by Tezov on 28/03/2023 23:25
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 28/03/2023 22:50
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */
package com.tezov.lib_core_android_kotlin.type.primaire

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_kotlin.type.primaire.Scale

fun Modifier.size(size: SizeDp):Modifier {
    return if(size.width != 0.dp && size.height != 0.dp){
        width(size.width).height(size.height)
    }
    else if(size.width != 0.dp){
        width(size.width).aspectRatio(1.0f)
    }
    else{
        height(size.height).aspectRatio(1.0f)
    }
}

inline val Int.sizeDp: SizeDp get() = SizeDp(this)
inline val Double.sizeDp: SizeDp get() = SizeDp(this)

class SizeDp constructor(var width: Dp = 0.dp, var height: Dp = 0.dp) {

    constructor(size:Dp):this(size, size)
    constructor(size:Int):this(size.dp, size.dp)
    constructor(size:Double):this(size.dp, size.dp)

    fun swap() {
        val tmp = width
        width = height
        height = tmp
    }

    val ratio get() = if (width.value != 0f) {
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