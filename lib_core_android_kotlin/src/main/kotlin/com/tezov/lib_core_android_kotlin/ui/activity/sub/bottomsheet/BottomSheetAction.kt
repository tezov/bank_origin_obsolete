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

package com.tezov.lib_core_android_kotlin.ui.activity.sub.bottomsheet

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub.ActivitySubAction
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class BottomSheetAction constructor(
    val coroutineScope: CoroutineScope,
    val state: BottomSheetState
): ActivitySubAction<BottomSheetState> {

    companion object {
        @Composable
        fun create(
            coroutineScope: CoroutineScope,
            bottomSheetState: BottomSheetState
        ) = BottomSheetAction(
            coroutineScope = coroutineScope,
            state = bottomSheetState,
        )
    }

    var currentJob: Job? = null

    @OptIn(ExperimentalMaterialApi::class)
    fun show(content: @Composable () -> Unit) {
        currentJob?.cancel()
        currentJob = coroutineScope.launch {
            state.sheetContent(content)
            state.bottomSheetState.show()
        }
    }

    @OptIn(ExperimentalMaterialApi::class)
    fun hide() {
        currentJob?.cancel()
        currentJob = coroutineScope.launch {
            state.bottomSheetState.hide()
            state.sheetContent({state.EmptyContent()}) //todo wait animation done
        }
    }

}