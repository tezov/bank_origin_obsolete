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

package com.tezov.lib_core_kotlin.extension

import java.util.*

object ExtensionNull {

    fun <T> MutableList<T>?.nullify() = if (this != null && this.isNotEmpty()) this else null
    fun <T> Collection<T>?.nullify() = if (this != null && this.isNotEmpty()) this else null

    fun String?.nullify() = if (this != null && this.isNotEmpty()) this else null
    fun String?.isNullOrEmpty() = this?.let { length <= 0 } ?: let { true }
    fun String?.isNotNullAndNotEmpty() = this?.let { length > 0 } ?: let { false }

    fun CharSequence?.isNullOrEmpty() = this?.let { length <= 0 } ?: let { true }
    fun CharSequence?.isNotNullAndNotEmpty() = this?.let { length > 0 } ?: let { false }

    fun ByteArray?.nullify() = this?.let {
        val byte = 0.toByte()
        Arrays.fill(this, byte)
    }

    fun ByteArray?.isNullOrEmpty() = this?.let { size <= 0 } ?: let { true }
    fun ByteArray?.isNotNullAndNotEmpty() = this?.let { size > 0 } ?: let { false }

    fun CharArray?.nullify() = this?.let {
        val char = 0.toChar()
        Arrays.fill(this, char)
    }

    fun CharArray?.isNullOrEmpty() = this?.let { size <= 0 } ?: let { true }
    fun CharArray?.isNotNullAndNotEmpty() = this?.let { size > 0 } ?: let { false }

}
