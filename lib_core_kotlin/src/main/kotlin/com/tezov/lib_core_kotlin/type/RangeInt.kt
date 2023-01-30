/*
 *  *********************************************************************************
 *  Created by Tezov on 30/01/2023 20:18
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 30/01/2023 20:11
 *  First project bank / bank.lib_core_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_kotlin.type

import java.text.DecimalFormatSymbols

class RangeInt(
    var min: Int?,
    val max: Int?,
    val isMinIncluded: Boolean = min != null,
    val isMaxIncluded: Boolean = max != null
) {

    fun isInside(value: Int): Boolean {
        val minCheck =
            min == null || isMinIncluded && min!! <= value || !isMinIncluded && min!! < value
        val maxCheck = max == null || isMaxIncluded && max >= value || !isMaxIncluded && max > value
        return minCheck && maxCheck
    }

    fun length(): Int {
        var length = max!! - min!! + 1
        if (!isMinIncluded) {
            length -= 1
        }
        if (!isMaxIncluded && length > 0) {
            length -= 1
        }
        return length
    }

    override fun equals(other: Any?): Boolean {
        return takeIf { other is RangeInt }?.let { it ->
            min == it.min && max == it.max && isMinIncluded == it.isMinIncluded && isMaxIncluded == it.isMaxIncluded
        } ?: false
    }

    override fun toString(): String {
        val infinity = DecimalFormatSymbols.getInstance().infinity
        return (if (isMinIncluded) "[" else "]") + (min ?: infinity) + "," + (max
            ?: infinity) + if (isMaxIncluded) "]" else "["
    }


}