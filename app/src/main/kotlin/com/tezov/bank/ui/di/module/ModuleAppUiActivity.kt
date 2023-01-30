/*
 *  *********************************************************************************
 *  Created by Tezov on 30/01/2023 20:18
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 30/01/2023 20:11
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

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