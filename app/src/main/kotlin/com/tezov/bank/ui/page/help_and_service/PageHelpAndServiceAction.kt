package com.tezov.bank.ui.page.help_and_service

import com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog.DialogAction
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageAction

class PageHelpAndServiceAction private constructor(
    private val state: PageHelpAndServiceState,
    private val dialogAction: DialogAction,
) : PageAction<PageHelpAndServiceState> {

    companion object {
        fun create(
            state: PageHelpAndServiceState,
            dialogAction: DialogAction,
        ) =
            PageHelpAndServiceAction(
                state = state,
                dialogAction = dialogAction,
            )
    }
}