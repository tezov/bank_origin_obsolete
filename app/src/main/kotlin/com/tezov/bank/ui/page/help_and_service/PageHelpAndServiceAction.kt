/*
 *  *********************************************************************************
 *  Created by Tezov on 30/01/2023 20:18
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 30/01/2023 20:11
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

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