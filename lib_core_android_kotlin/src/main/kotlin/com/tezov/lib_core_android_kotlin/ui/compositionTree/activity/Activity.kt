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