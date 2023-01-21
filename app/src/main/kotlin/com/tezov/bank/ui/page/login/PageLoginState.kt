package com.tezov.bank.ui.page.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.tezov.bank.ui.screen.login.PageLoginStateAnimation
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageState


class PageLoginState private constructor(
    val animationState: PageLoginStateAnimation,
    val loginState:MutableState<String>,
    val passwordState:MutableState<String>,
    val passwordVisibleState:MutableState<Boolean>,
) : PageState {

    companion object {
        @Composable
        fun remember(
            animationState: PageLoginStateAnimation = PageLoginStateAnimation.remember(),
            loginState:MutableState<String> = mutableStateOf(""),
            passwordState:MutableState<String> = mutableStateOf(""),
            passwordVisibleState:MutableState<Boolean> = mutableStateOf(false),
        ) = PageLoginState(
            animationState = animationState,
            loginState = loginState,
            passwordState = passwordState,
            passwordVisibleState = passwordVisibleState,
        )
    }

    val credentialValidState get() = loginState.value.isNotBlank() && passwordState.value.isNotBlank()

}