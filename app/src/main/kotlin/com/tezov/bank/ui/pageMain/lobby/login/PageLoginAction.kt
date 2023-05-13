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

package com.tezov.bank.ui.pageMain.lobby.login

import com.tezov.bank.navigation.NavigationController.Route
import com.tezov.bank.ui.dialog.lobby.login.loginAuth.DialogLoginAuth
import com.tezov.lib_core_android_kotlin.navigation.NavigationController
import com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog.DialogAction
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageAction

class PageLoginAction private constructor(
    private val navigationController: NavigationController,
    private val dialogAction: DialogAction,
) : PageAction<PageLoginState> {

    companion object {
        fun create(
            navigationController: NavigationController,
            dialogAction: DialogAction
        ) = PageLoginAction(
            navigationController = navigationController,
            dialogAction = dialogAction
        )
    }

    fun onClickAdd() {
        navigationController.showSnackBarNotImplemented("click add")
    }

    fun onClickMenu(index:Int) {
        navigationController.showSnackBarNotImplemented("click menu $index")
    }

    fun onClickBalanceActivate() {
        navigationController.showSnackBarNotImplemented("click balance activate")
    }

    fun onClickConnect() {
        dialogAction.show {
            DialogLoginAuth.invokeContent()
        }
    }

    fun onClickSendMoney() {
        navigationController.showSnackBarNotImplemented("click send money")
    }

    fun onClickHelpAndService() {
        navigationController.requestNavigate(Route.HelpAndService, this)
    }

}