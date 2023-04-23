/*
 *  *********************************************************************************
 *  Created by Tezov on 23/04/2023 17:27
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 23/04/2023 15:11
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.di.helper

import androidx.compose.runtime.DisposableEffect

abstract class ComposableHolder<T : Any> {
    private var value: T? = null

    @androidx.compose.runtime.Composable
    protected abstract fun create(): T
    private fun exist() = value != null

    @androidx.compose.runtime.Composable
    fun get(): T {
        if (!exist()) {
            value = create()
//            Log.d(">>:", "${DebugLocalLevel.current}: create ${this.javaClass.simpleName} ${this.hashCode().toStringHex()}::${value.hashCode().toStringHex()}")
            DisposableEffect(Unit) {
                onDispose {
//                    with(this@ComposableHolder){
//                        Log.d(">>:", "dispose ${this.javaClass.simpleName} ${this.hashCode().toStringHex()}::${value.hashCode().toStringHex()}")
//                    }
                    value = null
                }
            }
        }
//        Log.d(">>:", "${DebugLocalLevel.current}: get ${this.javaClass.simpleName} ${this.hashCode().toStringHex()}::${value.hashCode().toStringHex()}")
        return value ?: throw Exception("failed to create")
    }
}