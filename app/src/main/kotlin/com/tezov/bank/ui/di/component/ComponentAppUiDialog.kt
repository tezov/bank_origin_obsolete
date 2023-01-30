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

import com.tezov.bank.ui.di.module.ModuleAppUiDialog
import com.tezov.bank.ui.dialog.login.auth.DialogLoginAuthAction
import com.tezov.bank.ui.dialog.login.auth.DialogLoginAuthState
import com.tezov.lib_core_android_kotlin.ui.di.component.ComponentCoreUiDialog
import com.tezov.lib_core_android_kotlin.ui.di.annotation.scope.ScopeAppUiDialog
import com.tezov.lib_core_android_kotlin.ui.di.component.ComponentContextLazy
import dagger.Component

object ComponentAppUiDialog {

    @ScopeAppUiDialog
    @Component(dependencies = [ComponentCoreUiDialog.EntryPoint::class, ComponentAppUiPage.EntryPoint::class], modules = [ModuleAppUiDialog.MapperContext::class])
    interface EntryPoint:Exposer {

        @Component.Factory
        interface Factory{
            fun create(componentCore: ComponentCoreUiDialog.EntryPoint, componentAppPage: ComponentAppUiPage.EntryPoint): EntryPoint
        }

        fun contextLoginAuth(): ComponentContextLazy<DialogLoginAuthState, DialogLoginAuthAction>

    }

    interface Exposer {

//        fun exposeAppLoginAuthState(): ModuleAppUiDialog.State.DialogLoginAuthState
//        fun exposeAppLoginAuthAction(): ModuleAppUiDialog.Action.DialogLoginAuthAction

    }

}

