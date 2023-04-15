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

package com.tezov.lib_core_kotlin.type.primitive.string

import com.google.common.truth.Truth
import com.tezov.lib_core_kotlin.type.primitive.string.StringHexTo.toUByteArrayHex
import com.tezov.test_common.rule.RepeatRule
import com.tezov.test_common.rule.RepeatTest
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.random.Random
import kotlin.random.nextUBytes


class StringHexToTest {

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
    fun toUByteArrayHex_isConform() {
        val result = Random.nextUBytes(0xFF)
        val value = StringBuilder()
        result.forEach {
            value.append(it.toString(16).padStart(2, '0').uppercase())
        }
        Truth.assertThat(value.toString().toUByteArrayHex())
            .containsExactlyElementsIn(result).inOrder()
    }

}