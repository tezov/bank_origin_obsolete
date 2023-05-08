/*
 *  *********************************************************************************
 *  Created by Tezov on 08/05/2023 14:37
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/05/2023 13:58
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.dialog.lobby.login.loginAuth

import com.tezov.bank.navigation.NavigationController.Route
import com.tezov.lib_core_android_kotlin.navigation.NavigationController
import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.dialog.DialogAction

class DialogLoginAuthAction private constructor(
    private val action: com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog.DialogAction,
    private val navigationController: NavigationController,
) : DialogAction<DialogLoginAuthState> {


    companion object {
        fun create(
            action: com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog.DialogAction,
            navigationController: NavigationController
        ) = DialogLoginAuthAction(
            action = action,
            navigationController = navigationController,
        )
    }


    fun onClickClose() {
        action.close()
    }


    fun onClickConnect() {
        action.close()
        navigationController.requestNavigate(Route.NavAuth, this)
    }

    fun onClickForgetLogin() {
        navigationController.showSnackBarNotImplemented("click forget login")
    }

    fun onClickForgetPassword() {
        navigationController.showSnackBarNotImplemented("click forget password")
    }

}