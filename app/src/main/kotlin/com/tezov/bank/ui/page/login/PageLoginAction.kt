package com.tezov.bank.ui.page.login

import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.text.input.ImeAction
import com.tezov.bank.R
import com.tezov.bank.navigation.NavigationController.Companion.Route
import com.tezov.lib_core_android_kotlin.navigation.NavigationController
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageAction

class PageLoginAction private constructor(
    private val state: PageLoginState,
    private val navigationController: NavigationController
) : PageAction<PageLoginState> {

    companion object {
        fun create(state: PageLoginState, navigationController: NavigationController) =
            PageLoginAction(
                state = state,
                navigationController = navigationController,
            )
    }

    fun onImeActionFromContentBoxLogin(
        action: ImeAction,
        field: Int,
        focusManager: FocusManager
    ) {
        when (field) {
            R.string.screen_login_field_login -> {
                when (action) {
                    ImeAction.Done -> {
                        onClickButtonConnect()
                    }
                    ImeAction.Next -> {
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                }
            }
            R.string.screen_login_field_password -> {
                when (action) {
                    ImeAction.Done -> {
                        onClickButtonConnect()
                    }
                    ImeAction.Next -> {
                        focusManager.moveFocus(FocusDirection.Up)
                    }
                }
            }
        }
    }

    fun onClickButtonConnect() {

//        if (state.credentialValidState) {
//            navigationController.requestNavigate(Route.Connecting, this)
//        }

    }

    fun onClickButtonCreatePassword() {

//        navigationController.requestNavigate(Route.CreatePassword, this)

    }

    fun onClickLinkForgotten(resourceId: Int) {
        val route = when (resourceId) {
//            R.string.screen_login_link_login_forgotten -> Route.LoginForgotten
//            R.string.screen_login_link_password_forgotten -> Route.PasswordForgotten
            else -> null
        }
        route?.let { navigationController.requestNavigate(it, this) }
    }

}