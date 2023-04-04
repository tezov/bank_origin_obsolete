/*
 *  *********************************************************************************
 *  Created by Tezov on 04/04/2023 20:57
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 04/04/2023 20:37
 *  First project bank / bank.lib_core_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_kotlin.delegate

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class DelegateNullFallBack<V>(initialValue: V?, lazyFallBackValue: (()->V)? = null) : ReadOnlyProperty<Any?, V> {

    interface Group<V : Any> {
        @Suppress("UNCHECKED_CAST")
        var groupLazyFallBackValue: (()->V)?
            get() {
                groupFallBackRefs().firstOrNull()?.let {
                    runCatching { it as? DelegateNullFallBack<V> }
                        .getOrNull()?.value?.let {
                            return { it }
                        }
                }
                return null
            }
            set(value) {
                value?.let {
                    setFallbackValue(it, groupFallBackRefs())
                }
            }

        @Suppress("UNCHECKED_CAST")
        fun Group<V>.setFallbackValue(lazyFallBackValue: ()->V, refs: List<V>) {
            refs.forEach {
                runCatching { it as? DelegateNullFallBack<V> }
                    .getOrNull()?.setFallbackValueIfValueIsNull(lazyFallBackValue)
            }
        }

        fun groupFallBackRefs(): List<V>

    }

    private var value:V?

    init {
        value = initialValue
        lazyFallBackValue?.let {
            setFallbackValueIfValueIsNull(it)
        }
    }

    private fun setFallbackValueIfValueIsNull(lazyFallBackValue: ()->V) {
        this.value ?: run {
            this.value = lazyFallBackValue()
        }
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): V {
        return value ?: throw UninitializedPropertyAccessException()
    }
}