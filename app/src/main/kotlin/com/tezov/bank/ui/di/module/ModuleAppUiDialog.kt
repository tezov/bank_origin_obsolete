/*
 *  *********************************************************************************
 *  Created by Tezov on 31/01/2023 20:01
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 31/01/2023 19:37
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.di.module


import com.tezov.bank.ui.dialog.login.auth.DialogLoginAuthAction
import com.tezov.bank.ui.dialog.login.auth.DialogLoginAuthState
import com.tezov.lib_core_android_kotlin.ui.di.helper.ComposableHolder
import com.tezov.lib_core_android_kotlin.ui.di.module.ModuleCoreUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.annotation.qualifier.QualifierCoroutineScopeMain
import com.tezov.lib_core_android_kotlin.ui.di.annotation.scope.ScopeAppUiDialog
import com.tezov.lib_core_android_kotlin.ui.di.component.ComponentContextLazy
import dagger.Module
import dagger.Provides
import javax.inject.Inject

interface ModuleAppUiDialog {

    @Module
    class MapperContext{

        @ScopeAppUiDialog
        @Provides
        fun provideContextSendEmail(
            state: State.DialogLoginAuthState,
            action: Action.DialogLoginAuthAction
        ) = ComponentContextLazy.make(state, action)

    }

    object State {

        @ScopeAppUiDialog
        class DialogLoginAuthState @Inject constructor() :
            ComposableHolder<com.tezov.bank.ui.dialog.login.auth.DialogLoginAuthState>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.dialog.login.auth.DialogLoginAuthState.create()
        }

    }

    object Action {

        @ScopeAppUiDialog
        class DialogLoginAuthAction @Inject constructor(
            private val action: ModuleCoreUiActivity.Action.DialogAction,
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
        ) : ComposableHolder<com.tezov.bank.ui.dialog.login.auth.DialogLoginAuthAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.dialog.login.auth.DialogLoginAuthAction.create(
                    action.get(),
                    navigationController.get()
                )
        }


    }

}