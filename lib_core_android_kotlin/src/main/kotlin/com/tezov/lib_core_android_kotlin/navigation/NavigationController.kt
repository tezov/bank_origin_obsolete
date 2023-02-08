/*
 *  *********************************************************************************
 *  Created by Tezov on 08/02/2023 18:18
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/02/2023 18:18
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.navigation

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.tezov.lib_core_android_kotlin.navigation.RouteManager.Route
import com.tezov.lib_core_android_kotlin.ui.activity.sub.snackbar.SnackbarAction
import com.tezov.lib_core_android_kotlin.ui.compositionTree.base.CompositionAction
import com.tezov.lib_core_kotlin.extension.ExtensionBoolean.on
import com.tezov.lib_core_kotlin.type.collection.ListEntry
import com.tezov.lib_core_kotlin.util.Event
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
        fun remember(
            snackbarAction: SnackbarAction,
            navHostController: NavHostController = rememberAnimatedNavController(),
        ):NavigationController = NavigationController(
            snackbarAction = snackbarAction,
            navHostController = navHostController,
        )
    }

    private val actionControllers:ListEntry<KClass<out CompositionAction<*>>, (from: Route?, to: Route)->Unit> = ListEntry()

    @Composable
    fun onBackPressedDispatch() =  handleOnBackPressed()

    @Composable
    fun handleOnBackPressed() = isLastRoute().on(
        ok = { false },
        ko = {
            navigateBack()
            true
        }
    )

    fun addAction(klass:KClass<out CompositionAction<*>>, action:(from: Route?, to: Route)->Unit){
        actionControllers.add(klass, action)
    }

    fun addAction(actions: Map<KClass<out CompositionAction<*>>, ((from: Route?, to: Route)->Unit)>){
        actions.forEach{ (klass, action) ->
            actionControllers.add(klass, action)
        }
    }

    fun showSnackBarNotImplemented() = snackbarAction.showNotImplemented()

    private val clickDispatcher = MutableLiveData<Event<Route>>()
    fun dispatchClick(route: Route) {
        clickDispatcher.value = Event(route)
    }
    fun listenClick(lifecycleOwner: LifecycleOwner, observer: Observer<Event<Route>>) {
        clickDispatcher.observe(lifecycleOwner, observer)
    }
    fun unlistenClick(lifecycleOwner: LifecycleOwner, observer: Observer<Event<Route>>) {
        clickDispatcher.removeObserver(observer)
    }
    fun unlistenClick(lifecycleOwner: LifecycleOwner) {
        clickDispatcher.removeObservers(lifecycleOwner)
    }

    fun currentRoute() = routes.find(navHostController.currentBackStackEntry?.destination?.route)

    fun isLastRoute() = navHostController.backQueue.sumOf { (if(it.destination.route != null) 1 else 0).toInt() } <= 1

    fun navigate(route: Route, builder: NavOptionsBuilder.() -> Unit) {
        navHostController.navigate(route = route.value, builder = builder)
    }

    fun navigate(route: Route) = navHostController.navigate(route = route.value)

    fun navigateBack() = navHostController.popBackStack()

    fun requestNavigate(to: Route, askedBy: CompositionAction<*>) {
        requestNavigate(currentRoute(), to, askedBy)
    }

    fun requestNavigate(from: Route?, to: Route, askedBy: CompositionAction<*>) {
        actionControllers.find{
            askedBy::class.isInstance(it.key) || askedBy::class.isSubclassOf(it.key)
        }?.value?.invoke(from, to) ?: run {
            showSnackBarNotImplemented()
        }
    }

}