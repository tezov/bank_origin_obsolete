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