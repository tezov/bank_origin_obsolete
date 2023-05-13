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