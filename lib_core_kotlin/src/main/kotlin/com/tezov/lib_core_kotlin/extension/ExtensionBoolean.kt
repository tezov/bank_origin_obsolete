/*
 *  *********************************************************************************
 *  Created by Tezov on 09/04/2023 20:20
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 09/04/2023 20:20
 *  First project bank / bank.lib_core_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_kotlin.extension

object ExtensionBoolean {

    fun Boolean?.isTrue() = this == true

    fun Boolean?.isTrueOrNull() = isTrue() || this == null

    fun Boolean?.isFalse() = this == false

    fun Boolean?.isFalseOrNull() = isFalse() || this == null

    inline fun <T> Boolean.onOk(crossinline run: () -> T) = if (this) {
        run()
    } else null

    inline fun <T> Boolean.onKo(crossinline run: () -> T) = if (!this) {
        run()
    } else null

    inline fun <T> Boolean.on(crossinline ok: () -> T,crossinline ko: () -> T) = if (this) {
        ok()
    } else {
        ko()
    }
}