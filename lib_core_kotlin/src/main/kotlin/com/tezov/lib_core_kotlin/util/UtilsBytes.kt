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

package com.tezov.lib_core_kotlin.util

import com.tezov.lib_core_java.type.unit.UnitByte
import com.tezov.lib_core_kotlin.cipher.SecureProvider.randomGenerator

@OptIn(ExperimentalUnsignedTypes::class)
object UtilsBytes {

    fun reverse(bytes: UByteArray): UByteArray {
        var i = 0
        var j = bytes.size - 1
        var tmp: UByte
        while (j > i) {
            tmp = bytes[j]
            bytes[j] = bytes[i]
            bytes[i] = tmp
            j--
            i++
        }
        return bytes
    }

    fun removeLeadingZero(bytes: UByteArray): UByteArray {
        var countZero = 0
        for (b in bytes) {
            if (b != 0x00.toUByte()) {
                break
            }
            countZero++
        }
        val length = bytes.size - countZero
        if (length == 0) {
            return ubyteArrayOf(0x00.toUByte())
        }
        val out = UByteArray(length)
        copy(bytes, countZero, out, 0, length)
        return out
    }

    fun copyAndRepeat(src: UByteArray, dest: UByteArray, destOffset: Int = 0) {
        val end = dest.size
        var i = destOffset
        while (i < end) {
            dest[i] = src[i % src.size]
            i++
        }
    }

    fun copy(source: UByteArray, from: Int, to: Int): UByteArray {
        val range = UByteArray(to - from)
        copy(source, from, range, 0, range.size)
        return range
    }

    fun copy(src: UByteArray, dest: UByteArray) {
        copy(src, 0, dest, 0, src.size)
    }

    fun copy(src: UByteArray, dest: UByteArray, destOffset: Int) {
        copy(src, 0, dest, destOffset, src.size)
    }

    fun copy(src: UByteArray, srcOffset: Int, dest: UByteArray, destOffset: Int, length: Int) {
        System.arraycopy(src.asByteArray(), srcOffset, dest.asByteArray(), destOffset, length)
    }

    fun random(length: Int): UByteArray? {
        return try {
            val sr = randomGenerator()
            val bytes = UByteArray(length)
            sr.nextBytes(bytes.asByteArray())
            bytes
        } catch (e: Throwable) {
            null
        }
    }

    fun random(): UByte? {
        return try {
            val sr = randomGenerator()
            val bytes = ByteArray(1)
            sr.nextBytes(bytes)
            bytes[0].toUByte()
        } catch (e: Throwable) {
            null
        }
    }

    fun UByteArray.xor(alter: UByte): UByteArray {
        for (i in this.indices) {
            this[i] = (this[i] xor alter)
        }
        return this
    }

    fun UByteArray.xor(alter: UByteArray): UByteArray {
        for (i in this.indices) {
            this[i] = (this[i] xor alter[i % alter.size])
        }
        return this
    }

    private val MAX_BYTES_ARRAY_SIZE = UnitByte.o.convert(20f, UnitByte.Mo)

    fun obtain(length: Int): UByteArray {
        if (length > MAX_BYTES_ARRAY_SIZE) {
            return UByteArray(0)
        }
        return UByteArray(length)
    }

}