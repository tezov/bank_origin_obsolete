package com.tezov.bank.ui.page.login

import com.tezov.bank.ui.dialog.login.auth.DialogLoginAuth
import com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog.DialogAction
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageAction

class PageLoginAction private constructor(
    private val state: PageLoginState,
    private val dialogAction: DialogAction,
) : PageAction<PageLoginState> {

    companion object {
        fun create(
            state: PageLoginState,
            dialogAction: DialogAction
        ) =
            PageLoginAction(
                state = state,
                dialogAction = dialogAction
            )
    }


    fun onClickConnect() {
        dialogAction.show {
            DialogLoginAuth()
        }
    }

}