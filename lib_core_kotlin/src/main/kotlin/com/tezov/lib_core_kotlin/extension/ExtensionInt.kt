/*
 *  *********************************************************************************
 *  Created by Tezov on 17/04/2023 21:26
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 17/04/2023 19:20
 *  First project bank / bank.lib_core_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_kotlin.extension


object ExtensionInt {
    fun Int.isEven() = this % 2 == 0
    fun <T> Int.onEven(run: (Int) -> T) = if (isEven()) {
        run(this)
    } else null

    fun Int.isOdd() = this % 2 == 1
    fun <T> Int.onOdd(run: (Int) -> T) = if (isOdd()) {
        run(this)
    } else null

    fun <T> Int.on(even: (Int) -> T, odd: (Int) -> T) = if (isEven()) {
        even(this)
    } else {
        odd(this)
    }
}