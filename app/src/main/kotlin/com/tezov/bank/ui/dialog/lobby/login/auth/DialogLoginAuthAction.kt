/*
 *  *********************************************************************************
 *  Created by Tezov on 15/04/2023 19:41
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 15/04/2023 18:51
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.dialog.lobby.login.auth

import com.tezov.bank.navigation.NavigationController.Companion.Route
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

    fun hide() {
        action.hide()
    }


    fun connect() {
        hide()
        navigationController.requestNavigate(Route.Account, this)
    }

}