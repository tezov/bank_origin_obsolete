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

package com.tezov.bank.navigation

import androidx.compose.animation.*
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.*
import androidx.navigation.*
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.tezov.bank.navigation.NavigationController.Companion.Route
import com.tezov.bank.ui.activity.MainActivity
import com.tezov.bank.ui.di.accessor.AccessorAppUiActivity
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

            composableWithAnimation(Route.Splash) {
                PageSplash(PaddingValues())
            }

            composableWithAnimation(Route.Login) {
                (LocalActivity.current as MainActivity).empty {
                    PageLogin(innerPadding = it)
                }
            }

            composableWithAnimation(Route.HelpAndService) {
                (LocalActivity.current as MainActivity).empty {
                    PageHelpAndService(innerPadding = it)
                }
            }

            composableWithAnimation(Route.Account) {
                (LocalActivity.current as MainActivity).withBottomNavigationBar {
                    PageAccount(innerPadding = it)
                }
            }

            composableWithAnimation(Route.Discover) {
                (LocalActivity.current as MainActivity).withBottomNavigationBar {
                    PageDiscover(innerPadding = it)
                }
            }

            composableWithAnimation(Route.Help) {
                (LocalActivity.current as MainActivity).withBottomNavigationBar {
                    PageHelp(innerPadding = it)
                }
            }

            composableWithAnimation(Route.Profile) {
                (LocalActivity.current as MainActivity).withBottomNavigationBar {
                    PageProfile(innerPadding = it)
                }
            }

            composableWithAnimation(Route.Payment) {
                (LocalActivity.current as MainActivity).withBottomNavigationBar {
                    PagePayment(innerPadding = it)
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
        popEnterTransition = { EnterTransition.None },
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