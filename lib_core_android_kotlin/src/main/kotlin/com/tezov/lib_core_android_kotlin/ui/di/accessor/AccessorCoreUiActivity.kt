/*
 *  *********************************************************************************
 *  Created by Tezov on 15/04/2023 19:41
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 15/04/2023 18:52
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.di.accessor

import androidx.compose.runtime.Composable
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalApplication
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.component.ComponentCoreUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.component.ComponentCoreUiPage
import com.tezov.lib_core_android_kotlin.ui.di.component.DaggerComponentCoreUiActivity_EntryPoint
import com.tezov.lib_core_android_kotlin.ui.di.component.DaggerComponentCoreUiPage_EntryPoint
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.wakeUp
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.wakeUpSub
import kotlin.reflect.KClass

class AccessorCoreUiActivity protected constructor() :
    AccessorBase<ComponentCoreUiActivity.EntryPoint, KClass<out Page<*, *>>, ComponentCoreUiPage.EntryPoint>() {

    companion object {
        @Composable
        operator fun invoke() = (LocalApplication.current).accessorCoreUi

        @Composable
        operator fun invoke(requester: Any) = (LocalApplication.current).accessorCoreUi
    }

    @Composable
    override fun create() = DaggerComponentCoreUiActivity_EntryPoint.factory().create()

    @Composable
    override fun onCreated() {
        getChild(this)
    }

    @Composable
    override fun createChild(type: KClass<out Page<*, *>>) =
        DaggerComponentCoreUiPage_EntryPoint.factory().create(this.get(this))

    @Composable
    override fun getChild(requester: Any, type: KClass<out Page<*, *>>) =
        throw Exception("use getChild(requester: Any) instead")

    @Composable
    fun getChild(requester: Any) = super.getChild(requester, Page::class)

    var a = true

    @Composable
    fun wakeUp(requester: Activity<*, *>) {
        with(get(Activity.LocalActivity.current)) {
            exposeCoreCoroutineScope().get()
            exposeCoreScaffoldState().get()
            exposeCoreNavigationController().get()
            contextSubMap().wakeUpSub()
            contextMain().wakeUp()
        }
    }

    @Composable
    fun test() {
        get(Activity.LocalActivity.current).exposeCoreCoroutineScope().get()
    }

}