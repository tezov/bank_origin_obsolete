package com.tezov.bank.ui.page.help_and_service

import com.tezov.lib_core_android_kotlin.navigation.NavigationController
import com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog.DialogAction
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageAction

class PageHelpAndServiceAction private constructor(
    private val navigationController: NavigationController,
) : PageAction<PageHelpAndServiceState> {

    companion object {
        fun create(
            navigationController: NavigationController,
        ) = PageHelpAndServiceAction(
                navigationController = navigationController

            )
    }

    fun close() {
        navigationController.navigateBack()
    }
}