/*
 *  *********************************************************************************
 *  Created by Tezov on 26/04/2023 21:07
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 26/04/2023 21:02
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
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Lifecycle.Event
import androidx.lifecycle.LifecycleEventObserver

interface Composition<S : CompositionState, A : CompositionAction<S>>{

    @Composable
    fun Composition<S, A>.enableLifeCycle(){
        val lifecycle = LocalLifecycleOwner.current.lifecycle
        val latestLifecycleEvent = remember { mutableStateOf(Event.ON_ANY) }
        DisposableEffect(lifecycle) {
            val observer = LifecycleEventObserver { _, event ->
                latestLifecycleEvent.value = event
            }
            lifecycle.addObserver(observer)
            onDispose {
                lifecycle.removeObserver(observer)
            }
        }
        when (latestLifecycleEvent.value) {
            Event.ON_RESUME -> {
                onResume()
            }
            Event.ON_PAUSE -> {
                onPause()
            }
            Event.ON_STOP -> {
                onStop()
            }
            Event.ON_DESTROY -> {
                onDestroy()
            }
            else -> {}
        }
    }

    @Composable
    fun Composition<S, A>.onResume(){
        Log.d(">>:", "onResume: ")
    }

    @Composable
    fun Composition<S, A>.onPause(){
        Log.d(">>:", "onPause: ")
    }

    @Composable
    fun Composition<S, A>.onStop(){
        Log.d(">>:", "onStop: ")
    }

    @Composable
    fun Composition<S, A>.onDestroy(){
        Log.d(">>:", "onDestroy: ")
    }


}