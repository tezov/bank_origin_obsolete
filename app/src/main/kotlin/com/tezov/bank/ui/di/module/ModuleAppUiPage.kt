/*
 *  *********************************************************************************
 *  Created by Tezov on 31/01/2023 20:01
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 31/01/2023 19:34
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.di.module

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
import com.tezov.lib_core_android_kotlin.ui.di.helper.ComposableHolder
import com.tezov.lib_core_android_kotlin.ui.di.module.ModuleCoreUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.annotation.scope.ScopeAppUiPage
import com.tezov.lib_core_android_kotlin.ui.di.component.ComponentContextLazy
import dagger.Module
import dagger.Provides
import javax.inject.Inject


interface ModuleAppUiPage {

    @Module
    class MapperContext{

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
            ComposableHolder<com.tezov.bank.ui.page.splash.PageSplashState>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.page.splash.PageSplashState.create()
        }

        @ScopeAppUiPage
        class PageLoginState @Inject constructor() :
            ComposableHolder<com.tezov.bank.ui.page.login.PageLoginState>() {
            @androidx.compose.runtime.Composable
            override fun create() = com.tezov.bank.ui.page.login.PageLoginState.remember()
        }

        @ScopeAppUiPage
        class PageHelpAndServiceState @Inject constructor(
        ) : ComposableHolder<com.tezov.bank.ui.page.help_and_service.PageHelpAndServiceState>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.page.help_and_service.PageHelpAndServiceState.create()
        }

        @ScopeAppUiPage
        class PageAccountState @Inject constructor() :
            ComposableHolder<com.tezov.bank.ui.page.account.PageAccountState>() {
            @androidx.compose.runtime.Composable
            override fun create() = com.tezov.bank.ui.page.account.PageAccountState.create()
        }

        @ScopeAppUiPage
        class PageDiscoverState @Inject constructor() :
            ComposableHolder<com.tezov.bank.ui.page.discover.PageDiscoverState>() {
            @androidx.compose.runtime.Composable
            override fun create() = com.tezov.bank.ui.page.discover.PageDiscoverState.create()
        }

        @ScopeAppUiPage
        class PageHelpState @Inject constructor() :
            ComposableHolder<com.tezov.bank.ui.page.help.PageHelpState>() {
            @androidx.compose.runtime.Composable
            override fun create() = com.tezov.bank.ui.page.help.PageHelpState.create()
        }

        @ScopeAppUiPage
        class PagePaymentState @Inject constructor() :
            ComposableHolder<com.tezov.bank.ui.page.payment.PagePaymentState>() {
            @androidx.compose.runtime.Composable
            override fun create() = com.tezov.bank.ui.page.payment.PagePaymentState.create()
        }

        @ScopeAppUiPage
        class PageProfileState @Inject constructor() :
            ComposableHolder<com.tezov.bank.ui.page.profile.PageProfileState>() {
            @androidx.compose.runtime.Composable
            override fun create() = com.tezov.bank.ui.page.profile.PageProfileState.create()
        }

    }

    object Action {
        @ScopeAppUiPage
        class PageSplashAction @Inject constructor(
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
        ) : ComposableHolder<com.tezov.bank.ui.page.splash.PageSplashAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.page.splash.PageSplashAction.create(
                    navigationController.get()
                )
        }

        @ScopeAppUiPage
        class PageLoginAction @Inject constructor(
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
            private val dialogAction: ModuleCoreUiActivity.Action.DialogAction,
        ) : ComposableHolder<com.tezov.bank.ui.page.login.PageLoginAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.page.login.PageLoginAction.create(
                    navigationController.get(),
                    dialogAction.get()
                )
        }

        @ScopeAppUiPage
        class PageHelpAndServiceAction @Inject constructor(
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
        ) : ComposableHolder<com.tezov.bank.ui.page.help_and_service.PageHelpAndServiceAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.page.help_and_service.PageHelpAndServiceAction.create(
                    navigationController.get(),
                )
        }

        @ScopeAppUiPage
        class PageAccountAction @Inject constructor(
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
        ) : ComposableHolder<com.tezov.bank.ui.page.account.PageAccountAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.page.account.PageAccountAction.create(
                    navigationController.get()
                )
        }

        @ScopeAppUiPage
        class PageDiscoverAction @Inject constructor(
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
        ) : ComposableHolder<com.tezov.bank.ui.page.discover.PageDiscoverAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.page.discover.PageDiscoverAction.create(
                    navigationController.get()
                )
        }

        @ScopeAppUiPage
        class PageHelpAction @Inject constructor(
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
        ) : ComposableHolder<com.tezov.bank.ui.page.help.PageHelpAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.page.help.PageHelpAction.create(
                    navigationController.get()
                )
        }

        @ScopeAppUiPage
        class PagePaymentAction @Inject constructor(
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
        ) : ComposableHolder<com.tezov.bank.ui.page.payment.PagePaymentAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.page.payment.PagePaymentAction.create(
                    navigationController.get()
                )
        }

        @ScopeAppUiPage
        class PageProfileAction @Inject constructor(
            private val navigationController: ModuleCoreUiActivity.Action.NavigationController,
        ) : ComposableHolder<com.tezov.bank.ui.page.profile.PageProfileAction>() {
            @androidx.compose.runtime.Composable
            override fun create() =
                com.tezov.bank.ui.page.profile.PageProfileAction.create(
                    navigationController.get()
                )
        }


    }

}