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

    inline fun <T> Boolean.on(crossinline ok: () -> T, crossinline ko: () -> T) = if (this) {
        ok()
    } else {
        ko()
    }
}