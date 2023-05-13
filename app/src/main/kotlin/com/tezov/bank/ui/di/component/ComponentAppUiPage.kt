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

package com.tezov.bank.ui.di.component

import com.tezov.bank.ui.di.accessor.DiAccessorAppUiDialog
import com.tezov.bank.ui.di.module.ModuleAppUiPage
import com.tezov.bank.ui.dialog.auth.closeAppConfirmation.DialogAuthCloseAppController
import com.tezov.bank.ui.pageMain.auth.account.PageAccountAction
import com.tezov.bank.ui.pageMain.auth.account.PageAccountState
import com.tezov.bank.ui.pageMain.auth.discover.PageDiscoverAction
import com.tezov.bank.ui.pageMain.auth.discover.PageDiscoverState
import com.tezov.bank.ui.pageMain.auth.help.PageHelpAction
import com.tezov.bank.ui.pageMain.auth.help.PageHelpState
import com.tezov.bank.ui.pageMain.auth.payment.PagePaymentAction
import com.tezov.bank.ui.pageMain.auth.payment.PagePaymentState
import com.tezov.bank.ui.pageMain.auth.profile.PageProfileAction
import com.tezov.bank.ui.pageMain.auth.profile.PageProfileState
import com.tezov.bank.ui.pageMain.lobby.help_and_service.PageHelpAndServiceAction
import com.tezov.bank.ui.pageMain.lobby.help_and_service.PageHelpAndServiceState
import com.tezov.bank.ui.pageMain.lobby.login.PageLoginAction
import com.tezov.bank.ui.pageMain.lobby.login.PageLoginState
import com.tezov.bank.ui.pageMain.lobby.splash.PageSplashAction
import com.tezov.bank.ui.pageMain.lobby.splash.PageSplashState
import com.tezov.bank.ui.pageSecondary.auth.messageInfo.PageMessageInfoAction
import com.tezov.bank.ui.pageSecondary.auth.messageInfo.PageMessageInfoState
import com.tezov.lib_core_android_kotlin.ui.di.annotation.scope.ScopeAppUiPage
import com.tezov.lib_core_android_kotlin.ui.di.component.ComponentContextLazy
import com.tezov.lib_core_android_kotlin.ui.di.component.ComponentCoreUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.component.ComponentCoreUiPage
import com.tezov.lib_core_android_kotlin.ui.di.component.ComponentLazy
import dagger.Component

object ComponentAppUiPage {

    @ScopeAppUiPage
    @Component(
        dependencies = [ComponentCoreUiPage.EntryPoint::class, ComponentAppUiActivity.EntryPoint::class],
        modules = [ModuleAppUiPage.MapperContext::class]
    )
    interface EntryPoint : ComponentCoreUiActivity.Exposer {

        @Component.Factory
        interface Factory {
            fun create(
                componentCorePage: ComponentCoreUiPage.EntryPoint,
                componentAppActivity: ComponentAppUiActivity.EntryPoint
            ): EntryPoint
        }

        fun accessorDialog(): DiAccessorAppUiDialog

        fun contextSplash(): ComponentContextLazy<PageSplashState, PageSplashAction>
        fun contextLogin(): ComponentContextLazy<PageLoginState, PageLoginAction>
        fun contextHelpAndService(): ComponentContextLazy<PageHelpAndServiceState, PageHelpAndServiceAction>

        //------------ *******
        fun contextAccount(): ComponentContextLazy<PageAccountState, PageAccountAction>
        fun contextMessageInfo(): ComponentContextLazy<PageMessageInfoState, PageMessageInfoAction>
        //............ *******

        fun contextDiscover(): ComponentContextLazy<PageDiscoverState, PageDiscoverAction>
        fun contextPayment(): ComponentContextLazy<PagePaymentState, PagePaymentAction>
        fun contextProfile(): ComponentContextLazy<PageProfileState, PageProfileAction>
        fun contextHelp(): ComponentContextLazy<PageHelpState, PageHelpAction>

        fun controllerDialogAuthCloseApp(): ComponentLazy<DialogAuthCloseAppController>

    }


}

