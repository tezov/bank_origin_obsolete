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

package com.tezov.lib_core_kotlin.type.primitive

import com.google.common.truth.Truth
import com.tezov.lib_core_kotlin.type.primitive.BytesTo.toCharArray
import com.tezov.lib_core_kotlin.type.primitive.BytesTo.toStringChar
import com.tezov.lib_core_kotlin.type.primitive.CharsTo.toUByteArray
import com.tezov.test_common.rule.RepeatRule
import com.tezov.test_common.rule.RepeatTest
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.random.Random
import kotlin.random.nextUBytes

class CharsToTest{

    companion object{
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
    fun toUByteArray_Back_toCharArray_isConform(){
        val size = Random.nextInt(1,500)
        val result = Random.nextUBytes(size).toStringChar().toCharArray()
        val value = result.toUByteArray().toCharArray()
        Truth.assertThat(value).isEqualTo(result)
    }

}