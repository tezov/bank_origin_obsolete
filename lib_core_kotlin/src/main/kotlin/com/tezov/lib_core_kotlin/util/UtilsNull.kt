/*
 *  *********************************************************************************
 *  Created by Tezov on 30/01/2023 20:18
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 30/01/2023 20:11
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
}