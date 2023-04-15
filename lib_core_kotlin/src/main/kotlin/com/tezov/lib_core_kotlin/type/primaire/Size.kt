/*
 *  *********************************************************************************
 *  Created by Tezov on 15/04/2023 19:41
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 15/04/2023 18:51
 *  First project bank / bank.lib_core_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */
package com.tezov.lib_core_kotlin.type.primaire

class Size constructor(var width: Int = 0, var height: Int = 0) {

    fun swap() {
        val tmp = width
        width = height
        height = tmp
    }

    val ratio
        get() = if (width != 0) {
            height.toFloat() / width.toFloat()
        } else {
            Float.NaN
        }

    fun scaleTo(s: Scale) {
        width = (width * s.w).toInt()
        height = (height * s.h).toInt()
    }

    fun scaleFrom(s: Scale) {
        width = (width / s.w).toInt()
        height = (height / s.h).toInt()
    }

    companion object {
        fun wrap(size: android.util.Size?) = size?.let { Size(it.width, it.height) }
    }
}