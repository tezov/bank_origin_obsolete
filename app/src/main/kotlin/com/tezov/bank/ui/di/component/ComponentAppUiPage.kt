/*
 *  *********************************************************************************
 *  Created by Tezov on 08/02/2023 21:11
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/02/2023 20:19
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.di.component

import com.tezov.bank.ui.di.accessor.AccessorAppUiDialog
import com.tezov.bank.ui.di.module.ModuleAppUiPage
import com.tezov.bank.ui.dialog.auth.closeAppConfirmation.DialogAuthCloseAppController
import com.tezov.bank.ui.page.lobby.help_and_service.PageHelpAndServiceAction
import com.tezov.bank.ui.page.lobby.help_and_service.PageHelpAndServiceState
import com.tezov.bank.ui.page.lobby.login.PageLoginAction
import com.tezov.bank.ui.page.lobby.login.PageLoginState
import com.tezov.bank.ui.page.auth.account.PageAccountAction
import com.tezov.bank.ui.page.auth.account.PageAccountState
import com.tezov.bank.ui.page.auth.discover.PageDiscoverAction
import com.tezov.bank.ui.page.auth.discover.PageDiscoverState
import com.tezov.bank.ui.page.auth.help.PageHelpAction
import com.tezov.bank.ui.page.auth.help.PageHelpState
import com.tezov.bank.ui.page.auth.payment.PagePaymentAction
import com.tezov.bank.ui.page.auth.payment.PagePaymentState
import com.tezov.bank.ui.page.auth.profile.PageProfileAction
import com.tezov.bank.ui.page.auth.profile.PageProfileState
import com.tezov.bank.ui.page.lobby.splash.PageSplashAction
import com.tezov.bank.ui.page.lobby.splash.PageSplashState
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

        fun controllerDialogAuthCloseApp(): ComponentLazy<DialogAuthCloseAppController>

    }


}

