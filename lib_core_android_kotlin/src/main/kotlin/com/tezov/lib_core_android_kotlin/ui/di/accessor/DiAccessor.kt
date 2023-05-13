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

package com.tezov.lib_core_android_kotlin.ui.di.accessor

import android.util.Log
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
//             Log.d(">>:", "create ${this::class.simpleName}")
            create().also {
                components.add(key.diAccessorKeyId, it)
                onCreated()
            }
        }

    @Composable
    open fun dispose(requester: Any, key: Key) =
        null != components.removeKey(key.diAccessorKeyId).also {
//             Log.d(">>:", "dispose ${this::class.simpleName} requester:${requester::class.simpleName} key:${key.diAccessorKeyId}")
        }

}