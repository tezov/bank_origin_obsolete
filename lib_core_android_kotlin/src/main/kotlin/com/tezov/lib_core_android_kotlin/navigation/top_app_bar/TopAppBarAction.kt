/*
 *  *********************************************************************************
 *  Created by Tezov on 15/04/2023 19:41
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 15/04/2023 18:52
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.navigation.top_app_bar

import androidx.compose.runtime.Composable
import com.tezov.lib_core_android_kotlin.navigation.NavigationController
import com.tezov.lib_core_android_kotlin.navigation.RouteManager.Route
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub.ActivitySubAction

class TopAppBarAction private constructor(val navigationController: NavigationController) :
    ActivitySubAction<TopAppBarState> {

    companion object {
        @Composable
        fun create(
            navigationController: NavigationController,
        ) = TopAppBarAction(
            navigationController = navigationController,
        )
    }

    fun onClickIconButton(route: Route) {
        navigationController.requestNavigate(route, this)
    }


}