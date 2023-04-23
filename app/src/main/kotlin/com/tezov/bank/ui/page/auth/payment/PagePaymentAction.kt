/*
 *  *********************************************************************************
 *  Created by Tezov on 23/04/2023 17:27
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 23/04/2023 16:04
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.auth.payment

import androidx.compose.runtime.Composable
import com.tezov.lib_core_android_kotlin.navigation.NavigationController
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageAction

class PagePaymentAction private constructor(
    private val navigationController: NavigationController,
) :
    PageAction<PagePaymentState> {


    companion object {
        @Composable
        fun create(
            navigationController: NavigationController
        ) = PagePaymentAction(
            navigationController = navigationController,
        )
    }

    fun onClickCardsSmall(index: Int) {
        navigationController.showSnackBarNotImplemented("click card small $index")
    }

    fun onClickCardsLarge(index: Int) {
        navigationController.showSnackBarNotImplemented("click card large $index")
    }


}