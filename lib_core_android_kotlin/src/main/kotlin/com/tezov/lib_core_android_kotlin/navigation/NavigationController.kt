/*
 *  *********************************************************************************
 *  Created by Tezov on 06/05/2023 15:39
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 06/05/2023 15:30
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.navigation

import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.DialogNavigator
import com.google.accompanist.navigation.animation.AnimatedComposeNavigator
import com.tezov.lib_core_android_kotlin.navigation.RouteManager.Route
import com.tezov.lib_core_android_kotlin.ui.activity.sub.snackbar.SnackbarAction
import com.tezov.lib_core_android_kotlin.ui.compositionTree.base.CompositionAction
import com.tezov.lib_core_kotlin.extension.ExtensionBoolean.on
import com.tezov.lib_core_kotlin.type.collection.ListEntry
import kotlinx.coroutines.*
import kotlin.reflect.KClass
import kotlin.reflect.full.isSubclassOf

class NavigationController constructor(
    val snackbarAction: SnackbarAction, //todo remove snackbar here. have nothing to with navigation!
    val navHostController: NavHostController,
    val routes: RouteManager = RouteManager()
) {

    companion object {
        @OptIn(ExperimentalAnimationApi::class)
        @Composable
        fun create(
            snackbarAction: SnackbarAction,
            navHostController: NavHostController = NavHostController(LocalContext.current).apply {
                navigatorProvider.addNavigator(AnimatedComposeNavigator())
                navigatorProvider.addNavigator(ComposeNavigator())
                navigatorProvider.addNavigator(DialogNavigator())
            }
        ): NavigationController = NavigationController(
            snackbarAction = snackbarAction,
            navHostController = navHostController,
        )
    }

    private val requestManagers: ListEntry<KClass<out CompositionAction<*>>, (from: Route?, to: Route) -> Unit> =
        ListEntry()

    fun addRequestManager(
        klass: KClass<out CompositionAction<*>>,
        manager: (from: Route?, to: Route) -> Unit
    ) {
        requestManagers.add(klass, manager)
    }

    fun addRequestManager(manager: Map<KClass<out CompositionAction<*>>, ((from: Route?, to: Route) -> Unit)>) {
        manager.forEach { (klass, action) ->
            requestManagers.add(klass, action)
        }
    }

    @Composable
    fun onBackPressedDispatch() = handleOnBackPressed()

    @Composable
    fun handleOnBackPressed() = isLastRoute().on(
        ok = { false },
        ko = {
            navigateBack()
            true
        }
    )

    fun showSnackBarNotImplemented(message:String? = null) = snackbarAction.showNotImplemented(message)

    fun currentRoute() = routes.find(navHostController.currentBackStackEntry?.destination?.route)

    fun isLastRoute() = navHostController.previousBackStackEntry == null

    fun navigate(to: Route, builder: NavOptionsBuilder.() -> Unit) {
        navHostController.navigate(route = to.value, builder = builder)
    }

    fun navigate(to: Route) {
        navHostController.navigate(route = to.value)
    }

    fun navigateBack():Boolean {
        return navHostController.popBackStack()
    }

    fun requestNavigate(to: Route, askedBy: CompositionAction<*>) {
        requestNavigate(currentRoute(), to, askedBy)
    }

    fun requestNavigate(from: Route?, to: Route, askedBy: CompositionAction<*>) {
        requestManagers.find {
            askedBy::class.isInstance(it.key) || askedBy::class.isSubclassOf(it.key)
        }?.value?.invoke(from, to) ?: run {
            showSnackBarNotImplemented()
        }
    }

}