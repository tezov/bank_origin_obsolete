/*
 *  ********************************************************************************
 *  Created by Tezov under MIT LICENCE.
 *  For any request, please send me an email to tezov.app@gmail.com.
 *  I'll be glad to answer you if your request is sane :)
 *  ********************************************************************************
 *
 *
 */

/*
 *  ********************************************************************************
 *  Created by Tezov under MIT LICENCE.
 *  For any request, please send me an email to tezov.app@gmail.com.
 *  I'll be glad to answer you if your request is sane :)
 *  ********************************************************************************
 *
 *
 */

package com.tezov.lib_core_android_kotlin.navigation.bottom_navigation

import androidx.compose.runtime.Composable
import com.tezov.lib_core_android_kotlin.navigation.NavigationController
import com.tezov.lib_core_android_kotlin.navigation.RouteManager.Route
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub.ActivitySubAction

class BottomNavigationAction private constructor(val navigationController: NavigationController) :
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