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

package com.tezov.bank.ui.di.module

import com.tezov.bank.ui.page.help_and_service.PageHelpAndServiceAction
import com.tezov.bank.ui.page.help_and_service.PageHelpAndServiceState
import com.tezov.bank.ui.page.login.PageLoginAction
import com.tezov.bank.ui.page.login.PageLoginState
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
        ): ComponentContextLazy<PageSplashState, PageSplashAction> =
            object :
                ComponentContextLazy<PageSplashState, PageSplashAction> {

                override fun lazyState() = state

                override fun lazyAction() = action

            }

        @ScopeAppUiPage
        @Provides
        fun provideContextLogin(
            state: State.PageLoginState,
            action: Action.PageLoginAction
        ): ComponentContextLazy<PageLoginState, PageLoginAction> =
            object :
                ComponentContextLazy<PageLoginState, PageLoginAction> {

                override fun lazyState() = state

                override fun lazyAction() = action

            }


        @ScopeAppUiPage
        @Provides
        fun provideContextHelp(
            state: State.PageHelpAndServiceState,
            action: Action.PageHelpAndServiceAction
        ): ComponentContextLazy<PageHelpAndServiceState, PageHelpAndServiceAction> =
            object : ComponentContextLazy<PageHelpAndServiceState, PageHelpAndServiceAction> {

                override fun lazyState() = state

                override fun lazyAction() = action

            }

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

    }

}