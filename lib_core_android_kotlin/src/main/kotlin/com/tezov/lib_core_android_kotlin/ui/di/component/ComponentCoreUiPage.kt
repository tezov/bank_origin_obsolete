package com.tezov.lib_core_android_kotlin.ui.di.component

import com.tezov.lib_core_android_kotlin.ui.di.accessor.AccessorCoreUiDialog
import com.tezov.lib_core_android_kotlin.ui.di.annotation.scope.ScopeCoreUiPage
import dagger.Component


object ComponentCoreUiPage {

    @ScopeCoreUiPage
    @Component(
        dependencies = [ComponentCoreUiActivity.EntryPoint::class],
        modules = []
    )
    interface EntryPoint {

        @Component.Factory
        interface Factory {
            fun create(componentCoreActivity: ComponentCoreUiActivity.EntryPoint): EntryPoint
        }

        fun accessorDialog(): AccessorCoreUiDialog

    }

}

