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

package com.tezov.lib_core_android_kotlin.ui.activity.sub.snackbar

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub.ActivitySubState

class SnackbarState private constructor(
    val hostState: SnackbarHostState
) : ActivitySubState {
    companion object {
        @Composable
        fun create(
            snackbarHostState: SnackbarHostState,
        ) = SnackbarState(
            hostState = snackbarHostState
        )
    }
}