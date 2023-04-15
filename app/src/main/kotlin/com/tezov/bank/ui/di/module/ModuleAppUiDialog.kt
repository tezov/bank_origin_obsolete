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

package com.tezov.bank.ui.di.module


import com.tezov.lib_core_android_kotlin.ui.di.annotation.scope.ScopeAppUiDialog
import com.tezov.lib_core_android_kotlin.ui.di.component.ComponentContextLazy
import com.tezov.lib_core_android_kotlin.ui.di.helper.ComposableHolder
import com.tezov.lib_core_android_kotlin.ui.di.module.ModuleCoreUiActivity
import dagger.Module
import dagger.Provides
import javax.inject.Inject

interface ModuleAppUiDialog {

    @Module
    class MapperContext {

        @ScopeAppUiDialog
        @Provides
        fun provideContextDialogLoginAuth(
            state: State.DialogLoginAuthState,
            action: Action.DialogLoginAuthAction
        ) = ComponentContextLazy.make(state, action)

        @ScopeAppUiDialog
        @Provides
        fun provideContextDialogAuthCloseAppConfirmation(
            state: State.DialogAuthCloseAppConfirmationState,
            action: Action.DialogAuthCloseAppConfirmationAction
        ) = ComponentContextLazy.make(state, action)

    }

    object State {

        @ScopeAppUiDialog
        class DialogLoginAuthState @Inject constructor() :
            ComposableHolder<com.tezov.bank.ui.dialog.lobby.login.auth.DialogLoginAuthState>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.dialog.lobby.login.auth.DialogLoginAuthState.create()
        }

        @ScopeAppUiDialog
        class DialogAuthCloseAppConfirmationState @Inject constructor() :
            ComposableHolder<com.tezov.bank.ui.dialog.auth.closeAppConfirmation.DialogAuthCloseAppConfirmationState>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.dialog.auth.closeAppConfirmation.DialogAuthCloseAppConfirmationState.create()
        }

    }

    object Action {

        @ScopeAppUiDialog
        class DialogLoginAuthAction @Inject constructor(
            private val action: ModuleCoreUiActivity.Action.DialogAction,
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
        ) : ComposableHolder<com.tezov.bank.ui.dialog.lobby.login.auth.DialogLoginAuthAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.dialog.lobby.login.auth.DialogLoginAuthAction.create(
                    action.get(),
                    navigationController.get()
                )
        }

        @ScopeAppUiDialog
        class DialogAuthCloseAppConfirmationAction @Inject constructor(
            private val action: ModuleCoreUiActivity.Action.DialogAction,
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
        ) : ComposableHolder<com.tezov.bank.ui.dialog.auth.closeAppConfirmation.DialogAuthCloseAppConfirmationAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.dialog.auth.closeAppConfirmation.DialogAuthCloseAppConfirmationAction.create(
                    action.get(),
                    navigationController.get()
                )
        }


    }

}