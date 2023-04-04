/*
 *  *********************************************************************************
 *  Created by Tezov on 04/04/2023 13:51
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 04/04/2023 13:03
 *  First project bank / bank.lib_core_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_kotlin.delegate

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class DelegateNullFallBack<V>(initialValue: V?, fallBackValue: V? = null) : ReadOnlyProperty<Any?, V> {

    interface Group<V : Any> {
        @Suppress("UNCHECKED_CAST")
        var groupFallBackValue: V?
            get() {
                groupFallBackRefs().firstOrNull()?.let {
                    kotlin.runCatching { it as? DelegateNullFallBack<V> }
                        .getOrNull()?.fallBackValue?.let {
                            return it
                        }
                }
                return null
            }
            set(value) {
                setFallbackValue(value, groupFallBackRefs())
            }

        @Suppress("UNCHECKED_CAST")
        fun Group<V>.setFallbackValue(fallBackValue: V?, refs: List<V>) {
            refs.forEach {
                kotlin.runCatching { it as? DelegateNullFallBack<V> }
                    .getOrNull()?.fallBackValue = fallBackValue
            }
        }

        fun groupFallBackRefs(): List<V>

    }

    private val value = initialValue
    private var fallBackValue: V? = null
        set(value) {
            value ?: kotlin.run {
                field = value
            }
        }

    init {
        fallBackValue?.let {
            this.fallBackValue = it
        }
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): V {
        return value ?: (fallBackValue ?: throw UninitializedPropertyAccessException())
    }
}