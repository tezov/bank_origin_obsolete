/*
 *  *********************************************************************************
 *  Created by Tezov on 06/05/2023 13:31
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 06/05/2023 13:30
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.dialog.auth.closeAppConfirmation

import androidx.compose.runtime.Composable
import com.tezov.bank.ui.di.accessor.DiAccessorAppUiPage
import com.tezov.lib_core_android_kotlin.navigation.NavigationController
import com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog.DialogAction
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalPagesBundle
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.ref

class DialogAuthCloseAppController private constructor(
    private val navigationController: NavigationController,
    private val dialogAction: DialogAction,

    ) {

    companion object {
        fun create(
            navigationController: NavigationController,
            dialogAction: DialogAction
        ) = DialogAuthCloseAppController(
            navigationController = navigationController,
            dialogAction = dialogAction
        )

        @Composable
        fun handleOnBackPressed(): Boolean {
            DiAccessorAppUiPage()
                .with(key = LocalPagesBundle.last().current)
                .controllerDialogAuthCloseApp()
                .ref().takeIf { it.navigationController.isLastRoute() }?.let {
                    it.show()
                    return true
                }
            return false
        }

    }

    fun show() {
        dialogAction.showOnCardWithOverlay {
            DialogAuthCloseAppConfirmation()
        }
    }

}