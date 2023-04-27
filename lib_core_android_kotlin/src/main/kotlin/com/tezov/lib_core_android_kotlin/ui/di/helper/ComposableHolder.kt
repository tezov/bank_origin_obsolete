/*
 *  *********************************************************************************
 *  Created by Tezov on 27/04/2023 20:26
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 27/04/2023 20:23
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.di.helper

import android.util.Log
import androidx.compose.runtime.Composable
import com.tezov.lib_core_kotlin.type.primitive.IntTo.toStringHex

abstract class ComposableHolder<T : Any> {
    private var value: T? = null

    @Composable
    protected abstract fun create(): T

    @Composable
    protected open fun onCreated() {
    }

    @Composable
    fun get(): T = value ?: run {
        create().also {
            value = it
//            Log.d(">>:", "create ${this.javaClass.simpleName} ${this.hashCode().toStringHex()}::${value.hashCode().toStringHex()}")
            onCreated()
        }

    }

    fun dispose(): Boolean = null != value.also {
//         Log.d(">>:", "dispose ${this.javaClass.simpleName} ${this.hashCode().toStringHex()}::${value.hashCode().toStringHex()}")
        value = null
    }
}