package com.tezov.lib_core_android_kotlin.ui.activity.sub.bottomsheet

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

@OptIn(ExperimentalMaterialApi::class)
class BottomSheetState private constructor(
    val bottomSheetState: ModalBottomSheetState,
    private val sheetContentUpdated: MutableState<Int>
) : ActivitySubState {


    companion object {
        @OptIn(ExperimentalMaterialApi::class)
        @Composable
        fun remember(
            bottomSheetState: ModalBottomSheetState = rememberModalBottomSheetState(
                initialValue = ModalBottomSheetValue.Hidden
            ),
            sheetContentUpdated: MutableState<Int> = mutableStateOf(0)
        ) = BottomSheetState(
            bottomSheetState = bottomSheetState,
            sheetContentUpdated = sheetContentUpdated,
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

    private var _sheetContent: (@Composable () -> Unit) = {
        //hack content bottomsheet can't be null even if not showing
        EmptyContent()
    }

    @Composable
    internal fun sheetContent() {
        if (sheetContentUpdated.value >= 0) {
            _sheetContent()
        }
    }

    internal fun sheetContent(content: @Composable () -> Unit) {
        _sheetContent = content
        sheetContentUpdated.value++
    }

}