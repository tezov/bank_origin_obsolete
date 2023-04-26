/*
 *  *********************************************************************************
 *  Created by Tezov on 26/04/2023 21:54
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 26/04/2023 21:47
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.compositionTree.base

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle.Event
import androidx.lifecycle.LifecycleEventObserver

interface Composition<S : CompositionState, A : CompositionAction<S>>{

    @Composable
    fun Composition<S, A>.lifeCycleAware(){
        val lifecycle = LocalLifecycleOwner.current.lifecycle
        val lifecycleEvent = remember { mutableStateOf(Event.ON_ANY) }
        when (lifecycleEvent.value) {
            Event.ON_RESUME -> {
                onShow()
            }
            Event.ON_PAUSE -> {
                onHide()
            }
            Event.ON_STOP -> {
                onDispose()
            }
            else -> {}
        }
        DisposableEffect(lifecycle) {
            val observer = LifecycleEventObserver { _, event ->
                lifecycleEvent.value = event
            }
            lifecycle.addObserver(observer)
            onDispose {
                lifecycle.removeObserver(observer)
            }
        }
    }

    @Composable
    fun Composition<S, A>.onShow(){

    }

    @Composable
    fun Composition<S, A>.onHide(){

    }

    @Composable
    fun Composition<S, A>.onDispose(){

    }


}