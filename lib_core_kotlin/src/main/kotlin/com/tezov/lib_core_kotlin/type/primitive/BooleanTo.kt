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

@OptIn(ExperimentalUnsignedTypes::class)
object BooleanTo {

    fun Boolean.toByte() = if (this) 1.toByte() else 0.toByte()
    fun Boolean?.toByte() = this?.toByte()

    fun Boolean.toUByte() = if (this) 1.toUByte() else 0.toUByte()
    fun Boolean?.toUByte() = this?.toUByte()

    fun Boolean.toUByteArray() = ubyteArrayOf(this.toUByte())
    fun Boolean?.toUByteArray() = this?.toUByteArray()
}