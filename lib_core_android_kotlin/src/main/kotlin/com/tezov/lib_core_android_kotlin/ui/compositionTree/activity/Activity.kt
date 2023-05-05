/*
 *  *********************************************************************************
 *  Created by Tezov on 05/05/2023 20:30
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 05/05/2023 20:27
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.compositionTree.activity

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalContext
import com.tezov.lib_core_android_kotlin.application.Application
import com.tezov.lib_core_android_kotlin.ui.activity.ActivityBase
import com.tezov.lib_core_android_kotlin.ui.compositionTree.base.Composition
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.di.accessor.DiAccessor
import com.tezov.lib_core_android_kotlin.ui.di.accessor.DiAccessorCoreUiActivity
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action

interface Activity<S : ActivityState, A : ActivityAction<S>> : Composition<S, A>, DiAccessor.Key {

    override val diAccessorKeyId: Int
        get() = Activity.hashCode()

    companion object {
        val LocalLevel: ProvidableCompositionLocal<Int> = staticCompositionLocalOf {
            -1
        }
        val LocalApplication: ProvidableCompositionLocal<Application> = staticCompositionLocalOf {
            error("not provided")
        }
        val LocalActivityBundle: ProvidableCompositionLocal<Bundle> = staticCompositionLocalOf {
            error("not provided")
        }
        val LocalActivity @Composable get() = LocalActivityBundle.current
        val LocalPagesBundle @Composable get() = LocalActivityBundle.current.pages

        data class Bundle(
            val current: Activity<*, *>,
            val pages: ArrayDeque<Page.Companion.Bundle> = ArrayDeque(),
        )
    }

    @Composable
    fun invokeContent() {
        CompositionLocalProvider(
            LocalLevel provides 0,
            LocalApplication provides LocalContext.current.applicationContext as Application,
            LocalActivityBundle provides Bundle(this),
        ) {
            lifeCycleAware()
            content()
        }
    }

    @Composable
    fun Activity<S, A>.content()

    @Composable
    fun onBackPressedDispatch(): Boolean {
        if (!this.handleOnBackPressed()) {
            val accessor = DiAccessorCoreUiActivity().with(key = this)
            val mainAction = accessor.contextMain().action()
            if (!mainAction.navigationController.onBackPressedDispatch()) {
                (LocalActivity.current as? ActivityBase)?.finishAffinity()
            }
        }
        return true
    }

    @Composable
    fun handleOnBackPressed() = false
}