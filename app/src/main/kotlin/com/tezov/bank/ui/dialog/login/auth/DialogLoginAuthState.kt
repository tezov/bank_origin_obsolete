package com.tezov.bank.ui.dialog.login.auth

import androidx.compose.runtime.*
import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.dialog.DialogState

class DialogLoginAuthState private constructor(
    val loginState:MutableState<String>,
    val passwordState:MutableState<String>,
): DialogState {
    companion object {
        @Composable
        fun create(
            loginState:MutableState<String> = mutableStateOf(""),
            passwordState:MutableState<String> = mutableStateOf(""),
        ) = DialogLoginAuthState(
            loginState = loginState,
            passwordState = passwordState,
        )
    }

    val credentialValidState get() = loginState.value.isNotBlank() && passwordState.value.isNotBlank()

}