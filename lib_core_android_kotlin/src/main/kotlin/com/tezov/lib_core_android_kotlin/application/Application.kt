package com.tezov.lib_core_android_kotlin.application

import com.tezov.lib_core_android_kotlin.ui.di.accessor.AccessorCoreUiActivity
import com.tezov.lib_core_kotlin.application.Application
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.jvm.isAccessible


abstract class Application : Application() {
    lateinit var accessorCoreUi:AccessorCoreUiActivity

    override fun onCreate() {
        super.onCreate()
        accessorCoreUi = AccessorCoreUiActivity::class.primaryConstructor?.apply {
            isAccessible = true
        }?.call() ?: throw Exception("failed to create instance of AccessorCoreUiActivity")
    }

}