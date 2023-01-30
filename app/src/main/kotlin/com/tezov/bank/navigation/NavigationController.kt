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

package com.tezov.bank.navigation

import com.tezov.bank.ui.page.login.PageLoginAction
import com.tezov.bank.ui.page.splash.PageSplashAction
import com.tezov.lib_core_android_kotlin.navigation.RouteManager
import com.tezov.lib_core_android_kotlin.navigation.bottom_navigation.BottomNavigationAction
import com.tezov.lib_core_android_kotlin.navigation.top_app_bar.TopAppBarAction

class NavigationController(
    private val navigationController: com.tezov.lib_core_android_kotlin.navigation.NavigationController
) {
    companion object{
        sealed class Route(value:String):RouteManager.Route(value) {

            object Splash : Route("splash")
            object Login : Route("login")
            object HelpAndService : Route("help_and_service")

            companion object{
                val items get():Set<RouteManager.Route> = setOf(
                    Splash,
                    Login,
                    HelpAndService,
                )

            }
        }

        val startRoute = Route.Splash
    }

    val navHostController get() = navigationController.navHostController

    init {
        navigationController.routes.add(Route.items)
        navigationController.addAction(mapOf(
            TopAppBarAction::class to this::navigateFromTopAppBar,
            BottomNavigationAction::class to this::navigateFromBottomNavigation,
            PageSplashAction::class to this::navigateFromSplashPage,
            PageLoginAction::class to this::navigateFromLoginPage,

        ))
    }

    private fun navigateFromTopAppBar(from: RouteManager.Route?, to: RouteManager.Route){
        with(navigationController){
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

    private fun navigateFromBottomNavigation(from: RouteManager.Route?, to: RouteManager.Route){
        with(navigationController){
            navigate(to) {
                popUpTo(to.value) {
                    inclusive = false
                }
                launchSingleTop = true
            }
        }
    }

    private fun navigateFromSplashPage(from: RouteManager.Route?, to: RouteManager.Route){
        with(navigationController){
            navigate(to) {
                popUpTo(Route.Splash.value) {
                    inclusive = true
                }
                launchSingleTop = true
            }
        }
    }

    private fun navigateFromLoginPage(from: RouteManager.Route?, to: RouteManager.Route){
        with(navigationController){
            when(to){
                Route.HelpAndService -> {
                    navigate(to) {
                        launchSingleTop = true
                    }
                }
                else -> {
                    showSnackBarNotImplemented()
                }
            }
        }
    }
}




