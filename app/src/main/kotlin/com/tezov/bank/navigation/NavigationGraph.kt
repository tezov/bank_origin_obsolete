/*
 *  *********************************************************************************
 *  Created by Tezov on 06/05/2023 16:45
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 06/05/2023 16:43
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.navigation

import androidx.compose.animation.*
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.*
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tezov.bank.navigation.NavigationController.Companion.Route
import com.tezov.bank.ui.activity.MainActivity
import com.tezov.bank.ui.di.accessor.DiAccessorAppUiActivity
import com.tezov.bank.ui.page.auth.account.PageAccount
import com.tezov.bank.ui.page.auth.discover.PageDiscover
import com.tezov.bank.ui.page.auth.help.PageHelp
import com.tezov.bank.ui.page.auth.payment.PagePayment
import com.tezov.bank.ui.page.auth.profile.PageProfile
import com.tezov.bank.ui.page.lobby.help_and_service.PageHelpAndService
import com.tezov.bank.ui.page.lobby.login.PageLogin
import com.tezov.bank.ui.page.lobby.splash.PageSplash
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalActivity
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action

object NavigationGraph {
    private const val TRANSITION_DURATION_ms = 350

    @Composable
    operator fun invoke() {
        graph()
    }

    @Composable
    private fun graph() {
        val accessor = DiAccessorAppUiActivity().with(LocalActivity.current)
        val mainAction = accessor.contextMain().action()

        NavHost(
            navController = mainAction.navigationController.navHostController,
            startDestination = NavigationController.startRoute.value,
        ) {
            navigation(startDestination  = Route.Splash.value, route = Route.NavLobby.value){
                composable(Route.Splash) {
                    PageSplash(PaddingValues())
                }
                composable(Route.Login) {
                    (LocalActivity.current as MainActivity).empty {
                        PageLogin(innerPadding = it)
                    }
                }
                composable(Route.HelpAndService) {
                    (LocalActivity.current as MainActivity).empty {
                        PageHelpAndService(innerPadding = it)
                    }
                }
            }
            navigation(startDestination  = Route.Account.value, route = Route.NavAuth.value){
                composable(Route.Account) {
                    (LocalActivity.current as MainActivity).withBottomNavigationBar {
                        PageAccount(innerPadding = it)
                    }
                }

                composable(Route.Discover) {
                    (LocalActivity.current as MainActivity).withBottomNavigationBar {
                        PageDiscover(innerPadding = it)
                    }
                }

                composable(Route.Help) {
                    (LocalActivity.current as MainActivity).withBottomNavigationBar {
                        PageHelp(innerPadding = it)
                    }
                }

                composable(Route.Profile) {
                    (LocalActivity.current as MainActivity).withBottomNavigationBar {
                        PageProfile(innerPadding = it)
                    }
                }

                composable(Route.Payment) {
                    (LocalActivity.current as MainActivity).withBottomNavigationBar {
                        PagePayment(innerPadding = it)
                    }
                }
            }
        }
    }


    private fun NavGraphBuilder.composable(
        route: Route,
        arguments: List<NamedNavArgument> = emptyList(),
        content: @Composable (NavBackStackEntry) -> Unit
    ) = composable(
        route = route.value,
        arguments = arguments,
        content = content
    )


}