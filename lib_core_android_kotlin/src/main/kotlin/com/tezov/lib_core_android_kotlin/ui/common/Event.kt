/*
 *  *********************************************************************************
 *  Created by Tezov on 05/05/2023 23:33
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 05/05/2023 21:03
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
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