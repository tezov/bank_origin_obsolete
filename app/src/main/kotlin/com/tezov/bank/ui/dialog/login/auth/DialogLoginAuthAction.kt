package com.tezov.bank.ui.dialog.login.auth

import androidx.activity.ComponentActivity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.dialog.DialogAction
import com.tezov.lib_core_android_kotlin.util.UtilsIntent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class DialogLoginAuthAction private constructor(
    private val coroutineScope: CoroutineScope,
    private val action:  com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog.empty_card.DialogAction,

): DialogAction<DialogLoginAuthState> {


    companion object {
        fun create(
            coroutineScope: CoroutineScope,
            action:  com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog.empty_card.DialogAction,
        ) = DialogLoginAuthAction(
            coroutineScope = coroutineScope,
            action = action,
        )
    }


}