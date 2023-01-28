package com.tezov.bank.ui.page.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.tezov.bank.ui.screen.login.PageLoginStateAnimation
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageState


class PageLoginState private constructor(
    val animationState: PageLoginStateAnimation,
    val nameState: State<String>,
) : PageState {

    companion object {
        @Composable
        fun remember(
            animationState: PageLoginStateAnimation = PageLoginStateAnimation.remember(),
            nameState:State<String> = mutableStateOf("M.ZOLLVER"),

        ) = PageLoginState(
            animationState = animationState,
            nameState = nameState,
        )
    }

}