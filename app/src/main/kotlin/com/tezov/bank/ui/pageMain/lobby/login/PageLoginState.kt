/*
 *  *********************************************************************************
 *  Created by Tezov on 07/05/2023 17:18
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 07/05/2023 16:32
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.pageMain.lobby.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.tezov.bank.R
import com.tezov.bank.ui.screen.login.PageLoginStateAnimation
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.PageState


class PageLoginState private constructor(
    val animationState: PageLoginStateAnimation,
    val nameState: State<String>,
    val iconState: State<Int>,
) : PageState {

    companion object {
        @Composable
        fun create(
            animationState: PageLoginStateAnimation = PageLoginStateAnimation.remember(), //TODO
            nameState: State<String> = mutableStateOf("M.ZOLLVER"),
            iconState: State<Int> = mutableStateOf(R.drawable.img_suitcase_blue),
        ) = PageLoginState(
            animationState = animationState,
            nameState = nameState,
            iconState = iconState,
        )
    }

}