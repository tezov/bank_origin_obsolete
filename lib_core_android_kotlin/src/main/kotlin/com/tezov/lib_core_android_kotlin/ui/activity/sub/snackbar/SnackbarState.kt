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