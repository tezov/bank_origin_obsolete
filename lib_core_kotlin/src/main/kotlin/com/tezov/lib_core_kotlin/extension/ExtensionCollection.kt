/*
 *  *********************************************************************************
 *  Created by Tezov on 05/02/2023 01:03
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 05/02/2023 00:38
 *  First project bank / bank.lib_core_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_kotlin.extension

import java.util.Deque
import java.util.LinkedList

object ExtensionCollection {

    inline fun <T> Iterable<T>.forEach(offset:Int = 0, action: (T) -> Unit) =
        drop(offset).forEach(action)
    inline fun <T> Iterable<T>.forEachIndexed(offset:Int = 0, action: (index: Int, T) -> Unit) {
        var index = offset
        drop(offset).forEach {
            item -> action(index, item)
            index++
        }
    }

    inline fun <T> Iterable<T>.find(offset:Int = 0, predicate: (T) -> Boolean): T? = drop(offset).find(predicate)
    inline fun <T> Iterable<T>.findIndexed(offset:Int = 0, predicate: (index: Int, T) -> Boolean): T? {
        forEachIndexed(offset){ index, element ->
            if (predicate(index, element)) return element
        }
        return null
    }

    inline fun <T> Iterable<T>.findIndex(offset:Int = 0, predicate: (T) -> Boolean): Int? {
        forEachIndexed(offset){ index, element ->
            if (predicate(element)) return index
        }
        return null
    }

    fun <T> ArrayDeque<T>.push(t:T) = this.addLast(t)

    fun <T> ArrayDeque<T>.pop() = this.removeLastOrNull()
}