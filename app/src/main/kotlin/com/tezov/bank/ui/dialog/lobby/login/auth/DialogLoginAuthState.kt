/*
 *  *********************************************************************************
 *  Created by Tezov on 06/05/2023 14:54
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 06/05/2023 14:45
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.dialog.lobby.login.auth

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.tezov.bank.ui.page.lobby.help_and_service.PageHelpAndServiceState
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