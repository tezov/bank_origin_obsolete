/*
 *  *********************************************************************************
 *  Created by Tezov on 07/05/2023 13:14
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 07/05/2023 12:18
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
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