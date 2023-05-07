/*
 *  *********************************************************************************
 *  Created by Tezov on 07/05/2023 13:58
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 07/05/2023 13:57
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.auth.profile

import androidx.compose.runtime.Composable
import com.tezov.bank.ui.dialog.auth.closeAppConfirmation.DialogAuthCloseAppConfirmation
import com.tezov.bank.ui.dialog.auth.closeAppConfirmation.DialogAuthCloseAppController
import com.tezov.lib_core_android_kotlin.navigation.NavigationController
import com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog.DialogAction
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageAction

class PageProfileAction private constructor(
    private val navigationController: NavigationController,
    private val dialogAction: DialogAction,
) : PageAction<PageProfileState> {

    companion object {
        @Composable
        fun create(
            navigationController: NavigationController,
            dialogAction: DialogAction
        ) = PageProfileAction(
            navigationController = navigationController,
            dialogAction = dialogAction
        )
    }


    fun onClickExit() {
        dialogAction.showOnCardWithOverlay {
            DialogAuthCloseAppConfirmation.invokeContent()
        }
    }

    fun onClickProfiles(index: Int) {
        navigationController.showSnackBarNotImplemented("click profile $index")
    }

    fun onClickDocuments(index: Int) {
        navigationController.showSnackBarNotImplemented("click document $index")
    }

    fun onClickOffers(index: Int) {
        navigationController.showSnackBarNotImplemented("click offer $index")
    }

    fun onClickHelps(index: Int) {
        navigationController.showSnackBarNotImplemented("click action $index")
    }

}