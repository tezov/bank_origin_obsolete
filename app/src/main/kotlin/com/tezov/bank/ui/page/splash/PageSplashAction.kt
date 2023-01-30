/*
 *  *********************************************************************************
 *  Created by Tezov on 30/01/2023 20:18
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 30/01/2023 20:11
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.tezov.bank.navigation.NavigationController.Companion.Route
import com.tezov.lib_core_android_kotlin.navigation.NavigationController
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageAction

class PageSplashAction private constructor(
    private val navigationController: NavigationController,
    private val executionState: MutableState<Int>
) :
    PageAction<PageSplashState> {


    companion object {
        @Composable
         fun create(navigationController: NavigationController):PageSplashAction{
             val executionState = remember {
                 mutableStateOf(0)
             }
             return PageSplashAction(
                 navigationController = navigationController,
                 executionState = executionState
             )
         }
    }

    fun onStart(){
        navigationController.requestNavigate(Route.Login, this)
    }

}