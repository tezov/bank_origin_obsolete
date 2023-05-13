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