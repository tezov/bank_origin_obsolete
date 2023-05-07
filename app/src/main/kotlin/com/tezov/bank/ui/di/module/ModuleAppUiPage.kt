/*
 *  *********************************************************************************
 *  Created by Tezov on 07/05/2023 17:18
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 07/05/2023 16:29
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.di.module

import com.tezov.lib_core_android_kotlin.ui.di.annotation.scope.ScopeAppUiPage
import com.tezov.lib_core_android_kotlin.ui.di.component.ComponentContextLazy
import com.tezov.lib_core_android_kotlin.ui.di.component.ComponentLazy
import com.tezov.lib_core_android_kotlin.ui.di.helper.ComposableHolder
import com.tezov.lib_core_android_kotlin.ui.di.module.ModuleCoreUiActivity
import dagger.Module
import dagger.Provides
import javax.inject.Inject


interface ModuleAppUiPage {

    @Module
    class MapperContext {

        @ScopeAppUiPage
        @Provides
        fun provideDialogAuthCloseAppController(
            ref: Misc.DialogAuthCloseAppController
        ) = ComponentLazy.make(ref)

        @ScopeAppUiPage
        @Provides
        fun provideContextSplash(
            state: State.PageSplashState,
            action: Action.PageSplashAction
        ) = ComponentContextLazy.make(state, action)


        @ScopeAppUiPage
        @Provides
        fun provideContextLogin(
            state: State.PageLoginState,
            action: Action.PageLoginAction
        ) = ComponentContextLazy.make(state, action)


        @ScopeAppUiPage
        @Provides
        fun provideContextHelpAndService(
            state: State.PageHelpAndServiceState,
            action: Action.PageHelpAndServiceAction
        ) = ComponentContextLazy.make(state, action)

        //------------ *******
        @ScopeAppUiPage
        @Provides
        fun provideContextAccount(
            state: State.PageAccountState,
            action: Action.PageAccountAction
        ) = ComponentContextLazy.make(state, action)

        @ScopeAppUiPage
        @Provides
        fun provideContextMessageInfo(
            state: State.PageMessageInfoState,
            action: Action.PageMessageInfoAction
        ) = ComponentContextLazy.make(state, action)
        //............ *******

        @ScopeAppUiPage
        @Provides
        fun provideContextDiscover(
            state: State.PageDiscoverState,
            action: Action.PageDiscoverAction
        ) = ComponentContextLazy.make(state, action)

        @ScopeAppUiPage
        @Provides
        fun provideContextHelp(
            state: State.PageHelpState,
            action: Action.PageHelpAction
        ) = ComponentContextLazy.make(state, action)

        @ScopeAppUiPage
        @Provides
        fun provideContextPayment(
            state: State.PagePaymentState,
            action: Action.PagePaymentAction
        ) = ComponentContextLazy.make(state, action)

        @ScopeAppUiPage
        @Provides
        fun provideContextProfile(
            state: State.PageProfileState,
            action: Action.PageProfileAction
        ) = ComponentContextLazy.make(state, action)

    }

    object State {
        @ScopeAppUiPage
        class PageSplashState @Inject constructor() :
            ComposableHolder<com.tezov.bank.ui.pageMain.lobby.splash.PageSplashState>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.pageMain.lobby.splash.PageSplashState.create()
        }

        @ScopeAppUiPage
        class PageLoginState @Inject constructor() :
            ComposableHolder<com.tezov.bank.ui.pageMain.lobby.login.PageLoginState>() {
            @androidx.compose.runtime.Composable
            override fun create() = com.tezov.bank.ui.pageMain.lobby.login.PageLoginState.create()
        }

        @ScopeAppUiPage
        class PageHelpAndServiceState @Inject constructor(
        ) : ComposableHolder<com.tezov.bank.ui.pageMain.lobby.help_and_service.PageHelpAndServiceState>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.pageMain.lobby.help_and_service.PageHelpAndServiceState.create()
        }

        //------------ *******
        @ScopeAppUiPage
        class PageAccountState @Inject constructor() :
            ComposableHolder<com.tezov.bank.ui.pageMain.auth.account.PageAccountState>() {
            @androidx.compose.runtime.Composable
            override fun create() = com.tezov.bank.ui.pageMain.auth.account.PageAccountState.create()
        }

        @ScopeAppUiPage
        class PageMessageInfoState @Inject constructor() :
            ComposableHolder<com.tezov.bank.ui.pageSecondary.auth.messageInfo.PageMessageInfoState>() {
            @androidx.compose.runtime.Composable
            override fun create() = com.tezov.bank.ui.pageSecondary.auth.messageInfo.PageMessageInfoState.create()
        }
        //............ *******

        @ScopeAppUiPage
        class PageDiscoverState @Inject constructor() :
            ComposableHolder<com.tezov.bank.ui.pageMain.auth.discover.PageDiscoverState>() {
            @androidx.compose.runtime.Composable
            override fun create() = com.tezov.bank.ui.pageMain.auth.discover.PageDiscoverState.create()
        }

        @ScopeAppUiPage
        class PageHelpState @Inject constructor() :
            ComposableHolder<com.tezov.bank.ui.pageMain.auth.help.PageHelpState>() {
            @androidx.compose.runtime.Composable
            override fun create() = com.tezov.bank.ui.pageMain.auth.help.PageHelpState.create()
        }

        @ScopeAppUiPage
        class PagePaymentState @Inject constructor() :
            ComposableHolder<com.tezov.bank.ui.pageMain.auth.payment.PagePaymentState>() {
            @androidx.compose.runtime.Composable
            override fun create() = com.tezov.bank.ui.pageMain.auth.payment.PagePaymentState.create()
        }

        @ScopeAppUiPage
        class PageProfileState @Inject constructor() :
            ComposableHolder<com.tezov.bank.ui.pageMain.auth.profile.PageProfileState>() {
            @androidx.compose.runtime.Composable
            override fun create() = com.tezov.bank.ui.pageMain.auth.profile.PageProfileState.create()
        }

    }

    object Action {
        @ScopeAppUiPage
        class PageSplashAction @Inject constructor(
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
        ) : ComposableHolder<com.tezov.bank.ui.pageMain.lobby.splash.PageSplashAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.pageMain.lobby.splash.PageSplashAction.create(
                    navigationController.get()
                )
        }

        @ScopeAppUiPage
        class PageLoginAction @Inject constructor(
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
            private val dialogAction: ModuleCoreUiActivity.Action.DialogAction,
        ) : ComposableHolder<com.tezov.bank.ui.pageMain.lobby.login.PageLoginAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.pageMain.lobby.login.PageLoginAction.create(
                    navigationController.get(),
                    dialogAction.get()
                )
        }

        @ScopeAppUiPage
        class PageHelpAndServiceAction @Inject constructor(
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
        ) : ComposableHolder<com.tezov.bank.ui.pageMain.lobby.help_and_service.PageHelpAndServiceAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.pageMain.lobby.help_and_service.PageHelpAndServiceAction.create(
                    navigationController.get(),
                )
        }

        //------------ *******
        @ScopeAppUiPage
        class PageAccountAction @Inject constructor(
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
            private val bottomSheetAction: ModuleCoreUiActivity.Action.BottomSheetAction,
        ) : ComposableHolder<com.tezov.bank.ui.pageMain.auth.account.PageAccountAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.pageMain.auth.account.PageAccountAction.create(
                    navigationController.get(),
                    bottomSheetAction.get()
                )
        }

        @ScopeAppUiPage
        class PageMessageInfoAction @Inject constructor(
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
        ) : ComposableHolder<com.tezov.bank.ui.pageSecondary.auth.messageInfo.PageMessageInfoAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.pageSecondary.auth.messageInfo.PageMessageInfoAction.create(
                    navigationController.get(),
                )
        }
        //............ *******

        @ScopeAppUiPage
        class PageDiscoverAction @Inject constructor(
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
        ) : ComposableHolder<com.tezov.bank.ui.pageMain.auth.discover.PageDiscoverAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.pageMain.auth.discover.PageDiscoverAction.create(
                    navigationController.get()
                )
        }

        @ScopeAppUiPage
        class PageHelpAction @Inject constructor(
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
        ) : ComposableHolder<com.tezov.bank.ui.pageMain.auth.help.PageHelpAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.pageMain.auth.help.PageHelpAction.create(
                    navigationController.get()
                )
        }

        @ScopeAppUiPage
        class PagePaymentAction @Inject constructor(
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
        ) : ComposableHolder<com.tezov.bank.ui.pageMain.auth.payment.PagePaymentAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.pageMain.auth.payment.PagePaymentAction.create(
                    navigationController.get()
                )
        }

        @ScopeAppUiPage
        class PageProfileAction @Inject constructor(
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
            private val dialogAction: ModuleCoreUiActivity.Action.DialogAction,
        ) : ComposableHolder<com.tezov.bank.ui.pageMain.auth.profile.PageProfileAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.pageMain.auth.profile.PageProfileAction.create(
                    navigationController.get(),
                    dialogAction.get()
                )
        }
    }

    object Misc {

        @ScopeAppUiPage
        class DialogAuthCloseAppController @Inject constructor(
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
            private val dialogAction: ModuleCoreUiActivity.Action.DialogAction,
        ) : ComposableHolder<com.tezov.bank.ui.dialog.auth.closeAppConfirmation.DialogAuthCloseAppController>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.dialog.auth.closeAppConfirmation.DialogAuthCloseAppController.create(
                    navigationController.get(),
                    dialogAction.get()
                )
        }

    }

}