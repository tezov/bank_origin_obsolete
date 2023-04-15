/*
 *  *********************************************************************************
 *  Created by Tezov on 15/04/2023 19:41
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 15/04/2023 18:51
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

        @ScopeAppUiPage
        @Provides
        fun provideContextAccount(
            state: State.PageAccountState,
            action: Action.PageAccountAction
        ) = ComponentContextLazy.make(state, action)

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
            ComposableHolder<com.tezov.bank.ui.page.lobby.splash.PageSplashState>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.page.lobby.splash.PageSplashState.create()
        }

        @ScopeAppUiPage
        class PageLoginState @Inject constructor() :
            ComposableHolder<com.tezov.bank.ui.page.lobby.login.PageLoginState>() {
            @androidx.compose.runtime.Composable
            override fun create() = com.tezov.bank.ui.page.lobby.login.PageLoginState.remember()
        }

        @ScopeAppUiPage
        class PageHelpAndServiceState @Inject constructor(
        ) : ComposableHolder<com.tezov.bank.ui.page.lobby.help_and_service.PageHelpAndServiceState>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.page.lobby.help_and_service.PageHelpAndServiceState.create()
        }

        @ScopeAppUiPage
        class PageAccountState @Inject constructor() :
            ComposableHolder<com.tezov.bank.ui.page.auth.account.PageAccountState>() {
            @androidx.compose.runtime.Composable
            override fun create() = com.tezov.bank.ui.page.auth.account.PageAccountState.create()
        }

        @ScopeAppUiPage
        class PageDiscoverState @Inject constructor() :
            ComposableHolder<com.tezov.bank.ui.page.auth.discover.PageDiscoverState>() {
            @androidx.compose.runtime.Composable
            override fun create() = com.tezov.bank.ui.page.auth.discover.PageDiscoverState.create()
        }

        @ScopeAppUiPage
        class PageHelpState @Inject constructor() :
            ComposableHolder<com.tezov.bank.ui.page.auth.help.PageHelpState>() {
            @androidx.compose.runtime.Composable
            override fun create() = com.tezov.bank.ui.page.auth.help.PageHelpState.create()
        }

        @ScopeAppUiPage
        class PagePaymentState @Inject constructor() :
            ComposableHolder<com.tezov.bank.ui.page.auth.payment.PagePaymentState>() {
            @androidx.compose.runtime.Composable
            override fun create() = com.tezov.bank.ui.page.auth.payment.PagePaymentState.create()
        }

        @ScopeAppUiPage
        class PageProfileState @Inject constructor() :
            ComposableHolder<com.tezov.bank.ui.page.auth.profile.PageProfileState>() {
            @androidx.compose.runtime.Composable
            override fun create() = com.tezov.bank.ui.page.auth.profile.PageProfileState.create()
        }

    }

    object Action {
        @ScopeAppUiPage
        class PageSplashAction @Inject constructor(
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
        ) : ComposableHolder<com.tezov.bank.ui.page.lobby.splash.PageSplashAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.page.lobby.splash.PageSplashAction.create(
                    navigationController.get()
                )
        }

        @ScopeAppUiPage
        class PageLoginAction @Inject constructor(
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
            private val dialogAction: ModuleCoreUiActivity.Action.DialogAction,
        ) : ComposableHolder<com.tezov.bank.ui.page.lobby.login.PageLoginAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.page.lobby.login.PageLoginAction.create(
                    navigationController.get(),
                    dialogAction.get()
                )
        }

        @ScopeAppUiPage
        class PageHelpAndServiceAction @Inject constructor(
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
        ) : ComposableHolder<com.tezov.bank.ui.page.lobby.help_and_service.PageHelpAndServiceAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.page.lobby.help_and_service.PageHelpAndServiceAction.create(
                    navigationController.get(),
                )
        }

        @ScopeAppUiPage
        class PageAccountAction @Inject constructor(
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
        ) : ComposableHolder<com.tezov.bank.ui.page.auth.account.PageAccountAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.page.auth.account.PageAccountAction.create(
                    navigationController.get()
                )
        }

        @ScopeAppUiPage
        class PageDiscoverAction @Inject constructor(
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
        ) : ComposableHolder<com.tezov.bank.ui.page.auth.discover.PageDiscoverAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.page.auth.discover.PageDiscoverAction.create(
                    navigationController.get()
                )
        }

        @ScopeAppUiPage
        class PageHelpAction @Inject constructor(
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
        ) : ComposableHolder<com.tezov.bank.ui.page.auth.help.PageHelpAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.page.auth.help.PageHelpAction.create(
                    navigationController.get()
                )
        }

        @ScopeAppUiPage
        class PagePaymentAction @Inject constructor(
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
        ) : ComposableHolder<com.tezov.bank.ui.page.auth.payment.PagePaymentAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.page.auth.payment.PagePaymentAction.create(
                    navigationController.get()
                )
        }

        @ScopeAppUiPage
        class PageProfileAction @Inject constructor(
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
        ) : ComposableHolder<com.tezov.bank.ui.page.auth.profile.PageProfileAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.page.auth.profile.PageProfileAction.create(
                    navigationController.get()
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