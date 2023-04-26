/*
 *  *********************************************************************************
 *  Created by Tezov on 26/04/2023 21:07
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 26/04/2023 20:05
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
import com.tezov.lib_core_android_kotlin.ui.di.component.ComponentCoreUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.component.DaggerComponentCoreUiActivity_EntryPoint
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.wakeUp
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.wakeUpSub

class DiAccessorCoreUiActivity protected constructor() :
    DiAccessor<ComponentCoreUiActivity.EntryPoint>() {

    companion object {
        @Composable
        operator fun invoke() = (LocalApplication.current).accessorCoreUi

        @Composable
        operator fun invoke(requester: Activity<*, *>) = (LocalApplication.current).accessorCoreUi
    }

    @Composable
    override fun create() = DaggerComponentCoreUiActivity_EntryPoint.factory().create()

    @Composable
    fun wakeUp(requester: Activity<*, *>) {
        with(requester).apply {
            exposeCoreCoroutineScope().get()
            exposeCoreScaffoldState().get()
            exposeCoreNavigationController().get()
            contextSubMap().wakeUpSub()
            contextMain().wakeUp()
        }
    }

}