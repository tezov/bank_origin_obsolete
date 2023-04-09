/*
 *  *********************************************************************************
 *  Created by Tezov on 09/04/2023 18:42
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 09/04/2023 18:40
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.di.helper

import android.util.Log
import androidx.compose.runtime.DisposableEffect
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.DebugLocalLevel
import com.tezov.lib_core_kotlin.type.primitive.IntTo.toStringHex

abstract class ComposableHolder<T:Any>{
    private var value:T? = null
    @androidx.compose.runtime.Composable
    protected abstract fun create():T
    private fun exist() = value != null
    @androidx.compose.runtime.Composable
    open fun get():T{
        if(!exist()){
            value = create()
            Log.d(">>:", "${DebugLocalLevel.current}: create ${this.javaClass.simpleName} ${this.hashCode().toStringHex()}::${value.hashCode().toStringHex()}")
            DisposableEffect(Unit){
                onDispose {
                    with(this@ComposableHolder){
                        Log.d(">>:", "dispose ${this.javaClass.simpleName} ${this.hashCode().toStringHex()}::${value.hashCode().toStringHex()}")
                    }
                    value = null
                }
            }
        }
        Log.d(">>:", "${DebugLocalLevel.current}: get ${this.javaClass.simpleName} ${this.hashCode().toStringHex()}::${value.hashCode().toStringHex()}")
        return value ?: throw Exception("failed to create")
    }
}