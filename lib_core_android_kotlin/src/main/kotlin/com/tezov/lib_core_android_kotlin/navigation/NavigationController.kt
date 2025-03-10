/*
 *  ********************************************************************************
 *  Created by Tezov under MIT LICENCE.
 *  For any request, please send me an email to tezov.app@gmail.com.
 *  I'll be glad to answer you if your request is sane :)
 *  ********************************************************************************
 *
 *
 */

/*
 *  ********************************************************************************
 *  Created by Tezov under MIT LICENCE.
 *  For any request, please send me an email to tezov.app@gmail.com.
 *  I'll be glad to answer you if your request is sane :)
 *  ********************************************************************************
 *
 *
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
import androidx.navigation.compose.rememberNavController
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
        @Composable
        fun create(
            snackbarAction: SnackbarAction,
            navHostController: NavHostController = NavHostController(LocalContext.current).apply {
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

    fun previousRoute() = routes.find(navHostController.previousBackStackEntry?.destination?.route)

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