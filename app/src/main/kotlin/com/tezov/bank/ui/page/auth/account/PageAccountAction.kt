/*
 *  *********************************************************************************
 *  Created by Tezov on 04/05/2023 20:17
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 04/05/2023 20:04
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.auth.account

import androidx.compose.runtime.Composable
import com.tezov.lib_core_android_kotlin.navigation.NavigationController
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageAction

class PageAccountAction private constructor(
    private val navigationController: NavigationController,
) :
    PageAction<PageAccountState> {


    companion object {
        @Composable
        fun create(
            navigationController: NavigationController
        ) = PageAccountAction(
            navigationController = navigationController,
        )
    }

    fun onClickAccountSummary(index: Int) {
        navigationController.showSnackBarNotImplemented("click menu $index")
    }

    fun onClickAccountHistories(section:Int, index: Int) {
        navigationController.showSnackBarNotImplemented("click history $section:$index")
    }

    fun onClickMailBox() {
        navigationController.showSnackBarNotImplemented("click mail box")
    }

    fun onClickAccount() {
        navigationController.showSnackBarNotImplemented("click account")
    }

}