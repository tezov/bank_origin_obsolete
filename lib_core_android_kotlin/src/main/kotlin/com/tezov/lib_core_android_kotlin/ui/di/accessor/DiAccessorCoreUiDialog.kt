/*
 *  *********************************************************************************
 *  Created by Tezov on 05/05/2023 20:30
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 05/05/2023 20:25
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.di.accessor

import androidx.compose.runtime.Composable
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalPagesBundle
import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.dialog.Dialog
import com.tezov.lib_core_android_kotlin.ui.di.annotation.scope.ScopeCoreUiPage
import com.tezov.lib_core_android_kotlin.ui.di.component.ComponentCoreUiDialog
import com.tezov.lib_core_android_kotlin.ui.di.component.DaggerComponentCoreUiDialog_EntryPoint
import javax.inject.Inject

@ScopeCoreUiPage
class DiAccessorCoreUiDialog @Inject protected constructor() :
    DiAccessor<ComponentCoreUiDialog.EntryPoint>() {

    companion object {
        @Composable
        operator fun invoke() =
            DiAccessorCoreUiPage().with(
                requester = this,
                key = LocalPagesBundle.last().current
            ).accessorDialog()

        @Composable
        operator fun invoke(requester: Dialog<*, *>) =
            DiAccessorCoreUiPage().with(
                key = LocalPagesBundle.last().current,
            ).accessorDialog().with(
                key = requester
            )
    }

    @Composable
    override fun create() = DaggerComponentCoreUiDialog_EntryPoint
        .factory()
        .create(
            DiAccessorCoreUiPage().with(
                key = LocalPagesBundle.last().current
            )
        )

}