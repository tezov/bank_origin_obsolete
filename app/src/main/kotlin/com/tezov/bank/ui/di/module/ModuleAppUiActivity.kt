package com.tezov.bank.ui.di.module

import com.tezov.bank.ui.activity.MainActivityAction
import com.tezov.bank.ui.activity.MainActivityState
import com.tezov.lib_core_android_kotlin.ui.di.helper.ComposableHolder
import com.tezov.lib_core_android_kotlin.ui.di.annotation.scope.ScopeAppUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.component.ComponentContextLazy
import com.tezov.lib_core_android_kotlin.ui.di.module.ModuleCoreUiActivity
import dagger.Module
import dagger.Provides
import javax.inject.Inject

interface ModuleAppUiActivity {

    @Module
    class MapperContext{

        @ScopeAppUiActivity
        @Provides
        fun provideContextMain(
            state: State.ActivityMainState,
            action: Action.ActivityMainAction
        ): ComponentContextLazy<MainActivityState, MainActivityAction> =
            object :
                ComponentContextLazy<MainActivityState, MainActivityAction> {

                override fun lazyState() = state

                override fun lazyAction() = action

            }

    }

    object State {
        @ScopeAppUiActivity
        class ActivityMainState @Inject constructor(
            private val coreState: ModuleCoreUiActivity.State.ActivityMainState
        ) : ComposableHolder<MainActivityState>() {
            @androidx.compose.runtime.Composable
            override fun create() = MainActivityState.create(coreState.get())
        }
    }

    object Action {
        @ScopeAppUiActivity
        class ActivityMainAction @Inject constructor(
            private val coreAction: ModuleCoreUiActivity.Action.ActivityMainAction,
        ) : ComposableHolder<MainActivityAction>() {
            @androidx.compose.runtime.Composable
            override fun create() = MainActivityAction.create(coreAction.get())
        }
    }

}