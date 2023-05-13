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

import com.tezov.lib_core_kotlin.type.primitive.string.StringHexTo

@OptIn(ExperimentalUnsignedTypes::class)
object ByteTo {
    var BYTES = 1
    var SIZE = java.lang.Byte.SIZE

    fun Byte.toBoolean() = this == 0x01.toByte()
    fun Byte?.toBoolean() = this?.toBoolean()

    fun UByte.toBoolean() = this == 0x01.toUByte()
    fun UByte?.toBoolean() = this?.toBoolean()

    fun UByte.toStringHex() = StringHexTo.decode(this)
    fun UByte?.toStringHex() = this?.toStringHex()
}