/*
 *  *********************************************************************************
 *  Created by Tezov on 05/05/2023 20:30
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 05/05/2023 20:28
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.di.accessor

import androidx.compose.runtime.Composable
import com.tezov.bank.ui.di.component.ComponentAppUiDialog
import com.tezov.bank.ui.di.component.DaggerComponentAppUiDialog_EntryPoint
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.dialog.Dialog
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.accessor.DiAccessor
import com.tezov.lib_core_android_kotlin.ui.di.accessor.DiAccessorCoreUiDialog
import com.tezov.lib_core_android_kotlin.ui.di.annotation.scope.ScopeAppUiPage
import javax.inject.Inject

@ScopeAppUiPage
class DiAccessorAppUiDialog @Inject protected constructor() :
    DiAccessor<ComponentAppUiDialog.EntryPoint>() {

    companion object {
        @Composable
        operator fun invoke() =
            DiAccessorAppUiPage().with(
                requester = this,
                key = Activity.LocalPagesBundle.last().current
            ).accessorDialog()

        @Composable
        operator fun invoke(requester: Dialog<*, *>) =
            DiAccessorAppUiPage().with(
                key = Activity.LocalPagesBundle.last().current,
            ).accessorDialog().with(
                key = requester
            )
    }

    @Composable
    override fun create() = DaggerComponentAppUiDialog_EntryPoint
        .factory()
        .create(
            DiAccessorCoreUiDialog().with(
                key = Page.LocalModalsBundle.last().current
            ),
            DiAccessorAppUiPage().with(
                key = Activity.LocalPagesBundle.last().current
            )
        )

    @Composable
    override fun dispose(requester: Any, key: Key) =
        DiAccessorCoreUiDialog().dispose(requester, key) or super.dispose(requester, key)

}