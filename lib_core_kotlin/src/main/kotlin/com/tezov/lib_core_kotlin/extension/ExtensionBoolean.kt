/*
 *  *********************************************************************************
 *  Created by Tezov on 05/02/2023 01:03
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 04/02/2023 23:17
 *  First project bank / bank.lib_core_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_kotlin.extension

object ExtensionBoolean {
    inline fun <T> Boolean.onOk(run: () -> T) = if (this) {
        run()
    } else null

    inline fun <T> Boolean.onKo(run: () -> T) = if (!this) {
        run()
    } else null

    inline fun <T> Boolean.on(ok: () -> T, ko: () -> T) = if (this) {
        ok()
    } else {
        ko()
    }
}