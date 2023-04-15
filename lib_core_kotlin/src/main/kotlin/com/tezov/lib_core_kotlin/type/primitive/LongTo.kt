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
object LongTo {
    var BYTES = java.lang.Long.SIZE / ByteTo.SIZE

    fun Long.toUByteArray() = ubyteArrayOf(
        (this shr 56).toUByte(),
        (this shr 48).toUByte(),
        (this shr 40).toUByte(),
        (this shr 32).toUByte(),
        (this shr 24).toUByte(),
        (this shr 16).toUByte(),
        (this shr 8).toUByte(),
        this.toUByte()
    )

    fun Long?.toUByteArray() = this?.toUByteArray()

    fun Long.toStringHex() = this.toUByteArray().toStringHex()
    fun Long?.toStringHex() = this?.toStringHex()

}