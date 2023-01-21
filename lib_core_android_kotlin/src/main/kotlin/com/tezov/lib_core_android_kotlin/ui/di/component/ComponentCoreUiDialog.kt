package com.tezov.lib_core_android_kotlin.ui.di.component

import com.tezov.lib_core_android_kotlin.ui.di.annotation.scope.ScopeCoreUiDialog
import dagger.Component

object ComponentCoreUiDialog {

    @ScopeCoreUiDialog
    @Component(
        dependencies = [ComponentCoreUiPage.EntryPoint::class],
        modules = []
    )
    interface EntryPoint {

        @Component.Factory
        interface Factory {
            fun create(componentCorePage: ComponentCoreUiPage.EntryPoint): EntryPoint
        }

    }
}

