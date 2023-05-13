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