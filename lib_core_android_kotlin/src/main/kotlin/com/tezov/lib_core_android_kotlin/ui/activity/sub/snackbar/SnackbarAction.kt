package com.tezov.lib_core_android_kotlin.ui.activity.sub.snackbar

import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.SnackbarResult
import androidx.compose.runtime.Composable
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub.ActivitySubAction
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class SnackbarAction private constructor(
    private val coroutineScope: CoroutineScope,
    private val hostState: SnackbarHostState
): ActivitySubAction<SnackbarState> {

    companion object {
        @Composable
        fun create(
            coroutineScope: CoroutineScope,
            hostState: SnackbarHostState
        ) = SnackbarAction(
            coroutineScope = coroutineScope,
            hostState = hostState,
        )
    }

    var currentJob:Job? = null

    fun show(message: String, duration: SnackbarDuration = SnackbarDuration.Short) {
        currentJob?.cancel()
        currentJob = coroutineScope.launch {
            val result = hostState.showSnackbar(
                message = message,
                actionLabel = "[X]",
                duration = duration
            )
            when(result){
                SnackbarResult.Dismissed -> {
                    //nothing yet
                }
                SnackbarResult.ActionPerformed -> {
                    //nothing yet
                }
            }
        }
    }
    fun showNotImplemented() {
        currentJob?.cancel()
        currentJob = coroutineScope.launch {
            val result = hostState.showSnackbar(
                message = "Not Implemented",
                actionLabel = "[X]",
                duration = SnackbarDuration.Short
            )
            when(result){
                SnackbarResult.Dismissed -> {
                    //nothing yet
                }
                SnackbarResult.ActionPerformed -> {
                    //nothing yet
                }
            }
        }
    }

}