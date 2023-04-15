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

package com.tezov.lib_core_kotlin.buffer

import com.google.common.truth.Truth
import org.junit.After
import org.junit.Before
import org.junit.Test

class ByteBufferInputTest {

    companion object {
        const val LOOP = 50
    }

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun bytebufferinput_is_equal_to_bytebufferbuilder() {
        //fix data
        val intData = 1
        val floatData = 2.0f
        val doubleData = 3.0
        val longData = 4L
        val byteData = 0x05.toUByte()
        val stringData = "hello world"
        val charsData = stringData.toCharArray()
        val bytesData = UByteArray(10) { index -> 0xAAU }
        val copyBytesData = UByteArray(10) { index -> 0xAAU }
        val copyByteData = 0x06.toUByte()

        val bytebufferbuilder = ByteBufferBuilder.obtain().apply {
            chars = charsData
            string = stringData
            bytes = bytesData
            byte = byteData
            int = intData
            long = longData
            double = doubleData
            float = floatData
            boolean = true
            boolean = false
            nullFlag = true
            nullFlag = false
            writeToBuffer(copyBytesData)
            writeToBuffer(copyByteData)
        }.build().uByteArray

        val bytebufferinput = ByteBufferInput.wrap(bytebufferbuilder)

        Truth.assertThat(bytebufferinput.chars).isEqualTo(charsData)
        Truth.assertThat(bytebufferinput.string).isEqualTo(stringData)
        Truth.assertThat(bytebufferinput.bytes).containsExactlyElementsIn(bytesData).inOrder()
        Truth.assertThat(bytebufferinput.byte).isEqualTo(byteData)
        Truth.assertThat(bytebufferinput.int).isEqualTo(intData)
        Truth.assertThat(bytebufferinput.long).isEqualTo(longData)
        Truth.assertThat(bytebufferinput.double).isEqualTo(doubleData)
        Truth.assertThat(bytebufferinput.float).isEqualTo(floatData)
        Truth.assertThat(bytebufferinput.boolean).isEqualTo(true)
        Truth.assertThat(bytebufferinput.boolean).isEqualTo(false)
        Truth.assertThat(bytebufferinput.nullFlag).isEqualTo(true)
        Truth.assertThat(bytebufferinput.nullFlag).isEqualTo(false)
        Truth.assertThat(bytebufferinput.readFromBuffer(10))
            .containsExactlyElementsIn(copyBytesData).inOrder()
        Truth.assertThat(bytebufferinput.readFromBuffer()).isEqualTo(copyByteData)
    }

}