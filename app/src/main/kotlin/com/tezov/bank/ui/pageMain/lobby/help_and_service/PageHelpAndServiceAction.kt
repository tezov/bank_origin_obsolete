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

package com.tezov.bank.ui.pageMain.lobby.help_and_service

import com.tezov.lib_core_android_kotlin.navigation.NavigationController
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

    fun onClickClose() {
        navigationController.navigateBack()
    }

    fun onClickHelpAndServices(index: Int) {
        navigationController.showSnackBarNotImplemented("click help $index")
    }

    fun onClickContacts(index: Int) {
        navigationController.showSnackBarNotImplemented("click contact $index")
    }

    fun onClickNotices(index: Int) {
        navigationController.showSnackBarNotImplemented("click notices $index")
    }

}