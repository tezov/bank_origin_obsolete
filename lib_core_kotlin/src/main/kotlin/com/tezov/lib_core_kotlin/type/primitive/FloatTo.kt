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

package com.tezov.lib_core_kotlin.type.primitive

import com.tezov.lib_core_kotlin.type.primitive.BytesTo.toStringHex

@OptIn(ExperimentalUnsignedTypes::class)
object FloatTo {
    var BYTES = java.lang.Float.SIZE / ByteTo.SIZE
    var MAX_DIGIT_DECIMAL = 7

    fun Float.toUByteArray() = this.let {
        val intBits = it.toRawBits()
        ubyteArrayOf(
            (intBits shr 24).toUByte(),
            (intBits shr 16).toUByte(),
            (intBits shr 8).toUByte(),
            intBits.toUByte()
        )
    }

    fun Float?.toUByteArray() = this?.toUByteArray()

    fun Float.toStringHex() = this.toUByteArray().toStringHex()
    fun Float?.toStringHex() = this?.toStringHex()
}