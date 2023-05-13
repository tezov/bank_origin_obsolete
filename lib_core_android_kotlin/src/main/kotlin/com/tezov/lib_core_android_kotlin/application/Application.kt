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

package com.tezov.lib_core_android_kotlin.application

import com.tezov.lib_core_android_kotlin.ui.di.accessor.DiAccessorCoreUiActivity
import com.tezov.lib_core_kotlin.application.Application
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.jvm.isAccessible


abstract class Application : Application() {
    lateinit var accessorCoreUi: DiAccessorCoreUiActivity

    override fun onCreate() {
        super.onCreate()
        accessorCoreUi = DiAccessorCoreUiActivity::class.primaryConstructor?.apply {
            isAccessible = true
        }?.call() ?: throw Exception("failed to create instance of AccessorCoreUiActivity")
    }

}