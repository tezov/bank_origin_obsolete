/*
 *  *********************************************************************************
 *  Created by Tezov on 30/01/2023 20:18
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 30/01/2023 20:11
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.application

import com.tezov.bank.ui.di.accessor.AccessorAppUiActivity
import com.tezov.lib_core_android_kotlin.application.Application
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.jvm.isAccessible

class Application : Application() {
    lateinit var accessorAppUi: AccessorAppUiActivity

    override fun onCreate() {
        super.onCreate()
        accessorAppUi = AccessorAppUiActivity::class.primaryConstructor?.apply {
            isAccessible = true
        }?.call() ?: throw Exception("failed to create instance of AccessorAppUiApplication")

    }


}