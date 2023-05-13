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

package com.tezov.lib_core_android_kotlin.ui.common

import androidx.compose.runtime.Composable

sealed class Event {
    object OnConfirm : Event()
    object OnCancel : Event()
}

open class EventListener(
    val event: Event?,
    private val action: @Composable (event: Event?) -> Unit
) {

    var isValid = true
    var isEnabled = isValid

    @Composable
    fun notify(event: Event?) {
        if (isEnabled) {
            if (this.event == event || this.event == null) {
                action(event)
                afterNotify(event)
            }
        }
    }

    @Composable
    internal open fun afterNotify(event: Event?) {
    }

}

class EventListenerSingle(
    event: Event?,
    action: @Composable (event: Event?) -> Unit
) : EventListener(event, action) {

    @Composable
    override fun afterNotify(event: Event?) {
        isValid = false
    }
}