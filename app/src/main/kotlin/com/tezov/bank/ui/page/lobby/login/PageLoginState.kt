/*
 *  *********************************************************************************
 *  Created by Tezov on 31/01/2023 20:43
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 31/01/2023 20:15
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.page.lobby.login

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