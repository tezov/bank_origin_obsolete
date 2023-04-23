/*
 *  *********************************************************************************
 *  Created by Tezov on 23/04/2023 17:27
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 23/04/2023 15:56
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.auth.discover

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