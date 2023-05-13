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
            nameState: State<String> = mutableStateOf("M.TEZOV"),
            iconState: State<Int> = mutableStateOf(R.drawable.img_suitcase_blue),
        ) = PageLoginState(
            animationState = animationState,
            nameState = nameState,
            iconState = iconState,
        )
    }

}