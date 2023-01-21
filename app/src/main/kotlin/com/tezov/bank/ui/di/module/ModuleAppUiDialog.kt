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
        ): ComponentContextLazy<DialogLoginAuthState, DialogLoginAuthAction> =
            object : ComponentContextLazy<DialogLoginAuthState, DialogLoginAuthAction> {

                override fun lazyState() = state

                override fun lazyAction() = action

            }

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
            @QualifierCoroutineScopeMain private val coroutineScope: ModuleCoreUiActivity.State.CoroutineScope,
            private val action: ModuleCoreUiActivity.Action.DialogAction,
        ) : ComposableHolder<com.tezov.bank.ui.dialog.login.auth.DialogLoginAuthAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.dialog.login.auth.DialogLoginAuthAction.create(
                    coroutineScope.get(),
                    action.get()
                )
        }


    }

}