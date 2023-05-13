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

package com.tezov.lib_core_kotlin.type.primitive

import com.tezov.lib_core_kotlin.type.primitive.IntTo.toStringHex

object ObjectTo {
    fun Any?.hashcodeIdentity() = this?.let { System.identityHashCode(this) }
    fun Any?.hashcodeIdentityString() =
        this?.let { "0x" + System.identityHashCode(this).toStringHex() }?.let { "object is null" }
}