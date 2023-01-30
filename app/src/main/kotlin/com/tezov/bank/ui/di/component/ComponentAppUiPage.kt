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

import com.tezov.bank.ui.di.accessor.AccessorAppUiDialog
import com.tezov.bank.ui.di.module.ModuleAppUiPage
import com.tezov.bank.ui.page.help_and_service.PageHelpAndServiceAction
import com.tezov.bank.ui.page.help_and_service.PageHelpAndServiceState
import com.tezov.bank.ui.page.login.PageLoginAction
import com.tezov.bank.ui.page.login.PageLoginState
import com.tezov.bank.ui.page.splash.PageSplashAction
import com.tezov.bank.ui.page.splash.PageSplashState
import com.tezov.lib_core_android_kotlin.ui.di.annotation.scope.ScopeAppUiPage
import com.tezov.lib_core_android_kotlin.ui.di.component.*
import dagger.Component

object ComponentAppUiPage {

    @ScopeAppUiPage
    @Component(dependencies = [ComponentCoreUiPage.EntryPoint::class, ComponentAppUiActivity.EntryPoint::class], modules = [ModuleAppUiPage.MapperContext::class])
    interface EntryPoint: ComponentCoreUiActivity.Exposer, Exposer  {

        @Component.Factory
        interface Factory {
            fun create(
                componentCorePage: ComponentCoreUiPage.EntryPoint,
                componentAppActivity: ComponentAppUiActivity.EntryPoint
            ): EntryPoint
        }
        fun accessorDialog(): AccessorAppUiDialog

        fun contextSplash(): ComponentContextLazy<PageSplashState, PageSplashAction>
        fun contextLogin(): ComponentContextLazy<PageLoginState, PageLoginAction>
        fun contextHelpAndService(): ComponentContextLazy<PageHelpAndServiceState, PageHelpAndServiceAction>

    }

    interface Exposer {

//        fun exposeAppPageSplashState(): ModuleAppUiPage.State.PageSplashState
//        fun exposeAppPageSplashAction(): ModuleAppUiPage.Action.PageSplashAction
//
//        fun exposeAppPageLoginState(): ModuleAppUiPage.State.PageLoginState
//        fun exposeAppPageLoginAction(): ModuleAppUiPage.Action.PageLoginAction
//
//        fun exposeAppPageHelpAndServiceState(): ModuleAppUiPage.State.PageHelpAndServiceState
//        fun exposeAppPageHelpAndServiceAction(): ModuleAppUiPage.Action.PageHelpAndServiceAction
    }

}

