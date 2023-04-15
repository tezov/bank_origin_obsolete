/*
 *  *********************************************************************************
 *  Created by Tezov on 15/04/2023 19:41
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 15/04/2023 18:52
 *  First project bank / bank.lib_core_kotlin.androidTest
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_kotlin.file

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.google.common.truth.Truth
import com.tezov.lib_core_kotlin.type.primitive.BytesTo.toStringHex
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.random.Random
import kotlin.random.nextUBytes


@RunWith(AndroidJUnit4::class)
class DirectoryTest {


    @Before
    fun setUp() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        StoragePackage.environnement = object : StoragePackage.Environnement {
            override val privateDataPath: String
                get() = ""
            override val privateDataCachePath: String
                get() = appContext.cacheDir.path
            override val privateDataFilePath: String
                get() = ""
            override val privateDataBasePath: String
                get() = ""
            override val privateSharePreferencePath: String
                get() = ""
            override val publicDataPath: String
                get() = ""
        }
    }

    @After
    fun tearDown() {
    }


    @Test
    fun can_create() {
        var test_done = true
        do {
            val size = Random.nextInt(1, 10)
            val name = Random.nextUBytes(size).toStringHex()
            val directory =
                Directory(StoragePackage.Type.PRIVATE_DATA_CACHE, "test_directory_$name")
            if (directory.exists) {
                continue
            }
            Truth.assertThat(directory.exists).isFalse()
            Truth.assertThat(directory.create()).isTrue()
            Truth.assertThat(directory.isDirectory).isTrue()
            Truth.assertThat(directory.canRead).isTrue()
            Truth.assertThat(directory.canWrite).isTrue()
            test_done = false
        } while (test_done)
    }

    @Test
    fun link_isConform() {
        val result = "PRIVATE_DATA_CACHE:BeWNDhxmZvfiyLpFHckBeGNcJRJPrNSDSaPwztUywS"
        val directory =
            Directory(StoragePackage.Type.PRIVATE_DATA_CACHE, "test_directory_link_isConform")
        if (!directory.exists) {
            directory.create()
        }
        Truth.assertThat(directory.toLinkString()).isEqualTo(result)
    }

    @Test
    fun can_create_from_link() {
        val link = "PRIVATE_DATA_CACHE:BeWNDhxmZvfiyLpFHckBeGNcJRJPrNSDSaPwztUywS"
        val directory = Directory.from(link)
        Truth.assertThat(directory.relativePathString).isEqualTo("test_directory_link_isConform")
        Truth.assertThat(directory.storage!!.name).isEqualTo("PRIVATE_DATA_CACHE")
    }


    @Test
    fun path_isConform() {
        val result = "private_data_cache/test_directory_link_isConform/"
        val directory =
            Directory(StoragePackage.Type.PRIVATE_DATA_CACHE, "test_directory_link_isConform")
        if (!directory.exists) {
            directory.create()
        }
        Truth.assertThat(directory.toLinkPathString()).isEqualTo(result)
    }


}