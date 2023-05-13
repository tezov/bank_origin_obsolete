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

package com.tezov.lib_core_kotlin.type.primitive.string

import android.util.Base64
import com.tezov.lib_core_kotlin.type.primitive.BytesTo.toStringChar

@OptIn(ExperimentalUnsignedTypes::class)
object StringBase64To {
    fun encode(b: UByteArray) = Base64.encodeToString(b.toByteArray(), Base64.DEFAULT)
    fun decode(s: String) = Base64.decode(s, Base64.DEFAULT).toUByteArray()

    fun String.toUByteArrayBase64() = decode(this)
    fun String?.toUByteArrayBase64() = this?.toUByteArrayBase64()

    fun String?.toStringChar() = this?.toUByteArrayBase64()?.toStringChar()
}