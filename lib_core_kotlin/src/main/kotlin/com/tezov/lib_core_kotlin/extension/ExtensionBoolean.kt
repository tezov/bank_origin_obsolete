/*
 *  *********************************************************************************
 *  Created by Tezov on 08/02/2023 18:17
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/02/2023 18:15
 *  First project bank / bank.lib_core_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_kotlin.extension

import com.tezov.lib_core_kotlin.extension.ExtensionBoolean.isTrueOrNull

object ExtensionBoolean {

    inline fun Boolean?.isTrueOrNull() = this == null || this

    inline fun Boolean?.isFalseOrNull() = this == null || !this

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