/*
 *  *********************************************************************************
 *  Created by Tezov on 23/04/2023 17:27
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 23/04/2023 16:03
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.lobby.help_and_service

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