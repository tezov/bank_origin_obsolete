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
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalPages
import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.dialog.Dialog
import com.tezov.lib_core_android_kotlin.ui.di.annotation.scope.ScopeCoreUiPage
import com.tezov.lib_core_android_kotlin.ui.di.component.ComponentCoreUiDialog
import com.tezov.lib_core_android_kotlin.ui.di.component.DaggerComponentCoreUiDialog_EntryPoint
import javax.inject.Inject
import kotlin.reflect.KClass

@ScopeCoreUiPage
class AccessorCoreUiDialog @Inject protected constructor() :
    AccessorBase<Dialog<*, *>, ComponentCoreUiDialog.EntryPoint>() {

    companion object {
        @Composable
        operator fun invoke() =
            AccessorCoreUiPage().get(
                requester = this,
                key = LocalPages.current.last().page::class
            ).accessorDialog()

        @Composable
        operator fun invoke(requester: Dialog<*, *>) =
            AccessorCoreUiPage().get(
                requester = LocalPages.current.last().page,
            ).accessorDialog().get(
                requester = requester
            )
    }

    @Composable
    override fun create() = DaggerComponentCoreUiDialog_EntryPoint
        .factory()
        .create(
            AccessorCoreUiPage().get(
                requester = LocalPages.current.last().page
            )
        )

}