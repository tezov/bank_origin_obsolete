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
import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.dialog.Dialog
import com.tezov.lib_core_android_kotlin.ui.di.annotation.scope.ScopeCoreUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.component.ComponentCoreUiDialog
import com.tezov.lib_core_android_kotlin.ui.di.component.ComponentCoreUiPage
import com.tezov.lib_core_android_kotlin.ui.di.component.DaggerComponentCoreUiDialog_EntryPoint
import javax.inject.Inject
import kotlin.reflect.KClass

@ScopeCoreUiActivity
class AccessorCoreUiPage @Inject protected constructor() :
    AccessorBase<ComponentCoreUiPage.EntryPoint, KClass<out Dialog<*, *>>, ComponentCoreUiDialog.EntryPoint>() {

    companion object {
        @Composable
        operator fun invoke() = AccessorCoreUiActivity().get(this).accessorPage()

        @Composable
        operator fun invoke(requester: Any) = AccessorCoreUiActivity().get(requester).accessorPage()
    }

    @Composable
    override fun create() = AccessorCoreUiActivity().getChild(this)

    @Composable
    override fun onCreated() {
        getChild(this)
    }

    @Composable
    override fun createChild(type: KClass<out Dialog<*, *>>) =
        DaggerComponentCoreUiDialog_EntryPoint.factory().create(this.get(this))

    @Composable
    override fun getChild(requester: Any, type: KClass<out Dialog<*, *>>) =
        throw Exception("use getChild(requester: Any) instead")

    @Composable
    fun getChild(requester: Any) = super.getChild(requester, Dialog::class)


}