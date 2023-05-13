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
object DoubleTo {
    var BYTES = java.lang.Double.SIZE / ByteTo.SIZE

    fun Double.toUByteArray() = this.let {
        val intBits = it.toRawBits()
        ubyteArrayOf(
            (intBits shr 56).toUByte(),
            (intBits shr 48).toUByte(),
            (intBits shr 40).toUByte(),
            (intBits shr 32).toUByte(),
            (intBits shr 24).toUByte(),
            (intBits shr 16).toUByte(),
            (intBits shr 8).toUByte(),
            intBits.toUByte()
        )
    }

    fun Double?.toUByteArray() = this?.toUByteArray()

    fun Double.toStringHex() = this.toUByteArray().toStringHex()
    fun Double?.toStringHex() = this?.toStringHex()


}