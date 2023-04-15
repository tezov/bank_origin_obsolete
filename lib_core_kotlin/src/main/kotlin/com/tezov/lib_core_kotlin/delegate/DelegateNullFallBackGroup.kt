/*
 *  *********************************************************************************
 *  Created by Tezov on 15/04/2023 19:41
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 15/04/2023 18:52
 *  First project bank / bank.lib_core_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_kotlin.delegate

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

object DelegateNullFallBack {

    class Ref<V>(initialValue: V?, fallBackValue: (() -> V)? = null) : ReadOnlyProperty<Any?, V> {

        var value: V?
            private set

        var fallBackValue: (() -> V)?
            get() = value?.let { fun() = it }
            set(fallBackValue) {
                value ?: fallBackValue?.let {
                    value = it()
                }
            }

        init {
            value = initialValue
            this.fallBackValue = fallBackValue
        }

        override fun getValue(thisRef: Any?, property: KProperty<*>): V {
            return value ?: throw UninitializedPropertyAccessException()
        }

    }

    class Group<V : Any> {

        private val refs = mutableListOf<Ref<V>>()

        fun ref(initialValue: V?, fallBackValue: (() -> V)? = null): Ref<V> {
            val ref = Ref(initialValue, fallBackValue)
            refs.add(ref)
            return ref
        }

        var fallBackValue: (() -> V)?
            get() = refs.firstOrNull()?.fallBackValue
            set(fallBackValue) {
                fallBackValue?.let {
                    refs.forEach { delegate ->
                        delegate.fallBackValue = fallBackValue
                    }
                }
            }

        fun firstNotNull() = refs.find { it.value != null }
    }

}



