/*
 *  *********************************************************************************
 *  Created by Tezov on 30/01/2023 20:18
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 30/01/2023 20:11
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.dialog.login.auth

import androidx.compose.runtime.*
import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.dialog.DialogState

class DialogLoginAuthState private constructor(
    val loginState:MutableState<String>,
    val passwordState:MutableState<String>,
): DialogState {
    companion object {

        const val LOGIN_LENGTH = 8
        const val PASSWORD_LENGTH = 6

        @Composable
        fun create(
            loginState:MutableState<String> = mutableStateOf(""),
            passwordState:MutableState<String> = mutableStateOf(""),
        ) = DialogLoginAuthState(
            loginState = loginState,
            passwordState = passwordState,
        )
    }

    val credentialValidState get() = loginState.value.length == LOGIN_LENGTH && passwordState.value.length == PASSWORD_LENGTH

}