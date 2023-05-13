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

package com.tezov.bank.ui.dialog.auth.closeAppConfirmation

import androidx.compose.runtime.Composable
import com.tezov.bank.navigation.NavigationController.Route
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
                .ref().takeIf {
                    //Splash is kept in memory if the user want to see again the terms
                    //So before to go back in lobby, we ask if the user wants to disconnect cf. NavigationController
                    it.navigationController.previousRoute() == Route.Splash
                }?.let {
                    it.show()
                    return true
                }
            return false
        }

    }

    fun show() {
        dialogAction.showOnCardWithOverlay {
            DialogAuthCloseAppConfirmation.invokeContent()
        }
    }

}