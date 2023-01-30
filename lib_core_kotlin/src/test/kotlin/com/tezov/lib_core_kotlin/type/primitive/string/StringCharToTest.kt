/*
 *  *********************************************************************************
 *  Created by Tezov on 30/01/2023 20:18
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 30/01/2023 20:11
 *  First project bank / bank.lib_core_kotlin.unitTest
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_kotlin.type.primitive.string

import com.google.common.truth.Truth
import com.tezov.lib_core_kotlin.type.primitive.BytesTo.toInt
import com.tezov.lib_core_kotlin.type.primitive.BytesTo.toStringChar
import com.tezov.lib_core_kotlin.type.primitive.BytesTo.toStringHex
import com.tezov.lib_core_kotlin.type.primitive.IntTo.toStringHex
import com.tezov.lib_core_kotlin.type.primitive.string.StringCharTo.toUByteArrayChar
import com.tezov.lib_core_kotlin.util.UtilsUnicode
import com.tezov.test_common.rule.RepeatRule
import com.tezov.test_common.rule.RepeatTest
import com.tezov.test_common.rule.RetryRule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.lang.StringBuilder
import java.nio.charset.StandardCharsets
import kotlin.random.Random
import kotlin.random.nextUInt


class StringCharToTest {

    companion object {
        const val LOOP = 50
    }
    @get:Rule
    val repeatRule = RepeatRule()


    @Before
    fun setup() {

    }

    @After
    fun teardown() {

    }

    @RepeatTest(LOOP)
    @Test
    fun toUByteArrayChar_isConform() {
        val result = UByteArray(0xFF)
        for (j in result.indices) {
            result[j] = Random.nextUInt(0x20U, 0x7EU).toUByte()
        }
        val value = StringBuilder()
        result.forEach {
            value.append(it.toInt().toChar())
        }
        Truth.assertThat(value.toString().toUByteArrayChar()).containsExactlyElementsIn(result).inOrder()
    }


    @Test
    fun toUByteArrayChar_with_latin_isConform() {
        val latin = UtilsUnicode.Latin()
        Truth.assertThat(latin.all().toUByteArrayChar().toStringChar()).isEqualTo(latin.all())
    }


}