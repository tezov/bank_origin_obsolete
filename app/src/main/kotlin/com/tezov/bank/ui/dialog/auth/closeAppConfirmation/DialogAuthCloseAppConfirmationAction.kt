/*
 *  *********************************************************************************
 *  Created by Tezov on 08/02/2023 21:11
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/02/2023 20:09
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.dialog.auth.closeAppConfirmation

import com.tezov.bank.navigation.NavigationController.Companion.Route
import com.tezov.lib_core_android_kotlin.navigation.NavigationController
import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.dialog.DialogAction

class DialogAuthCloseAppConfirmationAction private constructor(
    private val action: com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog.DialogAction,
    private val navigationController: NavigationController,
    ): DialogAction<DialogAuthCloseAppConfirmationState> {

    companion object {
        fun create(
            action: com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog.DialogAction,
            navigationController: NavigationController
        ) = DialogAuthCloseAppConfirmationAction(
            action = action,
            navigationController = navigationController,
        )
    }

    fun hide() {
        action.hide()
    }

}