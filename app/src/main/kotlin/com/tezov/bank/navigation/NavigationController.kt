/*
 *  *********************************************************************************
 *  Created by Tezov on 15/04/2023 16:15
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 15/04/2023 15:39
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.navigation

import android.util.Log
import com.tezov.lib_core_android_kotlin.navigation.RouteManager
import com.tezov.lib_core_android_kotlin.navigation.bottom_navigation.BottomNavigationAction
import com.tezov.lib_core_android_kotlin.navigation.top_app_bar.TopAppBarAction
import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.dialog.DialogAction
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageAction
import kotlin.math.log

class NavigationController(
    val navigationController: com.tezov.lib_core_android_kotlin.navigation.NavigationController
) {
    companion object{
        sealed class Route(value:String):RouteManager.Route(value) {

            //lobby
            object Splash : Route("splash")
            object Login : Route("login")
            object HelpAndService : Route("help_and_service")

            //auth
            object Account : Route("account")
            object Discover : Route("discover")
            object Payment : Route("payment")
            object Help : Route("help")
            object Profile : Route("Profile")

            companion object{
                val items get():Set<RouteManager.Route> = setOf(
                    Splash,
                    Login,
                    HelpAndService,
                    Discover,
                    Payment,
                    Help,
                    Profile,
                    Account,
                )
            }
        }

        val startRoute = Route.Discover
    }

    val navHostController get() = navigationController.navHostController

    init {
        navigationController.routes.add(Route.items)
        navigationController.addAction(mapOf(
            TopAppBarAction::class to this::navigateFromTopAppBar,
            BottomNavigationAction::class to this::navigateFromBottomNavigation,
            PageAction::class to this::navigateFromPage,
            DialogAction::class to this::navigateFromDialog,
        ))
    }

    fun isLastRoute() = navigationController.isLastRoute()

    fun navigateBack() = navigationController.navigateBack()

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

    private fun navigateFromPage(from: RouteManager.Route?, to: RouteManager.Route){
        with(navigationController){
            var showSnackBarNotImplemented = true
            when(from){
                Route.Splash -> {
                    when(to){
                        Route.Login -> {
                            navigate(to) {
                                popUpTo(from.value) {
                                    inclusive = true
                                }
                                launchSingleTop = true
                            }
                            showSnackBarNotImplemented = false
                        }
                    }
                }
                Route.Login -> {
                    when(to){
                        Route.HelpAndService -> {
                            navigate(to) {
                                launchSingleTop = true
                            }
                            showSnackBarNotImplemented = false
                        }
                    }
                }
            }
            if(showSnackBarNotImplemented){
                showSnackBarNotImplemented()
            }
        }
    }

    private fun navigateFromDialog(from: RouteManager.Route?, to: RouteManager.Route){
        with(navigationController){
            var showSnackBarNotImplemented = true
            when(from) {
                Route.Login -> {
                    when(to){
                        Route.Account -> {
                            navigate(to) {
                                popUpTo(from.value) {
                                    inclusive = true
                                }
                                launchSingleTop = true
                            }
                            showSnackBarNotImplemented = false
                        }
                    }
                }
            }
            if(showSnackBarNotImplemented){
                showSnackBarNotImplemented()
            }
        }
    }
}




