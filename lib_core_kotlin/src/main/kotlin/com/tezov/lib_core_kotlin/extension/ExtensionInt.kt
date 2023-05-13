/*
 *  ********************************************************************************
 *  Created by Tezov under MIT LICENCE.
 *  For any request, please send me an email to tezov.app@gmail.com.
 *  I'll be glad to answer you if your request is sane :)
 *  ********************************************************************************
 *
 *
 */

/*
 *  ********************************************************************************
 *  Created by Tezov under MIT LICENCE.
 *  For any request, please send me an email to tezov.app@gmail.com.
 *  I'll be glad to answer you if your request is sane :)
 *  ********************************************************************************
 *
 *
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