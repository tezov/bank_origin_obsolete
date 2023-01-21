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