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

package com.tezov.bank.ui.pageMain.auth.profile

import androidx.compose.runtime.Composable
import com.tezov.bank.ui.dialog.auth.closeAppConfirmation.DialogAuthCloseAppConfirmation
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