/*
 *  *********************************************************************************
 *  Created by Tezov on 06/05/2023 22:44
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 06/05/2023 22:33
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.navigation

import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import com.tezov.lib_core_android_kotlin.navigation.RouteManager
import com.tezov.lib_core_android_kotlin.navigation.bottom_navigation.BottomNavigationAction
import com.tezov.lib_core_android_kotlin.navigation.top_app_bar.TopAppBarAction
import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.dialog.DialogAction
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageAction

class NavigationController(
    val navigationController: com.tezov.lib_core_android_kotlin.navigation.NavigationController
) {
    companion object Route {

        //lobby
        object Splash : RouteManager.Route("splash")
        object Login : RouteManager.Route("login")
        object HelpAndService : RouteManager.Route("help_and_service")
        object NavLobby : RouteManager.Routes(
            "navLobby",
            child = setOf(Splash, Login, HelpAndService)
        )

        //auth
        object Account : RouteManager.Route("account")
        object Discover : RouteManager.Route("discover")
        object Payment : RouteManager.Route("payment")
        object Help : RouteManager.Route("help")
        object Profile : RouteManager.Route("Profile")
        object NavAuth : RouteManager.Routes(
            "navAuth",
            child = setOf(Account, Discover, Payment, Help, Profile)
        )

        val startNavRoute = NavLobby
        val startLobbyRoute = Splash
        val startAuthRoute = Account
    }

    val navHostController get() = navigationController.navHostController

    init {
        navigationController.routes.add(NavLobby)
        navigationController.routes.add(NavAuth)
        navigationController.addRequestManager(
            mapOf(
                TopAppBarAction::class to this::navigateFromTopAppBar,
                BottomNavigationAction::class to this::navigateFromBottomNavigation,
                PageAction::class to this::navigateFromPage,
                DialogAction::class to this::navigateFromDialog,
            )
        )
    }

    fun isLastRoute() = navigationController.isLastRoute()

    fun navigateBack() = navigationController.navigateBack()

    private fun navigateFromTopAppBar(from: RouteManager.Route?, to: RouteManager.Route) {
        with(navigationController) {
            when (to) {
                RouteManager.Back -> {
                    navigateBack()
                }
                else -> {
                    showSnackBarNotImplemented()
                }
            }
        }
    }

    private fun navigateFromBottomNavigation(from: RouteManager.Route?, to: RouteManager.Route) {
        with(navigationController) {
            navigate(to) {
                popUpTo(to.value) {
                    inclusive = false
                }
                launchSingleTop = true
            }
        }
    }

    private fun navigateFromPage(from: RouteManager.Route?, to: RouteManager.Route) {
        with(navigationController) {
            var showSnackBarNotImplemented = true
            when (from) {
                Route.Splash -> {
                    when (to) {
                        Route.Login -> {
                            navigate(to) {
                                popUpTo(from.value) {
                                    inclusive = true
                                }
                            }
                            showSnackBarNotImplemented = false
                        }
                    }
                }
                Route.Login -> {
                    when (to) {
                        Route.HelpAndService -> {
                            navigate(to)
                            showSnackBarNotImplemented = false
                        }
                    }
                }
            }
            if (showSnackBarNotImplemented) {
                showSnackBarNotImplemented()
            }
        }
    }

    private fun navigateFromDialog(from: RouteManager.Route?, to: RouteManager.Route) {
        with(navigationController) {
            var showSnackBarNotImplemented = true
            when (from) {
                Route.Login -> {
                    when (to) {
                        Route.Account -> {
                            navigate(to) {
                                popUpTo(from.value) {
                                    inclusive = true
                                }
                            }
                            showSnackBarNotImplemented = false
                        }
                    }
                }
            }
            if (showSnackBarNotImplemented) {
                showSnackBarNotImplemented()
            }
        }
    }
}




