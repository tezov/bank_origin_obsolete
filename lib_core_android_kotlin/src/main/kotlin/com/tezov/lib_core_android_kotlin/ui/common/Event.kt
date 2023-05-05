/*
 *  *********************************************************************************
 *  Created by Tezov on 05/05/2023 20:30
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 05/05/2023 20:20
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.common

sealed class Event {
    object OnConfirm : Event()
    object OnCancel : Event()
}