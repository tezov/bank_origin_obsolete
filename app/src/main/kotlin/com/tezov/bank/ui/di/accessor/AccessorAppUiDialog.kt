/*
 *  *********************************************************************************
 *  Created by Tezov on 15/04/2023 19:41
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 15/04/2023 18:51
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.di.accessor

import androidx.compose.runtime.Composable
import com.tezov.bank.ui.di.component.ComponentAppUiDialog
import com.tezov.lib_core_android_kotlin.ui.di.accessor.AccessorBase
import com.tezov.lib_core_android_kotlin.ui.di.annotation.scope.ScopeAppUiPage
import javax.inject.Inject

@ScopeAppUiPage
class AccessorAppUiDialog @Inject protected constructor() :
    AccessorBase<ComponentAppUiDialog.EntryPoint, Nothing, Nothing>() {

    companion object {
        @Composable
        operator fun invoke() = AccessorAppUiPage().get(this).accessorDialog()

        @Composable
        operator fun invoke(requester: Any) = AccessorAppUiPage().get(requester).accessorDialog()
    }

    @Composable
    override fun create() = AccessorAppUiPage().getChild(this)

    @Composable
    override fun createChild(type: Nothing) = throw Exception("can't have child")

}