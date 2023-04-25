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
import com.tezov.bank.ui.di.component.ComponentAppUiPage
import com.tezov.bank.ui.di.component.DaggerComponentAppUiPage_EntryPoint
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalActivity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalPages
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.accessor.AccessorBase
import com.tezov.lib_core_android_kotlin.ui.di.accessor.AccessorCoreUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.accessor.AccessorCoreUiPage
import com.tezov.lib_core_android_kotlin.ui.di.annotation.scope.ScopeAppUiActivity
import javax.inject.Inject
import kotlin.reflect.KClass

@ScopeAppUiActivity
class AccessorAppUiPage @Inject protected constructor() :
    AccessorBase<Page<*, *>, ComponentAppUiPage.EntryPoint>() {

    companion object {
        @Composable
        operator fun invoke() =
            AccessorAppUiActivity().get(
                requester = this,
                key = LocalActivity.current::class
            ).accessorPage()

        @Composable
        operator fun invoke(requester: Page<*, *>) =
            AccessorAppUiActivity().get(
                requester = LocalActivity.current
            ).accessorPage().get(
                requester = requester
            )
    }

    @Composable
    override fun create() = DaggerComponentAppUiPage_EntryPoint
        .factory()
        .create(
            AccessorCoreUiPage().get(
                requester = LocalPages.current.last().page
            ),
            AccessorAppUiActivity().get(
                requester = LocalActivity.current
            )
        )
}