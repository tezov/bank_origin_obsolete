package com.tezov.lib_core_android_kotlin.navigation.top_app_bar

import androidx.compose.runtime.Composable
import com.tezov.lib_core_android_kotlin.navigation.NavigationController
import com.tezov.lib_core_android_kotlin.navigation.RouteManager.Route
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub.ActivitySubAction

class TopAppBarAction private constructor(val navigationController:NavigationController):ActivitySubAction<TopAppBarState> {

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