/*
 *  *********************************************************************************
 *  Created by Tezov on 07/05/2023 13:14
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 07/05/2023 13:01
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.auth.account

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tezov.bank.ui.di.accessor.DiAccessorAppUiPage
import com.tezov.bank.ui.dialog.lobby.login.auth.DialogLoginAuth
import com.tezov.lib_core_android_kotlin.navigation.NavigationController
import com.tezov.lib_core_android_kotlin.type.primaire.size
import com.tezov.lib_core_android_kotlin.ui.activity.sub.bottomsheet.BottomSheetAction
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageAction
import com.tezov.lib_core_android_kotlin.ui.di.helper.ExtensionCoreUi.action

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

    fun onClickIci() {
        bottomsheetAction.show {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Green)
            ){
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .background(Color.Yellow)
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