/*
 *  *********************************************************************************
 *  Created by Tezov on 05/05/2023 23:33
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 05/05/2023 23:32
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.compositionTree.base

import android.util.Log
import androidx.annotation.CallSuper
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle.Event
import androidx.lifecycle.LifecycleEventObserver
import com.tezov.lib_core_kotlin.type.primitive.IntTo.toStringHex

interface Composition<S : CompositionState, A : CompositionAction<S>>{

    @Composable
    fun onShowEventEnabled() = true

    @Composable
    fun onHideEventEnabled() = true

    @Composable
    fun onDisposeEventEnabled() = true

    @Composable
    fun Composition<S, A>.lifeCycleAware(){
        val lifecycle = LocalLifecycleOwner.current.lifecycle
        val lifecycleEvent = remember { mutableStateOf(Event.ON_ANY) }
        when (lifecycleEvent.value) {
            Event.ON_RESUME -> {
                if(onShowEventEnabled()){
                    onShow()
                }
            }
            Event.ON_PAUSE -> {
                if(onHideEventEnabled()){
                    onHide()
                }
            }
            Event.ON_STOP -> {
                if(onDisposeEventEnabled()){
                    onDispose()
                }
            }
            else -> {}
        }
        lifecycleEvent.value = Event.ON_ANY
        DisposableEffect(lifecycle) {
            val observer = LifecycleEventObserver { _, event ->
                if(event == Event.ON_RESUME || event == Event.ON_PAUSE || event == Event.ON_STOP){
                    lifecycleEvent.value = event
                }
            }
            lifecycle.addObserver(observer)
            onDispose {
                lifecycle.removeObserver(observer)
            }
        }
    }

    @CallSuper
    @Composable
    fun onShow(){
//        Log.d(">>:", "onShow: ${this::class.simpleName} ${this.hashCode().toStringHex()}")
    }

    @CallSuper
    @Composable
    fun onHide(){
//        Log.d(">>:", "onHide: ${this::class.simpleName} ${this.hashCode().toStringHex()}")
    }

    @CallSuper
    @Composable
    fun onDispose(){
//        Log.d(">>:", "onDispose: ${this::class.simpleName} ${this.hashCode().toStringHex()}")
    }

}