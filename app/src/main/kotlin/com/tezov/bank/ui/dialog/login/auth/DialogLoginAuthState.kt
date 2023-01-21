package com.tezov.bank.ui.dialog.login.auth

import androidx.compose.runtime.*
import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.dialog.DialogState

class DialogLoginAuthState private constructor(
): DialogState {
    companion object {
        @Composable
        fun create() = DialogLoginAuthState()
    }

}