/*
 *  *********************************************************************************
 *  Created by Tezov on 26/04/2023 21:07
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 26/04/2023 20:41
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
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalActivity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalPages
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.accessor.DiAccessor
import com.tezov.lib_core_android_kotlin.ui.di.accessor.DiAccessorCoreUiPage
import com.tezov.lib_core_android_kotlin.ui.di.annotation.scope.ScopeAppUiActivity
import javax.inject.Inject

@ScopeAppUiActivity
class DiAccessorAppUiPage @Inject protected constructor() :
    DiAccessor<ComponentAppUiPage.EntryPoint>() {

    companion object {
        @Composable
        operator fun invoke() =
            DiAccessorAppUiActivity().with(
                requester = this,
                key = LocalActivity.current
            ).accessorPage()

        @Composable
        operator fun invoke(requester: Page<*, *>) =
            DiAccessorAppUiActivity().with(
                key = LocalActivity.current
            ).accessorPage().with(
                key = requester
            )
    }

    @Composable
    override fun create() = DaggerComponentAppUiPage_EntryPoint
        .factory()
        .create(
            DiAccessorCoreUiPage().with(
                key = LocalPages.current.last().page
            ),
            DiAccessorAppUiActivity().with(
                key = LocalActivity.current
            )
        )

    @Composable
    override fun dispose(requester: Any, key: Key) =
        DiAccessorCoreUiPage().dispose(requester, key) || super.dispose(requester, key)
}