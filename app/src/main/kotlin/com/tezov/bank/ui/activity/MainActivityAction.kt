/*
 *  *********************************************************************************
 *  Created by Tezov on 15/04/2023 19:41
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 15/04/2023 18:51
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.activity

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.tezov.bank.navigation.NavigationController
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.ActivityAction

class MainActivityAction private constructor(
    val coreAction: com.tezov.lib_core_android_kotlin.ui.activity.ActivityMainAction,
    val navigationController: NavigationController,
) : ActivityAction<MainActivityState> {

    companion object {
        @Composable
        fun create(
            coreAction: com.tezov.lib_core_android_kotlin.ui.activity.ActivityMainAction,
        ): MainActivityAction {
            val executionState = remember {
                mutableStateOf(0)
            }
            return MainActivityAction(
                coreAction = coreAction,
                navigationController = NavigationController(coreAction.navigationController),
            )
        }
    }

}