/*
 *  *********************************************************************************
 *  Created by Tezov on 25/04/2023 21:10
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 25/04/2023 21:04
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
import com.tezov.bank.ui.di.component.DaggerComponentAppUiActivity_EntryPoint
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalActivity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalApplication
import com.tezov.lib_core_android_kotlin.ui.di.accessor.AccessorBase
import com.tezov.lib_core_android_kotlin.ui.di.accessor.AccessorCoreUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.wakeUp
import kotlin.reflect.KClass

class AccessorAppUiActivity protected constructor() :
    AccessorBase<Activity<*, *>, ComponentAppUiActivity.EntryPoint>() {

    companion object {
        @Composable
        operator fun invoke() = (LocalApplication.current as Application).accessorAppUi

        @Composable
        operator fun invoke(requester: Activity<*, *>) =
            (LocalApplication.current as Application)
                .accessorAppUi
                .get(requester = requester)
    }

    @Composable
    override fun create() = DaggerComponentAppUiActivity_EntryPoint
        .factory()
        .create(
            AccessorCoreUiActivity().get(
                requester = LocalActivity.current
            )
        )

    @Composable
    fun wakeUp(requester: Activity<*, *>) {
        AccessorCoreUiActivity().wakeUp(LocalActivity.current)
        get(requester, LocalActivity.current::class).contextMain().wakeUp()
    }

}