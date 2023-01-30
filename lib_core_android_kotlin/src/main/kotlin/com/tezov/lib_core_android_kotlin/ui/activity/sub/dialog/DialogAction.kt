/*
 *  *********************************************************************************
 *  Created by Tezov on 30/01/2023 20:18
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 30/01/2023 20:11
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog

import androidx.compose.runtime.Composable
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub.ActivitySubAction
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class DialogAction private constructor(
    val coroutineScope: CoroutineScope,
    val state: DialogState
): ActivitySubAction<DialogState> {

    companion object {
        @Composable
        fun create(
            coroutineScope: CoroutineScope,
            dialogState: DialogState
        ) = DialogAction(
            coroutineScope = coroutineScope,
            state = dialogState,
        )
    }

    var currentJob: Job? = null

    fun show(content: @Composable () -> Unit) {
        currentJob?.cancel()
        currentJob = coroutineScope.launch {
            state.dialogContent(content)
            state.show(true)
        }
    }
    fun hide() {
        currentJob?.cancel()
        currentJob = coroutineScope.launch {
            state.show(false)
            state.dialogContent({state.EmptyContent()}) //todo wait animation done
        }
    }

    fun showOnCardWithOverlay(content: @Composable () -> Unit) {
        show{ Dialog.Card(content) }
    }

}