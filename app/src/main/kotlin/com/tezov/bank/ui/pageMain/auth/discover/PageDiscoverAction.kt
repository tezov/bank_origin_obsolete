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

package com.tezov.bank.ui.pageMain.auth.discover

import androidx.compose.runtime.Composable
import com.tezov.lib_core_android_kotlin.navigation.NavigationController
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageAction

class PageDiscoverAction private constructor(
    private val navigationController: NavigationController,
) :
    PageAction<PageDiscoverState> {


    companion object {
        @Composable
        fun create(
            navigationController: NavigationController
        ) = PageDiscoverAction(
            navigationController = navigationController,
        )
    }

    fun onClickCardsWithButton(index: Int) {
        navigationController.showSnackBarNotImplemented("click card button $index")
    }

    fun onClickCardsWithLink(index: Int) {
        navigationController.showSnackBarNotImplemented("click card link $index")
    }

    fun onClickCashbacksCard(index: Int) {
        navigationController.showSnackBarNotImplemented("click cashback $index")
    }

    fun onClickCashbacksButton() {
        navigationController.showSnackBarNotImplemented("click cashback button")
    }

    fun onClickOffers(index: Int) {
        navigationController.showSnackBarNotImplemented("click offer $index")
    }

    fun onClickTips(index: Int) {
        navigationController.showSnackBarNotImplemented("click tip $index")
    }


}