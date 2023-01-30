/*
 *  *********************************************************************************
 *  Created by Tezov on 30/01/2023 22:29
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 30/01/2023 22:28
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
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.tezov.bank.navigation.NavigationController.Companion.Route
import com.tezov.bank.ui.activity.MainActivity
import com.tezov.bank.ui.di.accessor.AccessorAppUiActivity
import com.tezov.bank.ui.page.help_and_service.PageHelpAndService
import com.tezov.bank.ui.page.login.PageLogin
import com.tezov.bank.ui.page.account.PageAccount
import com.tezov.bank.ui.page.splash.PageSplash
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalActivity

@OptIn(ExperimentalAnimationApi::class)
object NavigationGraph {
    private const val TRANSITION_DURATION_ms = 350

    @Composable
    operator fun invoke() {
        graph()
    }

    @Composable
    private fun graph() {
        val accessor = AccessorAppUiActivity().get(requester = this)
        val mainAction = accessor.contextMain().action()


        AnimatedNavHost(
            navController = mainAction.navigationController.navHostController,
            startDestination = NavigationController.startRoute.value,
        ) {

            composableWithAnimation(Route.Splash){
                 PageSplash(PaddingValues())
            }

            composableWithAnimation(Route.Login) {
                (LocalActivity.current as MainActivity).empty {
                    PageLogin(innerPadding = it)
                }
            }

            composableWithAnimation(Route.HelpAndService) {
                (LocalActivity.current as MainActivity).empty{
                    PageHelpAndService(innerPadding = it)
                }
            }

            composableWithAnimation(Route.Account){
                (LocalActivity.current as MainActivity).withBottomNavigationBar{
                    PageAccount(PaddingValues())
                }
            }

        }
    }


    @OptIn(ExperimentalAnimationApi::class)
    private fun NavGraphBuilder.composableWithAnimation(
        route: Route,
        arguments: List<NamedNavArgument> = emptyList(),
        content: @Composable AnimatedVisibilityScope.(NavBackStackEntry) -> Unit
    ) = composable(
        route = route.value,
        arguments = arguments,

        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = {  EnterTransition.None },
        popExitTransition = { ExitTransition.None },

//        enterTransition = {
//            fadeIn(animationSpec = tween(TRANSITION_DURATION_ms))
//        },
//        exitTransition = {
//            fadeOut(animationSpec = tween(TRANSITION_DURATION_ms))
//        },
//        popEnterTransition = {
//            fadeIn(animationSpec = tween(TRANSITION_DURATION_ms))
//        },
//        popExitTransition = {
//            fadeOut(animationSpec = tween(TRANSITION_DURATION_ms))
//        },

        content = content
    )


}