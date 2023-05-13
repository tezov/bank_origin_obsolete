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

package com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog

import androidx.compose.runtime.Composable
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub.ActivitySubAction

class DialogAction private constructor(
    val state: DialogState
) : ActivitySubAction<DialogState> {

    companion object {
        @Composable
        fun create(
            dialogState: DialogState
        ) = DialogAction(
            state = dialogState,
        )
    }

    fun show(content: @Composable () -> Unit) {
        state.show(content)
    }

    fun close() {
        state.show(null)
    }

    fun showOnCardWithOverlay(content: @Composable () -> Unit) {
        show { Dialog.Card(content) }
    }



}