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
import com.tezov.bank.ui.di.component.ComponentAppUiDialog
import com.tezov.bank.ui.di.component.DaggerComponentAppUiDialog_EntryPoint
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.dialog.Dialog
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.accessor.AccessorBase
import com.tezov.lib_core_android_kotlin.ui.di.accessor.AccessorCoreUiDialog
import com.tezov.lib_core_android_kotlin.ui.di.accessor.AccessorCoreUiPage
import com.tezov.lib_core_android_kotlin.ui.di.annotation.scope.ScopeAppUiPage
import javax.inject.Inject
import kotlin.reflect.KClass

@ScopeAppUiPage
class AccessorAppUiDialog @Inject protected constructor() :
    AccessorBase<Dialog<*, *>, ComponentAppUiDialog.EntryPoint>() {

    companion object {
        @Composable
        operator fun invoke() =
            AccessorAppUiPage().get(
                requester = this,
                key = Activity.LocalPages.current.last().page::class
            ).accessorDialog()

        @Composable
        operator fun invoke(requester: Dialog<*, *>) =
            AccessorAppUiPage().get(
                requester = Activity.LocalPages.current.last().page,
            ).accessorDialog().get(
                requester = requester
            )
    }

    @Composable
    override fun create() = DaggerComponentAppUiDialog_EntryPoint
        .factory()
        .create(
            AccessorCoreUiDialog().get(
                requester = Page.LocalModals.current.last().modal as Dialog<*, *>
            ),
            AccessorAppUiPage().get(
                requester = Activity.LocalPages.current.last().page
            )
        )

}