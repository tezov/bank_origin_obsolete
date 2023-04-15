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

object CharsTo {

    fun CharArray.toUByteArray() = this.let {
        val b = UByteArray(it.size * 2)
        for (i in b.indices step 2) {
            val code = it[i / 2].code
            b[i] = (code shr 8).toUByte()
            b[i + 1] = code.toUByte()
        }
        b
    }

    fun CharArray?.toUByteArray() = this?.toUByteArray()


}