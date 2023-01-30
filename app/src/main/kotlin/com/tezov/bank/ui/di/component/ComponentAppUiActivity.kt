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

package com.tezov.bank.ui.di.component

import com.tezov.bank.ui.activity.MainActivityAction
import com.tezov.bank.ui.activity.MainActivityState
import com.tezov.bank.ui.di.accessor.AccessorAppUiPage
import com.tezov.bank.ui.di.module.ModuleAppUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.annotation.scope.ScopeAppUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.component.*
import dagger.Component

object ComponentAppUiActivity {

    @ScopeAppUiActivity
    @Component(
        dependencies = [ComponentCoreUiActivity.EntryPoint::class],
        modules = [ModuleAppUiActivity.MapperContext::class]
    )
    interface EntryPoint : ComponentCoreUiActivity.Exposer, Exposer {

        @Component.Factory
        interface Factory{
            fun create(
                componentCoreActivity: ComponentCoreUiActivity.EntryPoint,
            ): EntryPoint
        }

        fun accessorPage(): AccessorAppUiPage

        fun contextMain(): ComponentContextLazy<MainActivityState, MainActivityAction>

    }

    interface Exposer {

        fun exposeAppActivityMainState(): ModuleAppUiActivity.State.ActivityMainState
        fun exposeAppActivityMainAction(): ModuleAppUiActivity.Action.ActivityMainAction
    }

}

