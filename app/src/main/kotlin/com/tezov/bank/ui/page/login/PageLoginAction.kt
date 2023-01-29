package com.tezov.bank.ui.page.login

import com.tezov.bank.navigation.NavigationController.Companion.Route
import com.tezov.bank.ui.dialog.login.auth.DialogLoginAuth
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
        ) =
            PageLoginAction(
                navigationController = navigationController,
                dialogAction = dialogAction
            )
    }

    fun onClickConnect() {
        dialogAction.show {
            DialogLoginAuth()
        }
    }

    fun onClickHelpAndService() {
        navigationController.requestNavigate(Route.HelpAndService, this)
    }

}