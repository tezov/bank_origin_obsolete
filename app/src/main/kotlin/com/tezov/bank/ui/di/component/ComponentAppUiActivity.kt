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

