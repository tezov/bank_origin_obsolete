/*
 *  *********************************************************************************
 *  Created by Tezov on 15/04/2023 19:41
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 15/04/2023 18:51
 *  First project bank / bank.lib_core_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_kotlin.type.primitive.string

import com.tezov.lib_core_kotlin.type.primitive.BytesTo.complement
import com.tezov.lib_core_kotlin.type.primitive.BytesTo.toStringBase49
import com.tezov.lib_core_kotlin.type.primitive.BytesTo.toStringBase58
import com.tezov.lib_core_kotlin.type.primitive.BytesTo.toStringBase64
import com.tezov.lib_core_kotlin.type.primitive.BytesTo.toStringHex
import com.tezov.lib_core_kotlin.type.primitive.LongTo.toStringHex
import com.tezov.lib_core_kotlin.type.primitive.LongTo.toUByteArray
import java.nio.charset.StandardCharsets

@OptIn(ExperimentalUnsignedTypes::class)
object StringCharTo {

    private const val PRIME = 1125899906842597L
    fun encode(s: String) = s.toByteArray(StandardCharsets.UTF_8).asUByteArray()
    fun decode(bytes: UByteArray) = String(bytes.asByteArray(), StandardCharsets.UTF_8)

    fun String.toHashcode64Long(): Long {
        var h = PRIME
        for (c in this) {
            h = 31 * h + c.code
        }
        return h
    }

    fun String.toHashcode64UByteArray() = this.toHashcode64Long().toUByteArray()
    fun String.toHashcode64UByte() = this.toHashcode64Long().toUByte()
    fun String.toHashcode64StringHex() = this.toHashcode64Long().toStringHex()

    fun String.toUByteArrayChar() = encode(this)
    fun String?.toUByteArrayChar() = this?.toUByteArrayChar()

    fun String?.toStringHex() = this?.toUByteArrayChar()?.toStringHex()
    fun String?.toStringBase64() = this?.toUByteArrayChar()?.toStringBase64()
    fun String?.toStringBase58() = this?.toUByteArrayChar()?.toStringBase58()
    fun String?.toStringBase49() = this?.toUByteArrayChar()?.toStringBase49()

    fun String?.complement() = this?.toUByteArrayChar()?.complement()?.toStringHex()


}