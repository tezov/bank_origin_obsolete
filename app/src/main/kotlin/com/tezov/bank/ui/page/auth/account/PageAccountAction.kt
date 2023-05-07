/*
 *  *********************************************************************************
 *  Created by Tezov on 07/05/2023 13:53
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 07/05/2023 13:51
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.auth.account

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.tezov.lib_core_android_kotlin.navigation.NavigationController
import com.tezov.lib_core_android_kotlin.ui.activity.sub.bottomsheet.BottomSheetAction
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageAction

class PageAccountAction private constructor(
    private val navigationController: NavigationController,
    private val bottomsheetAction: BottomSheetAction,
) :
    PageAction<PageAccountState> {

    companion object {
        @Composable
        fun create(
            navigationController: NavigationController,
            bottomsheetAction: BottomSheetAction
        ) = PageAccountAction(
            navigationController = navigationController,
            bottomsheetAction = bottomsheetAction,
        )
    }

    fun onClickIncomingHelp() {
        bottomsheetAction.show {
            Box(
                modifier = Modifier
                    .fillMaxHeight(0.5f)
                    .fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = "Donne moi du contenu que je sois utile..."
                )
            }
        }
    }

    fun onClickAccountSummary(index: Int) {
        navigationController.showSnackBarNotImplemented("click menu $index")
    }

    fun onClickAccountHistories(section: Int, index: Int) {
        navigationController.showSnackBarNotImplemented("click history $section:$index")
    }

    fun onClickMailBox() {
        navigationController.showSnackBarNotImplemented("click mail box")
    }

    fun onClickAccount() {
        navigationController.showSnackBarNotImplemented("click account")
    }

}