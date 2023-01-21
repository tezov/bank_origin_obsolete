package com.tezov.bank.ui.dialog.login.auth

import androidx.compose.runtime.Composable
import com.tezov.bank.ui.di.accessor.AccessorAppUiDialog
import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.dialog.Dialog

object DialogAuth : Dialog<DialogLoginAuthState, DialogLoginAuthAction> {

    @Composable
    override fun Dialog<DialogLoginAuthState, DialogLoginAuthAction>.content() {
//        val accessor = AccessorAppUiDialog().get(requester = this).contextLoginAuth()


    }

}