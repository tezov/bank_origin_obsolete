/*
 *  *********************************************************************************
 *  Created by Tezov on 06/05/2023 14:54
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 06/05/2023 14:54
 *  First project bank / bank.lib_core_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_kotlin.type

class ValueSingleRead<T:Any>(private val content: T) {
    var hasBeenRead = false
        private set

    val get get() = if (hasBeenRead) {
            null
        } else {
            hasBeenRead = true
            content
        }
}