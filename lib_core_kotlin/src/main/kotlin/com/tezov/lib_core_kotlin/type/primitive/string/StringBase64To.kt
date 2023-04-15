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