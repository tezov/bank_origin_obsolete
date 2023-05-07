/*
 *  *********************************************************************************
 *  Created by Tezov on 07/05/2023 17:18
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 07/05/2023 16:32
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.pageMain.lobby.splash

import androidx.compose.runtime.Composable
import com.tezov.bank.navigation.NavigationController.Route
import com.tezov.lib_core_android_kotlin.navigation.NavigationController
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageAction

class PageSplashAction private constructor(
    private val navigationController: NavigationController,
) :
    PageAction<PageSplashState> {


    companion object {
        @Composable
        fun create(
            navigationController: NavigationController
        ) = PageSplashAction(
            navigationController = navigationController,
        )
    }

    fun onStart() {
        navigationController.requestNavigate(Route.Login, this)
    }

}