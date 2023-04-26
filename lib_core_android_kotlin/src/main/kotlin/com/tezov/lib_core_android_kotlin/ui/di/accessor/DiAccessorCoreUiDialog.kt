/*
 *  *********************************************************************************
 *  Created by Tezov on 26/04/2023 21:07
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 26/04/2023 20:03
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.di.accessor

import androidx.compose.runtime.Composable
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalPages
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
                key = LocalPages.current.last().page
            ).accessorDialog()

        @Composable
        operator fun invoke(requester: Dialog<*, *>) =
            DiAccessorCoreUiPage().with(
                key = LocalPages.current.last().page,
            ).accessorDialog().with(
                key = requester
            )
    }

    @Composable
    override fun create() = DaggerComponentCoreUiDialog_EntryPoint
        .factory()
        .create(
            DiAccessorCoreUiPage().with(
                key = LocalPages.current.last().page
            )
        )

}