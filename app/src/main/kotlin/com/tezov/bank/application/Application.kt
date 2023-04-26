/*
 *  *********************************************************************************
 *  Created by Tezov on 26/04/2023 21:07
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 26/04/2023 19:43
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.application

import com.tezov.bank.ui.di.accessor.DiAccessorAppUiActivity
import com.tezov.lib_core_android_kotlin.application.Application
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.jvm.isAccessible

class Application : Application() {
    lateinit var accessorAppUi: DiAccessorAppUiActivity

    override fun onCreate() {
        super.onCreate()
        accessorAppUi = DiAccessorAppUiActivity::class.primaryConstructor?.apply {
            isAccessible = true
        }?.call() ?: throw Exception("failed to create instance of AccessorAppUiApplication")

    }


}