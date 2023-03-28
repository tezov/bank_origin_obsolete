/*
 *  *********************************************************************************
 *  Created by Tezov on 28/03/2023 22:22
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 21/03/2023 20:53
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
    private var value = initialValue
    var fallBackValue: (()->V)? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): V {
        return value ?: fallBackValue?.invoke() ?: throw UninitializedPropertyAccessException()
    }
}