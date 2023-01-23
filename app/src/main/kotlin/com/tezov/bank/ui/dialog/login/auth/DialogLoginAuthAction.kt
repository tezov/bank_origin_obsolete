package com.tezov.bank.ui.dialog.login.auth

import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.dialog.DialogAction
import kotlinx.coroutines.CoroutineScope

class DialogLoginAuthAction private constructor(
    private val coroutineScope: CoroutineScope,
    private val action: com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog.DialogAction,

    ): DialogAction<DialogLoginAuthState> {


    companion object {
        fun create(
            coroutineScope: CoroutineScope,
            action: com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog.DialogAction,
        ) = DialogLoginAuthAction(
            coroutineScope = coroutineScope,
            action = action,
        )
    }

    fun hide() {
        action.hide()
    }


}