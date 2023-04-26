/*
 *  *********************************************************************************
 *  Created by Tezov on 26/04/2023 21:07
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 26/04/2023 19:43
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.di.component

import com.tezov.bank.ui.activity.MainActivityAction
import com.tezov.bank.ui.activity.MainActivityState
import com.tezov.bank.ui.di.accessor.DiAccessorAppUiPage
import com.tezov.bank.ui.di.module.ModuleAppUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.annotation.scope.ScopeAppUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.component.ComponentContextLazy
import com.tezov.lib_core_android_kotlin.ui.di.component.ComponentCoreUiActivity
import dagger.Component

object ComponentAppUiActivity {

    @ScopeAppUiActivity
    @Component(
        dependencies = [ComponentCoreUiActivity.EntryPoint::class],
        modules = [ModuleAppUiActivity.MapperContext::class]
    )
    interface EntryPoint : ComponentCoreUiActivity.Exposer, Exposer {

        @Component.Factory
        interface Factory {
            fun create(
                componentCoreActivity: ComponentCoreUiActivity.EntryPoint,
            ): EntryPoint
        }

        fun accessorPage(): DiAccessorAppUiPage

        fun contextMain(): ComponentContextLazy<MainActivityState, MainActivityAction>

    }

    interface Exposer {

        fun exposeAppActivityMainState(): ModuleAppUiActivity.State.ActivityMainState
        fun exposeAppActivityMainAction(): ModuleAppUiActivity.Action.ActivityMainAction
    }

}

