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

package com.tezov.bank.ui.dialog.lobby.login.loginAuth

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.dialog.DialogState

class DialogLoginAuthState private constructor(
    val loginState: MutableState<String>,
    val passwordState: MutableState<String>,
) : DialogState {

    companion object {

        const val LOGIN_LENGTH = 4
        const val PASSWORD_LENGTH = 4

        @Composable
        fun create(
            loginState: MutableState<String> = mutableStateOf("1234"),
            passwordState: MutableState<String> = mutableStateOf("1234"),
        ) = DialogLoginAuthState(
            loginState = loginState,
            passwordState = passwordState,
        )
    }

    val credentialValidState get() = loginState.value.length == LOGIN_LENGTH && passwordState.value.length == PASSWORD_LENGTH

}