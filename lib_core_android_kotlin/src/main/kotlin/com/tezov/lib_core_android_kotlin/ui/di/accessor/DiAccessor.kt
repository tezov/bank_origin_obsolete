/*
 *  *********************************************************************************
 *  Created by Tezov on 26/04/2023 21:07
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 26/04/2023 20:33
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.di.accessor

import androidx.compose.runtime.Composable
import com.tezov.lib_core_kotlin.type.collection.ListEntry

abstract class DiAccessor<COMPONENT : Any> {

    interface Key {
        val diAccessorKeyId: Int get() = hashCode()
    }

    private val components: ListEntry<Int, COMPONENT> = ListEntry()

    @Composable
    protected abstract fun create(): COMPONENT

    @Composable
    protected open fun onCreated() {
    }

    @Composable
    fun with(key: Key): COMPONENT {
        return with(key, key)
    }

    @Composable
    open fun with(requester: Any, key: Key): COMPONENT =
        components.getValue(key.diAccessorKeyId) ?: run {
            // Log.d(">>:", "create ${this::class.simpleName}")
            create().also {
                components.add(key.diAccessorKeyId, it)
                onCreated()
            }
        }

    @Composable
    open fun dispose(requester: Any, key: Key) =
        null != components.removeKey(key.diAccessorKeyId).also {
            // Log.d(">>:", "dispose ${this::class.simpleName} requester:${requester::class.simpleName} key:${key.diAccessorKeyId}")
        }

}