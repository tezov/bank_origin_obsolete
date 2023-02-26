/*
 *  *********************************************************************************
 *  Created by Tezov on 26/02/2023 14:06
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 26/02/2023 13:42
 *  First project bank / bank.lib_core_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_kotlin.util

object UtilsNull {
    val NULL_OBJECT = NULL()
    val NOT_NULL_OBJECT = NOT_NULL()

    class NULL {
        override fun equals(other: Any?): Boolean {
            return other is NULL
        }

        override fun hashCode(): Int {
            return 0
        }

        override fun toString(): String {
            return "NULL"
        }
    }

    class NOT_NULL {
        override fun equals(other: Any?): Boolean {
            return other is NOT_NULL
        }

        override fun hashCode(): Int {
            return 1
        }

        override fun toString(): String {
            return "NOT NULL"
        }
    }

    inline fun <U : Any, V : Any, R : Any> ifNotNull(
        first: U?,
        second: V?,
        action: (U, V) -> R
    ): R? {
        return when {
            first !== null && second !== null -> action(first, second)
            else -> null
        }
    }

    inline fun <U : Any, V : Any, W : Any, R : Any> ifNotNull(
        first: U?,
        second: V?,
        third: W?,
        action: (U, V, W) -> R
    ): R? {
        return when {
            first !== null && second !== null && third !== null -> action(first, second, third)
            else -> null
        }
    }

    inline fun <U : Any, V : Any, W : Any, X : Any, R : Any> ifNotNull(
        first: U?,
        second: V?,
        third: W?,
        fourth: X?,
        action: (U, V, W, X) -> R
    ): R? {
        return when {
            first !== null && second !== null && third !== null && fourth !== null -> action(
                first,
                second,
                third,
                fourth
            )
            else -> null
        }
    }

}