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

package com.tezov.bank.ui.di.accessor

import androidx.compose.runtime.Composable
import com.tezov.bank.application.Application
import com.tezov.bank.ui.di.component.ComponentAppUiActivity
import com.tezov.bank.ui.di.component.ComponentAppUiPage
import com.tezov.bank.ui.di.component.DaggerComponentAppUiActivity_EntryPoint
import com.tezov.bank.ui.di.component.DaggerComponentAppUiPage_EntryPoint
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalActivity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.accessor.AccessorBase
import com.tezov.lib_core_android_kotlin.ui.di.accessor.AccessorCoreUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.accessor.AccessorCoreUiPage
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.wakeUp
import kotlin.reflect.KClass

class AccessorAppUiActivity protected constructor():
    AccessorBase<ComponentAppUiActivity.EntryPoint, KClass<out Page<*, *>>, ComponentAppUiPage.EntryPoint>() {

    companion object{
        @Composable
        operator fun invoke() = (Activity.LocalApplication.current as Application).accessorAppUi

        @Composable
        operator fun invoke(requester:Any) = (Activity.LocalApplication.current as Application).accessorAppUi
    }

    @Composable
    override fun create() =
        DaggerComponentAppUiActivity_EntryPoint.factory().create(AccessorCoreUiActivity().get(this))

    @Composable
    override fun onCreated() {
        getChild(this)
    }

    @Composable
    override fun createChild(type: KClass<out Page<*, *>>) =
        DaggerComponentAppUiPage_EntryPoint.factory().create(AccessorCoreUiPage().get(this), this.get(this))


    @Composable
    override fun getChild(requester:Any, type: KClass<out Page<*, *>>) = throw Exception("use getChild(requester:Any) instead")

    @Composable
    fun getChild(requester:Any) = super.getChild(requester, Page::class)

    @Composable
    fun wakeUp(requester:Activity<*, *>){
        AccessorCoreUiActivity().wakeUp(LocalActivity.current)
        get(LocalActivity.current).contextMain().wakeUp()
    }

}