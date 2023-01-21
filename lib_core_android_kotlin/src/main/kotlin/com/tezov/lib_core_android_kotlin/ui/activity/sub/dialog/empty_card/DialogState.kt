package com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog.empty_card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub.ActivitySubState
import com.tezov.lib_core_android_kotlin.ui.theme.definition.colorsResource

class DialogState private constructor(
    private val showDialog: MutableState<Boolean>,
    private val dialogContentUpdated: MutableState<Int>,
) : ActivitySubState {

    companion object {
        @Composable
        fun create(
            showDialog: MutableState<Boolean> = mutableStateOf(false),
            dialogContentUpdated: MutableState<Int> = mutableStateOf(0)
        ) = DialogState(
            showDialog = showDialog,
            dialogContentUpdated = dialogContentUpdated,
        )
    }

    @Composable
    internal fun EmptyContent(){
        Box(
            Modifier
                .background(MaterialTheme.colorsResource.transparent)
                .fillMaxWidth()
                .height(1.dp)
        )
    }

    private var _dialogContent: (@Composable () -> Unit) = {
        //hack content dialog can't be null even if not showing
        EmptyContent()
    }

    fun isVisible() = showDialog.value == true
    fun show(visible: Boolean) {
        showDialog.value = visible
    }

    @Composable
    internal fun dialogContent() {
        //todo animation show/hide
        if (showDialog.value && dialogContentUpdated.value >= 0) {
            _dialogContent()
        }
    }
    internal fun dialogContent(content: @Composable () -> Unit) {
        _dialogContent = content
        dialogContentUpdated.value++
    }

}