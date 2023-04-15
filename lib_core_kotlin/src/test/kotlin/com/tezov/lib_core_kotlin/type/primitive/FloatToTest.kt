/*
 *  *********************************************************************************
 *  Created by Tezov on 15/04/2023 19:41
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 15/04/2023 18:52
 *  First project bank / bank.lib_core_kotlin.unitTest
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_kotlin.type.primitive

import com.google.common.truth.Truth
import com.tezov.lib_core_kotlin.type.primitive.BytesTo.toFloat
import com.tezov.lib_core_kotlin.type.primitive.FloatTo.toUByteArray
import com.tezov.lib_core_kotlin.type.primitive.string.StringHexTo.toUByteArrayHex
import com.tezov.test_common.rule.RepeatRule
import com.tezov.test_common.rule.RepeatTest
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.random.Random

class FloatToTest {

    companion object {
        const val LOOP = 1000
    }

    @get:Rule
    val repeatRule = RepeatRule()

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun float_to_array_to_float_is_conform() {
        val result = "43324CCD".toUByteArrayHex()
        val value = 178.3F.toUByteArray()
        Truth.assertThat(value).containsExactlyElementsIn(result).inOrder()
    }

    @RepeatTest(LOOP)
    @Test
    fun random_float_to_array_to_float_is_conform() {
        val result = Random.nextFloat()
        val value = result.toUByteArray()
        Truth.assertThat(value.toFloat()).isEqualTo(result)
    }
}