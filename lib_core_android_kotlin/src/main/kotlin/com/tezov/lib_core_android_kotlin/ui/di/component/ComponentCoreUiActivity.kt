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

package com.tezov.lib_core_android_kotlin.ui.di.component

import com.tezov.lib_core_android_kotlin.ui.activity.ActivityMainAction
import com.tezov.lib_core_android_kotlin.ui.activity.ActivityMainState
import com.tezov.lib_core_android_kotlin.ui.di.accessor.DiAccessorCoreUiPage
import com.tezov.lib_core_android_kotlin.ui.di.annotation.qualifier.QualifierCoroutineScopeMain
import com.tezov.lib_core_android_kotlin.ui.di.annotation.scope.ScopeCoreUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.module.ModuleCoreUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.module.ModuleCoreUiActivity.Action
import com.tezov.lib_core_android_kotlin.ui.di.module.ModuleCoreUiActivity.State
import dagger.Component

object ComponentCoreUiActivity {

    @ScopeCoreUiActivity
    @Component(
        dependencies = [],
        modules = [ModuleCoreUiActivity.Provider::class, ModuleCoreUiActivity.MapperContext::class]
    )
    interface EntryPoint : Exposer {
        @Component.Factory
        interface Factory {
            fun create(): EntryPoint
        }

        fun accessorPage(): DiAccessorCoreUiPage

        fun contextMain(): ComponentContextLazy<ActivityMainState, ActivityMainAction>

        fun contextSubMap(): ComponentContextMap

    }

    interface Exposer {
        fun exposeCoreActivityMainState(): State.ActivityMainState
        fun exposeCoreActivityMainAction(): Action.ActivityMainAction

        fun exposeCoreBottomSheetState(): State.BottomSheetState
        fun exposeCoreBottomSheetAction(): Action.BottomSheetAction
        fun exposeCoreDialogState(): State.DialogState
        fun exposeCoreDialogAction(): Action.DialogAction
        fun exposeCoreSnackbarState(): State.SnackbarState
        fun exposeCoreSnackbarAction(): Action.SnackbarAction
        fun exposeCoreBottomNavigationState(): State.BottomNavigationState
        fun exposeCoreBottomNavigationAction(): Action.BottomNavigationAction
        fun exposeCoreTopNavigationState(): State.TopNavigationState
        fun exposeCoreTopNavigationAction(): Action.TopNavigationAction

        @QualifierCoroutineScopeMain
        fun exposeCoreCoroutineScope(): State.CoroutineScope
        fun exposeCoreScaffoldState(): State.ScaffoldState
        fun exposeCoreNavigationController(): Action.NavigationController
    }
}
