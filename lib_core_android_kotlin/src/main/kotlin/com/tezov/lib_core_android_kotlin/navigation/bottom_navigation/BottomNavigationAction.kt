/*
 *  *********************************************************************************
 *  Created by Tezov on 30/01/2023 20:18
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 30/01/2023 20:12
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.navigation.bottom_navigation

import androidx.compose.runtime.Composable
import com.tezov.lib_core_android_kotlin.navigation.NavigationController
import com.tezov.lib_core_android_kotlin.navigation.RouteManager.Route
import com.tezov.lib_core_android_kotlin.ui.navigation.bottom_navigation.BottomNavigationState
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub.ActivitySubAction

class BottomNavigationAction private constructor(val navigationController: NavigationController):
    ActivitySubAction<BottomNavigationState> {

    companion object {
        @Composable
        fun create(
            navigationController: NavigationController,
        ) = BottomNavigationAction(
            navigationController = navigationController,
        )
    }

    fun onClickItem(route: Route) {
        navigationController.requestNavigate(route, this)
    }


}