/*
 *  *********************************************************************************
 *  Created by Tezov on 30/01/2023 20:18
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 30/01/2023 20:11
 *  First project bank / bank.lib_core_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_kotlin.application

import androidx.core.os.ConfigurationCompat
import androidx.multidex.MultiDexApplication
import com.jakewharton.threetenabp.AndroidThreeTen
import com.tezov.lib_core_java.util.Clock
import java.util.*

open class Application : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
        val local: Locale = ConfigurationCompat.getLocales(resources.configuration)[0]!!
        Clock.FormatDate.init(local)
    }
}