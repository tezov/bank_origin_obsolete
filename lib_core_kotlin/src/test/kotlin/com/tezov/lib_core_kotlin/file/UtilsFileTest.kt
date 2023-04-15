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

package com.tezov.lib_core_kotlin.file

import com.google.common.truth.Truth
import com.tezov.lib_core_kotlin.file.UtilsFile.extension
import com.tezov.lib_core_kotlin.file.UtilsFile.name
import com.tezov.lib_core_kotlin.file.UtilsFile.splitToNameAndExtension
import com.tezov.lib_core_kotlin.type.primaire.Pair
import org.junit.After
import org.junit.Before
import org.junit.Test

class UtilsFileTest {


    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun can_find_extension_simple() {
        val extension = "extension"
        val fileFullName = "name" + File.DOT_SEPARATOR + extension
        Truth.assertThat(fileFullName.extension()).isEqualTo(extension)
    }

    @Test
    fun can_find_extension_double() {
        val extension = "extension"
        val fileFullName = "name.save" + File.DOT_SEPARATOR + extension
        Truth.assertThat(fileFullName.extension()).isEqualTo(extension)
    }

    @Test
    fun can_not_find_extension() {
        val fileFullName = "name"
        Truth.assertThat(fileFullName.extension()).isEqualTo(null)
    }

    @Test
    fun can_find_name_simple() {
        val name = "name"
        val fileFullName = name + File.DOT_SEPARATOR + "extension"
        Truth.assertThat(fileFullName.name()).isEqualTo(name)
    }

    @Test
    fun can_find_name_complexe() {
        val name = "name.name2"
        val fileFullName = name + File.DOT_SEPARATOR + "extension"
        Truth.assertThat(fileFullName.name()).isEqualTo(name)
    }

    @Test
    fun can_find_name_and_extension_simple() {
        val name = "name"
        val extension = "extension"
        val fileFullName = name + File.DOT_SEPARATOR + extension
        Truth.assertThat(fileFullName.splitToNameAndExtension()).isEqualTo(Pair(name, extension))
    }

    @Test
    fun can_find_name_and_extension_complex() {
        val name = "name.name2.name3"
        val extension = "extension"
        val fileFullName = name + File.DOT_SEPARATOR + extension
        Truth.assertThat(fileFullName.splitToNameAndExtension()).isEqualTo(Pair(name, extension))
    }

}