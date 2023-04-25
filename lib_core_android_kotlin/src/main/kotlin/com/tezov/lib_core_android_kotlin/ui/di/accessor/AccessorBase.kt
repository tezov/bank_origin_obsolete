/*
 *  *********************************************************************************
 *  Created by Tezov on 25/04/2023 21:10
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 25/04/2023 21:10
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.di.accessor

import android.util.Log
import androidx.compose.runtime.Composable
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity
import com.tezov.lib_core_android_kotlin.ui.di.component.ComponentCoreUiActivity
import com.tezov.lib_core_kotlin.type.collection.ListEntry
import kotlin.reflect.KClass

abstract class AccessorBase<KEY : Any, COMPONENT : Any> {
    private val components: ListEntry<KClass<out KEY>, COMPONENT> = ListEntry()

    init {
        Log.d(">>:", "construct ${this::class.simpleName}")
    }

    protected fun finalize() {
        Log.d(">>:", "destroy ${this::class.simpleName}")
    }

    @Composable
    protected abstract fun create(): COMPONENT

    @Composable
    protected open fun onCreated() {}

    @Composable
    fun get(requester: KEY): COMPONENT {
        return get(requester, requester::class)
    }
    @Composable
    open fun get(requester: Any, key: KClass<out KEY>): COMPONENT {
        Log.d(">>:", "get ${this::class.simpleName} requester:${requester::class.simpleName} key:${key.simpleName}")
        return components.getValue(key) ?: kotlin.run {
            Log.d(">>:", "create ${this::class.simpleName}")
            create().also {
                components.add(key, it)
                onCreated()
            }
        }
    }

    @Composable
    open fun dispose(requester: Any, key: KClass<out KEY>): Boolean {
        Log.d(">>:", "dispose ${this::class.simpleName} requester:${requester::class.simpleName} key:${key::class}")
        return components.removeKey(key) != null
    }

}