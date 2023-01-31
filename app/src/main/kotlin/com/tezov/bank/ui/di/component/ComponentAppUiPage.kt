/*
 *  *********************************************************************************
 *  Created by Tezov on 31/01/2023 20:01
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 31/01/2023 19:44
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
import com.tezov.bank.ui.page.account.PageAccountAction
import com.tezov.bank.ui.page.account.PageAccountState
import com.tezov.bank.ui.page.discover.PageDiscoverAction
import com.tezov.bank.ui.page.discover.PageDiscoverState
import com.tezov.bank.ui.page.help.PageHelpAction
import com.tezov.bank.ui.page.help.PageHelpState
import com.tezov.bank.ui.page.payment.PagePaymentAction
import com.tezov.bank.ui.page.payment.PagePaymentState
import com.tezov.bank.ui.page.profile.PageProfileAction
import com.tezov.bank.ui.page.profile.PageProfileState
import com.tezov.bank.ui.page.splash.PageSplashAction
import com.tezov.bank.ui.page.splash.PageSplashState
import com.tezov.lib_core_android_kotlin.ui.di.annotation.scope.ScopeAppUiPage
import com.tezov.lib_core_android_kotlin.ui.di.component.*
import dagger.Component

object ComponentAppUiPage {

    @ScopeAppUiPage
    @Component(dependencies = [ComponentCoreUiPage.EntryPoint::class, ComponentAppUiActivity.EntryPoint::class], modules = [ModuleAppUiPage.MapperContext::class])
    interface EntryPoint: ComponentCoreUiActivity.Exposer  {

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

        fun contextAccount(): ComponentContextLazy<PageAccountState, PageAccountAction>
        fun contextDiscover(): ComponentContextLazy<PageDiscoverState, PageDiscoverAction>
        fun contextPayment(): ComponentContextLazy<PagePaymentState, PagePaymentAction>
        fun contextProfile(): ComponentContextLazy<PageProfileState, PageProfileAction>
        fun contextHelp(): ComponentContextLazy<PageHelpState, PageHelpAction>

    }


}

