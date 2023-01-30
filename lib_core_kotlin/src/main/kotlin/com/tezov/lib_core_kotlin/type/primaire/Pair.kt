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

package com.tezov.lib_core_kotlin.type.primaire

class Pair<F, S>(var first: F, var second: S) {
    override fun equals(o: Any?): Boolean {
        return if (o is Pair<*, *>) {
            var result = equals(first, o.first)
            result = result and equals(
                second,
                o.second
            )
            result
        } else {
            false
        }
    }

    private fun equals(o1: Any?, o2: Any?): Boolean {
        return if (o1 != null) {
            o1 == o2
        } else {
            o2 == null
        }
    }
}