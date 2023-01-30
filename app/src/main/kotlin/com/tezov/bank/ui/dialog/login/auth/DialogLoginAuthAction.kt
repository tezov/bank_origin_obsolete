/*
 *  *********************************************************************************
 *  Created by Tezov on 30/01/2023 20:18
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 30/01/2023 20:11
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.dialog.login.auth

import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.dialog.DialogAction
import kotlinx.coroutines.CoroutineScope

class DialogLoginAuthAction private constructor(
    private val action: com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog.DialogAction,

    ): DialogAction<DialogLoginAuthState> {


    companion object {
        fun create(
            action: com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog.DialogAction,
        ) = DialogLoginAuthAction(
            action = action,
        )
    }

    fun hide() {
        action.hide()
    }


}