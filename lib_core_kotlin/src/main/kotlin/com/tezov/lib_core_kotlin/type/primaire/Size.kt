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