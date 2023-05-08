/*
 *  *********************************************************************************
 *  Created by Tezov on 08/05/2023 15:29
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/05/2023 14:48
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.dialog.auth.closeAppConfirmation

import com.tezov.lib_core_android_kotlin.navigation.NavigationController
import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.dialog.DialogAction

class DialogAuthCloseAppConfirmationAction private constructor(
    private val action: com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog.DialogAction,
    private val navigationController: NavigationController,
) : DialogAction<DialogAuthCloseAppConfirmationState> {

    companion object {
        fun create(
            action: com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog.DialogAction,
            navigationController: NavigationController
        ) = DialogAuthCloseAppConfirmationAction(
            action = action,
            navigationController = navigationController,
        )
    }

    fun onClickCancel() {
        action.close()
    }

    fun onClickConfirm() {
        navigationController.showSnackBarNotImplemented("deconnection")
        action.close()
    }

}