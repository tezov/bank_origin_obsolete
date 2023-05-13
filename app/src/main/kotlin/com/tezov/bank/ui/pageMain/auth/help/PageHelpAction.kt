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

package com.tezov.bank.ui.pageMain.auth.help

import androidx.compose.runtime.Composable
import com.tezov.lib_core_android_kotlin.navigation.NavigationController
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageAction

class PageHelpAction private constructor(
    private val navigationController: NavigationController,
) :
    PageAction<PageHelpState> {


    companion object {
        @Composable
        fun create(
            navigationController: NavigationController
        ) = PageHelpAction(
            navigationController = navigationController,
        )
    }


    fun onClickEmergencies(index: Int) {
        navigationController.showSnackBarNotImplemented("click emergency $index")
    }

    fun onClickPaymentModes(index: Int) {
        navigationController.showSnackBarNotImplemented("click payment $index")
    }

    fun onClickConfigurations(index: Int) {
        navigationController.showSnackBarNotImplemented("click configuration $index")
    }

    fun onClickAccounts(index: Int) {
        navigationController.showSnackBarNotImplemented("click account $index")
    }

    fun onClickMisc(index: Int) {
        navigationController.showSnackBarNotImplemented("click misc. $index")
    }

}