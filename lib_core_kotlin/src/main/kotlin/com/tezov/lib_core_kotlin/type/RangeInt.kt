package com.tezov.lib_core_kotlin.type

import java.text.DecimalFormatSymbols

class RangeInt(var min: Int?, val max: Int?, val isMinIncluded: Boolean = min != null, val isMaxIncluded: Boolean = max != null) {

    fun isInside(value: Int): Boolean {
        val minCheck = min == null || isMinIncluded && min!! <= value || !isMinIncluded && min!! < value
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
        }?:false
    }
    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun toString(): String {
        val infinity = DecimalFormatSymbols.getInstance().infinity
        return (if (isMinIncluded) "[" else "]") + (min ?: infinity) + "," + (max
            ?: infinity) + if (isMaxIncluded) "]" else "["
    }



}