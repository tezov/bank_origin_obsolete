/*
 *  *********************************************************************************
 *  Created by Tezov on 15/04/2023 19:41
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 15/04/2023 18:52
 *  First project bank / bank.lib_core_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
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