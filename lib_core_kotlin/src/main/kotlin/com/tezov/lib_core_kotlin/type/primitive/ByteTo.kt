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