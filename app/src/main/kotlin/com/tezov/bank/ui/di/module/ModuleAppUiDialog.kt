/*
 *  ********************************************************************************
 *  Created by Tezov under MIT LICENCE.
 *  For any request, please send me an email to tezov.app@gmail.com.
 *  I'll be glad to answer you if your request is sane :)
 *  ********************************************************************************
 *
 *
 */

/*
 *  ********************************************************************************
 *  Created by Tezov under MIT LICENCE.
 *  For any request, please send me an email to tezov.app@gmail.com.
 *  I'll be glad to answer you if your request is sane :)
 *  ********************************************************************************
 *
 *
 */

package com.tezov.bank.ui.di.module


import com.tezov.bank.ui.bottomsheet.account.accountIncoming.BottomSheetAccountIncomingAction
import com.tezov.bank.ui.bottomsheet.account.accountIncoming.BottomSheetAccountIncomingState
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

        @ScopeAppUiDialog
        @Provides
        fun provideContextBottomSheetAccountIncoming(
            state: State.BottomSheetAccountIncomingState,
            action: Action.BottomSheetAccountIncomingAction
        ) = ComponentContextLazy.make(state, action)

    }

    object State {

        @ScopeAppUiDialog
        class DialogLoginAuthState @Inject constructor() :
            ComposableHolder<com.tezov.bank.ui.dialog.lobby.login.loginAuth.DialogLoginAuthState>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.dialog.lobby.login.loginAuth.DialogLoginAuthState.create()
        }

        @ScopeAppUiDialog
        class DialogAuthCloseAppConfirmationState @Inject constructor() :
            ComposableHolder<com.tezov.bank.ui.dialog.auth.closeAppConfirmation.DialogAuthCloseAppConfirmationState>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.dialog.auth.closeAppConfirmation.DialogAuthCloseAppConfirmationState.create()
        }

        @ScopeAppUiDialog
        class BottomSheetAccountIncomingState @Inject constructor() :
            ComposableHolder<com.tezov.bank.ui.bottomsheet.account.accountIncoming.BottomSheetAccountIncomingState>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.bottomsheet.account.accountIncoming.BottomSheetAccountIncomingState.create()
        }



    }

    object Action {

        @ScopeAppUiDialog
        class DialogLoginAuthAction @Inject constructor(
            private val action: ModuleCoreUiActivity.Action.DialogAction,
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
        ) : ComposableHolder<com.tezov.bank.ui.dialog.lobby.login.loginAuth.DialogLoginAuthAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.dialog.lobby.login.loginAuth.DialogLoginAuthAction.create(
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

        @ScopeAppUiDialog
        class BottomSheetAccountIncomingAction @Inject constructor(
            private val action: ModuleCoreUiActivity.Action.BottomSheetAction,
        ) : ComposableHolder<com.tezov.bank.ui.bottomsheet.account.accountIncoming.BottomSheetAccountIncomingAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.bottomsheet.account.accountIncoming.BottomSheetAccountIncomingAction.create(
                    action.get(),
                )
        }


    }

}