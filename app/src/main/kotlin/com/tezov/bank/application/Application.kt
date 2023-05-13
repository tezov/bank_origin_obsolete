/*
 *  ********************************************************************************
 *  Created by Tezov under MIT LICENCE.
 *  For any request, please send me an email to tezov.app@gmail.com.
 *  I'll be glad to answer you if your request is sane :)
 *  ********************************************************************************
 *
 *
 */

/*
 *  ********************************************************************************
 *  Created by Tezov under MIT LICENCE.
 *  For any request, please send me an email to tezov.app@gmail.com.
 *  I'll be glad to answer you if your request is sane :)
 *  ********************************************************************************
 *
 *
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