/*
 *  *********************************************************************************
 *  Created by Tezov on 02/04/2023 14:12
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 02/04/2023 14:12
 *  First project bank / bank.lib_core_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_kotlin.delegate

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class DelegateNullFallBack<V>(initialValue: V?) : ReadOnlyProperty<Any?, V> {

    interface Setter<V : Any> {
        @Suppress("UNCHECKED_CAST")
        var nullFallback: (() -> V)?
            get() {
                refs().firstOrNull()?.let {
                    kotlin.runCatching { it as? DelegateNullFallBack<V> }
                        .getOrNull()?.fallBackValue?.let {
                            return it
                        }
                }
                return null
            }
            set(value) {
                nullFallback(value, refs())
            }

        @Suppress("UNCHECKED_CAST")
        fun Setter<V>.nullFallback(onNull: (() -> V)?, refs: List<V>) {
            refs.forEach {
                kotlin.runCatching { it as? DelegateNullFallBack<V> }.getOrNull()?.fallBackValue =
                    onNull
            }
        }

        fun refs(): List<V>

    }

    private var value = initialValue
    var fallBackValue: (()->V)? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): V {
        return value ?: fallBackValue?.invoke() ?: throw UninitializedPropertyAccessException()
    }
}