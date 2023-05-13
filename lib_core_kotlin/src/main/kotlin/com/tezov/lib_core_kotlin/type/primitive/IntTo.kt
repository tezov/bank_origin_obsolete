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
import com.tezov.lib_core_kotlin.type.primitive.string.StringHexTo

@OptIn(ExperimentalUnsignedTypes::class)
object IntTo {
    var BYTES = Integer.SIZE / ByteTo.SIZE

    var MAX_DIGIT_POSITIVE = Integer.toString(Int.MAX_VALUE).length
    var MAX_DIGIT_NEGATIVE = Integer.toString(Int.MIN_VALUE).length - 1

    fun Int.toUByteArray() = ubyteArrayOf(
        (this shr 24).toUByte(),
        (this shr 16).toUByte(),
        (this shr 8).toUByte(),
        this.toUByte()
    )

    fun Int?.toUByteArray() = this?.toUByteArray()

    fun Int.toStringHex(addPrefix: Boolean = false) =
        if (!addPrefix) this.toUByteArray().toStringHex()
        else StringHexTo.HEX_PREFIX + this.toUByteArray().toStringHex()

    fun Int?.toStringHex(addPrefix: Boolean = false) = this?.toStringHex(addPrefix)

}