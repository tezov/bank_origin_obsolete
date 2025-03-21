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

import com.tezov.lib_core_kotlin.application.AppRandomNumber.nextInt
import com.tezov.lib_core_kotlin.file.UtilsStream
import com.tezov.lib_core_kotlin.type.RangeInt
import com.tezov.lib_core_kotlin.type.primitive.string.StringCharTo.toUByteArrayChar
import java.io.ByteArrayOutputStream

object UtilsUnicode {
    class Latin {
        var length: Int = 0
        val ranges: MutableList<RangeInt>

        init {
            ranges = ArrayList<RangeInt>().apply {
                add(RangeInt(0x0020, 0x007E)) //ASCII
                add(RangeInt(0x00A0, 0x00FF)) //supplement
                add(RangeInt(0x0100, 0x0148)) //extended-A1
                add(RangeInt(0x0149, 0x017F)) //extended-A2
                add(RangeInt(0x0180, 0x024F)) //extended-B
                add(RangeInt(0x1E02, 0x1EF3)) //additional
                add(RangeInt(0x0259, 0x0259)) //IPA extension
                add(RangeInt(0x027C, 0x027C)) //IPA extension
                add(RangeInt(0x0292, 0x0292)) //IPA extension
                add(RangeInt(0x02B0, 0x02FF)) //Spacing modifier
            }
            for (r in ranges) {
                length += r.length()
            }
        }

        private fun codeAt(length: Int): Int {
            var value = length
            var charCode = 0
            for (r in ranges) {
                if (value < r.length()) {
                    charCode = r.min!! + value
                    break
                }
                value -= r.length()
            }
            return charCode
        }

        private fun randomCode(): Int {
            return codeAt(nextInt(length))
        }

        fun randomChar() = randomCode().toChar()
        fun randomString() = randomChar().toString()
        fun randomUByteArray() = randomString().toUByteArrayChar()

        fun randomUByteArray(length: Int): UByteArray {
            var output: ByteArrayOutputStream? = null
            return try {
                output = ByteArrayOutputStream()
                for (i in 0 until length) {
                    output.write(randomUByteArray().asByteArray())
                }
                val array = output.toByteArray().asUByteArray()
                output.close()
                array
            } catch (e: Throwable) {
                UtilsStream.closeSilently(output)
                ubyteArrayOf()
            }
        }

        fun randomString(length: Int): String {
            val builder = StringBuilder()
            for (i in 0 until length) {
                builder.append(randomChar())
            }
            return builder.toString()
        }

        fun all(): String {
            val builder = StringBuilder()
            for (i in 0 until length) {
                builder.append(codeAt(i).toChar())
            }
            return builder.toString()

        }

    }
}