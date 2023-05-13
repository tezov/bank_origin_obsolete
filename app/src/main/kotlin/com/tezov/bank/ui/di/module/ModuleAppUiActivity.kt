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

import com.tezov.bank.ui.activity.MainActivityAction
import com.tezov.bank.ui.activity.MainActivityState
import com.tezov.lib_core_android_kotlin.ui.di.annotation.scope.ScopeAppUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.component.ComponentContextLazy
import com.tezov.lib_core_android_kotlin.ui.di.helper.ComposableHolder
import com.tezov.lib_core_android_kotlin.ui.di.module.ModuleCoreUiActivity
import dagger.Module
import dagger.Provides
import javax.inject.Inject

interface ModuleAppUiActivity {

    @Module
    class MapperContext {

        @ScopeAppUiActivity
        @Provides
        fun provideContextMain(
            state: State.ActivityMainState,
            action: Action.ActivityMainAction
        ) = ComponentContextLazy.make(state, action)

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