/*
 *  *********************************************************************************
 *  Created by Tezov on 07/02/2023 22:45
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 07/02/2023 22:43
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.compositionTree.activity

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import com.tezov.lib_core_android_kotlin.application.Application
import com.tezov.lib_core_android_kotlin.ui.activity.ActivityBase
import com.tezov.lib_core_android_kotlin.ui.compositionTree.base.Composition
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.accessor.AccessorCoreUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action

interface Activity<S : ActivityState, A : ActivityAction<S>> : Composition<S, A> {

    companion object {
        val DebugLocalLevel: ProvidableCompositionLocal<Int> = staticCompositionLocalOf {
            -1
        }
        val LocalApplication: ProvidableCompositionLocal<Application> = staticCompositionLocalOf {
            error("not provided")
        }
        val LocalActivity: ProvidableCompositionLocal<Activity<*, *>> = staticCompositionLocalOf {
            error("not provided")
        }
        val LocalPages: ProvidableCompositionLocal<ArrayDeque<Page.Companion.Locals>> =
            staticCompositionLocalOf {
                error("not provided")
            }
    }

    @Composable
    fun invokeContent() {
        CompositionLocalProvider(
            DebugLocalLevel provides 0,
            LocalApplication provides LocalContext.current.applicationContext as Application,
            LocalActivity provides this,
            LocalPages provides ArrayDeque()
        ) {
            val onBackPressedState = remember {
                mutableStateOf(false)
            }
            BackHandler(true) {
                onBackPressedState.value = true
            }
            onBackPressedStateUpdate(onBackPressedState)
            content()
        }
    }

    @Composable
    fun Activity<S, A>.content()

    @Composable
    private fun onBackPressedStateUpdate(onBackPressedState: MutableState<Boolean>) {
        if (!onBackPressedState.value) {
            return
        }
        LocalPages.current.lastOrNull()?.page?.handleOnBackPressed()
            .takeIf { (it == false || it == null) && !this.handleOnBackPressed() }?.let {
            val accessor = AccessorCoreUiActivity().get(requester = this)
            val mainAction = accessor.contextMain().action()
            if (!mainAction.navigationController.handleOnBackPressed()) {
                (LocalActivity.current as? ActivityBase)?.finishAffinity()
            }
        }
        onBackPressedState.value = false
    }

    @Composable
    fun handleOnBackPressed() = false
}