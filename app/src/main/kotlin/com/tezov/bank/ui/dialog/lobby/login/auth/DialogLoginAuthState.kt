/*
 *  *********************************************************************************
 *  Created by Tezov on 03/05/2023 21:39
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 03/05/2023 21:20
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
    private val _diCanDispose: MutableState<Boolean>,
    val loginState: MutableState<String>,
    val passwordState: MutableState<String>,
) : DialogState {

    companion object {

        const val LOGIN_LENGTH = 4
        const val PASSWORD_LENGTH = 4

        @Composable
        fun create(
            diCanDispose:MutableState<Boolean> = mutableStateOf(false),
            loginState: MutableState<String> = mutableStateOf("1234"),
            passwordState: MutableState<String> = mutableStateOf("1234"),
        ) = DialogLoginAuthState(
            _diCanDispose = diCanDispose,
            loginState = loginState,
            passwordState = passwordState,
        )
    }

    var diCanDispose get() = _diCanDispose.value
        set(value) {
            _diCanDispose.value = value
        }

    val credentialValidState get() = loginState.value.length == LOGIN_LENGTH && passwordState.value.length == PASSWORD_LENGTH

}