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

package com.tezov.lib_core_kotlin.type.primitive

import com.tezov.lib_core_kotlin.type.primitive.BytesTo.toStringHex
import com.tezov.lib_core_kotlin.type.primitive.FloatTo.toUByteArray
import com.tezov.lib_core_kotlin.util.UtilsBytes
import kotlin.jvm.JvmOverloads
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