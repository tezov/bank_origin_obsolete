/*
 *  *********************************************************************************
 *  Created by Tezov on 30/01/2023 20:18
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 30/01/2023 20:11
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.compositionTree.activity

import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import com.tezov.lib_core_android_kotlin.application.Application
import com.tezov.lib_core_android_kotlin.ui.compositionTree.base.Composition
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page

interface Activity<S: ActivityState, A: ActivityAction<S>>: Composition<S, A> {

    companion object{
        val DebugLocalLevel: ProvidableCompositionLocal<Int> = staticCompositionLocalOf {
            -1
        }
        val LocalApplication: ProvidableCompositionLocal<Application> = staticCompositionLocalOf {
            error("not provided")
        }
        val LocalActivity: ProvidableCompositionLocal<Activity<*, *>> = staticCompositionLocalOf {
            error("not provided")
        }
        val LocalPages: ProvidableCompositionLocal<MutableList<Page.Companion.Locals>> = staticCompositionLocalOf {
            error("not provided")
        }
    }

    @Composable
    fun invokeContent() {
        CompositionLocalProvider(
            DebugLocalLevel provides 0,
            LocalApplication provides LocalContext.current.applicationContext as Application,
            LocalActivity provides this,
            LocalPages provides ArrayList()
        ) {
            content()
        }
    }

    @Composable
    fun Activity<S, A>.content()



}