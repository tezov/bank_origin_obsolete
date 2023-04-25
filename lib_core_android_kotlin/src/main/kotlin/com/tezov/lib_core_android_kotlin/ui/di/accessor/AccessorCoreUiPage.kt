/*
 *  *********************************************************************************
 *  Created by Tezov on 25/04/2023 21:10
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 25/04/2023 21:04
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.di.accessor

import androidx.compose.runtime.Composable
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalActivity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.annotation.scope.ScopeCoreUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.component.ComponentCoreUiPage
import com.tezov.lib_core_android_kotlin.ui.di.component.DaggerComponentCoreUiPage_EntryPoint
import javax.inject.Inject
import kotlin.reflect.KClass

@ScopeCoreUiActivity
class AccessorCoreUiPage @Inject protected constructor() :
    AccessorBase<Page<*, *>, ComponentCoreUiPage.EntryPoint>() {

    companion object {
        @Composable
        operator fun invoke() =
            AccessorCoreUiActivity().get(
                requester = this,
                key = LocalActivity.current::class
            ).accessorPage()

        @Composable
        operator fun invoke(requester: Page<*, *>) =
            AccessorCoreUiActivity().get(
                requester = LocalActivity.current
            ).accessorPage().get(
                requester = requester
            )
    }

    @Composable
    override fun create() = DaggerComponentCoreUiPage_EntryPoint
        .factory()
        .create(
            AccessorCoreUiActivity().get(
                requester = LocalActivity.current
            )
        )

}