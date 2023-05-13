/*
 *  ********************************************************************************
 *  Created by Tezov under MIT LICENCE.
 *  For any request, please send me an email to tezov.app@gmail.com.
 *  I'll be glad to answer you if your request is sane :)
 *  ********************************************************************************
 *
 *
 */

/*
 *  ********************************************************************************
 *  Created by Tezov under MIT LICENCE.
 *  For any request, please send me an email to tezov.app@gmail.com.
 *  I'll be glad to answer you if your request is sane :)
 *  ********************************************************************************
 *
 *
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